import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER_PER_CUP = 200; // мл води
    private static final int MILK_PER_CUP = 50;  // мл молока
    private static final int BEANS_PER_CUP = 15; // г кавових зерен

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.calculateIngredients();
    }

    public void calculateIngredients() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть, скільки чашок кави ви хочете приготувати:");
        int numberOfCups = scanner.nextInt();

        int totalWater = numberOfCups * WATER_PER_CUP;
        int totalMilk = numberOfCups * MILK_PER_CUP;
        int totalBeans = numberOfCups * BEANS_PER_CUP;

        System.out.println("Для " + numberOfCups + " чашок кави вам знадобиться:");
        System.out.println(totalWater + " мл води");
        System.out.println(totalMilk + " мл молока");
        System.out.println(totalBeans + " г кавових зерен");
    }
}
