
public class Main {

    public static void main(String[] args) {
        Bowl bowl = new Bowl();
        Cat cat = new Cat("Симба", 12);
        Cat cat1 = new Cat("Мурзик", 20);
        Cat cat3 = new Cat("Дымок", 12);
        Cat cat2 = new Cat("Пушок", 5);
        Dog dog = new Dog("Мухтар");
        Cat[] cats = {cat1, cat2, cat3};

        bowl.setFoodInBowl(17);

        dog.run(100);
        dog.sail(5);

        cat.run(90);
        cat.sail(5);

        int countCats = cat.getCounter();
        int countDogs = dog.getCounter();
        System.out.println("Животных: " + (countCats + countDogs));
        feeding(cats, bowl);
    }

    public static void feeding(Cat[] cats, Bowl bowl) {
        for (Cat currentCat : cats) {
            currentCat.eat(bowl.food);
            if (bowl.food >= currentCat.maxFoodValue) {
                bowl.setFoodInBowl(bowl.food - currentCat.maxFoodValue);
            }
            System.out.println(currentCat.getName() + "-" + currentCat.getSatiety());
        }
    }

}
