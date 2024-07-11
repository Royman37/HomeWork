package main;

import java.util.*;

public class MyArrayList {
    public void countWords() {
        /*
        Создаём массив типа String и добавляем туда слова.
         */

        ArrayList<String> people = new ArrayList<>();
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

        Set<String> set = new LinkedHashSet<>(people);
        System.out.println("Начальный список: " + people);
        System.out.println("Уникальные элементы из списка: " + set);

        /*
        Подсчитываем каждый элемент, сколько раз он повторяется.
        Через метод frequency();
         */

        for (String key : set) {
            System.out.println(key + ": " + Collections.frequency(people, key));
        }
    }
}
