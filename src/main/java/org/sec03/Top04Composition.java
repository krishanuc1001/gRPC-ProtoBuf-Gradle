package org.sec03;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proto.generatedProtoClasses.sec03.Address;
import com.proto.generatedProtoClasses.sec03.School;
import com.proto.generatedProtoClasses.sec03.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Top04Composition {

    private static final Logger LOGGER = LoggerFactory.getLogger(Top04Composition.class);

    public static void main(String[] args) {

        // Create Address obj
        Address address = Address.newBuilder()
                .setStreet("10/1, Wellington")
                .setCity("Kolkata")
                .setState("West Bengal")
                .build();

        // Create Student obj
        Student student = Student.newBuilder()
                .setName("Krishanu Chakraborty")
                .setAddress(address)
                .build();

        // Create School obj
        School school = School.newBuilder()
                .setId(10)
                .setName("GLLES")
                .setAddress(address.toBuilder().setStreet("123 Downing Street"))
                .build();


        LOGGER.info("Student: {}", student);
        LOGGER.info("School: {}", school);

    }

}
