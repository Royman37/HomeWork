package main.exceptions;

public class MyArrayDataException extends CustomException {
    /*
    Принимает 2 значения(наши i, j из массива, чтобы знать, в какой ячейке ошибка)
     */
    public MyArrayDataException(int num1, int num2) {
        super(String.format("Неверный тип данных в ячейке: " + num1 + "x" + num2));
    }
}
