package ru.otus.generics.bounds;

import ru.otus.generics.bounds.entries.Animal;
import ru.otus.generics.bounds.entries.Cat;
import ru.otus.generics.bounds.entries.HomeCat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sergey
 * created on 23.11.18.
 */
public class WildcardPECS {

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());
        //printProducer(animalList); //ошибка
        printConsumer(animalList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printProducer(catList);
        printConsumer(catList);

        List<HomeCat> homeCatList = new ArrayList<>();
        homeCatList.add(new HomeCat("homeCat"));
        printProducer(homeCatList);

    }

    private static void printProducer(List<? extends Cat> catList) {
        //catList.add(new Object()); //Ошибка
        //catList.add(new Animal()); //Ошибка
        //catList.add(new Cat()) //Ошибка
        //catList.add(new HomeCat("f")); //Ошибка

        List<? extends Cat> catList2 = Arrays.asList(new Cat(), new HomeCat("d"));
        //catList.addAll(catList2); //Ошибка

        catList.forEach(System.out::println);
    }

    private static void printConsumer(List<? super Cat> catList) {
        //catList.add(new Animal());// Ошибка
        catList.add(new Cat());
        catList.add(new HomeCat("noName"));

        Object item = catList.get(0);
        System.out.println("item from the list:" + item);

        catList.forEach(System.out::println);
    }

}
