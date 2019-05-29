package ru.otus.abstractFactory;

public class LampholderLed implements Lampholder {
    @Override
    public void hold() {
        System.out.println("Led hold");
    }
}
