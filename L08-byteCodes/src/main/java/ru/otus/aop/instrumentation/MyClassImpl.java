package ru.otus.aop.instrumentation;


import ru.otus.aop.proxy.MyClassInterface;

public class MyClassImpl implements MyClassInterface {

    public void secureAccess(String param) {
        System.out.println("secureAccess, param:" + param);
    }

    @Override
    public String toString() {
        return "MyClassImpl{}";
    }
}
