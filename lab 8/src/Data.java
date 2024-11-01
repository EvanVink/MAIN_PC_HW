import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Data {

    final Path countries = Paths.get("src/week8countries.txt");
    final Path path = Paths.get("src/matches");
    final Path file = path.resolve("gt.txt");
    List<String> countriesList;

    public Data() throws IOException {

        if(Files.notExists(path)){
            Files.createDirectories(path);
        }

        countriesList = Files.readAllLines(countries);
    }


    void startsWithA(){
        List<String> startA = countriesList.stream()
                .filter(country -> country != null)
                .filter(country -> country.startsWith("A"))
                .toList();

        startA.forEach(System.out::println);
    }

    void alphaOrder(){
        List<String> Order = countriesList.stream()
                .filter(country -> country != null)
                .sorted(Comparator.comparing(country -> country))
                .toList();
        Order.forEach(System.out::println);
    }

    void numberOfCountries(){
        List<String> total = countriesList.stream()
                .filter(country -> country != null)
                .toList();
        System.out.println(total.size())    ;
    }

    void namesInUpperCase(){
        List<String> namesInUpper = countriesList.stream()
                .filter(country -> country != null)
                .
    }



}
