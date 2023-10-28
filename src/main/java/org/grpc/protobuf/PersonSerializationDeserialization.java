package org.grpc.protobuf;

import com.proto.generatedProtoClasses.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class PersonSerializationDeserialization {

    public static void main(String[] args) throws IOException {

        // Serialization
        Person john = Person.newBuilder()
                .setName("John")
                .setAge(35)
                .build();

        Path path = Paths.get("john.serialized");
        Files.write(path, john.toByteArray());
        /* Serialization Output:
         * john.serialized file is created in the project root directory
         */


        // Deserialization
//        Path path = Paths.get("john.serialized");
        byte[] bytes = Files.readAllBytes(path);
        Person johnNew = Person.parseFrom(bytes);
        System.out.println(johnNew);

        /* De-serialization Output:
         * name: "John"
         * age: 35
         */

    }
}
