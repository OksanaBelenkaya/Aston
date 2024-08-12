
class Dog extends Animal {

    private static int counter;

    public static void main(String[] args) {
    }

    public Dog(String name) {
        super(name, "Собака");
        counter++;
    }

    public void run(int distance) {
        final int MAX_RUNNING_DISTANCE_OF_THE_DOG = 500;
        if (distance <= MAX_RUNNING_DISTANCE_OF_THE_DOG) {
            super.run(distance);
        } else {
            System.out.println(name + " не сможет пробежать " + distance + " м. ");
        }
    }

    public void sail(int distance) {
        final int MAX_DISTANCE_SWIMMING_DOG = 10;
        if (distance <= MAX_DISTANCE_SWIMMING_DOG) {
            super.sail(distance);
        } else {
            System.out.println(name + " не сможет проплыть " + distance + " м.  ");
        }
    }

    public static int getCounter() {
        System.out.println("Собак - " + counter);
        return counter;
    }
}
