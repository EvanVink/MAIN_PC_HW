package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Country {

    final String name;
    final String capitalCityName;


    String[] countries = new String[3];

    public Country(String name, String capitalCityName){
        this.name = name;
        this.capitalCityName = capitalCityName;


        final Scanner scan;
        File file;
        String filePath;


        String[] files = {"a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt", "g.txt", "h.txt", "i.txt",
                "j.txt", "k.txt", "l.txt", "m.txt", "n.txt", "o.txt", "p.txt", "q.txt", "r.txt", "s.txt",
                "t.txt", "u.txt", "v.txt", "y.txt", "z.txt"};


        for (String s : files) {
            if (name.substring(0, 1).toLowerCase().equals(s)) {
                filePath = String.format("%s", files[0]);
                file = new File(filePath);
                try {
                    scan = new Scanner(file);
                    scan.useDelimiter("[:\n\0]");


                    while(scan.hasNext()) {

                        final String factOne;
                        final String factTwo;
                        final String factThree;

                        scan.next();
                        if(name.equalsIgnoreCase(scan.next())){
                            scan.next();
                            factOne = scan.next();
                            factTwo = scan.next();
                            factThree = scan.next();
                            System.out.println(factOne);
                            System.out.println(factTwo);

                            countries[0] = factOne;
                            countries[1] = factTwo;
                            countries[2] = factThree;
                            break;
                        }


                    }


                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }





    }


    public void title(){

        System.out.println(countries[0]);
        System.out.println(countries[1]);
        System.out.println(countries[2]);
    }

}
