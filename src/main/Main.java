package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GroupEmployee group = new GroupEmployee();
        Employee person = new Employee("Tony", "Bullet in teeth",
                "Businessman", "tonybullet@gmail.com", "+375441233232",
                50000, 38); //Перенес из-за слишком большой длины(как и в др. классах).
        /*
        Cоздал 2 экземпляра класса Attractions
         */
        Park park = new Park("Lalaland");

        System.out.println("\nTask1: ");
        System.out.println(person.toString());

        System.out.println("\nTask2: ");
        group.joinGoup();
        System.out.println("\nTask3: ");
        park.newAttraction("Ferris wheel", "From 10:00 to 20:00", 60);
        park.newAttraction("Сarousel of death", "From 6:06 to 20:00", 666);
        park.info();

    }
}
