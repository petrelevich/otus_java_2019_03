package ru.otus.l6.demo.cache;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CalculateApplication {

    public static void main(String[] args) {
        Operation operation = new Operation(1, 2);
        operation.getA();
        System.out.println(operation);

//        CalculateService calculateService = makeCache(new CalculateServiceImpl());
//        System.out.println(calculateService.add(new Operation(2, 2)));
//        System.out.println(calculateService.add(new Operation(2, 3)));
//        System.out.println(calculateService.add(new Operation(2, 2)));
    }

    public static CalculateService makeCache(CalculateService calculateService) {
        Map<Operation, Integer> cache = new HashMap<>();

        Class<? extends CalculateService> clazz = calculateService.getClass();
        return (CalculateService) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("Proxy");
                    if (!method.isAnnotationPresent(Cache.class)) {
                        return method.invoke(calculateService, args);
                    }
                    Operation operation = (Operation) args[0];
                    Integer result = cache.get(operation);
                    if (result == null) {
                        System.out.println("Calculating...");
                        Thread.sleep(5000L);
                        result = calculateService.add(operation);
                        cache.put(operation, result);
                        return result;
                    } else {
                        System.out.println("From cache: " + result);
                        return result;
                    }
                });
    }


}
