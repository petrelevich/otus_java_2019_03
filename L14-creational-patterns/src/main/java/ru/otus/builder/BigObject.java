package ru.otus.builder;

public class BigObject {
    private final String param1;
    private final String param2;
    private final String param3;
    private final String param4;
    private final String param5;

    public BigObject(String param1, String param2, String param3, String param4, String param5) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
        this.param5 = param5;
    }

    @Override
    public String toString() {
        return "BigObject{" +
                "param1='" + param1 + '\'' +
                ", param2='" + param2 + '\'' +
                ", param3='" + param3 + '\'' +
                ", param4='" + param4 + '\'' +
                ", param5='" + param5 + '\'' +
                '}';
    }

}
