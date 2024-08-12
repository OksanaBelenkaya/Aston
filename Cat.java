
class Cat extends Animal {

    private static int counter;
    private boolean satiety;
    int maxFoodValue;

    public static void main(String[] args) {
    }

    public Cat(String name, int food) {
        super(name, "Кот");
        counter++;
        satiety = false;
        maxFoodValue = food;
    }

    public void run(int distance) {
        final int MAX_RUNNING_DISTANCE_OF_THE_CAT = 200;
        if (distance <= MAX_RUNNING_DISTANCE_OF_THE_CAT) {
            super.run(distance);
        } else {
            System.out.println(name + " не сможет пробежать " + distance + " м. ");
        }
    }

    public void sail(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getCounter() {
        System.out.println("Котов - " + counter);
        return counter;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void eat(int food) {
        satiety = food >= maxFoodValue;
    }

}
