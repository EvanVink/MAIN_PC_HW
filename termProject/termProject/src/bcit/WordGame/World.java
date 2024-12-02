package bcit.WordGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The World class manages a collection of countries and their associated capitals and facts.
 * It loads country data from text files and stores the information in a HashMap for easy access.
 * @author Evan Vink
 * @version 1.0
 */
public class World{

    private static final int AMOUNT_OF_FACTS    = 3;
    private static final int FACT_FIRST_SPOT    = 0;
    private static final int FACT_SECOND_SPOT   = 1;
    private static final int FACT_THIRD_SPOT    = 2;


    HashMap<String, Country> world;


    /**
     * Constructor for the World class.
     * It loads country data from predefined text files and stores it in a HashMap.
     */
    public World(){
        world = new HashMap<>();
        Scanner scan;
        File    file;
        String  filePath;

        String[] files = {"a.txt", "b.txt", "c.txt", "d.txt", "e.txt", "f.txt", "g.txt", "h.txt", "i.txt",
        "j.txt", "k.txt", "l.txt", "m.txt", "n.txt", "o.txt", "p.txt", "q.txt", "r.txt", "s.txt",
        "t.txt", "u.txt", "v.txt", "y.txt", "z.txt"};

        for(int i = 0; i < files.length; i++) {
            filePath    = String.format("Text/%s", files[i]);
            file        = new File(filePath);

            try {
                scan = new Scanner(file);
                scan.useDelimiter("[:\\r\\n]+");

                while (scan.hasNext()) {

                    final String country;
                    final String capital;
                    String[] facts;
                    facts = new String[AMOUNT_OF_FACTS];


                    country     = scan.next();
                    capital     = scan.next();
                    facts[FACT_FIRST_SPOT]    = scan.next();
                    facts[FACT_SECOND_SPOT]    = scan.next();
                    facts[FACT_THIRD_SPOT]    = scan.next();
                    scan.nextLine();

                    world.put(country, new Country(country, capital, facts));
                }

                scan.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

    }

    /**
     * Gets the world map containing countries and their associated data.
     *
     * @return A HashMap where the key is the country name and the value is a Country object.
     */
    public HashMap<String, Country> getWorld(){
        return world;
    }




}
