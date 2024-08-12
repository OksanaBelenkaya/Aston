
class Bowl {

    int food;

    public static void main(String[] args) {
    }

    void setFoodInBowl(int value) {
        if (value >= 0) {
            food = value;
        } else {
            food = 0;
        }
    }

}
