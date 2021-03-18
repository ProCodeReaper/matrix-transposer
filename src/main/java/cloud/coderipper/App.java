package cloud.coderipper;

import cloud.coderipper.utils.MatrixUtils;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        final App app = new App();
        app.init(args);

    }

    private void init(String[] args) {
        int[][] matrix = MatrixUtils.readMatrixFromConsole(2, 3);
        System.out.println(Arrays.deepToString(matrix));

        int[][] transposedMatrix = MatrixUtils.transpose(matrix);
        System.out.println(Arrays.deepToString(transposedMatrix));
    }
}
