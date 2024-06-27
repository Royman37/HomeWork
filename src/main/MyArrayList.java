package main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyArrayList {
    public void countWords() {
        /*
        Создаём массив типа String и добавляем туда слова.
         */
        ArrayList<String> people = new ArrayList<String>();
        people.add("Roma");
        people.add("James");
        people.add("John");
        people.add("Mary");
        people.add("Bob");
        people.add("Jack");
        people.add("Jane");
        people.add("Joe");
        people.add("Jack");
        people.add("Jane");
        people.add("Roma");
        /*
        С помощью Set отбираем уникальные элементы.
         */
        Set<String> set = new LinkedHashSet<String>(people);
        System.out.println("Начальный список: " + people);
        System.out.println("Уникальные элементы из списка: " + set);

        /*
        Подсчитываем каждый элемент, сколько раз он повторяется.
         */
        Map<String, Long> countPeople = people.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        countPeople.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
