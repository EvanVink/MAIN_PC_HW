package bcit.WordGame;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class represents the score of a game. It contains information about the number of games played,
 * the number of correct answers on the first and second attempts, and the number of incorrect attempts.
 * It also provides methods for saving, reading, and calculating scores.
 *@author Evan Vink
 * @version 1.0
 */
public class Score {

    private static final int LINES_PER_SET_IN_SCORE_FILE    = 6;
    private static final int FIRST_ATTEMPT_MULTIPLIER_BONUS = 2;
    private static final int SPLIT_SECOND_INDEX             = 1;
    private static final int PARSE_SECOND_POSITION          = 1;
    private static final int PARSE_THIRD_POSITION           = 2;
    private static final int PARSE_FOURTH_POSITION          = 3;
    private static final int PARSE_FIFTH_POSITION           = 4;



    private final int               numGamesPlayed;
    private final int               numCorrectFirstAttempt;
    private final int               numCorrectSecondAttempt;
    private final int               numIncorrectTwoAttempts;
    private final DateTimeFormatter formatter;
    private final DateTimeFormatter hms;
    private final DateTimeFormatter date;
    private final LocalDateTime     time;



    /**
     * Constructor for creating a Score object.
     *
     * @param time The date and time when the score was recorded.
     * @param numGamesPlayed The number of games played.
     * @param numCorrectFirstAttempt The number of correct answers on the first attempt.
     * @param numCorrectSecondAttempt The number of correct answers on the second attempt.
     * @param numIncorrectTwoAttempts The number of incorrect answers after two attempts.
     */
    public Score(final LocalDateTime time, final int numGamesPlayed,
            final int numCorrectFirstAttempt, final int numCorrectSecondAttempt,
                 final int numIncorrectTwoAttempts){

        this.time                       = time;
        this.numGamesPlayed             = numGamesPlayed;
        this.numCorrectFirstAttempt     = numCorrectFirstAttempt;
        this.numCorrectSecondAttempt    = numCorrectSecondAttempt;
        this.numIncorrectTwoAttempts    = numIncorrectTwoAttempts;

        formatter   = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        hms         = DateTimeFormatter.ofPattern("HH:mm:ss");
        date        = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }


    /**
     * Returns a string representation of the score.
     *
     * @return A formatted string with the score details including date, number of games played, correct attempts,
     *         incorrect attempts, and total score.
     */
    public String toString(){
        return String.format(
                "Date and Time: %s\nGames Played: %d\nCorrect First Attempts: %d" +
                "\nCorrect Second Attempts: %d\nIncorrect Attempts: %d\nScore: %d points\n",
                time.format(formatter), numGamesPlayed, numCorrectFirstAttempt,
                numCorrectSecondAttempt, numIncorrectTwoAttempts, getScore()
        );
    }

    /**
     * Appends the score details to a file.
     *
     * @param score The score object to be appended.
     * @param fileName The name of the file where the score should be saved.
     * @throws RuntimeException If an error occurs during file writing.
     */
    public static void appendScoreToFile(final Score score, final String fileName){
        try {
            Path path = Paths.get(fileName);
            File        scoreFile;
            FileWriter  fileWriter;

            scoreFile   = new File(String.valueOf(path));
            fileWriter  = new FileWriter(scoreFile, true);

            fileWriter.write(score.toString());
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Reads scores from a file and returns a list of Score objects.
     *
     * @param fileName The name of the file to read scores from.
     * @return A list of Score objects read from the file.
     * @throws IOException If an error occurs while reading the file.
     */
    public static List<Score> readScoresFromFile(final String fileName) throws IOException {
        Path path = Paths.get(fileName);

        if(Files.notExists(path)){
            Files.createDirectories(path);
        }

        List<String> lines;
        List<Score> total;
        DateTimeFormatter formatter;

        lines       = Files.readAllLines(path);
        total       = new ArrayList<>();
        formatter   = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < lines.size(); i += LINES_PER_SET_IN_SCORE_FILE) {

            String dateTimePart = lines.get(i).split("Date and Time: ")[SPLIT_SECOND_INDEX].trim();
            LocalDateTime time = LocalDateTime.parse(dateTimePart, formatter);

            int gamesPlayed = Integer.parseInt(lines.get(i + PARSE_SECOND_POSITION)
                    .split("Games Played: ")[SPLIT_SECOND_INDEX].trim());

            int correctFirstAttempts = Integer.parseInt(lines.get(i + PARSE_THIRD_POSITION)
                    .split("Correct First Attempts: ")[SPLIT_SECOND_INDEX].trim());

            int correctSecondAttempts = Integer.parseInt(lines.get(i + PARSE_FOURTH_POSITION)
                    .split("Correct Second Attempts: ")[SPLIT_SECOND_INDEX].trim());

            int incorrectAttempts = Integer.parseInt(lines.get(i + PARSE_FIFTH_POSITION)
                    .split("Incorrect Attempts: ")[SPLIT_SECOND_INDEX].trim());

            total.add(new Score(time, gamesPlayed, correctFirstAttempts,
                    correctSecondAttempts, incorrectAttempts));
        }

        return total;
    }

    /**
     * Calculates the total score based on correct attempts.
     *
     * @return The calculated total score.
     */
    public int getScore(){
        return (numCorrectFirstAttempt * FIRST_ATTEMPT_MULTIPLIER_BONUS) + (numCorrectSecondAttempt);
    }

    /**
     * Calculates the average score per game based on the correct attempts.
     *
     * @return The average score per game.
     */
    public double getAverage(){
        return (double) ((numCorrectFirstAttempt * FIRST_ATTEMPT_MULTIPLIER_BONUS)
                + numCorrectSecondAttempt) / numGamesPlayed;
    }

    /**
     * Gets the date of the score record in "yyyy-MM-dd" format.
     *
     * @return The formatted date of the score record.
     */
    public String getDate(){
        return date.format(time);
    }

    /**
     * Gets the time (hour, minute, second) of the score record in "HH:mm:ss" format.
     *
     * @return The formatted time of the score record.
     */
    public String getHMS(){
        return hms.format(time);
    }





}
