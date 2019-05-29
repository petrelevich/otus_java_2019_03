package ru.otus.factoryMethod;

public class ConfigurationFile implements Configuration {
    @Override
    public String params() {
        return "params from file";
    }
}
