public class CreditCalculator {
    public static void main(String[] args) {
        CalculatorLogic logic = new CalculatorLogic();
        try {
            CreditParameters params = CreditInput.parseArguments(args);
            logic.calculate(params);
        } catch (IllegalArgumentException e) {
            System.out.println("Incorrect parameters");
        }
    }
}

class CreditInput {
    public static CreditParameters parseArguments(String[] args) {
        String type = System.getProperty("type");
        String principalStr = System.getProperty("principal");
        String periodsStr = System.getProperty("periods");
        String interestStr = System.getProperty("interest");
        String paymentStr = System.getProperty("payment");

        if (type == null || (!type.equals("diff") && !type.equals("annuity"))) {
            throw new IllegalArgumentException("Invalid type of payment");
        }

        Double principal = principalStr != null ? Double.parseDouble(principalStr) : null;
        Integer periods = periodsStr != null ? Integer.parseInt(periodsStr) : null;
        Double interest = interestStr != null ? Double.parseDouble(interestStr) : null;
        Double payment = paymentStr != null ? Double.parseDouble(paymentStr) : null;

        if (interest == null || interest <= 0 ||
            (type.equals("diff") && payment != null) ||
            (principal != null && principal < 0) ||
            (periods != null && periods <= 0) ||
            (payment != null && payment < 0)) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        return new CreditParameters(type, principal, periods, interest, payment);
    }
}

class CreditParameters {
    String type;
    Double principal;
    Integer periods;
    Double interest;
    Double payment;

    public CreditParameters(String type, Double principal, Integer periods, Double interest, Double payment) {
        this.type = type;
        this.principal = principal;
        this.periods = periods;
        this.interest = interest;
        this.payment = payment;
    }
}

class CalculatorLogic {
    public void calculate(CreditParameters params) {
        double monthlyRate = params.interest / 100 / 12;

        if ("diff".equals(params.type)) {
            calculateDifferentiatedPayments(params.principal, params.periods, monthlyRate);
        } else if ("annuity".equals(params.type)) {
            calculateAnnuity(params.principal, params.payment, params.periods, monthlyRate);
        }
    }

    private void calculateDifferentiatedPayments(Double principal, Integer periods, double monthlyRate) {
        double totalPayment = 0;

        for (int m = 1; m <= periods; m++) {
            double payment = (principal / periods) + monthlyRate * (principal - (principal * (m - 1) / periods));
            totalPayment += Math.ceil(payment);
            System.out.println("Month " + m + ": payment is " + (int) Math.ceil(payment));
        }

        System.out.println("Overpayment = " + (int) (totalPayment - principal));
    }

    private void calculateAnnuity(Double principal, Double payment, Integer periods, double monthlyRate) {
        if (principal == null) {
            principal = payment * (1 - Math.pow(1 + monthlyRate, -periods)) / monthlyRate;
            System.out.println("Your loan principal = " + (int) Math.ceil(principal) + "!");
        } else if (payment == null) {
            payment = principal * monthlyRate * Math.pow(1 + monthlyRate, periods) / (Math.pow(1 + monthlyRate, periods) - 1);
            System.out.println("Your annuity payment = " + (int) Math.ceil(payment) + "!");
        } else {
            double months = Math.log(payment / (payment - monthlyRate * principal)) / Math.log(1 + monthlyRate);
            int roundedMonths = (int) Math.ceil(months);
            int years = roundedMonths / 12;
            int remainingMonths = roundedMonths % 12;

            if (years > 0 && remainingMonths > 0) {
                System.out.println("It will take " + years + " years and " + remainingMonths + " months to repay this loan!");
            } else if (years > 0) {
                System.out.println("It will take " + years + " years to repay this loan!");
            } else {
                System.out.println("It will take " + remainingMonths + " months to repay this loan!");
            }
        }
    }
}
