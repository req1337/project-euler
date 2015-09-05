import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Problem 11: Largest product in grid
 * <p>
 * What is the greatest product of four adjacent numbers in the same
 * direction (up, down, left, right, or diagonally) in the 20×20 grid?
 * <p>
 * Created by thomasalm on 01/06/15.
 */
public class Problem_11 {

    private final static int GRID_MAX_ROW = 20, GRID_MAX_COL = 20, ADJACENT = 4;

    public static void main(String[] args) throws IOException {

        String rawGridData = new String(Files.readAllBytes(Paths.get("../project-euler/problem-solutions/src/Resources/grid.txt")));

        int[][] grid = generateGrid(rawGridData.split("\\s+"));

        int max = 0, tempProduct;

        for (int col = 0; col < GRID_MAX_COL; col++) {
            for (int row = 0; row < GRID_MAX_ROW; row++) {

                //Check horizontal forward
                if (row < GRID_MAX_ROW - ADJACENT) {
                    tempProduct = grid[col][row];
                    for (int i = 1; i < ADJACENT; i++) {
                        tempProduct *= grid[col][row + i];
                    }
                    max = Math.max(max, tempProduct);
                }

                //Check vertical downward
                if (col < GRID_MAX_COL - ADJACENT) {
                    tempProduct = grid[col][row];
                    for (int i = 1; i < ADJACENT; i++) {
                        tempProduct *= grid[col + i][row];
                    }
                    max = Math.max(max, tempProduct);
                }

                //Check diagonally forward-upward
                if ((col < GRID_MAX_COL - ADJACENT) && (row >= ADJACENT)) {
                    tempProduct = grid[col][row];
                    for (int i = 1; i < ADJACENT; i++) {
                        tempProduct *= grid[col + i][row - i];
                    }
                    max = Math.max(max, tempProduct);
                }

                //Check diagonally forward-downward
                if ((row < GRID_MAX_ROW - ADJACENT) && (col < GRID_MAX_COL - ADJACENT)) {
                    tempProduct = grid[col][row];
                    for (int i = 1; i < ADJACENT; i++) {
                        tempProduct *= grid[col + i][row + i];
                    }
                    max = Math.max(max, tempProduct);
                }
            }
        }

        System.out.println(max);

    }

    private static int[][] generateGrid(String[] numbers) {
        int intArray[][] = new int[GRID_MAX_COL][GRID_MAX_ROW];
        for (int i = 0; i < GRID_MAX_COL; i++) {
            for (int j = 0; j < GRID_MAX_ROW; j++) {
                intArray[i][j] = Integer.parseInt(numbers[i * GRID_MAX_COL + j]);
            }
        }
        return intArray;
    }

}
