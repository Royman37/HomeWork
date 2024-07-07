package main;

import main.exceptions.MyArrayDataException;
import main.exceptions.MyArraySizeException;

import java.util.Arrays;

public class MyArray {
    private int sum;

    public int initialisationArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.deepToString(array[i]));
            if (array[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
