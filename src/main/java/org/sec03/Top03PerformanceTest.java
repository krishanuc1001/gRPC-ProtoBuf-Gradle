package org.sec03;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.proto.generatedProtoClasses.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Top03PerformanceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Top03PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        Person protoPerson = Person.newBuilder()
                .setLastName("Chakraborty")
                .setAge(33)
                .setEmail("abc@xyz.com")
                .setEmployed(true)
                .setSalary(45635.74774)
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        JsonPerson jsonPerson = new JsonPerson(
                "Chakraborty",
                33,
                "abc@xyz.com",
                true,
                45635.74774,
                123456789012L,
                -10000);

        LOGGER.info("proto person {}", protoPerson);
        LOGGER.info("json person {}", jsonPerson);

        // To compare the json and proto object sizes
        json(jsonPerson);
        proto(protoPerson);

        for (int i = 0; i < 5; i++) {
            runTest("jsonTest", () -> json(jsonPerson));
            runTest("protoTest", () -> proto(protoPerson));
        }

    }

    private static void proto(Person person) {
        try {
            var bytes = person.toByteArray(); // Serialization: Object to Byte array
            LOGGER.info("Proto bytes length: {}", bytes.length);
            Person.parseFrom(bytes); // De-serialization: Bytes to Object
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    private static void json(JsonPerson jsonPerson) {
        try {
            var bytes = mapper.writeValueAsBytes(jsonPerson); // Serialization: Object to Byte array
            LOGGER.info("JSON bytes length: {}", bytes.length);
            mapper.readValue(bytes, JsonPerson.class); // De-serialization: Byte array to Object
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void runTest(String testName, Runnable runnable) {
        var start = System.currentTimeMillis();

        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }

        var end = System.currentTimeMillis();

        LOGGER.info("Time taken for {} => {}", testName, (end - start));

    }


}
