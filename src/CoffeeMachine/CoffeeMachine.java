import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER_PER_CUP = 200; // мл води
    private static final int MILK_PER_CUP = 50;  // мл молока
    private static final int BEANS_PER_CUP = 15; // г кавових зерен

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.checkIngredientsAndMakeCoffee();
    }

    public void checkIngredientsAndMakeCoffee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть, скільки мл води є у кавомашині:");
        int availableWater = scanner.nextInt();

        System.out.println("Введіть, скільки мл молока є у кавомашині:");
        int availableMilk = scanner.nextInt();

        System.out.println("Введіть, скільки грамів кавових зерен є у кавомашині:");
        int availableBeans = scanner.nextInt();

        System.out.println("Введіть, скільки чашок кави ви хочете приготувати:");
        int requiredCups = scanner.nextInt();

        int requiredWater = requiredCups * WATER_PER_CUP;
        int requiredMilk = requiredCups * MILK_PER_CUP;
        int requiredBeans = requiredCups * BEANS_PER_CUP;

        int maxCupsByWater = availableWater / WATER_PER_CUP;
        int maxCupsByMilk = availableMilk / MILK_PER_CUP;
        int maxCupsByBeans = availableBeans / BEANS_PER_CUP;

        int maxCups = Math.min(Math.min(maxCupsByWater, maxCupsByMilk), maxCupsByBeans);

        if (requiredCups == 0) {
            System.out.println("Yes, I can make that amount of coffee (and even " + maxCups + " more than that)");
        } else if (maxCups >= requiredCups) {
            int extraCups = maxCups - requiredCups;
            if (extraCups > 0) {
                System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.println("No, I can make only " + maxCups + " cups of coffee");
        }
    }
}
