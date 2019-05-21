package ru.otus.patterns.behavioral.visitor;

interface CarElement {
    void accept(CarElementVisitor visitor);
}