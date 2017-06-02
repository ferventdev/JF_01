package javase01.t02;

/**
 * Created by Aleksandr Shevkunenko on 02.06.2017.
 */
public class Main {
    private static final double EPSILON = 1.0e-6;   // эту константу можно изменить

    public static void main(String[] args) {
        System.out.printf("EPSILON = %e%n", EPSILON);

        int i = 0;
        double element = 1.0e2;
        do {
            i++;
            element = 1.0 / Math.pow( (1.0 + i), 2.0 );
            System.out.printf("a[%d] = %.17f%n", i, element);
        } while (element >= EPSILON);

        System.out.printf("Наименьший номер n элемента посл-сти, такой что a[n] < EPSILON, равен %d.%n", i);
    }
}
