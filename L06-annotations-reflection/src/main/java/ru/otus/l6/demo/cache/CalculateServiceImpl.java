package ru.otus.l6.demo.cache;

public class CalculateServiceImpl implements CalculateService {

    @Override
    public int add(Operation operation) {
        return operation.getA() + operation.getB();
    }
}
