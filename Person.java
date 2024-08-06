
class Person {

    private final String fullName;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final int salary;
    private final int age;

    public Person(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println(" ");
    }

    public static void main() {

        Person employee = new Person("Изабелла Мари Свон", "Intern", "almax@yandex.ru", "89098905721", 30000, 25);

        employee.printInfo();

        Person[] employees = new Person[5];
        employees[0] = new Person("Гарри Поттер", "Engineer", "avat@yandex.ru", "79084657693", 10000, 20);
        employees[1] = new Person("Гермиона Грейнджер", "Intern", "asvalt@yandex.ru", "79089364783", 1000, 25);
        employees[2] = new Person("Рон Уизли", "Director", "wery@yandex.ru", "78089004783", 25000, 26);
        employees[3] = new Person("Сириус Блэк", "Programmer", "tututu@yandex.ru", "79048900478", 79900, 45);
        employees[4] = new Person("Седрик Диггори", "Secretar", "bud@yandex.ru", "70887978470", 90000, 35);

        for (Person emp : employees) {
            emp.printInfo();
        }
    }

}
