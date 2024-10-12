package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class World {


    HashMap<String, Country> world = new HashMap<>();


    public World(){

        final Scanner scan;
        File file;
        String filePath;


        String[] files = {"a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt", "g.txt", "h.txt", "i.txt",
        "j.txt", "k.txt", "l.txt", "m.txt", "n.txt", "o.txt", "p.txt", "q.txt", "r.txt", "s.txt",
        "t.txt", "u.txt", "v.txt", "y.txt", "z.txt"};


        filePath = String.format("%s", files[0]);

        file = new File(filePath);

        try {
            scan = new Scanner(file);
            scan.useDelimiter("[:\n\0]");

            while(scan.hasNext()){

                final String country;
                final String capital;
                final String factOne;
                final String factTwo;
                final String factThree;

                //remove space at the start
                scan.next();

                country = scan.next();
                capital = scan.next();

                world.put(country, new Country(country, capital));
            }

            scan.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void title(){
        System.out.println(world.get("Albania"));
    }





}
