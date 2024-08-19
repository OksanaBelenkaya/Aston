
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Задание №1. Использование коллекций.");
        System.out.println(" ");

        WordAnalyzer.analyzeWords();

        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Зайцев", "+7 111-222-33-33");
        phoneDirectory.add("Сметанкин", "+7 987-654-32-10");
        phoneDirectory.add("Мигулин", "+7 989-345-89-65");
        phoneDirectory.add("Мигулин", "+7 988-348-89-85");
        phoneDirectory.add("Мигулин", "+7 999-999-99-99");
        phoneDirectory.add("Зайцев", "+0 111-222-33-33");

        System.out.println(" ");
        System.out.println("Задание №2. Справочник номеров.");
        System.out.println(" ");

        List<String> номераЗайцева = phoneDirectory.get("Зайцев");
        System.out.println("Номера Зайцева: " + номераЗайцева);

        List<String> номераСметанкина = phoneDirectory.get("Сметанкин");
        System.out.println("Номера Сметанкина: " + номераСметанкина);

        List<String> номераМигулина = phoneDirectory.get("Мигулин");
        System.out.println("Номера Мигулина: " + номераМигулина);

        List<String> номераМагулина = phoneDirectory.get("Магулин");
        System.out.println("Номера Магулина: " + номераМагулина);

        List<String> номераСамаркина = phoneDirectory.get("Самаркин");
        System.out.println("Номера Сметанкина: " + номераСамаркина);

    }
}
