package ru.otus.l15.io;

import java.io.Serializable;

/**
 * @author sergey
 * created on 27.01.19.
 */
//implements Serializable - обязательное условие для сериализации
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int age;
    private final String name;
    private transient final String hidden; //transient - поле будет пропущено при сериализации

   // public String newField ="ddd";  //опыт с полем

    // Обратите внимание на то, сколько раз вызывается констурктор и сколько объектов создается
    Person(int age, String name, String hidden) {
        System.out.println("new Person");
        this.age = age;
        this.name = name;
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hidden='" + hidden + '\'' +
      //          ", newField='" + newField + '\'' +
                '}';
    }
}