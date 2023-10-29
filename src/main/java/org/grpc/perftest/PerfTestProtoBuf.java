package org.grpc.perftest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.proto.generatedProtoClasses.Person;
import org.grpc.json.JPerson;

import java.io.IOException;

public class PerfTestProtoBuf {

    public static void main(String[] args) {

        // JSON Serialization De-serialization
        JPerson jPerson = new JPerson();
        jPerson.setName("John");
        jPerson.setAge(40);

        ObjectMapper objectMapper = new ObjectMapper();

        Runnable runnableJson = () -> {
            try {
                byte[] bytes = objectMapper.writeValueAsBytes(jPerson);
                objectMapper.readValue(bytes, JPerson.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // ProtoBuf Serialization De-serialization
        Person person = Person.newBuilder()
                .setName("John")
                .setAge(40)
                .build();

        Runnable runnableProtoBuf = () -> {
            try {
                byte[] bytes = person.toByteArray();
                Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };

        // Running the Performance tests for 5 times in row
        for (int i = 0; i < 5; i++) {
            runPerformanceTest(runnableJson, "JSON");
            runPerformanceTest(runnableProtoBuf, "ProtoBuf");
            System.out.println("<<================================>>");
        }

    }

    private static void runPerformanceTest(Runnable runnable, String methodName) {

        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < 5000000; i++) {
            runnable.run();
        }

        long timeStop = System.currentTimeMillis();

        System.out.println(methodName + " took: " + (timeStop - timeStart) + " ms");

    }


}
