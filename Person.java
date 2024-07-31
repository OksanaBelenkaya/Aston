
class Person {

    String fullName;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

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

    public static void main(String[] args) {

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

class Park {

    class Attraction {

        String name;
        String workingHours;
        int cost;

        public Attraction(String name, String workingHours, int cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printInfo() {
            System.out.println("Название: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost);
        }
    }

    public static void main(String[] args) {

        Park park = new Park();

        Park.Attraction attraction1 = park.new Attraction("Картинг", "09:00 - 12:00", 1500);
        Park.Attraction attraction2 = park.new Attraction("Американские гоки", "15:00 - 00:00", 2500);

        attraction1.printInfo();
        System.out.println("");
        attraction2.printInfo();
    }
}
