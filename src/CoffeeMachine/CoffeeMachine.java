import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Кавомашина має:");
            System.out.println(water + " мл води");
            System.out.println(milk + " мл молока");
            System.out.println(coffeeBeans + " г кавових зерен");
            System.out.println(disposableCups + " одноразових стаканчиків");
            System.out.println(money + " грн");

            System.out.println("Виберіть дію (buy, fill, take):");
            String action = scanner.nextLine();

            if (action.equals("buy")) {
                buyCoffee(scanner);
            } else if (action.equals("fill")) {
                fillMachine(scanner);
            } else if (action.equals("take")) {
                takeMoney();
            }
        }
    }

    public void buyCoffee(Scanner scanner) {
        System.out.println("Що ви хочете купити? 1 - еспресо, 2 - лате, 3 - капучино:");
        int coffeeChoice = Integer.parseInt(scanner.nextLine());

        int requiredWater = 0;
        int requiredMilk = 0;
        int requiredBeans = 0;
        int price = 0;

        switch (coffeeChoice) {
            case 1: // еспресо
                requiredWater = 250;
                requiredBeans = 16;
                price = 4;
                break;
            case 2: // лате
                requiredWater = 350;
                requiredMilk = 75;
                requiredBeans = 20;
                price = 7;
                break;
            case 3: // капучино
                requiredWater = 200;
                requiredMilk = 100;
                requiredBeans = 12;
                price = 6;
                break;
        }

        if (water >= requiredWater && milk >= requiredMilk && coffeeBeans >= requiredBeans && disposableCups > 0) {
            water -= requiredWater;
            milk -= requiredMilk;
            coffeeBeans -= requiredBeans;
            disposableCups--;
            money += price;

            System.out.println("Ваша кава готова! Ви купили каву за " + price + " грн.");
        } else {
            if (water < requiredWater) {
                System.out.println("Перепрошую, недостатньо води!");
            }
            if (milk < requiredMilk) {
                System.out.println("Перепрошую, недостатньо молока!");
            }
            if (coffeeBeans < requiredBeans) {
                System.out.println("Перепрошую, недостатньо кавових зерен!");
            }
            if (disposableCups <= 0) {
                System.out.println("Перепрошую, недостатньо одноразових стаканчиків!");
            }
        }
    }

    public void fillMachine(Scanner scanner) {
        System.out.println("Скільки мл води ви хочете додати?");
        water += Integer.parseInt(scanner.nextLine());

        System.out.println("Скільки мл молока ви хочете додати?");
        milk += Integer.parseInt(scanner.nextLine());

        System.out.println("Скільки грамів кавових зерен ви хочете додати?");
        coffeeBeans += Integer.parseInt(scanner.nextLine());

        System.out.println("Скільки одноразових стаканчиків ви хочете додати?");
        disposableCups += Integer.parseInt(scanner.nextLine());

        System.out.println("Запаси оновлені.");
    }

    public void takeMoney() {
        System.out.println("Я вручив вам " + money + " грн");
        money = 0;
    }
}
