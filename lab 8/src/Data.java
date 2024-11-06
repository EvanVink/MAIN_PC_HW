import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Data {

    final Path countries = Paths.get("src/week8countries.txt");
    final Path path = Paths.get("src/matches");
    final Path file = path.resolve("data.txt");
    List<String> countriesList;

    public Data() throws IOException {

        if(Files.notExists(path)){
            Files.createDirectories(path);
        }

        countriesList = Files.readAllLines(countries);
    }


    void startsWithA() throws IOException {
        List<String> startA = countriesList.stream()
                .filter(country -> country != null)
                .filter(country -> country.startsWith("A"))
                .toList();


        Files.writeString(file, "Countries that start with an A:\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);


        startA.forEach(country -> {
            try {
                Files.writeString(file, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Files.writeString(file, "\n\n\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    void alphaOrder() throws IOException {
        List<String> Order = countriesList.stream()
                .filter(country -> country != null)
                .sorted(Comparator.comparing(country -> country))
                .toList();

        Files.writeString(file, "Countries in Alphabetical Order:\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Order.forEach(country -> {
            try {
                Files.writeString(file, country + System.lineSeparator(),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Files.writeString(file, "\n\n\n\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    void numberOfCountries(){
        long total = countriesList.stream()
                .filter(country -> country != null)
                .count();
        System.out.println(total);
    }

    void namesInUpperCase(){
        List<String> namesInUpper = countriesList.stream()
                .filter(country -> country != null)
                .map(country -> country.toUpperCase())
                .toList();
        namesInUpper.forEach(System.out::println);
    }

    void startWithZ(){
        List<Boolean> startWithZ = countriesList.stream()
                .filter(country -> country != null)
                .map(country -> country.startsWith("Z"))
                .toList();

        int i = 0;
        for(Boolean start : startWithZ){
            System.out.println(countriesList.get(i)  + ": " + start);
            i += 1;
        }
    }



}
