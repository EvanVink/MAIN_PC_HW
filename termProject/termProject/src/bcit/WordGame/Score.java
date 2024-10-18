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
    private final float scoreAverage;
    final int totalScore;
    final DateTimeFormatter formatter;
    final DateTimeFormatter bigDateFormatter;
    final DateTimeFormatter smallDateFormatter;
    final String formattedDateTime;
    final String bigDateFormatted;
    final String smallDateFormatted;




    public Score(final int numGamesPlayed,
            final int numCorrectFirstAttempt, final int numCorrectSecondAttempt,
                 final int numIncorrectTwoAttempts){

        dateTimePlayed = LocalDateTime.now();
        this.numGamesPlayed = numGamesPlayed;
        this.numCorrectFirstAttempt = numCorrectFirstAttempt;
        this.numCorrectSecondAttempt = numCorrectSecondAttempt;
        this.numIncorrectTwoAttempts = numIncorrectTwoAttempts;
        int firstAttemptScore = numCorrectFirstAttempt * 2;
        scoreAverage = (float) (firstAttemptScore + numCorrectSecondAttempt) /
                numGamesPlayed;
        totalScore = firstAttemptScore + numCorrectSecondAttempt;

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        bigDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        smallDateFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        formattedDateTime = dateTimePlayed.format(formatter);
        bigDateFormatted = dateTimePlayed.format(bigDateFormatter);
        smallDateFormatted = dateTimePlayed.format(smallDateFormatter);

    }

    public void printScore(){


        final String output;




        output = String.format("""
                - Date and Time: %s
                - Games Played: %d
                - Correct First Attempts: %d
                - Correct Second Attempts: %d
                - Incorrect Attempts: %d
                - Total Score: %d Points
                - Average Score: %.2f Points/Game
                """, formattedDateTime, numGamesPlayed,
                numCorrectFirstAttempt, numCorrectSecondAttempt,
                numIncorrectTwoAttempts, totalScore, scoreAverage);

        System.out.println(output);


    }

    public float getScoreAverage(){
        return scoreAverage;
    }

    public String getDateTimePlayed(){
        return formattedDateTime;
    }

    public String getSmallDateFormatted(){
        return smallDateFormatted;
    }

    public String getBigDateFormatted(){
        return bigDateFormatted;
    }






}
