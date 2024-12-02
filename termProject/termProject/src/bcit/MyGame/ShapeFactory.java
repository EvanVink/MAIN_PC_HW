package bcit.MyGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * An abstract class that defines a factory for creating objects.
 * Subclasses are required to provide their own implementations for creating specific shapes.
 * @author Evan Vink
 * @version 1.0
 */
public abstract class ShapeFactory {

    /**
     * Creates an object with the specified size and color.
     * This method must be implemented by subclasses to create specific shapes like rectangles or circles.
     *
     * @param size1 The first dimension of the shape (e.g., length or radius).
     * @param size2 The second dimension of the shape (e.g., width for a rectangle).
     * @param color The color of the shape.
     * @return An object with the specified dimensions and color.
     */
    public abstract Shape createShape(int size1, int size2, Color color);
}
