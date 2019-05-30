package ru.otus.abstractFactory;

public class LampholderLuminescent implements Lampholder {
    @Override
    public void hold() {
        System.out.println("Luminescent hold");
    }
}
