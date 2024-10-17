package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;


public class World extends WordGame{

    HashMap<String, Country> world = new HashMap<>();

    private int[] score = {0, 0, 0, 0};

    public World(){
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
                scan.useDelimiter("[:\n]");

                while (scan.hasNext()) {

                    final String country;
                    final String capital;
                    String[] facts = new String[3];

                    country     = scan.next();
                    System.out.println(country);
                    capital     = scan.next();
                    System.out.println(capital);
                    facts[0]    = scan.next();
                    System.out.println(facts[0]);
                    facts[1]    = scan.next();
                    System.out.println(facts[1]);
                    facts[2]    = scan.next();
                    System.out.println(facts[2]);
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
        randGame = new Random();
        score[0] = score[0] + 1;


        for(int i = 0; i < 10; i++){
            int randomGameNum;
            randomGameNum = randGame.nextInt(3);
//            switch(randomGameNum){
//                case 0:
//                    askQuestionCapital();
//                    break;
//                case 1:
//                    askQuestionCountry();
//                    break;
//                case 2:
//                    askQuestionFact();
//                    break;
//                default:
//                    throw new RuntimeException("random number doesnt work");
//            }
            askQuestionCapital();
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
                System.out.println("INCORRECT\nThe Capital of " + question + " was: " +
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
        System.out.println(score[0] + ", " + score[1] + ", " + score[2] + ", " + score[3]);
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

        //change question to answer(the country (world.get(country).getName())) and pass through the verify
        // and answer to userGuess
        if(!verifyCountry(question, answer)){
            System.out.println("INCORRECT\nSecond Chance: ");
            secondTry = scanAnswer.nextLine();
            if(!verifyCountry(question, secondTry)){
                System.out.println("INCORRECT\nThe Country of " + question + " was: " +
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
        System.out.println(score[0] + ", " + score[1] + ", " + score[2] + ", " + score[3]);
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

        if(!verifyFact(question, answer)){
            System.out.println("INCORRECT\nSecond Chance: ");
            secondTry = scanAnswer.nextLine();
            if(!verifyFact(question, secondTry)){
                System.out.println("INCORRECT\nThe Country of the Fact " + question + " was: " +
                        world.get(country) + "\n");
                score[3] = score[3] + 1;
            } else {
                System.out.println("CORRECT");
                score[2] = score[2] + 1;
            }
        } else {
            System.out.println("CORRECT");
            score[1] = score[1] + 1;
        }
        System.out.println(score[0] + ", " + score[1] + ", " + score[2] + ", " + score[3]);
    }

    @Override
    public boolean verifyFact(final String question, final String answer){
        return world.get(question).getName().equalsIgnoreCase(answer);
    }




}
