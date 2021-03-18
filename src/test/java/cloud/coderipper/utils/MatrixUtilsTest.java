package cloud.coderipper.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {

    @Test
    void readMatrixFromFile() throws URISyntaxException, FileNotFoundException {
        final int[][] expectedMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        final File file = Paths.get(ClassLoader.getSystemResource("input-matrix.txt").toURI()).toFile();
        int[][] matrix = MatrixUtils.readMatrixFromFile(file);
        Assertions.assertEquals(Arrays.deepToString(expectedMatrix), Arrays.deepToString(matrix));
    }

    @Test
    void readMatrixFromConsole() {
        final int[][] expectedMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        final String input = "1\n2\n3\n4\n5\n6\n7\n8\n9\n";
        final ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setIn(testIn);
        System.setOut(new PrintStream(testOut));

        int[][] matrix = MatrixUtils.readMatrixFromConsole(3, 3);
        Assertions.assertEquals(Arrays.deepToString(expectedMatrix), Arrays.deepToString(matrix));

        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void transpose() throws URISyntaxException, FileNotFoundException {
        final int[][] expectedMatrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };
        final File file = Paths.get(ClassLoader.getSystemResource("input-matrix.txt").toURI()).toFile();
        final int[][] matrix = MatrixUtils.readMatrixFromFile(file);
        final int[][] transposedMatrix = MatrixUtils.transpose(matrix);

        Assertions.assertEquals(Arrays.deepToString(expectedMatrix), Arrays.deepToString(transposedMatrix));
    }
}