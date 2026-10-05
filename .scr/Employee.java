import java.util.Objects;

public class Employee {
    public static final int MIN_DEPARTMENT = 1;
    public static final int MAX_DEPARTMENT = 5;
    public static final int MIN_SALARY = 50;
    public static final int MAX_SALARY = 450;

    private static int counter = 1;

    private final int id;
    private final String fullName;
    private int department;
    private int salary;

    public Employee(String fullName, int department, int salary) {
        checkDepartment(department);
        checkSalary(salary);
        this.id = counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    private static void checkDepartment(int department) {
        if (department < MIN_DEPARTMENT || department > MAX_DEPARTMENT) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5: " + department);
        }
    }

    private static void checkSalary(int salary) {
        if (salary < MIN_SALARY || salary > MAX_SALARY) {
            throw new IllegalArgumentException("Зарплата должна быть от 50 до 450: " + salary);
        }
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        checkDepartment(department);
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        checkSalary(salary);
        this.salary = salary;
    }

    public void printShortInfo() {
        System.out.println("Сотрудник: " + fullName + ", зарплата: " + salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", ФИО=" + fullName + ", отдел=" + department + ", зарплата=" + salary + "}";
    }
}
