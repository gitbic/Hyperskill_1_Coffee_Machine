package machine;

enum CoffeeMenu {
    ESPRESSO("1", 250, 0, 16, 4),
    LATTE("2", 350, 75, 20, 7),
    CAPPUCCINO("3", 200, 100, 12, 6);

    private String str;
    private int water;
    private int milk;
    private int coffeeBean;
    private int cost;

    CoffeeMenu(String str, int water, int milk, int coffeeBean, int cost) {
        this.str = str;
        this.water = water;
        this.milk = milk;
        this.coffeeBean = coffeeBean;
        this.cost = cost;
    }

    public String getNumber() {return str;}
    public int getWater() {return water;}
    public int getMilk() {return milk;}
    public int getCoffeeBean() {return coffeeBean;}
    public int getCost() {return cost;}
}
