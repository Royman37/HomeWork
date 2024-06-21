package main;

public class Main {
    public static void main(String[] args) {
        Employee person = new Employee("Tony", "Bullet in teeth",
                "Businessman", "tonybullet@gmail.com", "+375441233232",
                50000, 38); //Перенес из-за слишком большой длины(как и в др. классах).
        person.info();
    }
}
