package org.grpc.protobuf;

import com.proto.generatedProtoClasses.sec01.Person;

public class PersonDemo {

    public static void main(String[] args) {

        Person tarzan = Person.newBuilder()
                .setName("John")
                .setAge(40)
                .build();

        Person jane = Person.newBuilder()
                .setName("Jane")
                .setAge(30)
                .build();

        System.out.println(tarzan.equals(jane));

    }
}
