package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;


public class World extends WordGame{

    HashMap<String, Country> world;

    List<Score> allScores;

    private float highestScore;
    private float oldHighestScore;
    private String oldHighestScoreBigDate;
    private String oldHighestScoreSmallDate;

    private final int[] score = {0, 0, 0, 0};

    public World(){
        world = new HashMap<>();
        Scanner scan;
        File    file;
        String  filePath;

        String[] files = {"a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt", "g.txt", "h.txt", "i.txt",
        "j.txt", "k.txt", "l.txt", "m.txt", "n.txt", "o.txt", "p.txt", "q.txt", "r.txt", "s.txt",
        "t.txt", "u.txt", "v.txt", "y.txt", "z.txt"};

        for(int i = 0; i < files.length; i++) {
            filePath    = String.format("%s", files[i]);
            file        = new File(filePath);

            try {
                scan = new Scanner(file);
                scan.useDelimiter("[:\\r\\n]+");

                while (scan.hasNext()) {

                    final String country;
                    final String capital;
                    String[] facts = new String[3];


                    country     = scan.next();
                    capital     = scan.next();
                    facts[0]    = scan.next();
                    facts[1]    = scan.next();
                    facts[2]    = scan.next();
                    scan.nextLine();

                    world.put(country, new Country(country, capital, facts));
                }

                scan.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @Override
    public void playGame(){
        Random randGame;
        Score scores;
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

        allScores.add(scores);

        scores.printScore();
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
                oldHighestScore = highestScore;
                highestScore = scores.getScoreAverage();
                String format = String.format("CONGRATULATIONS! You are the " +
                                "new high score with an average of %.2f points per game; " +
                                "the previous record was %.2f points per game on" +
                                "%s at %s", highestScore, oldHighestScore, oldHighestScoreBigDate,
                                oldHighestScoreSmallDate);
                System.out.println(format);
            } else {
                System.out.println("NO HIGHSCORE");
            }

            System.out.println("Thanks for playing!\nBye!");
        }

    }




    @Override
    public void askQuestionCapital(){
        Random          randQuestion;
        Scanner         scanAnswer;

        randQuestion    = new Random();
        scanAnswer      = new Scanner(System.in);

        final String    question;
        final String    answer;
        final String    secondTry;


        question    = (String) world.keySet().toArray()[randQuestion.nextInt(world.size())];


        System.out.println("Guess the Capital from this Country: \n" + question);

        answer      = scanAnswer.nextLine();

        if(!verifyCapital(question, answer)){
            System.out.println("INCORRECT\nSecond Chance: ");
            secondTry = scanAnswer.nextLine();
            if(!verifyCapital(question, secondTry)){
                System.out.println("INCORRECT\nThe Capital of " + question + " is: " +
                        world.get(question).getCapitalCityName() + "\n");
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

    @Override
    public boolean verifyCapital(final String question, final String answer){
        return world.get(question).getCapitalCityName().equalsIgnoreCase(answer);
    }

    @Override
    public void askQuestionCountry(){
        Random randQuestion;
        Scanner scanAnswer;

        randQuestion = new Random();
        scanAnswer = new Scanner(System.in);

        final String question;
        final String country;
        final String answer;
        final String secondTry;

        country = (String) world.keySet().toArray()[randQuestion.nextInt(world.size())];
        question = world.get(country).getCapitalCityName();


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

    @Override
    public boolean verifyCountry(final String question, final String answer){
        return world.get(question).getName().equalsIgnoreCase(answer);
    }

    @Override
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

        country = (String) world.keySet().toArray()[randQuestion.nextInt(world.size())];
        factIndex = factRand.nextInt(3);
        question = world.get(country).getFacts()[factIndex];


        System.out.println("Guess this Country from this fact: \n" + question);

        answer = scanAnswer.nextLine();

        if(!verifyFact(country, answer)){
            System.out.println("INCORRECT\nSecond Chance: ");
            secondTry = scanAnswer.nextLine();
            if(!verifyFact(country, secondTry)){
                System.out.println("INCORRECT\nThe Country of the Fact " + question + " is: " +
                        world.get(country).getName() + "\n");
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

    @Override
    public boolean verifyFact(final String question, final String answer){
        return world.get(question).getName().equalsIgnoreCase(answer);
    }


    public float getHighScore(){
        for(Score highScore : allScores){
            System.out.println(highScore.getScoreAverage());
            if(highScore.getScoreAverage() > highestScore){
                highestScore = highScore.getScoreAverage();
                oldHighestScoreBigDate = highScore.getBigDateFormatted();
                oldHighestScoreSmallDate = highScore.getSmallDateFormatted();
            }
        }
        return highestScore;
    }


}
