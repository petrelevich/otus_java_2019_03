package ru.otus.l6.demo;


import lombok.SneakyThrows;

import java.lang.reflect.Constructor;

public class DemoApplication {

    @SneakyThrows
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("1234567891011");

        Class<LengthValidator> validatorClass = LengthValidator.class;
        Constructor<LengthValidator> constructor = validatorClass.getDeclaredConstructor(String.class);
        LengthValidator lengthValidator = constructor.newInstance("Hello, world!");

        lengthValidator.validate(person);
    }

}
