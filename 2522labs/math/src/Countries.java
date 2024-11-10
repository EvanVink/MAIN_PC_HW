import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Countries {


    final Path countries = Paths.get("src","week8countries.txt");
    final List<String> countriesList;

    public Countries() throws IOException {
        countriesList = Files.readAllLines(countries);
    }


    void questionA(){
        final String[] startWithAorTinUpper;

        startWithAorTinUpper = filteredStream(countriesList)
                .filter(country -> country.startsWith("A") || country.startsWith("T"))
                .map(country -> country.toUpperCase())
                .sorted(Comparator.comparing(String::length))
                .toArray(String[]::new);

        for(String country : startWithAorTinUpper){
            System.out.println(country);
        }

    }


    void questionB(){
        final List<String> containTwoVowels;

        containTwoVowels = filteredStream(countriesList)
                .filter(country -> country.matches("[^AEIOUaeiou]*[AEIOUaeiou][^AEIOUaeiou]*[AEIOUaeiou][^AEIOUaeiou]*"))
                .toList()
                .reversed();

        containTwoVowels.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final Countries con;

        try{
            con = new Countries();

            System.out.println("Question 1.a:\n");
            con.questionA();

            System.out.println("\nQuestion 1.b\n");
            con.questionB();

        } catch(IOException e) {
            System.out.println("Error: printing out the countries" + e.getMessage());
        }


    }


    private static Stream<String> filteredStream(final List<String> countryList){
        return countryList.stream().filter(country -> country != null);
    }

}