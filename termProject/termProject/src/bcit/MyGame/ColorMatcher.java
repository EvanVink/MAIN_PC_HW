package bcit.MyGame;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.util.*;

/**
 * The main class for the ColorMatcher game, which allows the player to match colors
 * to a target color by adjusting RGB sliders. The game runs for a set duration, and
 * the player's score is based on how accurately they match the target color.
 * @author Evan Vink
 * @version 1.0
 */
public class ColorMatcher extends Application {


    private static final int DEFAULT_PLAYER_COLOR           = 125;
    private static final int DURATION_PAUSE                 = 3;
    private static final int VBOX_SIZE                      = 10;
    private static final int GAME_DURATION                  = 30;
    private static final int CHANGE_CIRCLE_TIME_ONE         = 10;
    private static final int CHANGE_CIRCLE_TIME_TWO         = 20;
    private static final int COUNT_DOWN_SLEEP_TIME          = 1000;
    private static final int MAX_SCORE                      = 100;
    private static final int EUCLIDEAN_FORMULA_POWER        = 2;
    private static final int AMOUNT_OF_COLORS_RGB           = 3;
    private static final int PERCENTAGE_ADJUST              = 100;
    private static final int SLIDER_MIN                     = 0;
    private static final int SLIDER_MAX                     = 255;
    private static final int SLIDER_STARTING_POSITION       = 125;
    private static final int SHAPE_LENGTH                   = 100;
    private static final int SHAPE_WIDTH                    = 100;
    private static final int RANDOM_MIN_BOUNDS              = 1;
    private static final int RANDOM_MAX_BOUNDS              = 255;
    private static final int SCENE_LENGTH                   = 400;
    private static final int SCENE_WIDTH                    = 600;
    private static final double TARGET_TOP_POSITION         = 5.0;
    private static final double TARGET_LEFT_POSITION        = 25.0;
    private static final double PLAYER_TOP_POSITION         = 5.0;
    private static final double PLAYER_LEFT_POSITION        = 300.0;
    private static final double TARGET_TOP_CIRCLE_POSITION  = 15.0;
    private static final double TARGET_LEFT_CIRCLE_POSITION = 100.0;
    private static final double PLAYER_TOP_CIRCLE_POSITION  = 15.0;
    private static final double PLAYER_LEFT_CIRCLE_POSITION = 375.0;
    private static final double SUBMIT_TOP_POSITION         = 10.0;
    private static final double SUBMIT_LEFT_POSITION        = 400.0;
    private static final double VIEW_HELPER_TOP_POSITION    = 10.0;
    private static final double VIEW_HELPER_LEFT_POSITION   = 100.0;
    private static final int PADDING                        = 20;
    private static final int EMPTY_SCORE                    = 0;
    private static final int STARTING_COUNTER_NUMBER        = 0;



    private Slider              redSlider;
    private Slider              greenSlider;
    private Slider              blueSlider;
    private Shape               playerColorDisplay;
    private Shape               targetColorDisplay;
    private Color               targetColor;
    private Color               playerColor;
    private Button              submit;
    private Button              viewHelper;
    private static ShapeFactory factory;
    private MakeColors          colors;
    private static String       inputShape;
    private int                 counter;
    private static String       difficulty;
    private static Scores       scores;
    private static AnchorPane   pane;
    private static AnchorPane   buttonPane;
    private static Label        target;
    private static Label        player;
    private static VBox         layout;

    /**
     * Starts the ColorMatcher game.
     *
     * @param stage The primary stage for this application.
     * @throws Exception If any error occurs during the launch.
     */
    @Override
    public void start(Stage stage) throws Exception {

        layout      = new VBox(VBOX_SIZE);
        player      = new Label("Your Color:");
        target      = new Label("Target Color:");
        pane        = new AnchorPane();
        buttonPane  = new AnchorPane();
        colors      = new MakeColors();
        scores      = new Scores();
        redSlider   = createColorSlider();
        greenSlider = createColorSlider();
        blueSlider  = createColorSlider();
        targetColor = colors.getColor(getRandColor(), getRandColor(), getRandColor());
        submit      = new Button("Submit");
        viewHelper  = new Button("View Target Color");
        counter     = STARTING_COUNTER_NUMBER;

        applyRedSliderStyle();
        applyGreenSliderStyle();
        applyBlueSliderStyle();


        if(difficulty.equalsIgnoreCase("easy")){
            targetColor = colors.getColor(getRandColor());
        } else if(difficulty.equalsIgnoreCase("medium")){
            targetColor = colors.getColor(getRandColor(), getRandColor());
        } else if(difficulty.equalsIgnoreCase("hard")){
            targetColor = colors.getColor(getRandColor(), getRandColor(), getRandColor());
        }


        if(inputShape.equalsIgnoreCase("rectangle")){
            playerColorDisplay = createRec(Color.rgb(DEFAULT_PLAYER_COLOR, DEFAULT_PLAYER_COLOR, DEFAULT_PLAYER_COLOR));
            targetColorDisplay = createRec(targetColor);
        } else if(inputShape.equalsIgnoreCase("circle")){
            playerColorDisplay = createCir(Color.rgb(DEFAULT_PLAYER_COLOR, DEFAULT_PLAYER_COLOR, DEFAULT_PLAYER_COLOR));
            targetColorDisplay = createCir(targetColor);
        }


        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            playerColorDisplay.setFill(Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue()));
        });
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            playerColorDisplay.setFill(Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue()));
        });
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            playerColorDisplay.setFill(Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue()));
        });

        submit.setOnAction(actionEvent -> {
            playerColor = Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue());
            scores.addScore();
            targetColor = updateColor();
            targetColorDisplay.setFill(targetColor);
        });

        viewHelper.setOnAction(actionEvent -> {
            targetColorDisplay.setVisible(true);
            PauseTransition viewHelperPause = new PauseTransition(Duration.seconds(DURATION_PAUSE));
            viewHelperPause.setOnFinished(event -> {
                targetColorDisplay.setVisible(false);
            });
            viewHelperPause.play();
        });


        PauseTransition pause = new PauseTransition(Duration.seconds(DURATION_PAUSE));
        pause.setOnFinished(event -> {
            targetColorDisplay.setVisible(false);
        });
        pause.play();



        AnchorPane.setTopAnchor(target, TARGET_TOP_POSITION);
        AnchorPane.setLeftAnchor(target, TARGET_LEFT_POSITION);
        AnchorPane.setTopAnchor(player, PLAYER_TOP_POSITION);
        AnchorPane.setLeftAnchor(player, PLAYER_LEFT_POSITION);
        AnchorPane.setTopAnchor(targetColorDisplay, TARGET_TOP_CIRCLE_POSITION);
        AnchorPane.setLeftAnchor(targetColorDisplay, TARGET_LEFT_CIRCLE_POSITION);
        AnchorPane.setTopAnchor(playerColorDisplay, PLAYER_TOP_CIRCLE_POSITION);
        AnchorPane.setLeftAnchor(playerColorDisplay, PLAYER_LEFT_CIRCLE_POSITION);

        AnchorPane.setTopAnchor(submit, SUBMIT_TOP_POSITION);
        AnchorPane.setLeftAnchor(submit, SUBMIT_LEFT_POSITION);
        AnchorPane.setTopAnchor(viewHelper, VIEW_HELPER_TOP_POSITION);
        AnchorPane.setLeftAnchor(viewHelper, VIEW_HELPER_LEFT_POSITION);

        buttonPane.getChildren().addAll(viewHelper, submit);

        pane.getChildren().addAll(target, player, targetColorDisplay, playerColorDisplay);


        layout.setPadding(new Insets(PADDING));
        layout.getChildren().addAll(
                pane,
                redSlider, greenSlider, blueSlider,
                buttonPane
        );


        Thread countdownThread = new Thread(new Runnable(){

            @Override
            public void run() {
                for(int i = 0; i < GAME_DURATION; i++){
                    counter++;
                    if(counter == CHANGE_CIRCLE_TIME_ONE || counter == CHANGE_CIRCLE_TIME_TWO){
                        System.out.println("OH NO! The Color Changed!!");
                        targetColor = updateColor();
                        targetColorDisplay.setFill(targetColor);
                    }
                    try{
                        Thread.sleep(COUNT_DOWN_SLEEP_TIME);
                    } catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                gameEnd(stage);
            }
        });




        countdownThread.start();



        Scene scene = new Scene(layout, SCENE_WIDTH, SCENE_LENGTH);
        stage.setScene(scene);
        stage.setTitle("Color Matcher");
        stage.setResizable(false);
        stage.show();

    }

    /**
     * Scores class handles the calculation and management of the player's score.
     */
    public class Scores {
        private final ArrayList<Double> scores;

        public Scores(){
            scores = new ArrayList<>();
        }

        /**
         * Increases the score based on the player's performance.
         */
        public void addScore(){
            scores.add(applyEuclideanFormula());
        }

        /**
         * Applies the Euclidean formula to calculate the similarity score
         * between the target color and the player's color.
         * The score is then normalized and adjusted to a percentage.
         *
         * @return The calculated score as a percentage.
         */
        public double applyEuclideanFormula(){

            return MAX_SCORE - Math.sqrt((Math.pow(targetColor.getRed() - playerColor.getRed(), EUCLIDEAN_FORMULA_POWER) +
                    Math.pow(targetColor.getGreen() - playerColor.getGreen(), EUCLIDEAN_FORMULA_POWER) +
                    Math.pow(targetColor.getBlue() - playerColor.getBlue(), EUCLIDEAN_FORMULA_POWER)) / AMOUNT_OF_COLORS_RGB) * PERCENTAGE_ADJUST;
        }

        /**
         * Returns the list of scores achieved by the player.
         *
         * @return A list of scores.
         */
        public ArrayList<Double> getScores(){
            return scores;
        }

        /**
         * Prints the player's scores, formatted as percentages of accuracy.
         * Each score is displayed on a new line.
         */
        public void printScores(){
            Iterator<Double> it;
            DecimalFormat df;


            it = getScores().iterator();
            df = new DecimalFormat("##.##");

            while(it.hasNext()){
                System.out.println(df.format(it.next()) + "% accurate!");
            }
        }

        /**
         * Prints the highest score the player has achieved.
         * If there are scores, the highest score is displayed as a percentage.
         */
        public void printHighestScore(){
            final Double highestScore;
            DecimalFormat df;
            df = new DecimalFormat("##.##");
            highestScore = scores.stream()
                    .filter(Objects::nonNull)
                    .max(Comparator.comparingDouble(Double::doubleValue))
                    .orElse(null);


            System.out.println("\nYour highest score was " +df.format(highestScore) + "% accurate! Good Job!\n");
        }

        /**
         * Returns the number of scores in the player's score list.
         *
         * @return The size of the score list.
         */
        public int getSize(){
            return scores.size();
        }

    }

    /**
     * Ends the game by displaying an information alert and closing the game stage.
     *
     * @param stage The primary stage for the application.
     */
    public void gameEnd(final Stage stage){

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert gameEnd;
                gameEnd = new Alert(Alert.AlertType.INFORMATION);
                gameEnd.setContentText("Timer Ran Out! Game has ended");
                gameEnd.showAndWait();
                stage.close();

            }
        });


    }


    /**
     * Creates a slider for color adjustment with a defined range and an initial value.
     *
     * @return A configured Slider for color selection.
     */
    public Slider createColorSlider() {
        Slider slider = new Slider(SLIDER_MIN, SLIDER_MAX, SLIDER_STARTING_POSITION);
        slider.setShowTickLabels(true);
        return slider;
    }

    /**
     * Creates a rectangle shape with a specified color.
     *
     * @param color The color to fill the rectangle.
     * @return A Shape representing a rectangle.
     */
    public static Shape createRec(final Color color){
        factory = new RectangleFactory();
        return factory.createShape(SHAPE_LENGTH, SHAPE_WIDTH, color);
    }

    /**
     * Creates a circle shape with a specified color.
     *
     * @param color The color to fill the circle.
     * @return A Shape representing a circle.
     */
    public static Shape createCir(final Color color){
        factory = new CircleFactory();
        return factory.createShape(SHAPE_LENGTH, SHAPE_WIDTH, color);
    }

    /**
     * Returns a random integer within the specified color range.
     *
     * @return A random integer between RANDOM_MIN_BOUNDS and RANDOM_MAX_BOUNDS.
     */
    public int getRandColor(){
        Random randColor;
        randColor = new Random();
        return randColor.nextInt(RANDOM_MAX_BOUNDS) + RANDOM_MIN_BOUNDS;
    }

    /**
     * Updates and returns a new random color.
     *
     * @return A new random color.
     */
    public Color updateColor(){
        return Color.rgb(getRandColor(), getRandColor(), getRandColor());

    }

    /**
     * Applies custom styling to the red color slider.
     */
    public void applyRedSliderStyle(){
        redSlider.setStyle(
                """
                -fx-control-inner-background: red;
                -fx-track-color: linear-gradient(to right, #000000, #000000);
                -fx-thumb-background-color: #000000;
                """
        );
    }

    /**
     * Applies custom styling to the green color slider.
     */
    public void applyGreenSliderStyle(){
        greenSlider.setStyle(
                """
                -fx-control-inner-background: green;
                -fx-track-color: linear-gradient(to right, #00ff00, #80ff80);
                -fx-thumb-background-color: #008000;
                -fx-padding: 5;
                """
        );
    }

    /**
     * Applies custom styling to the blue color slider.
     */
    public void applyBlueSliderStyle(){
        blueSlider.setStyle(
                """
                -fx-control-inner-background: blue;
                -fx-track-color: linear-gradient(to right, #0000ff, #8080ff);
                -fx-thumb-background-color: #0000ff;
                -fx-padding: 5;
                """
        );
    }

    /**
     * Sets the target color for the game.
     *
     * @param color The color to set as the target color.
     */
    public void setTargetColor(final Color color){
        targetColor = color;
    }

    /**
     * Sets the player's color based on their selection.
     *
     * @param color The color to set as the player's color.
     */
    public void setPlayerColor(final Color color){
        playerColor = color;
    }

    /**
     * Returns the maximum score possible in the game.
     *
     * @return The maximum possible score.
     */
    public static int getMaxScore(){
        return MAX_SCORE;
    }

    /**
     * Main method to start the game. It prompts the user to select a difficulty and shape,
     * then launches the game.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {

        Scanner scanShape;
        Scanner scanDifficulty;
        scanShape = new Scanner(System.in);
        scanDifficulty = new Scanner(System.in);


        System.out.println("enter a difficulty:\n" +
                "easy, medium, hard");
        difficulty = scanDifficulty.nextLine();

        while(!difficulty.equalsIgnoreCase("easy") &&
                !difficulty.equalsIgnoreCase("medium") &&
                !difficulty.equalsIgnoreCase("hard")){
            System.out.println("Invalid! Try Again!");
            difficulty = scanDifficulty.nextLine();
        }


        System.out.println("enter a shape you'd like\n(Circle or Rectangle)");
        inputShape = scanShape.nextLine();

        while(!inputShape.equalsIgnoreCase("circle") &&
                !inputShape.equalsIgnoreCase("rectangle")){
            System.out.println("Invalid! Try Again!");
            inputShape = scanShape.nextLine();
        }


        launch(args);



        System.out.println("Thanks for playing!\nHere's all of your score/s");

        if(!(scores.getSize() == EMPTY_SCORE)){
            scores.printScores();
            scores.printHighestScore();
        }


        System.out.println("Bye!");
    }

}
