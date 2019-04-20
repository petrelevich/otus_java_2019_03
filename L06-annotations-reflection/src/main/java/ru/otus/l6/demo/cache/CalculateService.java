package ru.otus.l6.demo.cache;

public interface CalculateService {

    @Cache
    int add(Operation operation);

}
