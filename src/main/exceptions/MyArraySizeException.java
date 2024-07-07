package main.exceptions;

public class MyArraySizeException extends CustomException {
    public MyArraySizeException() {
        super("Неверный размер массива!");
    }
}
