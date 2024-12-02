package bcit.Tests;

import bcit.MyGame.ColorMatcher;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for to verify the correctness of the scoring system.
 * This class contains tests for the method.
 * @author Evan Vink
 * @version 1.0
 */
public class MyGameTest {

    private ColorMatcher colorMatcher;
    private ColorMatcher.Scores scores;

    /**
     * Set up the test environment before each test.
     * Initializes a new instance of and its inner class.
     */
    @BeforeEach
    void setUp() {
        colorMatcher = new ColorMatcher();
        scores = colorMatcher.new Scores();
    }

    /**
     * Test the application of the Euclidean formula for color matching.
     * Verifies that the score is correct when the player color exactly matches the target color,
     * and that the score decreases when the player color is different from the target color.
     */
    @Test
    void testApplyEuclideanFormula() {
        Color targetColor = Color.rgb(255, 0, 0);
        Color playerColor = Color.rgb(255, 0, 0); // Perfect match
        colorMatcher.setTargetColor(targetColor);
        colorMatcher.setPlayerColor(playerColor);

        double score = scores.applyEuclideanFormula();
        assertEquals(ColorMatcher.getMaxScore(), score, 0.01);

        playerColor = Color.rgb(0, 0, 0);
        colorMatcher.setPlayerColor(playerColor);

        score = scores.applyEuclideanFormula();
        assertTrue(score < ColorMatcher.getMaxScore(), "Score should be less than MAX_SCORE for a mismatch");
    }



}
