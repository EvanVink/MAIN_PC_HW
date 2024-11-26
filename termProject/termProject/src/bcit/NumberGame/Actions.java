package bcit.NumberGame;

public interface Actions {
    int insertNumber(int number, int col, int row);
    boolean checkGame(int index, int col, int row);
    void resetGame();
}
