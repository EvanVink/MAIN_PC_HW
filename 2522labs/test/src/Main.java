import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String test = "Date and Time: 2024-11-30 18:36:46";

        String date = test.split("Date and Time: ")[1].trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(date, formatter);



        System.out.println(time);
    }
}