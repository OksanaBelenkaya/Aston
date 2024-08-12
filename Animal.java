
class Animal {

    String name;
    String view;

    public Animal(String name, String view) {
        this.name = name;
        this.view = view;

    }

    public String getName() {
        return name;
    }

    public String getView() {
        return view;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м. ");
    }

    public void sail(int distance) {
        System.out.println(name + " проплыл " + distance + " м. ");
    }

}
