package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WordGame{

    private Score scores;


    private final World world;

    private float highestScore;
    private float oldHighestScore;
    private String oldHighestScoreBigDate;
    private String oldHighestScoreSmallDate;

    private final int[] score = {0, 0, 0, 0};



    public WordGame(){
        world = new World();
    }



//    abstract void playGame();

    public void playGame(){
        System.out.println(oldHighestScoreSmallDate);
        System.out.println(oldHighestScoreBigDate);
        Random randGame;
        Scanner playScanner;
        String playAgain;
        randGame = new Random();
        playScanner = new Scanner(System.in);
        score[0] = score[0] + 1;
        allScores = new ArrayList<>();


        for(int i = 0; i < 3; i++){
            int randomGameNum;
            randomGameNum = randGame.nextInt(3);
            switch(randomGameNum){
                case 0:
                    askQuestionCapital();
                    break;
                case 1:
                    askQuestionCountry();
                    break;
                case 2:
                    askQuestionFact();
                    break;
                default:
                    throw new RuntimeException("random number doesnt work");
            }
        }



        scores = new Score(score[0], score[1], score[2], score[3]);

        System.out.println("Would you like to play again? (Y/N)");
        playAgain = playScanner.next();

        while(!playAgain.equalsIgnoreCase("Y") && !playAgain.equalsIgnoreCase("N")){
            System.out.println("Error, Wrong character, try again: \n");
            playAgain = playScanner.next();
        }

        if(playAgain.equalsIgnoreCase("Y")){
            playGame();
        } else if(playAgain.equalsIgnoreCase("N")){

            if(scores.getScoreAverage() > getHighScore()){
                oldHighestScore = allScores.getFirst();
                highestScore = scores.getScoreAverage();
                String format = String.format("CONGRATULATIONS! You are the " +
                                "new high score with an average of %.2f points per game; " +
                                "the previous record was %.2f points per game on " +
                                "%s at %s", highestScore, oldHighestScore, oldHighestScoreBigDate,
                        oldHighestScoreSmallDate);
                System.out.println(format);
            } else {
                System.out.println("NO HIGHSCORE");
            }

            System.out.println("Thanks for playing!\nBye!");
            try {
                File scoreFile = new File("WordGame/Score.txt");
                FileWriter fileWriter = new FileWriter(scoreFile, true);
                fileWriter.write(scores.stringScore() + "\n");
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



//    abstract void askQuestionCapital();
//
//    abstract boolean verifyCapital(String question, String answer);

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
                score[3] = score[3] + 1;
            } else {
                System.out.println("CORRECT");
                score[2] = score[2] + 1;
            }
        } else {
            System.out.println("CORRECT");
            score[1] = score[1] + 1;
        }
    }


    public boolean verifyCapital(final String question, final String answer){
        return world.getWorld().get(question).getCapitalCityName().equalsIgnoreCase(answer);
    }



//    abstract void askQuestionCountry();
//
//    abstract boolean verifyCountry(String question, String answer);
//

    public void askQuestionCountry(){
        Random randQuestion;
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
                score[3] = score[3] + 1;
            } else {
                System.out.println("CORRECT");
                score[2] = score[2] + 1;
            }
        } else {
            System.out.println("CORRECT");
            score[1] = score[1] + 1;
        }
    }


    public boolean verifyCountry(final String question, final String answer){
        return world.getWorld().get(question).getName().equalsIgnoreCase(answer);
    }




//    abstract void askQuestionFact();
//
//    abstract boolean verifyFact(String question, String answer);
public void askQuestionFact(){
    Random randQuestion;
    Random factRand;
    Scanner scanAnswer;

    randQuestion = new Random();
    factRand = new Random();
    scanAnswer = new Scanner(System.in);


    final String question;
    final int factIndex;
    final String country;
    final String answer;
    final String secondTry;

    country = (String) world.getWorld().keySet().toArray()[randQuestion.nextInt(world.getWorld().size())];
    factIndex = factRand.nextInt(3);
    question = world.getWorld().get(country).getFacts()[factIndex];


    System.out.println("Guess this Country from this fact: \n" + question);

    answer = scanAnswer.nextLine();

    if(!verifyFact(country, answer)){
        System.out.println("INCORRECT\nSecond Chance: ");
        secondTry = scanAnswer.nextLine();
        if(!verifyFact(country, secondTry)){
            System.out.println("INCORRECT\nThe Country of the Fact " + question + " is: " +
                    world.getWorld().get(country).getName() + "\n");
            score[3] = score[3] + 1;
        } else {
            System.out.println("CORRECT");
            score[2] = score[2] + 1;
        }
    } else {
        System.out.println("CORRECT");
        score[1] = score[1] + 1;
    }
}


    public boolean verifyFact(final String question, final String answer){
        return world.getWorld().get(question).getName().equalsIgnoreCase(answer);
    }










    public float getHighScore(){


        try {
            File highScoreFile = new File("WordGame/Score.txt");
            Scanner txtScanner = new Scanner(highScoreFile);

            txtScanner.useDelimiter("(- Date and Time: |- Games Played: |- Correct First Attempts: |" +
                    "- Correct Second Attempts: |- Incorrect Attempts: |- Total Score: |- Average Score: |" +
                    "\\n)+");

            while (txtScanner.hasNext()){

                String value;
                String time;
                String bigTime;
                String smallTime;

                time = txtScanner.next();
                bigTime = time.substring(0, 9);
                smallTime = time.substring(11);
                System.out.println(bigTime);
                System.out.println(smallTime);

                for(int i = 0; i < 5; i++){
                    System.out.println(txtScanner.next());;
                }

                value = txtScanner.next().replaceAll("Points/Game", " ").trim();
                allScores.add(Float.parseFloat(value));
                txtScanner.nextLine();

            }

            Collections.sort(allScores);
            Collections.reverse(allScores);
            System.out.println(allScores);
            return allScores.getFirst();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }



    }




}
