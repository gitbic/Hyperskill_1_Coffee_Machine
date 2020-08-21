package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MachineInnerWork coffeeMachine = new MachineInnerWork(400, 540, 120, 9, 550);
        MachineInnerWork someCoffee = null;

        State stateCoffeeMachine = State.POWER_ON;
        ProcessingMenu process = new ProcessingMenu();
        MainMenu chooseAction;
        CoffeeMenu chooseCoffee;
        String inputString;

        while (stateCoffeeMachine != State.POWER_OFF) {

            switch (stateCoffeeMachine) {

                case POWER_ON:
                    stateCoffeeMachine = State.MAIN_MENU;
                    break;

                case MAIN_MENU:
                    process.showMainMenu();
                    stateCoffeeMachine = State.CHOOSE_ACTION;
                    break;

                case COFFEE_MENU:
                    process.showCoffeeMenu();
                    stateCoffeeMachine = State.CHOOSE_COFFEE;
                    break;

                case CHOOSE_ACTION:
                    chooseAction = null;
                    inputString = scanner.nextLine();

                    for (MainMenu menu : MainMenu.values()) {
                        if (menu.name().equalsIgnoreCase(inputString)) {
                            chooseAction = menu;
                        }
                    }

                    if (chooseAction == null) {
                        System.out.println("Invalid action.");
                        stateCoffeeMachine = State.MAIN_MENU;
                        break;
                    }

                    switch (chooseAction) {
                        case BUY:
                            stateCoffeeMachine = State.COFFEE_MENU;
                            break;
                        case FILL:
                            stateCoffeeMachine = State.FILL_RESOURCES;
                            break;
                        case TAKE:
                            stateCoffeeMachine = State.TAKE_MONEY;
                            break;
                        case REMAINING:
                            stateCoffeeMachine = State.SHOW_RESOURCES;
                            break;
                        case EXIT:
                            stateCoffeeMachine = State.POWER_OFF;
                            break;
                    }
                    break;

                case CHOOSE_COFFEE:
                    someCoffee = null;
                    inputString = scanner.nextLine();

                    if (inputString.equals("back")) {
                        stateCoffeeMachine = State.MAIN_MENU;
                        break;
                    }

                    for (CoffeeMenu menu : CoffeeMenu.values()) {
                        if (menu.getNumber().equalsIgnoreCase(inputString)) {
                            someCoffee = new MachineInnerWork(menu.getWater(), menu.getMilk(), menu.getCoffeeBean(), menu.getCost());
                            stateCoffeeMachine = State.MAKE_COFFEE;
                            break;
                        }
                    }

                    if (someCoffee == null) {
                        System.out.println("Incorrect choose!");
                        stateCoffeeMachine = State.COFFEE_MENU;
                        break;
                    }
                    break;

                case MAKE_COFFEE:
                    if (coffeeMachine.checkResources(someCoffee)) {
                        coffeeMachine.spendResources(someCoffee);
                    }
                    stateCoffeeMachine = State.MAIN_MENU;
                    break;

                case FILL_RESOURCES:
                    coffeeMachine.fillResources();
                    stateCoffeeMachine = State.MAIN_MENU;
                    break;

                case TAKE_MONEY:
                    coffeeMachine.takeMoney();
                    stateCoffeeMachine = State.MAIN_MENU;
                    break;

                case SHOW_RESOURCES:
                    coffeeMachine.printResources();
                    stateCoffeeMachine = State.MAIN_MENU;
                    break;
            }
        }
    }
}






