package ru.otus.abstractFactory;

public class BulbLed implements Bulb {
    @Override
    public void light() {
        System.out.println("Led light");
    }
}
