import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть суму кредиту:");
        int principal = scanner.nextInt();

        System.out.println("Що ви хочете розрахувати?");
        System.out.println("введіть \"m\" – для кількості місячних платежів,");
        System.out.println("введіть \"p\" – для розміру щомісячного платежу:");
        char choice = scanner.next().charAt(0);

        if (choice == 'm') {
            System.out.println("Введіть розмір щомісячного платежу:");
            int monthlyPayment = scanner.nextInt();

            int months = (int) Math.ceil((double) principal / monthlyPayment);
            System.out.println("Для погашення кредиту знадобиться " + months + " місяців.");

        } else if (choice == 'p') {
            System.out.println("Введіть кількість місяців:");
            int months = scanner.nextInt();

            int monthlyPayment = (int) Math.ceil((double) principal / months);
            int lastPayment = principal - (months - 1) * monthlyPayment;

            if (lastPayment == monthlyPayment) {
                System.out.println("Ваш щомісячний платіж = " + monthlyPayment);
            } else {
                System.out.println("Ваш щомісячний платіж = " + monthlyPayment + " і останній платіж = " + lastPayment);
            }
        } else {
            System.out.println("Невірний вибір. Спробуйте ще раз.");
        }

        scanner.close();
    }
}
