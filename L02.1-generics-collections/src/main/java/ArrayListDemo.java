import ru.otus.generics.bounds.entries.Animal;
import ru.otus.generics.bounds.entries.Cat;
import ru.otus.generics.bounds.entries.HomeCat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sergey
 * created on 23.11.18.
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        Cat[] animalArr = new Cat[]{new HomeCat("Мурзик"), new HomeCat("Васька")};
        List<Cat> animalList = Arrays.asList(animalArr);
        System.out.println(animalList);

        animalArr[0] = new HomeCat("1");
        System.out.println(animalList);

       // animalList.add(new HomeCat("Мурка")); //Ошибка

        Animal[] catsArr = animalList.toArray(new Animal[0]);
        System.out.println("catsArr:" + Arrays.toString(catsArr));

        //copy(List<? super T> dest, List<? extends T> src)
        List<? super Cat> animalListDest = new ArrayList<>(animalList);
        Collections.copy(animalListDest, animalList);
        System.out.println("homeCats:" + animalListDest);


        //Как убрать дубли
        List<String> strDubl = Arrays.asList("1", "2", "2", "4");
        System.out.println("srtDubl:" + strDubl);
        Set<String> strDublFiltered = new HashSet<>(strDubl);
        System.out.println("strDublFiltered:" + strDublFiltered);

        //АвтоСортировка
        Set<Integer> sorted = new TreeSet<>();
        sorted.add(1);
        sorted.add(9);
        System.out.println("sorted_1:" + sorted);
        sorted.add(2);
        sorted.add(8);
        System.out.println("sorted_2:" + sorted);
    }
}
