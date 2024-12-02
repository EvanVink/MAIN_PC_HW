package bcit.WordGame;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The WordGame class represents a quiz game that involves asking questions related to countries, capitals, and facts.
 * It tracks scores based on user responses and allows players to play multiple rounds.
 * The game interacts with a "World" object that provides country and capital information, as well as facts about countries.
 * @author Evan Vink
 * @version 1.0
 */
public class WordGame{

    private static final int SCORE_FIRST_POSITION   = 0;
    private static final int SCORE_SECOND_POSITION  = 1;
    private static final int SCORE_THIRD_POSITION   = 2;
    private static final int SCORE_FORTH_POSITION   = 3;
    private static final int AMOUNT_OF_FACTS        = 3;
    private static final int SCORE_INCREMENT        = 1;
    private static final int AMOUNT_OF_QUESTIONS    = 3;
    private static final int QUESTION_ONE           = 0;
    private static final int QUESTION_TWO           = 1;
    private static final int QUESTION_THREE         = 2;



    private Score       scores;

    private final World world;

    private final int[] score = {SCORE_FIRST_POSITION, SCORE_SECOND_POSITION, SCORE_THIRD_POSITION, SCORE_FORTH_POSITION};

    /**
     * Constructor for the WordGame class.
     * Initializes a new World object.
     */
    public WordGame(){
        world = new World();
    }

    /**
     * Starts and runs the game, asking a set of random questions and tracking the player's score.
     * The game continues to ask questions until the user chooses not to play again.
     *
     * @throws IOException if there's an issue with file I/O during score saving/loading
     */
    public void playGame() throws IOException {
        Random      randGame;
        Scanner     playScanner;
        String      playAgain;
        List<Score> allScores;
        Score       highScore;
        randGame    = new Random();
        playScanner = new Scanner(System.in);
        allScores   = Score.readScoresFromFile( "Score.txt");
        score[SCORE_FIRST_POSITION] = score[SCORE_FIRST_POSITION] + SCORE_INCREMENT;



        for(int i = 0; i < AMOUNT_OF_QUESTIONS; i++){
            int randomGameNum;
            randomGameNum = randGame.nextInt(AMOUNT_OF_QUESTIONS);
            switch(randomGameNum){
                case QUESTION_ONE:
                    askQuestionCapital();
                    break;
                case QUESTION_TWO:
                    askQuestionCountry();
                    break;
                case QUESTION_THREE:
                    askQuestionFact();
                    break;
                default:
                    throw new RuntimeException("random number doesnt work");
            }
        }



        scores = new Score(LocalDateTime.now(), score[SCORE_FIRST_POSITION], score[SCORE_SECOND_POSITION], score[SCORE_THIRD_POSITION], score[SCORE_FORTH_POSITION]);

        System.out.println("Would you like to play again? (Y/N)");
        playAgain = playScanner.next();


        while(!playAgain.equalsIgnoreCase("Y") && !playAgain.equalsIgnoreCase("N")){
            System.out.println("Error, Wrong character, try again: \n");
            playAgain = playScanner.next();
        }

        if(playAgain.equalsIgnoreCase("Y")){
            playGame();
        } else if(playAgain.equalsIgnoreCase("N")){

            System.out.println("Thanks for playing!\nBye!");

            highScore = allScores.stream()
                    .max(Comparator.comparingDouble(Score::getAverage))
                    .orElse(null);

            if(!allScores.isEmpty()){
                if(highScore.getAverage() < scores.getAverage()){
                    System.out.println("CONGRATULATIONS! You are the new high score" +
                            " with an average of " + scores.getAverage() +
                            " points per game; the previous record was " + highScore.getAverage() +
                            " points per game on " + highScore.getDate() + " at " +
                            highScore.getHMS());
                } else {
                    System.out.println();
                }
            } else {
                System.out.println("CONGRATULATIONS! You are the new high score" +
                        " with an average of " + scores.getAverage() +
                        " points per game");
            }
            Score.appendScoreToFile(scores, "Score.txt");


        }

    }


    /**
     * Asks a random question about a country's capital and checks the player's answer.
     */
    public void askQuestionCapital(){
        Random randQuestion;
        Scanner scanAnswer;

        randQuestion    = new Random();
        scanAnswer      = new Scanner(System.in);

        final String    question;
        final String    answer;
        final String    secondTry;


        question    = (String) world.getWorld().keySet().toArray()[randQuestion.nextInt(world.getWorld().size())];


        System.out.println("Guess the Capital from this Country: \n" + question);

        answer      = scanAnswer.nextLine();

        if(!verifyCapital(question, answer)){
            System.out.println("INCORRECT\nSecond Chance: ");
            secondTry = scanAnswer.nextLine();
            if(!verifyCapital(question, secondTry)){
                System.out.println("INCORRECT\nThe Capital of " + question + " is: " +
                        world.getWorld().get(question).getCapitalCityName() + "\n");
                score[SCORE_FORTH_POSITION] = score[SCORE_FORTH_POSITION] + SCORE_INCREMENT;
            } else {
                System.out.println("CORRECT");
                score[SCORE_THIRD_POSITION] = score[SCORE_THIRD_POSITION] + SCORE_INCREMENT;
            }
        } else {
            System.out.println("CORRECT");
            score[SCORE_SECOND_POSITION] = score[SCORE_SECOND_POSITION] + SCORE_INCREMENT;
        }
    }

    /**
     * Verifies if the player's answer matches the correct capital for the given country.
     *
     * @param question The country name
     * @param answer The player's answer for the capital
     * @return true if the answer is correct, false otherwise
     */
    public boolean verifyCapital(final String question, final String answer){
        return world.getWorld().get(question).getCapitalCityName().equalsIgnoreCase(answer);
    }



    /**
     * Asks a random question about a capital's country and checks the player's answer.
     */
    public void askQuestionCountry(){
        Random  randQuestion;
        Scanner scanAnswer;

        randQuestion = new Random();
        scanAnswer = new Scanner(System.in);

        final String question;
        final String country;
        final String answer;
        final String secondTry;

        country = (String) world.getWorld().keySet().toArray()[randQuestion.nextInt(world.getWorld().size())];
        question = world.getWorld().get(country).getCapitalCityName();


        System.out.println("Guess the Country from this Capital: \n" + question);
        answer = scanAnswer.nextLine();


        if(!verifyCountry(country, answer)){
            System.out.println("INCORRECT\nSecond Chance: ");
            secondTry = scanAnswer.nextLine();
            if(!verifyCountry(country, secondTry)){
                System.out.println("INCORRECT\nThe Country with the Capital " + question + " is: " +
                        country + "\n");
                score[SCORE_FORTH_POSITION] = score[SCORE_FORTH_POSITION] + SCORE_INCREMENT;
            } else {
                System.out.println("CORRECT");
                score[SCORE_THIRD_POSITION] = score[SCORE_THIRD_POSITION] + SCORE_INCREMENT;
            }
        } else {
            System.out.println("CORRECT");
            score[SCORE_SECOND_POSITION] = score[SCORE_SECOND_POSITION] + SCORE_INCREMENT;
        }
    }

    /**
     * Verifies if the player's answer matches the correct country for the given capital.
     *
     * @param question The capital city name
     * @param answer The player's answer for the country
     * @return true if the answer is correct, false otherwise
     */
    public boolean verifyCountry(final String question, final String answer){
        return world.getWorld().get(question).getName().equalsIgnoreCase(answer);
    }




    /**
     * Asks a random fact-based question about a country and checks the player's answer.
     */
    public void askQuestionFact(){
        Random  randQuestion;
        Random  factRand;
        Scanner scanAnswer;

        randQuestion    = new Random();
        factRand        = new Random();
        scanAnswer      = new Scanner(System.in);


        final String    question;
        final int       factIndex;
        final String    country;
        final String    answer;
        final String    secondTry;

        country = (String) world.getWorld().keySet().toArray()[randQuestion.nextInt(world.getWorld().size())];
        factIndex = factRand.nextInt(AMOUNT_OF_FACTS);
        question = world.getWorld().get(country).getFacts()[factIndex];


        System.out.println("Guess this Country from this fact: \n" + question);

        answer = scanAnswer.nextLine();

        if(!verifyFact(country, answer)){
            System.out.println("INCORRECT\nSecond Chance: ");
            secondTry = scanAnswer.nextLine();
            if(!verifyFact(country, secondTry)){
                System.out.println("INCORRECT\nThe Country of the Fact " + question + " is: " +
                        world.getWorld().get(country).getName() + "\n");
                score[SCORE_FORTH_POSITION] = score[SCORE_FORTH_POSITION] + SCORE_INCREMENT;
            } else {
                System.out.println("CORRECT");
                score[SCORE_THIRD_POSITION] = score[SCORE_THIRD_POSITION] + SCORE_INCREMENT;
            }
        } else {
            System.out.println("CORRECT");
            score[SCORE_SECOND_POSITION] = score[SCORE_SECOND_POSITION] + SCORE_INCREMENT;
        }
    }

    /**
     * Verifies if the player's answer matches the correct country based on a given fact.
     *
     * @param question The fact
     * @param answer The player's answer for the country
     * @return true if the answer is correct, false otherwise
     */
    public boolean verifyFact(final String question, final String answer){
        return world.getWorld().get(question).getName().equalsIgnoreCase(answer);
    }









}
