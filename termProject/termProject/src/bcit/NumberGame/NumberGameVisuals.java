package bcit.NumberGame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * NumberGameVisuals is the JavaFX application that serves as the visual representation of the NumberGame logic.
 * It displays a grid of buttons where users interact to play the game.
 * @author Evan Vink
 * @version 1.0
 */
public class NumberGameVisuals extends Application {

    private static final int GRID_ROWS      = 4;
    private static final int GRID_COLS      = 5;
    private static final int GRID_HGAP      = 20;
    private static final int GRID_VGAP      = 20;
    private static final int SCENE_WIDTH    = 700;
    private static final int SCENE_HEIGHT   = 500;

    private NumberGame      numberGame;
    private AtomicInteger   index;

    /**
     * Constructor initializes the game logic.
     */
    public NumberGameVisuals() {
        numberGame = new NumberGame();
    }

    /**
     * Starts the JavaFX application.
     *
     * @param stage the primary stage for this application
     * @throws Exception if any error occurs during application startup
     */
    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid;
        grid = new GridPane();
        grid.setHgap(GRID_HGAP);
        grid.setVgap(GRID_VGAP);
        grid.setAlignment(Pos.CENTER);
        Scene scene;

        Button[][] buttons = new Button[GRID_ROWS][GRID_COLS];
        index = new AtomicInteger();

        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                buttons[row][col] = new Button("[]");
                int finalRow1 = row;
                int finalCol1 = col;

                buttons[row][col].setOnAction(actionEvent -> {

                    numberGame.addNum(numberGame.getRandNumbers().get(index.intValue()));
                    numberGame.editGrid(numberGame.getRandNumbers().get(index.intValue()), finalRow1, finalCol1);

                    if (!numberGame.ifInvalidSpot(index.intValue(), finalRow1, finalCol1)) {
                        numberGame.getNumsPlaced().removeLast();
                        numberGame.editGrid(0, finalRow1, finalCol1);
                        Alert gameEnd = new Alert(Alert.AlertType.INFORMATION);
                        gameEnd.setContentText("Wrong Choice!");
                        gameEnd.showAndWait();
                        stage.close();
                    }

                    buttons[finalRow1][finalCol1].setText(numberGame.getRandNumbers().get(index.intValue()) + "");

                    if (!numberGame.checkGame(index.intValue(), finalCol1, finalRow1)) {
                        Alert gameEnd = new Alert(Alert.AlertType.INFORMATION);
                        gameEnd.setContentText("Game Over No More Spots!");
                        gameEnd.showAndWait();
                        resetButtons(buttons);
                        numberGame.resetGame();
                    }

                    index.getAndIncrement();
                });

                grid.add(buttons[row][col], col, row);
            }
        }

        scene = new Scene(grid, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The entry point for the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Resets all the buttons in the grid to their initial state.
     *
     * @param buttons the 2D array of buttons in the grid
     */
    public void resetButtons(Button[][] buttons) {
        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                buttons[row][col].setText("[]");
            }
        }
        index.lazySet(-1);
    }
}