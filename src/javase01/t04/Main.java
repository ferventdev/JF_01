package javase01.t04;

import java.util.Random;

/**
 * Created by Aleksandr Shevkunenko on 02.06.2017.
 */
public class Main {
    private static final int N = 4;            // кол-во элементов последовательности, эту константку можно изменить
    private static final double LIMIT = 1.0e3;  // верхний предел для случайных чисел, эту константку можно изменить

    public static void main(String[] args) {
        Random random = new Random();
        double[] a = new double[2 * N];         // массив для хранения посл-сти a1, a2, ..., an, a(n+1), ..., a2n
        // инициализируем исходную последовательность случайными числами из диапазона [0.0; LIMIT)
        for (int i = 0; i < a.length; i++) a[i] = LIMIT * random.nextDouble();
        //a = new double[] { 0, 2, 1, 5, 7, 4 };    // эту последовательность можно использовать для проверки

        System.out.println("Исходная последовательность действительных чисел:");
        StringBuilder sequence = new StringBuilder().append("[ ");
        for( double el : a) sequence.append(el).append(' ');
        System.out.println(sequence.append(']'));

        System.out.printf("Ответ задачи: %f", findMax(a));
    }

    private static double findMax(double[] a) {
        int _2n = a.length;
        if (_2n == 0) throw new IllegalArgumentException("Массив не должен быть пуст.");
        if (_2n % 2 == 1) throw new IllegalArgumentException("В массиве должно быть четное кол-во элементов.");

        // ищем max(a1 + a2n, a2 + a(2n-1), ... an + a(n+1) )
        double max = a[0] + a[_2n - 1];           // = a1 + a2n
        for (int i = 1; i < _2n / 2; i++) {
            double element = a[i] + a[_2n - i - 1];
            if (element > max) max = element;
        }
        return max;
    }
}
