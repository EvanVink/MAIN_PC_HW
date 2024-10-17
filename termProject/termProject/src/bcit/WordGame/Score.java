package bcit.WordGame;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Score {

    private final LocalDateTime dateTimePlayed;
    private final int numGamesPlayed;
    private final int numCorrectFirstAttempt;
    private final int numCorrectSecondAttempt;
    private final int numIncorrectTwoAttempts;




    public Score(final int numGamesPlayed,
            final int numCorrectFirstAttempt, final int numCorrectSecondAttempt,
                 final int numIncorrectTwoAttempts){

        dateTimePlayed = LocalDateTime.now();
        this.numGamesPlayed = numGamesPlayed;
        this.numCorrectFirstAttempt = numCorrectFirstAttempt;
        this.numCorrectSecondAttempt = numCorrectSecondAttempt;
        this.numIncorrectTwoAttempts = numIncorrectTwoAttempts;

    }

    public void printScore(){

        final DateTimeFormatter formatter;
        final String formattedDateTime;


        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDateTime = dateTimePlayed.format(formatter);

        System.out.println(formattedDateTime);


    }






}
