package org.sec03;

import com.proto.generatedProtoClasses.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Top02Serialization {

    private static final Logger LOGGER = LoggerFactory.getLogger(Top02Serialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {

        Person person = Person.newBuilder()
                .setLastName("Chakraborty")
                .setAge(33)
                .setEmail("abc@xyz.com")
                .setEmployed(true)
                .setSalary(45635.74774)
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        serialize(person);
        LOGGER.info("{}", deserialize());
        LOGGER.info("person obj equals deserialized obj: {}", person.equals(deserialize()));
        LOGGER.info("person obj == deserialized obj: {}", person == deserialize());
        LOGGER.info("person proto obj length in bytes: {}", person.toByteArray().length);
    }

    // Serialization: Object to File
    public static void serialize(Person person) throws IOException {
        try (var stream = Files.newOutputStream(PATH)) {
            person.writeTo(stream);
        }
    }

    // De-serialization: File to Object
    public static Person deserialize() throws IOException {
        try (var stream = Files.newInputStream(PATH)) {
            return Person.parseFrom(stream);
        }
    }

}
