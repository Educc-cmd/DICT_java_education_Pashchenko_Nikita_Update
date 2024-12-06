import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Що ви хочете розрахувати?");
        System.out.println("введіть \"n\" – для кількості місячних платежів,");
        System.out.println("введіть \"a\" – для розміру ануїтетного щомісячного платежу,");
        System.out.println("введіть \"p\" – для основної суми кредиту:");
        char choice = scanner.next().charAt(0);

        switch (choice) {
            case 'n':
                calculateNumberOfPayments(scanner);
                break;
            case 'a':
                calculateAnnuityPayment(scanner);
                break;
            case 'p':
                calculateLoanPrincipal(scanner);
                break;
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
        }

        scanner.close();
    }

    private static void calculateNumberOfPayments(Scanner scanner) {
        System.out.println("Введіть основну суму кредиту:");
        double principal = scanner.nextDouble();

        System.out.println("Введіть щомісячний платіж:");
        double payment = scanner.nextDouble();

        System.out.println("Введіть відсоткову ставку (річну у відсотках):");
        double interestRate = scanner.nextDouble() / 100 / 12;

        double months = Math.log(payment / (payment - interestRate * principal)) / Math.log(1 + interestRate);
        int roundedMonths = (int) Math.ceil(months);

        int years = roundedMonths / 12;
        int remainingMonths = roundedMonths % 12;

        if (years > 0 && remainingMonths > 0) {
            System.out.println("Для погашення кредиту знадобиться " + years + " років і " + remainingMonths + " місяців!");
        } else if (years > 0) {
            System.out.println("Для погашення кредиту знадобиться " + years + " років!");
        } else {
            System.out.println("Для погашення кредиту знадобиться " + remainingMonths + " місяців!");
        }
    }

    private static void calculateAnnuityPayment(Scanner scanner) {
        System.out.println("Введіть основну суму кредиту:");
        double principal = scanner.nextDouble();

        System.out.println("Введіть кількість періодів (місяців):");
        int months = scanner.nextInt();

        System.out.println("Введіть відсоткову ставку (річну у відсотках):");
        double interestRate = scanner.nextDouble() / 100 / 12;

        double annuityPayment = principal * interestRate * Math.pow(1 + interestRate, months) /
                (Math.pow(1 + interestRate, months) - 1);

        System.out.println("Ваш щомісячний платіж = " + Math.ceil(annuityPayment) + "!");
    }

    private static void calculateLoanPrincipal(Scanner scanner) {
        System.out.println("Введіть розмір ануїтетного платежу:");
        double annuityPayment = scanner.nextDouble();

        System.out.println("Введіть кількість періодів (місяців):");
        int months = scanner.nextInt();

        System.out.println("Введіть відсоткову ставку (річну у відсотках):");
        double interestRate = scanner.nextDouble() / 100 / 12;

        double principal = annuityPayment * (Math.pow(1 + interestRate, months) - 1) /
                (interestRate * Math.pow(1 + interestRate, months));

        System.out.println("Ваша основна сума кредиту = " + Math.ceil(principal) + "!");
    }
}
