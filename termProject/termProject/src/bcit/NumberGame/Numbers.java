package bcit.NumberGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Numbers class implements the Actions interface and serves as the base class
 * for managing the game grid, random number generation, and placement of numbers.
 * It provides methods for grid manipulation, number placement, and game state resetting.
 * @author Evan Vink
 * @version 1.0
 */
public abstract class Numbers implements Actions {

    private static final int GRID_ROWS      = 4;
    private static final int GRID_COLS      = 5;
    private static final int NUMBERS_COUNT  = 20;

    int[][] grid;
    ArrayList<Integer> numsPlaced;
    ArrayList<Integer> nums;

    /**
     * Constructor for the Numbers class, which initializes the grid, the list of placed numbers,
     * and generates a list of random numbers.
     */
    public Numbers() {
        grid        = new int[GRID_ROWS][GRID_COLS];
        numsPlaced  = new ArrayList<>();
        nums        = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            nums.add(rand.nextInt(1, 1000));
        }
    }

    /**
     * Retrieves the coordinates (row and column) of a specific number in the grid.
     *
     * @param number the number to find in the grid
     * @return an array containing the row and column of the number, or null if not found
     */
    public int[] getRowColOfNum(int number) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == number) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Retrieves the current grid.
     *
     * @return the grid as a 2D array
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Retrieves the list of numbers that have been placed in the grid.
     *
     * @return the list of placed numbers
     */
    public ArrayList<Integer> getNumsPlaced() {
        return numsPlaced;
    }

    /**
     * Adds a number to the list of placed numbers.
     *
     * @param number the number to add
     */
    public void addNum(int number) {
        numsPlaced.add(number);
    }

    /**
     * Edits the grid by placing a number at the specified row and column.
     *
     * @param number the number to place
     * @param row    the row index
     * @param col    the column index
     */
    public void editGrid(int number, int row, int col) {
        grid[row][col] = number;
    }

    /**
     * Retrieves the list of random numbers.
     *
     * @return the list of random numbers
     */
    public ArrayList<Integer> getRandNumbers() {
        return nums;
    }

    /**
     * Abstract method to check if a spot is available (empty) on the grid.
     * The implementation will depend on the subclass.
     *
     * @param col the column index
     * @param row the row index
     * @return true if the spot is available, false otherwise
     */
    public abstract Boolean ifAvaliableSpot(int col, int row);

    /**
     * Resets the list of placed numbers and generates a new list of random numbers.
     */
    public void resetVariables() {
        numsPlaced.clear();
        Random rand;
        nums = new ArrayList<>();
        rand = new Random();

        for (int i = 0; i < NUMBERS_COUNT; i++) {
            nums.add(rand.nextInt(1, 1000));
        }
    }

    /**
     * Resets the grid by setting all values to zero.
     */
    public void resetGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = 0;
            }
        }
    }
}
