package org.sec01;

import com.proto.generatedProtoClasses.sec01.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

    public static final Logger LOGGER = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {

        Person tarzan = Person.newBuilder()
                .setName("Tarzan")
                .setAge(40)
                .build();

        LOGGER.info("{}", tarzan);
    }

}
