package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Streams {

    private static List<Student> students;

    static {
        Student s1 = new Student("Alex", 22, 5, 4.5);
        Student s2 = new Student("Maria", 22, 5, 3.5);
        Student s3 = new Student("John", 12, 4, 4.7);
        Student s4 = new Student("Bob", 22, 5, 4.8);
        Student s5 = new Student("Anna", 20, 3, 4.5);
        students = Arrays.asList(s1, s2, s3, s4, s5);
    }

    public static void main(String[] args) throws IOException {
        creating();
       // stringsJoiner();
       // filterMapReduce();
       // linesReader();
       // System.out.println(getAvgMark());
       // groupBy(students);
    }

    private static void creating() {
        Stream<String> empty = Stream.empty();
            empty.forEach(System.out::println);
        Stream<Integer> single = Stream.of(10);
            single.forEach(System.out::println);
        Stream<Integer> array = Stream.of(1, 2, 3);
            array.forEach(System.out::print);
        IntStream range = IntStream.range(1, 5);
            range.forEach(System.out::print);
    }

    private static void stringsJoiner() {
        String[] arrayOfString = {"A", "B", "C", "D"};
        String result = Arrays.stream(arrayOfString).collect(Collectors.joining(","));
        System.out.println(result);

        String result2 = String.join(",", arrayOfString);
        System.out.println(result2);
    }

    private static void filterMapReduce() {
        System.out.println("filterMapReduce");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int result = list.stream()
                .filter(val -> val % 2 > 0).peek(System.out::println)
                .map(val -> val * 10).peek(System.out::println)
                .reduce(0, Integer::sum);
        System.out.println("result:" + result);
    }

    private static void linesReader() throws IOException {
        String suffix = "-suff";
        Files.lines(Paths.get("lines.txt"))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .sorted(Comparator.comparingLong(String::hashCode))
                .map(line -> line.hashCode() + "\t" + line.concat(suffix))
                .forEach(System.out::println);
    }

    private static double getAvgMark() {
        OptionalDouble avg = students.stream()
                .filter(st -> st.getCourse() == 5)
                .mapToDouble(Student::getAvgMark)
                .average();

        return avg.orElse(0.0);
    }

    private static void groupBy(List<Student> students) {
        Map<Integer, List<Student>> map = students.stream()
                .collect(Collectors.groupingBy(Student::getCourse));
        System.out.println(map);
    }
}
