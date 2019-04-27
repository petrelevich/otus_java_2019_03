package ru.otus.aop.instrumentation;


/*
    java -javaagent:instrumentationDemo.jar -jar instrumentationDemo.jar
*/
public class InstrumentationDemo {

    public static void main(String[] args) {
        MyClassImpl myClass = new MyClassImpl();
        myClass.secureAccess("Security Param");
    }

}
