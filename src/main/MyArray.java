package main;

import main.exceptions.MyArrayDataException;
import main.exceptions.MyArraySizeException;

public class MyArray {
    private int parce;
    private int sum;
    private String[][] array = new String[4][4];

    public void initializationArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Неверный размер массива!");
        }
        System.out.println("Task1: Массив типа String");
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                   array[i][j] = "1";
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
        System.out.println("\nTask2: Преобразованный массив в int");
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                try {
                    parce = Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                System.out.print(parce + " ");
                sum += parce;
            }
        }
        System.out.println("\nСумма всех чисел: " + sum);
    }

    public String[][] getArray() {
        return array;
    }
}
