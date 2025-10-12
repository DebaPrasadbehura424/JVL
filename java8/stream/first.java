package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class first {
    public static void main(String[] args) {

        // Collect(),sorted(),min(),max(),forEach(),toArrays(),Stream.of();
        // it is related to group of objects
        // it is very different from io stream
        List<Integer> lists = List.of(2, 3, 4, 5, 5, 4, 5, 5);

        List<Integer> lists1 = Arrays.asList(1, 2);
        System.out.println(lists1);

        Stream<Integer> stream = lists.stream();
        List<Integer> fList = stream.filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(fList);

        Predicate<Integer> pd = i -> i % 2 == 0;
        List<Integer> sList = lists.stream().filter(pd).collect(Collectors.toList());
        System.out.println(sList);
        sList.forEach(System.out::print);
        // filter takes predicate and map takes fuctions
    }

}
