package main.exceptions;

public class MyArrayDataException extends Exception {
    public int i,j;
    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
