package ru.otus.abstractFactory;

public class LuminescentFactory implements AbstractFactory {
    @Override
    public Bulb createBulb() {
        return new BulbLuminescent();
    }

    @Override
    public Lampholder createLampholder() {
        return new LampholderLuminescent();
    }
}
