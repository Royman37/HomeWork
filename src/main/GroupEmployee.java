package main;

import java.util.Arrays;

public class GroupEmployee {
    /*
    Создал метод для реализации в отдельном классе, в Main не хотел засовывать массив.(там и так не красиво)
     */
            public void joinGoup() { //создал метод для создания отдельного массива.
                Employee[] employees = new Employee[5];

                employees[0] = new Employee("Mickey", "O'Neill", "Traider",
                        "mik@gmail.com", "+375299912345", 32000, 25);

                employees[1] = new Employee("Tony", "Montana", "Businessman",
                        "tony123@gmail.com", "+375299976345", 1500000, 62);

                employees[2] = new Employee("Gandalf", "The Green", "Mage",
                        "fireman228@gmail.com", "+37544444222", 5000, 1500);

                employees[3] = new Employee("John", "Constantine", "The Exorcist",
                        "john666@gmail.com", "+3756666666", 14000, 35);

                employees[4] = new Employee("Tony", "Bullet in teeth",
                        "Businessman", "tonybullet@gmail.com", "+375441233232",
                        50000, 38);
                /*
                В задании не указан какой либо вывод, возврат.
                Сделал для проверки массива.
                 */
                for(Employee employee : employees) {
                    System.out.println("\n" + employee);
                }
            }
}