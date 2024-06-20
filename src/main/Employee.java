package main;

public class Employee {
    public String name;
    public String position;
    public String email;
    public String phone;
    public int salary;
    public int age;

    public Employee(String personName, String personPosition, String personEmail, String personPhone, int personSalary, int personAge) {
        this.name = personName;
        this.position = personPosition;
        this.email = personEmail;
        this.phone = personPhone;
        this.salary = personSalary;
        this.age = personAge;
    }

    public void info() {
        System.out.println("Name: " + this.name + "Position: " + this.position + "Email: " + this.email + "Phone: " + this.phone + "Salary: " + this.salary + "Age: " + this.age);
    }

}
