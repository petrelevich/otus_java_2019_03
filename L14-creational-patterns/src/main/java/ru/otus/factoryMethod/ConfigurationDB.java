package ru.otus.factoryMethod;

public class ConfigurationDB implements Configuration {
    @Override
    public String params() {
        return "params from DB";
    }
}
