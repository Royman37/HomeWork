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
        Park.Attractions attractions = new Park.Attractions("Carousel, Ferris wheel", "From 9:00 to 21:00",30.0);
        Park.Attractions attractions1 = new Park.Attractions("Ferris wheel", "From 9:00 to 15:00",26.0);
        System.out.println("\nTask1: ");
        System.out.println(person.toString());

        System.out.println("\nTask2: ");
        group.joinGoup();
        /*
        С помощью сеттера можем изменить (вносим) данные о аттракционах.
        Геттер для  вывода информации (возврата т.к. return)
         */
        System.out.println("\nTask3: ");
        attractions.setAttractions("Carousel");
        attractions.setWorkingHours("9:00 to 19:00");
        attractions.setCost(35.00);
        System.out.println(attractions.getAttractions() + "\n");

        attractions1.setAttractions("New name");
        attractions1.setWorkingHours("9:00 to 21:00");
        attractions1.setCost(20.00);
        System.out.println(attractions1.getAttractions());
        System.out.println(attractions1.getWorkingHours());
        System.out.println(attractions1.getCost());
    }
}
