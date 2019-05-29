package ru.otus.abstractFactory;

public class BulbLuminescent implements Bulb {
    @Override
    public void light() {
        System.out.println("Luminescent light");
    }
}
