package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;


public class World {

    HashMap<String, Country> world = new HashMap<>();

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

    public void playGame(){
        Random randGame;
        randGame = new Random();


        for(int i = 0; i < 10; i++){
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

    }

    public void askQuestionCapital(){
        Random          randQuestion;
        Scanner         scanAnswer;
        final String    question;
        final String    answer;
        final boolean   report;

        randQuestion    = new Random();
        scanAnswer      = new Scanner(System.in);

        question    = (String) world.keySet().toArray()[randQuestion.nextInt(world.size())];
        System.out.println("Guess the Capital from this Country: " + question);

        answer      = scanAnswer.next();
        report      = verifyCapital(question, answer);

        System.out.println(report ? "CORRECT" : "INCORRECT");
    }

    public boolean verifyCapital(String question, String answer){
        return world.get(question).getCapitalCityName().equalsIgnoreCase(answer);
    }


    public void askQuestionCountry(){
        Random randQuestion;
        Scanner scanAnswer;
        final String question;
        final String country;
        final String answer;
        final boolean report;

        randQuestion = new Random();
        scanAnswer = new Scanner(System.in);


        country = (String) world.keySet().toArray()[randQuestion.nextInt(world.size())];
        question = world.get(country).getCapitalCityName();
        System.out.println("Guess the Country from this Capital: " + question);
        answer = scanAnswer.next();
        report = verifyCountry(country, answer);

        System.out.println(report ? "CORRECT" : "INCORRECT");
    }


    public boolean verifyCountry(String question, String answer){
        return world.get(question).getName().equalsIgnoreCase(answer);
    }


    public void askQuestionFact(){
        Random randQuestion;
        Random factRand;
        Scanner scanAnswer;
        final String question;
        final int factIndex;
        final String country;
        final String answer;
        final boolean report;

        randQuestion = new Random();
        factRand = new Random();
        scanAnswer = new Scanner(System.in);
        factIndex = factRand.nextInt(3);

        country = (String) world.keySet().toArray()[randQuestion.nextInt(world.size())];


        question = world.get(country).getFacts()[factIndex];
        System.out.println("Guess this Country from this fact: " + question);

        answer = scanAnswer.next();
        report = verifyFact(country, answer);

        System.out.println(report ? "CORRECT" : "INCORRECT");
    }

    public boolean verifyFact(String question, String answer){
        return world.get(question).getName().equalsIgnoreCase(answer);
    }




}
