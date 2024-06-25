package main;

import main.exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        StaticArray array = new StaticArray();
        try {
            array.initializationArray(array.getArray());
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
    }
}
