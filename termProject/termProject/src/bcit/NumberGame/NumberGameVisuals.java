package bcit.NumberGame;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberGameVisuals extends Application {

    NumberGame numberGame;
    AtomicInteger index;

    public NumberGameVisuals(){
        numberGame = new NumberGame();
    }


    @Override
    public void start(Stage stage) throws Exception {
        GridPane grid;
        grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);
        Scene scene;

        Button[][] buttons;
        buttons = new Button[4][5];
        index = new AtomicInteger();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                buttons[row][col] = new Button("[]");
                int finalRow = row;
                int finalCol = col;
                int finalRow1 = row;
                int finalCol1 = col;

                buttons[row][col].setOnAction(actionEvent -> {
//                    System.out.println(finalRow + ", " + finalCol + ((Button) actionEvent.getSource()).getText());
                    buttons[finalRow1][finalCol1].setText(numberGame.getRandNumbers().get(index.get()) + "");
                    numberGame.editGrid(numberGame.getRandNumbers().get(index.get()), finalRow1, finalCol1);
                    numberGame.addNum(numberGame.getRandNumbers().get(index.get()));


                    if(!numberGame.checkGame(index.intValue(), finalCol1, finalRow1)){
                        Alert gameEnd;
                        gameEnd = new Alert(Alert.AlertType.INFORMATION);
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



        scene = new Scene(grid, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void resetButtons(Button[][] buttons) {
        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                buttons[row][col].setText("[]"); // Reset button text
            }
        }
        index.lazySet(-1);
    }

}
