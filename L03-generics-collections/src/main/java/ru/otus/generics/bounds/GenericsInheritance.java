package ru.otus.generics.bounds;

import ru.otus.generics.bounds.entries.Animal;
import ru.otus.generics.bounds.entries.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergey
 * created on 23.11.18.
 */
public class GenericsInheritance {

    public static void main(String[] args) {

        Animal cat = new Cat();

        List<Cat> catList = new ArrayList<>();
        //List<Animal> animalList = catList; //ошибка
    }
}
