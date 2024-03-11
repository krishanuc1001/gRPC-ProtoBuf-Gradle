package org.sec03;

public record JsonPerson(String lastName,
                         int age,
                         String email,
                         boolean employed,
                         double salary,
                         long bankAccountNum,
                         int balance) {
}
