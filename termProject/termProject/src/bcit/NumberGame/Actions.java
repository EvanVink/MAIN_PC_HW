package bcit.NumberGame;

/**
 * The Actions interface defines the essential actions required for a game.
 * Any game that implements this interface should provide implementations
 * for checking the game's status and resetting the game.
 * @author Evan Vink
 * @version 1.0
 */
public interface Actions {

    /**
     * Checks the status of the game at a given position.
     * The exact criteria for checking the game can vary depending on the game implementation.
     *
     * @param index The index used for checking the game status (may refer to a specific element or condition in the game).
     * @param col The column coordinate of the position to check.
     * @param row The row coordinate of the position to check.
     * @return true if the game condition at the specified position is met, false otherwise.
     */
    boolean checkGame(int index, int col, int row);

    /**
     * Resets the game to its initial state.
     * This method is intended to restore the game to its starting configuration,
     * clearing any progress and preparing for a new round of play.
     */
    void resetGame();
}
