
public class Park {

    class Attraction {

        private final String name;
        private final String workingHours;
        private final int cost;

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

    public static void main() {

        Park park = new Park();

        Park.Attraction attraction1 = park.new Attraction("Картинг", "09:00 - 12:00", 1500);
        Park.Attraction attraction2 = park.new Attraction("Американские горки", "15:00 - 00:00", 2500);

        attraction1.printInfo();
        System.out.println("");
        attraction2.printInfo();
    }
}
