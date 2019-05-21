package ru.otus.patterns.behavioral.visitor;

public class VisitorApplication {
    public static void main(final String[] args) {
        Car car = new Car();

        car.accept(new CarElementPrintVisitor());
        car.accept(new CarElementDoVisitor());
    }
}
