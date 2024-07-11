package main;

public class Main {
    public static void main(String[] args) {
        MyArrayList array = new MyArrayList();
        PhoneBook book = new PhoneBook();
        array.countWords();
        book.addingАUser("John", "+375 44 001 23 32");
        book.addingАUser("John", "+375 44 001 11 33");
        book.addingАUser("Jason", "+375 44 001 66 66");
        book.addingАUser("Sam", "+375 29 221 36 76");
        book.addingАUser("Sonya", "+375 44 001 87 00");
        book.addingАUser("Jax", "+375 29 001 22 11");
        book.addingАUser("Jax", "+375 29 001 22 00");

        System.out.println("\nTask: 2");
        System.out.println(book.toString());
        book.gettingUser("Sonya");
        book.gettingUser("John");
        book.gettingUser("Jax");
    }
}
