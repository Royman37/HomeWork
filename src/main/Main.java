package main;

import main.exceptions.MyArrayDataException;
import main.exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {
        /*
        Создал 2 кастомных исключения MyArraySizeException и MyArrayDataException
         */
        MyArray array = new MyArray();
        try {
            try {
                array.initialisationArray(array.getArray());
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            }
        } catch (MyArrayDataException e) {
            System.out.println("Неверный тип данных!");
            System.out.println("Ячейка: " + e.num1 + "x" + e.num2);
        }
    }
}
