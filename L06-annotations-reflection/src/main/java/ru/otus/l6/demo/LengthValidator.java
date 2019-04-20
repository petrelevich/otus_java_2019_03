package ru.otus.l6.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class LengthValidator {


    public LengthValidator() {
    }

    public LengthValidator(String s) {
        System.out.println("Constructor: " + s);
    }


    public void validate(Person object) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Validating");
        Class<?> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                if (!field.isAnnotationPresent(Length.class)) {
                    continue;
                }
                field.setAccessible(true);
                System.out.println("Annotaions @Length present");
                Length length = field.getAnnotation(Length.class);
                int min = length.min();
                int max = length.max();

                String value = (String) field.get(object);
                if (max < value.length() || value.length() < min) {
                    System.out.println("Length is invalid: " + value.length());
                }
            } finally {
                field.setAccessible(false);
            }

        }
    }

}
