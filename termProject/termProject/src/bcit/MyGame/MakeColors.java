package bcit.MyGame;

import javafx.scene.paint.Color;

import java.util.Random;

/**
 * A class that implements the {@link Colors} interface to create colors.
 * The colors are generated randomly based on the provided RGB values.
 * This class supports creating colors with single or multiple color components
 * and uses randomization to select different color combinations.
 */
public class MakeColors implements Colors{

    private static final int COLOR_MAX          = 3;
    private static final int COLOR_MIN          = 1;
    private static final int EMPTY_COLOR        = 0;
    private static final int FIRST_COLOR_SET    = 1;
    private static final int SECOND_COLOR_SET   = 2;
    private static final int THIRD_COLOR_SET    = 3;


    private Random randColor;


    /**
     * Returns a color based on a single RGB value. The RGB value is randomly assigned
     * to one of the color channels (red, green, or blue).
     *
     * @param rgb The integer RGB value (range 0-255).
     * @return A Color object where the specified RGB value is assigned to one of the color channels.
     */
    @Override
    public Color getColor(int rgb) {
        randColor = new Random();
        switch(randColor.nextInt(COLOR_MAX) + COLOR_MIN){
            case FIRST_COLOR_SET:
                return Color.rgb(rgb, EMPTY_COLOR, EMPTY_COLOR);
            case SECOND_COLOR_SET:
                return Color.rgb(EMPTY_COLOR, rgb, EMPTY_COLOR);
            case THIRD_COLOR_SET:
                return Color.rgb(EMPTY_COLOR, EMPTY_COLOR, rgb);
            default:
                return Color.rgb(EMPTY_COLOR, EMPTY_COLOR, EMPTY_COLOR);
        }
    }


    /**
     * Returns a color based on two RGB values. The first value is randomly assigned
     * to one of the color channels (red, green, or blue), and the second value
     * is assigned to a different color channel.
     *
     * @param rgb The first RGB value (range 0-255).
     * @param grb The second RGB value (range 0-255).
     * @return A Color object with the specified RGB values assigned to two different channels.
     */
    @Override
    public Color getColor(int rgb, int grb) {
        randColor = new Random();
        switch(randColor.nextInt(COLOR_MAX) + COLOR_MIN){
            case FIRST_COLOR_SET:
                return Color.rgb(rgb, grb, EMPTY_COLOR);
            case SECOND_COLOR_SET:
                return Color.rgb(EMPTY_COLOR, rgb, grb);
            case THIRD_COLOR_SET:
                return Color.rgb(rgb, EMPTY_COLOR, grb);
            default:
                return Color.rgb(EMPTY_COLOR, EMPTY_COLOR, EMPTY_COLOR);
        }
    }


    /**
     * Returns a color based on individual red, green, and blue components.
     *
     * @param r The red color component (range 0-255).
     * @param g The green color component (range 0-255).
     * @param b The blue color component (range 0-255).
     * @return A Color object created from the provided RGB components.
     */
    @Override
    public Color getColor(int r, int g, int b) {
        return Color.rgb(r, g, b);
    }


}
