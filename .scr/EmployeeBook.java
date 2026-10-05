public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public Employee getById(int id) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void printAll() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    // количество сотрудников до первого null
    private int count() {
        int count = 0;
        while (count < employees.length && employees[count] != null) {
            count++;
        }
        return count;
    }

    public double averageSalary() {
        int count = count();
        if (count == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < count; i++) {
            sum += employees[i].getSalary();
        }
        return (double) sum / count;
    }

    public void printTaxes(String type) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            double salary = employee.getSalary();
            double rate;
            switch (type) {
                case "PROPORTIONAL":
                    rate = 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary <= 150) {
                        rate = 0.13;
                    } else if (salary <= 350) {
                        rate = 0.17;
                    } else {
                        rate = 0.21;
                    }
                    break;
                default:
                    System.out.println("Неизвестный тип расчета: " + type);
                    return;
            }
            System.out.printf("%s: налог %.2f%n", employee.getFullName(), salary * rate);
        }
    }

    public void indexSalaries(int department, double percent) {
        for (Employee employee : employees) {
            if (employee == null || employee.getDepartment() != department) {
                continue;
            }
            int newSalary = (int) Math.round(employee.getSalary() * (1 + percent / 100));
            newSalary = Math.max(Employee.MIN_SALARY, Math.min(Employee.MAX_SALARY, newSalary));
            if (newSalary == employee.getSalary()) {
                continue;
            }
            employee.setSalary(newSalary);
        }
    }

    public void printFirstWithSalaryAbove(int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > salary) {
                System.out.print("№" + (i + 1) + ": ");
                employee.printShortInfo();
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }

    public void printWithSalaryBelow(int wage, int employeeNumber) {
        int i = 0;
        int found = 0;
        while (i < employees.length && found < employeeNumber) {
            Employee employee = employees[i++];
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < wage) {
                employee.printShortInfo();
                found++;
            }
        }
        if (found == 0) {
            System.out.println("Сотрудники не найдены");
        }
    }

    public boolean contains(Employee other) {
        for (Employee employee : employees) {
            if (employee != null && employee.equals(other)) {
                return true;
            }
        }
        return false;
    }
}
