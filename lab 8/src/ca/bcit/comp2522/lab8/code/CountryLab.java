package ca.bcit.comp2522.lab8.code;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *  CountryLab is for practicing how to use NIO for file operations, "Stream" operations with terminal operations
 *  "filter", "map", "reduce".
 *      longerThanTen() Writing country names longer than 10 characters into data.txt.
 *      shorterThanFive() Writing country names shorter than 5 characters into data.txt.
 *      startsWithA() Writing country names starting with "A" into data.txt.
 *      endWIthLand() Writing country names ending with "land" into data.txt.
 *      containUnited() Writing country names containing "United" into data.txt.
 *      alphaOrder() Writing all country names in alphabetical order into data.txt.
 *      uniqueFirstLetter() Writing the unique first letters of all country names into data.txt.
 *      numberOfCountries() Writing the total count of country names into data.txt.
 *      longestCountryName() Writing the longest country name into data.txt.
 *      shortestCountryName() Writing the shortest country name into data.txt.
 *      namesInUpperCase() Writing all country names converted to uppercase into data.txt.
 *      moreThanOneWord() Writing all country names with more than one word into data.txt.
 *      mapCountriesName() Writing Map each country name to its character count into data.txt.
 *      startWithZ() Writing "true" if any country name starts with "Z"; otherwise, "false" into data.txt.
 *      longerThanThreeChar() Writing "true" if all country names are longer than 3 characters; otherwise, "false" into
 *                            data.txt.
 *
 * @author Evan Vink
 * @author Yujin Jeong
 * @version 1.0
 */
public class CountryLab {

    final Path countries = Paths.get("src","ca","bcit","comp2522","lab8", "code", "week8countries.txt");
    final Path dirPath = Paths.get("ca","bcit","comp2522","lab8", "matches");
    final Path dataFile = dirPath.resolve("data.txt");
    List<String> countriesList;

    /**
     * Creating constructor
     * @throws IOException if fails to read files or directories
     */
    public CountryLab() throws IOException {

        if(Files.notExists(dirPath)){
            Files.createDirectories(dirPath);
        }

        countriesList = Files.readAllLines(countries);
    }




    /*
     * Writing country names longer than 10 characters into data.txt
     */
    void longerThanTen() throws IOException {
        try {
            final List<String> countriesLongerThanTen;

            countriesLongerThanTen = countriesList.stream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.length() > 10)
                    .collect(ArrayList::new, List::add, List::addAll);

            Files.writeString(dataFile, "Country names longer than 10 characters:\n",
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            Files.write(dataFile, countriesLongerThanTen, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing country names longer than 10 char" + e.getMessage());
        }
    }

    /*
     * Writing country names shorter than 5 characters into data.txt
     */
    void shorterThanFive() throws IOException {
        try {
            final List<String> countriesShorterThanFive;

            countriesShorterThanFive = countriesList.stream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.length() < 5)
                    .collect(ArrayList::new, List::add, List::addAll);

            countriesShorterThanFive.addFirst("\n===Countries name shorter than 5 char===");

            Files.write(dataFile, countriesShorterThanFive, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing country names shorter than 5 char" + e.getMessage());
        }
    }


    /*
     *  Writing country names starting with "A" into data.txt
     */
    void startsWithA() throws IOException {
        List<String> startA = countriesList.stream()
                .filter(country -> country != null)
                .filter(country -> country.startsWith("A"))
                .toList();


        Files.writeString(dataFile, "Country names starting with 'A':\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);


        startA.forEach(country -> {
            try {
                Files.writeString(dataFile, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Error writing country names that start with A" + e.getMessage());
            }
        });

        Files.writeString(dataFile, "\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /*
     *  Writing country names ending with "land" into data.txt
     */
    void endWIthLand() throws IOException {
        try {
            final List<String> endWithLand;

            endWithLand = countriesList.stream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.endsWith("land"))
                    .collect(ArrayList::new, List::add, List::addAll);

            endWithLand.addFirst("\n===Countries ending with \"land\"===");

            Files.write(dataFile, endWithLand, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing country names ending with \"land\"" + e.getMessage());
        }
    }

    /*
     *  Writing country names containing "United" into data.txt
     */
    void containUnited() throws IOException {
        try {
            final List<String> containUnited;

            containUnited = countriesList.stream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.contains("United"))
                    .collect(ArrayList::new, List::add, List::addAll);

            containUnited.addFirst("\n===Countries containing \"United\"===");

            Files.write(dataFile, containUnited, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing country names containing \"United\"" + e.getMessage());
        }
    }

    /*
     *  Writing all country names in alphabetical order into data.txt
     */
    void alphaOrder() throws IOException {

        List<String> Order = countriesList.stream()
                .filter(country -> country != null)
                .sorted(Comparator.comparing(country -> country))
                .toList();

        Files.writeString(dataFile, "Countries in Alphabetical Order:\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Order.forEach(country -> {

            try {

                Files.writeString(dataFile, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            } catch (IOException e) {
                System.out.println("Error writing the unique first letters of all country names");
            }
        });

        Files.writeString(dataFile, "\n\n\n\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /*
     *  Writing the unique first letters of all country names into data.txt
     */
    void uniqueFirstLetter() throws IOException {
        try{
            final List<String> uniqueFirstLetter;

            uniqueFirstLetter = countriesList.stream()
                    .filter(Objects::nonNull)
                    .map(unique -> unique.substring(0,1))
                    .collect(ArrayList::new, List::add, List::addAll);

            uniqueFirstLetter.addFirst("\n===The unique first letters of all country names===");

            Files.write(dataFile, uniqueFirstLetter, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing the unique first letters of all country names" + e.getMessage());
        }
    }

    /*
     *  Writing the total count of country names into data.txt
     */
    void numberOfCountries() throws IOException {
        long total;

        total = countriesList.stream()
                .filter(country -> country != null)
                .count();

        Files.writeString(dataFile, "Number of Countries:\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Files.writeString(dataFile, String.valueOf(total),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Files.writeString(dataFile, "\n\n\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /*
     *  Writing the longest country name into data.txt
     */
    void longestCountryName() throws IOException {
        try{
            final Optional<String>  longest;
            final List<String>      longestName;

            longestName = new ArrayList<>();
            longest     = countriesList.stream().max(Comparator.comparingInt(String::length));

            longestName.addFirst("\n===Longest country name===");
            longestName.add(String.valueOf(longest));

            Files.write(dataFile, longestName, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing the longest country name" + e.getMessage());
        }
    }

    /*
     *  Writing the shortest country name into data.txt
     */
    void shortestCountryName() throws IOException {
        try{
            final Optional<String> shortest;
            final List<String>     shortestName;

            shortestName = new ArrayList<>();
            shortest     = countriesList.stream().min(Comparator.comparingInt(String::length));

            shortestName.addFirst("\n===Shortest country name===");
            shortestName.add(String.valueOf(shortest));

            Files.write(dataFile, shortestName, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing the shortest country name" + e.getMessage());
        }
    }

    /*
     *  Writing all country names converted to uppercase into data.txt
     */
    void namesInUpperCase(){
        List<String> namesInUpper = countriesList.stream()
                .filter(country -> country != null)
                .map(country -> country.toUpperCase())
                .toList();

        namesInUpper.forEach(country -> {
            try{
                Files.writeString(dataFile, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Error writing the names in upper case" + e.getMessage());
            }
        });
    }

    /*
     *  Writing all country names with more than one word into data.txt
     */
    void moreThanOneWord() throws IOException {
        try{
            final List<String> moreThanOneWord;

            moreThanOneWord = countriesList.stream()
                    .filter(Objects::nonNull)
                    .filter(word -> word.contains(" "))
                    .collect(ArrayList::new, List::add, List::addAll);

            moreThanOneWord.addFirst("\n===All country names with more than one word===");

            Files.write(dataFile, moreThanOneWord, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing all country names with more than one word" + e.getMessage());
        }
    }

    /*
     *  Writing Map each country name to its character count into data.txt
     */
    void mapCountriesName() throws IOException {
        try{
            final Map<String, Integer> nameLength;
            final List<String>         keyAndValue;

            nameLength = countriesList.stream()
                    .filter(Objects::nonNull)
                    .collect(HashMap::new, (map, name) -> map.put(name, name.length()), Map::putAll);

            keyAndValue = Stream.concat(Stream.of("\n===Map each country name to its character count==="),
                            nameLength.entrySet()
                                    .stream()
                                    .map(entry -> "Name: " + entry.getKey() +
                                            ", Length: " + entry.getValue()))
                    .toList();

            Files.write(dataFile, keyAndValue, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing Map each country name to its character count" + e.getMessage());
        }
    }

    /*
     *  Writing "true" if any country name starts with "Z"; otherwise, "false" into data.txt
     */
    void startWithZ() throws IOException {
        Boolean startWithZ = countriesList.stream()
                .filter(country -> country != null)
                .anyMatch(country -> country.startsWith("Z"));

        Files.writeString(dataFile, "\nAre there Countries that start with a Z? true or false:\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Files.writeString(dataFile, String.valueOf(startWithZ),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }

    /*
     *  Writing "true" if all country names are longer than 3 characters; otherwise, "false" into data.txt
     */
    void longerThanThreeChar() throws IOException {
        try{
            final boolean allLongerThanThree;
            final List<String> result2;

            result2            = new ArrayList<>();
            allLongerThanThree = countriesList.stream()
                    .filter(Objects::nonNull)
                    .allMatch(name -> name.length() > 3);

            result2.addFirst("\n\n===\"true\" if all country names are longer than 3 characters. Else, \"false\"===");
            result2.add(String.valueOf(allLongerThanThree));

            Files.write(dataFile, result2, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing true if all country names are longer than 3 characters. Else,false"
                    + e.getMessage());
        }
    }

    public static void main(Object o) {
        final CountryLab data;

        try {
            data = new CountryLab();


            data.longerThanTen();

            data.shorterThanFive();

            data.startsWithA();

            data.endWIthLand();

            data.containUnited();

            data.alphaOrder();

            data.uniqueFirstLetter();

            data.numberOfCountries();

            data.longestCountryName();

            data.shortestCountryName();

            data.namesInUpperCase();

            data.moreThanOneWord();

            data.mapCountriesName();

            data.startWithZ();

            data.longerThanThreeChar();

        } catch (IOException e) {
            System.out.println("error printing the method" + e.getMessage());
        }
    }

//    public static void main(final String[] args) {
//
//        final CountryLab data;
//
//        try {
//            data = new CountryLab();
//
//
//            data.longerThanTen();
//
//            data.shorterThanFive();
//
//            data.startsWithA();
//
//            data.endWIthLand();
//
//            data.containUnited();
//
//            data.alphaOrder();
//
//            data.uniqueFirstLetter();
//
//            data.numberOfCountries();
//
//            data.longestCountryName();
//
//            data.shortestCountryName();
//
//            data.namesInUpperCase();
//
//            data.moreThanOneWord();
//
//            data.mapCountriesName();
//
//            data.startWithZ();
//
//            data.longerThanThreeChar();
//
//        } catch (IOException e) {
//            System.out.println("error printing the method" + e.getMessage());
//        }
//    }
}
