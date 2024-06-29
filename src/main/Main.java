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
        park.info();
        Park.Attraction attraction = new Park.Attraction("Carousel of Death", "From 6:00 to 20:00", 666);
        Park.Attraction attraction1 = new Park.Attraction("Romashka", "From 10:00 to 18:00", 45);
        attraction.info();
        attraction1.info();
    }
}
