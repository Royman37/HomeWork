package main;

import main.exceptions.MyArrayDataException;
import main.exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        StaticArray array = new StaticArray();
        try {
            try {
                array.initializationArray(array.getArray());
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            }
        }catch (MyArrayDataException e) {
            System.out.println("Неверный тип данных!");
            System.out.println("Ячейка: " + e.i + "x" + e.j);
        }
    }
}
