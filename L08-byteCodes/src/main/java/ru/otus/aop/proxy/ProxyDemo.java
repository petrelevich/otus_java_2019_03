package ru.otus.aop.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        MyClassInterface myClass = IoC.createMyClass();
        myClass.secureAccess("Security Param");
    }
}



