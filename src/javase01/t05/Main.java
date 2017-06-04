package javase01.t05;

/**
 * Created by Aleksandr Shevkunenko on 04.06.2017.
 */
public class Main {
    private static final int MATRIX_SIZE = 7;   // эту константу можно изменить

    public static void main(String[] args) {
        int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        System.out.printf("Полученная матрица размером %dx%d:%n", MATRIX_SIZE, MATRIX_SIZE);
        for(int row = 0; row < MATRIX_SIZE; row++) {
            for(int col = 0; col < MATRIX_SIZE; col++) {
                matrix[row][col] = ((row == col) || (row == MATRIX_SIZE - col - 1)) ? 1 : 0;
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
