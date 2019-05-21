package ru.otus.patterns.behavioral.memento;

public class Originator {
    private byte[] state;

    public void setState(String state) {
        this.state = state.getBytes();
    }

    public byte[] getState() {
        return state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(Memento memento) {
        this.state = memento.getState();
    }

    public String toString() {
        return new String(state);
    }
}