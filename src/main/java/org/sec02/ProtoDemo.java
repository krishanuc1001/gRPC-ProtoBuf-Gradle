package org.sec02;

import com.proto.generatedProtoClasses.sec01.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDemo {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProtoDemo.class);

    public static void main(String[] args) {

        // Create person1
        var person1 = createPerson();

        // Create another instance of Person with same values
        var person2 = createPerson();

        // Comparison
        LOGGER.info("equals {}", person1.equals(person2));
        LOGGER.info("== {}", person1 == person2);

        // Mutability? Objects are immutable

        // Create another instance with different values
        var person3 = person1.toBuilder()
                .setName("Ram")
                .build();

        LOGGER.info("person3 {}", person3);

        LOGGER.info("********************************************");

        // Comparison
        LOGGER.info("equals {}", person1.equals(person3));
        LOGGER.info("== {}", person1 == person3);

        // Set a property, say name as null
        var person4 = person1.toBuilder()
                .clearName()
                .build();

        LOGGER.info("person 4 {}", person4);

    }

    private static Person createPerson() {
        return Person.newBuilder()
                .setName("Jane")
                .setAge(30)
                .build();
    }

}
