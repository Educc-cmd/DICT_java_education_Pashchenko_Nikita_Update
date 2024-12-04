import java.util.Scanner;

public class CoffeeMachine {
    private enum State {
        MAIN_MENU, CHOOSE_COFFEE, FILL_MACHINE
    }

    private State state = State.MAIN_MENU;

    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть дію (buy, fill, take, remaining, exit):");
            String input = scanner.nextLine();
            coffeeMachine.processInput(input);
        }
    }

    public void processInput(String input) {
        switch (state) {
            case MAIN_MENU:
                handleMainMenu(input);
                break;
            case CHOOSE_COFFEE:
                handleChooseCoffee(input);
                break;
            case FILL_MACHINE:
                handleFillMachine(input);
                break;
        }
    }

    private void handleMainMenu(String input) {
        switch (input) {
            case "buy":
                state = State.CHOOSE_COFFEE;
                System.out.println("Що ви хочете купити? 1 - еспресо, 2 - лате, 3 - капучино, back – повернутися до головного меню:");
                break;
            case "fill":
                state = State.FILL_MACHINE;
                System.out.println("Скільки мл води ви хочете додати?");
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                showRemaining();
                break;
            case "exit":
                System.out.println("Кавоварка вимикається...");
                System.exit(0);
                break;
            default:
                System.out.println("Невірна команда. Спробуйте ще раз.");
        }
    }

    private void handleChooseCoffee(String input) {
        if (input.equals("back")) {
            state = State.MAIN_MENU;
            return;
        }

        int requiredWater = 0;
        int requiredMilk = 0;
        int requiredBeans = 0;
        int price = 0;

        switch (input) {
            case "1": // еспресо
                requiredWater = 250;
                requiredBeans = 16;
                price = 4;
                break;
            case "2": // лате
                requiredWater = 350;
                requiredMilk = 75;
                requiredBeans = 20;
                price = 7;
                break;
            case "3": // капучино
                requiredWater = 200;
                requiredMilk = 100;
                requiredBeans = 12;
                price = 6;
                break;
            default:
                System.out.println("Невірний вибір, виберіть 1, 2, 3 або back.");
                return;
        }

        if (water >= requiredWater && milk >= requiredMilk && coffeeBeans >= requiredBeans && disposableCups > 0) {
            water -= requiredWater;
            milk -= requiredMilk;
            coffeeBeans -= requiredBeans;
            disposableCups--;
            money += price;

            System.out.println("У мене є достатньо ресурсів, роблю вам каву!");
        } else {
            if (water < requiredWater) {
                System.out.println("Вибачте, недостатньо води!");
            }
            if (milk < requiredMilk) {
                System.out.println("Вибачте, недостатньо молока!");
            }
            if (coffeeBeans < requiredBeans) {
                System.out.println("Вибачте, недостатньо кавових зерен!");
            }
            if (disposableCups <= 0) {
                System.out.println("Вибачте, недостатньо одноразових стаканчиків!");
            }
        }

        state = State.MAIN_MENU;
    }

    private void handleFillMachine(String input) {
        if (water == 400) {
            water += Integer.parseInt(input);
            System.out.println("Скільки мл молока ви хочете додати?");
            return;
        }

        milk += Integer.parseInt(input);
        System.out.println("Скільки грамів кавових зерен ви хочете додати?");
    }

    private void takeMoney() {
        System.out.println("Я дав вам " + money);
        money = 0;
    }

    private void showRemaining() {
        System.out.println("Кавоварка має:");
        System.out.println(water + " мл води");
        System.out.println(milk + " мл молока");
        System.out.println(coffeeBeans + " г кавових зерен");
        System.out.println(disposableCups + " одноразових стаканчиків");
        System.out.println(money + " грн");
    }
}
