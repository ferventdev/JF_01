package javase01.t02;

/**
 * Created by Aleksandr Shevkunenko on 02.06.2017.
 */
public class Main {
    private static final double EPSILON = 0.1;

    public static void main(String[] args) {
        int i = 0;
        double element;
        do {
            i++;
            element = 1.0 / Math.pow( (1.0 + i), 2.0 );
            System.out.printf("a[%d] = %f%n", i, element);
        } while (element >= EPSILON);

        System.out.printf("Искомый номер последовательности равен %d%n", i);
    }
}
