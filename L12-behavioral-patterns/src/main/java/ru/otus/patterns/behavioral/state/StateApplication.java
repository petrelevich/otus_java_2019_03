package ru.otus.patterns.behavioral.state;

public class StateApplication {
    public static void main(String[] args) {
        final StateContext sc = new StateContext();
        sc.writeName("Эники");
        sc.writeName("Беники");
        sc.writeName("Ели");
        sc.writeName("Вареники");
        sc.writeName("Трям!");
        for(int i = 0; i < 100; i++) {
            sc.writeName("Hello " + i);
        }
    }
}
