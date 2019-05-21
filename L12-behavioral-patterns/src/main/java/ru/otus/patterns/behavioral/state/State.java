package ru.otus.patterns.behavioral.state;

interface State {
    void writeName(StateContext context, String name);
}