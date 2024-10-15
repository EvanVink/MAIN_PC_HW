package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;


public class World {

    HashMap<String, Country> world = new HashMap<>();

    public World(){


        String[] files = {"a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt", "g.txt", "h.txt", "i.txt",
        "j.txt", "k.txt", "l.txt", "m.txt", "n.txt", "o.txt", "p.txt", "q.txt", "r.txt", "s.txt",
        "t.txt", "u.txt", "v.txt", "y.txt", "z.txt"};

        for(int i = 0; i < files.length; i++) {
            Scanner scan;
            File    file;
            String  filePath;

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

//    public void title(String country){
//        Random rand = new Random();
//        System.out.println(world.get(country).getName());
//        System.out.println(world.get(country).getCapitalCityName());
//        System.out.println(world.get(country).getFacts()[rand.nextInt(3)]);
//        String car = (String) world.keySet().toArray()[rand.nextInt(world.size())];
//        System.out.println(car);
//    }

    public void playGame(){

        for(int i = 0; i < 10; i++){
            askQuestionCapital();
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
        System.out.println(question);

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
        System.out.println(question);
        answer = scanAnswer.next();
        report = verifyCountry(country, answer);

        System.out.println(report ? "CORRECT" : "INCORRECT");
    }


    public boolean verifyCountry(String question, String answer){
        return question.equalsIgnoreCase(world.get(question).getName());
    }



}
