package SortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (checkNameLength(firstName)) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (checkNameLength(lastName)) {
            this.lastName = lastName;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must not be zero or negative");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary can't be less than 460.0");
        }
        this.salary = salary;
    }

    private boolean checkNameLength(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Names must be at least 3 symbols");
        }
        return true;
    }

    public void increaseSalary(double percentage) {
        if (this.age < 30) {
            this.setSalary(this.salary + (this.salary * percentage / 200));
        } else {
            this.setSalary(this.salary + (this.salary * percentage / 100));
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", this.firstName, this.lastName, this.salary);
    }
}
