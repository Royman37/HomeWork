package main;

import main.exceptions.CustomException;

public class Main {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        String[][] arrays = {
                {"1", "2", "3", "1"},
                {"132", "6", "0", "4"},
                {"3", "57", "7", "2"},
                {"10", "3333", "7hello", "4"},
        };
        try {
            System.out.println("\nСумма чисел массива: " + array.initialisationArray(arrays));
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
