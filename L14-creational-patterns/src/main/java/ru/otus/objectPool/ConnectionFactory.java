package ru.otus.objectPool;

public class ConnectionFactory {
    public Connection create() {
        return new ConnectionOracle();
    }
}
