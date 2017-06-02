package javase01.t03;

/**
 * Created by Aleksandr Shevkunenko on 02.06.2017.
 */
public class Main {
    // константы можно изменить
    private static final double START = -5.0;
    private static final double END = 5.0;
    private static final double STEP = 0.5;

    public static void main(String[] args) {
        String line = "---------------------------------";
        System.out.println(line);
        System.out.println("\tx\t\t\t|\t F(x)");
        System.out.println(line);
        for (double x = START; x <= END; x += STEP) {
            System.out.printf("%12f    |%12f%n", x, calculate(x));
        }
        System.out.println(line);
    }

    private static double calculate(double x) {
        return Math.tan( 2.0 * x ) - 3.0;
    }
}
