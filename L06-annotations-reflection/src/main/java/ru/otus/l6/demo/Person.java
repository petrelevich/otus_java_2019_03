package ru.otus.l6.demo;


public class Person {

    @Length
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
