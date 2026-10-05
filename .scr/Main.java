public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        System.out.println("--- Пустая книга ---");
        book.printAll();
        System.out.println("Среднее: " + book.averageSalary());
        book.printFirstWithSalaryAbove(1, 100);
        book.printWithSalaryBelow(300, 3);
        System.out.println("Поиск по id: " + book.getById(1));

        String[] names = {"Иванов Иван Иванович", "Петров Петр Петрович", "Сидорова Анна Сергеевна",
                "Кузнецов Олег Игоревич", "Смирнова Мария Павловна", "Попов Дмитрий Андреевич",
                "Лебедева Елена Викторовна", "Новиков Артем Львович", "Морозова Ольга Ильинична",
                "Волков Сергей Николаевич", "Соколов Андрей Романович"};
        int[] departments = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 1};
        int[] salaries = {50, 100, 150, 151, 200, 350, 351, 400, 450, 120, 100};

        System.out.println("--- Добавление 11 сотрудников ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " -> " + book.addEmployee(new Employee(names[i], departments[i], salaries[i])));
        }

        System.out.println("--- Все сотрудники ---");
        book.printAll();
        System.out.println("Среднее: " + book.averageSalary());

        System.out.println("--- PROPORTIONAL ---");
        book.printTaxes("PROPORTIONAL");
        System.out.println("--- PROGRESSIVE ---");
        book.printTaxes("PROGRESSIVE");
        book.printTaxes("OTHER");

        System.out.println("--- Индексация отдела 1 на 10% ---");
        book.indexSalaries(1, 10);
        book.printAll();

        System.out.println("--- Первый с зарплатой выше порога ---");
        book.printFirstWithSalaryAbove(2, 150);
        book.printFirstWithSalaryAbove(3, 199);
        book.printFirstWithSalaryAbove(5, 450);

        System.out.println("--- До 3 сотрудников с зарплатой ниже wage ---");
        book.printWithSalaryBelow(200, 3);
        book.printWithSalaryBelow(50, 3);

        System.out.println("--- contains (по зарплате) ---");
        System.out.println(book.contains(new Employee("Тест", 1, 200)));
        System.out.println(book.contains(new Employee("Тест", 1, 201)));

        System.out.println("--- По id ---");
        System.out.println(book.getById(3));
        System.out.println(book.getById(999));
    }
}
