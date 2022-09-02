import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y,int d ) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return roundValue(pay, 2);
    }
    double calculateSimplePercent(double Amount, double yearRate, int depositPeriod) {
         return roundValue(Amount+Amount * yearRate *depositPeriod, 2);
    }
    double roundValue(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value*scale) / scale;
    }
    void calculateIncome( ) {
        int period, action;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );

        System.out.println   ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double outVar = 0;

        if (action == 1) outVar = calculateComplexPercent(amount, 0.06, period);
            else if (action == 2) {
            outVar = calculateSimplePercent(amount,0.06, period);
            }
            System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outVar);
    }
    public static void main(String[] args) {
        new DepositCalculator().calculateIncome();
    }
}
