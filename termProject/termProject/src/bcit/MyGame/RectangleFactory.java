package bcit.MyGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

/**
 * A concrete implementation of the class that creates objects.
 * This factory class provides a method to generate rectangles with specified dimensions and color.
 * @author Evan Vink
 * @version 1.0
 */
public class RectangleFactory extends ShapeFactory {

    /**
     * Creates with the specified length, width, and color.
     * This method overrides the method to return an object.
     *
     * @param length The length of the rectangle.
     * @param width The width of the rectangle.
     * @param color The color of the rectangle.
     * @return An object with the specified dimensions and color.
     */
    @Override
    public Shape createShape(int length, int width, Color color) {
        return new Rectangle(length, width, color);
    }
}
