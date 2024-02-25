package org.sec03;

import com.proto.generatedProtoClasses.sec03.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Top01ScalarTypes {

    private static final Logger LOGGER = LoggerFactory.getLogger(Top01ScalarTypes.class);

    public static void main(String[] args) {

        // Note: All the Properties of a proto object are optional,
        //       and doesn't throw exception when missing.

        Person person = Person.newBuilder()
                .setLastName("Chakraborty")
                .setAge(33)
                .setEmail("abc@xyz.com")
                .setEmployed(true)
                .setSalary(45635.74774)
                .setBankAccountNumber(123456789012L)
                .setBalance(-10000)
                .build();

        LOGGER.info("person {}", person);

    }

}
