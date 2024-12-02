package bcit.MyGame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;

/**
 * A factory class for creating Circle objects.
 * Inherits from the ShapeFactory class.
 * @author Evan Vink
 * @version 1.0
 */
public class CircleFactory extends ShapeFactory {

    /**
     * Constant value for the circumference of the circle.
     */
    private final static int CIRCLE_CIRCUMFERENCE = 50;

    /**
     * Creates a Circle shape with the specified size and color.
     *
     * @param size1 The x-coordinate of the circle's center.
     * @param size2 The y-coordinate of the circle's center.
     * @param color The color of the circle.
     * @return A Circle object with the given parameters.
     */
    @Override
    public Shape createShape(int size1, int size2, Color color) {
        return new Circle(size1, size2, CIRCLE_CIRCUMFERENCE, color);
    }
}
