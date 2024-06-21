package main;

/*
Создал класс с полями.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    /*
    Конструктор, в котором поля приравниваются к аргументам из конструктора.
     */
    public Employee(String personFirstName, String personLastName, String personPosition,
                    String personEmail, String personPhone, int personSalary, int personAge) {
        this.firstName = personFirstName;
        this.lastName = personLastName;
        this.position = personPosition;
        this.email = personEmail;
        this.phone = personPhone;
        this.salary = personSalary;
        this.age = personAge;
    }

    public void info() {
        System.out.println("FirstName: " + this.firstName
                + "\nLastName: " + this.lastName
                + "\nPosition: " + this.position
                + "\nEmail: " + this.email
                + "\nPhone: " + this.phone
                + "\nSalary: " + this.salary
                + "\nAge: " + this.age);
    }

}
