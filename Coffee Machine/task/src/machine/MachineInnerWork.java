package machine;

import java.util.Scanner;

class MachineInnerWork {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cost;
    private int dispCups;
    private int leftMoney;

    MachineInnerWork(int water, int milk, int coffeeBeans, int dispCups, int leftMoney) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.dispCups = dispCups;
        this.leftMoney = leftMoney;
    }

    MachineInnerWork(int water, int milk, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.dispCups = 1;
        this.cost = cost;
    }

    void printResources() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n", water);
        System.out.printf("%d of milk%n", milk);
        System.out.printf("%d of coffee beans%n", coffeeBeans);
        System.out.printf("%d of disposable cups%n", dispCups);
        System.out.printf("%d of money%n", leftMoney);
    }

    boolean checkResources(MachineInnerWork someCoffee) {
        String str = "";
        boolean check = true;

        if (water < someCoffee.water) {
            str = "water";
            check = false;
        } else if (milk < someCoffee.milk) {
            str = "milk";
            check = false;
        } else if (coffeeBeans < someCoffee.coffeeBeans) {
            str = "coffeeBeans";
            check = false;
        } else if (dispCups < someCoffee.dispCups) {
            str = "disposable cups";
            check = false;
        }

        if (check) {
            System.out.printf("I have enough resources, making you a coffee!\n");
        } else {
            System.out.printf("Sorry, not enough %s!\n", str);
        }

        return check;
    }

    void spendResources(MachineInnerWork someCoffee) {
        water -= someCoffee.water;
        milk -= someCoffee.milk;
        coffeeBeans -= someCoffee.coffeeBeans;
        dispCups -= someCoffee.dispCups;
        leftMoney += someCoffee.cost;
    }

    void fillResources() {
        System.out.println("Enter quantity of water, milk, coffee, cups:");
        Scanner scanner = new Scanner(System.in);

        this.water += scanner.nextInt();
        this.milk += scanner.nextInt();
        this.coffeeBeans += scanner.nextInt();
        this.dispCups += scanner.nextInt();
    }

    void takeMoney() {
        System.out.printf("I gave you $%d.%n", leftMoney);
        leftMoney = 0;
    }
}
