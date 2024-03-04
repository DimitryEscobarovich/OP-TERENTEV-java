package matrix;

import java.util.Scanner;

public class Matrix_with_object {
    private int[][] matrix;
    private final int size;

    public Matrix_with_object(int size) {
        this.size = size;
        this.matrix = new int[size][size];
    }

    public void fillMatrix() {
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public void printMatrix() {
        System.out.println("Исходная матрица:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void calculateMatrix() {
        int diagonal = 1;
        int upRight = 0;
        int lowLeft = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    diagonal *= matrix[i][j];
                }
                if (i < j) {
                    upRight += matrix[i][j];
                }
                if (i > j) {
                    lowLeft -= matrix[i][j];
                }
            }
        }

        System.out.println("Произведение элементов по диагонали: " + diagonal);
        System.out.println("Сумма элементов правой верхней части: " + upRight);
        System.out.println("Разность элементов левой нижней части: " + lowLeft);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите размер квадратной матрицы: ");
        int size = scan.nextInt();

        Matrix_with_object matrix = new Matrix_with_object(size);
        matrix.fillMatrix();
        matrix.printMatrix();
        matrix.calculateMatrix();
    }
}