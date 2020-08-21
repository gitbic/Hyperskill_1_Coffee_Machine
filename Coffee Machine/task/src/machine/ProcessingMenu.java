package machine;

class ProcessingMenu {

    private String coffeeMenu;
    private String mainMenu;

    void showMainMenu() {
        if (this.mainMenu == null) {
            makeMainMenu();
        }
        System.out.println(mainMenu);
    }

    void showCoffeeMenu() {
        if (this.coffeeMenu == null) {
            makeCoffeeMenu();
        }
        System.out.println(coffeeMenu);
    }

    private void makeMainMenu() {
        String str = "";
        for (MainMenu menu : MainMenu.values()) {
            str += menu.name().toLowerCase() + ", ";
        }
        str = "\nWrite action: " + str.substring(0, str.length() - 2);
        this.mainMenu = str;
    }

    private void makeCoffeeMenu() {
        String str = "";
        for (CoffeeMenu menu : CoffeeMenu.values()) {
            str += menu.getNumber() + " - " + menu.name().toLowerCase() + ", ";
        }
        str = "\nWhat do you want to buy? " + str.substring(0, str.length() - 2);
        this.coffeeMenu = str;
    }
}
