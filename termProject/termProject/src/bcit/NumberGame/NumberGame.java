package bcit.NumberGame;

import java.util.ArrayList;
import java.util.List;

/**
 * The NumberGame class extends the Numbers class and contains the game logic.
 * It includes methods for checking the game state, resetting the game, and checking for valid or invalid spots on the grid.
 * @author Evan Vink
 * @version 1.0
 */
public class NumberGame extends Numbers {

    private static final int GRID_ROWS = 4;
    private static final int GRID_COLS = 5;

    /**
     * Checks the current state of the game by verifying if there are any valid spots available
     * after placing a number on the grid.
     *
     * @param index the current index of the random number
     * @param row the row index of the current spot
     * @param col the column index of the current spot
     * @return true if there are valid spots, false otherwise
     */
    @Override
    public boolean checkGame(final int index, final int row, final int col) {
        boolean passed = false;
        ArrayList<Boolean> spots = new ArrayList<>();

        int nextNumber = getRandNumbers().get(index + 1);

        for (int i = 0; i < GRID_ROWS; i++) {
            for (int j = 0; j < GRID_COLS; j++) {
                int currentNumber = getGrid()[i][j];

                if (nextNumber < currentNumber) {
                    passed = true;
                }

                if (ifAvaliableSpot(i, j) && !passed) {
                    if (currentNumber == 0) {
                        spots.add(true);
                    }
                }

                if (passed) {
                    spots.add(false);
                }
            }
        }

        return spots.stream().anyMatch(truth -> truth);
    }

    /**
     * Resets the game state by resetting the grid and variables.
     */
    @Override
    public void resetGame() {
        resetGrid();
        resetVariables();
    }

    /**
     * Checks if a given spot (row, col) is available (empty) on the grid.
     *
     * @param row the row index of the spot
     * @param col the column index of the spot
     * @return true if the spot is available (empty), false otherwise
     */
    @Override
    public Boolean ifAvaliableSpot(final int row, final int col) {
        return getGrid()[row][col] == 0;
    }

    /**
     * Checks if the spot being placed at (row, col) is valid based on the current number and placement constraints.
     *
     * @param index the current index of the random number being placed
     * @param row the row index of the spot being placed
     * @param col the column index of the spot being placed
     * @return true if the spot is valid, false otherwise
     */
    public Boolean ifInvalidSpot(final int index, final int row, final int col) {
        int nextNumber = getRandNumbers().get(index + 1);

        List<Integer> min = numsPlaced.stream()
                .filter(num -> num < nextNumber)
                .toList();
        int minNum = min.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);

        List<Integer> max = numsPlaced.stream()
                .filter(num -> num > nextNumber)
                .toList();
        int maxNum = max.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);

        if (numsPlaced.size() == 1) {
            return true;
        }

        if (minNum != 0 && getRandNumbers().get(index) < nextNumber) {
            int[] minPlaceable = getRowColOfNum(minNum);
            if (getNumsPlaced().size() > 1) {
                return (row < minPlaceable[0] || (row == minPlaceable[0] && col < minPlaceable[1]));
            }
        } else {
            return true;
        }

        if (maxNum != 0 && getRandNumbers().get(index) > nextNumber) {
            int[] maxPlaceable = getRowColOfNum(maxNum);
            if (getNumsPlaced().size() > 1) {
                return (row > maxPlaceable[0] || (row == maxPlaceable[0] && col > maxPlaceable[1]));
            }
        }

        if (minNum != 0 && maxNum != 0) {
            int[] minPlaceable = getRowColOfNum(minNum);
            int[] maxPlaceable = getRowColOfNum(maxNum);
            return (row > minPlaceable[0] || (row == minPlaceable[0] && col > minPlaceable[1])) &&
                    (row < maxPlaceable[0] || (row == maxPlaceable[0] && col < maxPlaceable[1]));
        }

        return true;
    }
}
