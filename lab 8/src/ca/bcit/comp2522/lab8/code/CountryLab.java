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
 *      longerThanTen() Writing country names longer than MAX_CHAR_LENGTH characters into data.txt.
 *      shorterThanFive() Writing country names shorter than SHORT_CHAR_LENGTH characters into data.txt.
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
 *      longerThanThreeChar() Writing "true" if all country names are longer than CHAR_MIN_LENGTH characters; otherwise,
 *      "false" into data.txt.
 *
 * @author Evan Vink
 * @author Yujin Jeong
 * @version 1.0
 */
public class CountryLab {

    private static final int SHORT_CHAR_LENGTH  = 5;
    private static final int MAX_CHAR_LENGTH    = 10;
    private static final int CHAR_MIN_LENGTH    = 3;
    private static final int FIRST_CHARACTER     = 0;
    private static final int SECOND_CHARACTER    = 1;

    private final Path          countries;
    private final Path          dirPath;
    private final Path          dataFile;
    private final List<String>  countriesList;

    /**
     * Creating constructor
     * @throws IOException if fails to read files or directories
     */
    public CountryLab() throws IOException {

        countries = Paths.get("src","ca","bcit","comp2522","lab8", "code", "week8countries.txt");
        dirPath = Paths.get("ca","bcit","comp2522","lab8", "matches");
        dataFile = dirPath.resolve("data.txt");


        if(Files.notExists(dirPath)){
            Files.createDirectories(dirPath);
        }

        countriesList = Files.readAllLines(countries);
    }

    /**
     * Writes country names longer than MAX_CHAR_LENGTH characters to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
     */
    void longerThanN(final int n) throws IOException {
        try {
            final List<String> countriesLongerThanTen;

            countriesLongerThanTen = countriesList.stream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.length() > n)
                    .collect(ArrayList::new, List::add, List::addAll);

            Files.writeString(dataFile, "Country names longer than " + n + " characters:\n",
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            Files.write(dataFile, countriesLongerThanTen, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing country names longer than " + n + " char" + e.getMessage());
        }
    }

    /**
     * Writes country names shorter than SHORT_CHAR_LENGTH characters to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
     */
    void shorterThanN(final int n) throws IOException {
        try {
            final List<String> countriesShorterThanFive;

            countriesShorterThanFive = countriesList.stream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.length() < n)
                    .collect(ArrayList::new, List::add, List::addAll);

            countriesShorterThanFive.addFirst("\n===Countries name shorter than " + n + " char===");

            Files.write(dataFile, countriesShorterThanFive, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing country names shorter than " + n + " char" +
                    e.getMessage());
        }
    }


    /**
     * Writes country names starting with 'A' to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
     */
    void startsWithA() throws IOException {
        final List<String> startA = countriesList.stream()
                .filter(country -> country != null)
                .filter(country -> country.startsWith("A"))
                .toList();


        Files.writeString(dataFile, "Country names starting with 'A':\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);


        startA.forEach(country -> {
            try {
                Files.writeString(dataFile, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (final IOException e) {
                System.out.println("Error writing country names that start with A" + e.getMessage());
            }
        });

        Files.writeString(dataFile, "\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /**
     * Writes country names ending with "land" to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
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

    /**
     * Writes country names containing "United" to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
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

    /**
     * Writes all country names in alphabetical order to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
     */
    void alphaOrder() throws IOException {

        final List<String> Order = countriesList.stream()
                .filter(country -> country != null)
                .sorted(Comparator.comparing(country -> country))
                .toList();

        Files.writeString(dataFile, "Countries in Alphabetical Order:\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Order.forEach(country -> {

            try {

                Files.writeString(dataFile, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            } catch (final IOException e) {
                System.out.println("Error writing the unique first letters of all country names");
            }
        });

        Files.writeString(dataFile, "\n\n\n\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    /**
     * Writes unique first letters of all country names to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
     */
    void uniqueFirstLetter() throws IOException {
        try{
            final List<String> uniqueFirstLetter;

            uniqueFirstLetter = countriesList.stream()
                    .filter(Objects::nonNull)
                    .map(unique -> unique.substring(FIRST_CHARACTER,SECOND_CHARACTER))
                    .collect(ArrayList::new, List::add, List::addAll);

            uniqueFirstLetter.addFirst("\n===The unique first letters of all country names===");

            Files.write(dataFile, uniqueFirstLetter, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing the unique first letters of all country names" + e.getMessage());
        }
    }

    /**
     * Writes the total count of country names to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
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

    /**
     * Writes the longest country name to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
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

    /**
     * Writes the shortest country name to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
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


    /**
     * Writes all country names in uppercase to "data.txt".
     */
    void namesInUpperCase(){
        final List<String> namesInUpper = countriesList.stream()
                .filter(country -> country != null)
                .map(country -> country.toUpperCase())
                .toList();

        namesInUpper.forEach(country -> {
            try{
                Files.writeString(dataFile, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (final IOException e) {
                System.out.println("Error writing the names in upper case" + e.getMessage());
            }
        });
    }

    /**
     * Writes country names with more than one word to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
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

    /**
     * Maps each country name to its character count and writes to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
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

    /**
     * Writes "true" if any country name starts with 'Z', otherwise "false", to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
     */
    void startWithZ() throws IOException {
        final Boolean startWithZ = countriesList.stream()
                .filter(country -> country != null)
                .anyMatch(country -> country.startsWith("Z"));

        Files.writeString(dataFile, "\nAre there Countries that start with a Z? true or false:\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Files.writeString(dataFile, String.valueOf(startWithZ),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

    }

    /**
     * Writes "true" if all country names are longer than CHAR_MIN_LENGTH characters,
     * otherwise "false", to "data.txt".
     *
     * @throws IOException if there is an error writing to the file.
     */
    void longerThanNChar(final int n) throws IOException {
        try{
            final boolean allLongerThanThree;
            final List<String> result2;

            result2            = new ArrayList<>();
            allLongerThanThree = countriesList.stream()
                    .filter(Objects::nonNull)
                    .allMatch(name -> name.length() > n);

            result2.addFirst("\n\n===\"true\" if all country names are longer than " + n +
                    " characters. Else, \"false\"===");
            result2.add(String.valueOf(allLongerThanThree));

            Files.write(dataFile, result2, StandardOpenOption.APPEND);

        } catch(final IOException e) {
            System.out.println("Error writing true if all country names are longer than " + CHAR_MIN_LENGTH +
                    " characters. Else,false"
                    + e.getMessage());
        }
    }

    public static void main(final String[] args) {

        final CountryLab data;

        try {
            data = new CountryLab();

            data.longerThanN(MAX_CHAR_LENGTH);

            data.shorterThanN(SHORT_CHAR_LENGTH);

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

            data.longerThanNChar(CHAR_MIN_LENGTH);

        } catch (IOException e) {
            System.out.println("error printing the method" + e.getMessage());
        }
    }
}
