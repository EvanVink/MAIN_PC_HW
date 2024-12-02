package bcit.MyGame;
import javafx.scene.paint.Color;


/**
 * Interface for defining color-related methods to create and retrieve color objects.
 * It provides methods for creating colors based on RGB values.
 * @author Evan Vink
 * @version 1.0
 */
public interface Colors {

    /**
     * Returns a color based on a single RGB value.
     * This method is intended for cases where the RGB value is a combined integer value
     * representing red, green, and blue channels.
     *
     * @param rgb The integer value representing the RGB color.
     * @return A Color object representing the color based on the RGB value.
     */
    Color getColor(int rgb);

    /**
     * Returns a color based on a single RGB value and a second GRB value.
     * This method is intended for more complex color calculations using two integer values.
     *
     * @param rgb The integer value representing the RGB color.
     * @param grb An additional integer value to modify the color.
     * @return A Color object representing the color based on both the RGB and GRB values.
     */
    Color getColor(int rgb, int grb);

    /**
     * Returns a color based on the individual red, green, and blue values.
     *
     * @param r The red color component.
     * @param g The green color component.
     * @param b The blue color component.
     * @return A Color object representing the color created from the red, green, and blue values.
     */
    Color getColor(int r, int g, int b);
}
