package lab6.lab6.backend;

import javafx.geometry.Point2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class Circle extends DrawableShape {
    public Circle(Point2D position, Color color, Color fillColor, Map<String, Double> properties,String name) {
        super(position, color, fillColor, properties,name);
    }




    @Override
    public void draw(GraphicsContext gc) {
        Double radius = getProperties().get("radius");
        if (radius != null) {
            int x = (int) (getPosition().getX() );
            int y = (int) (getPosition().getY() );
            int diameter = (int) (2 * radius);
            gc.setFill(getFillColor());
            gc.fillOval(x, y, diameter, diameter);
            gc.setStroke(getColor());
            gc.strokeOval(x, y, diameter, diameter);
        }
    }
}