package main.exceptions;

public class MyArrayDataException extends Exception {
    public int num1,num2;
    public MyArrayDataException(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
