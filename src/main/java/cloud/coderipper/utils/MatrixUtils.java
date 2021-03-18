package cloud.coderipper.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class MatrixUtils {

    private MatrixUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    private static final String DELIMITER = ",";

    public static int[][] readMatrixFromFile(File file) throws FileNotFoundException {
        final Scanner sc = new Scanner(file);
        int[][] matrix = initMatrix(file);
        while (sc.hasNextLine()) {
            for (int i = 0; i < matrix.length; i++) {
                String[] line = sc.nextLine().trim().split(DELIMITER);
                for (int j = 0; j < matrix[0].length; j++) {
                    int number = Integer.parseInt(line[j]);
                    matrix[i][j] = number;
                }
            }
        }
        return matrix;
    }

    public static int[][] readMatrixFromConsole(final int rows, final int columns) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter matrix elements");
        final int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] transpose(final int[][] matrix) {
        final int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    private static int[][] initMatrix(File file) throws FileNotFoundException {
        final Scanner sc = new Scanner(file);
        int rowsNumber = 0;
        int columnsNumber = 0;
        while (sc.hasNextLine()) {
            rowsNumber++;
            int numberElementsInRow = sc.nextLine().trim().split(DELIMITER).length;
            if (columnsNumber < numberElementsInRow) {
                columnsNumber = numberElementsInRow;
            }
        }

        return new int[rowsNumber][columnsNumber];
    }
}
