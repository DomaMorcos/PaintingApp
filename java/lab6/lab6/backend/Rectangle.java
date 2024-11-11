package lab6.lab6.backend;

import javafx.geometry.Point2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class Rectangle extends DrawableShape {
    public Rectangle(Point2D position, Color color, Color fillColor, Map<String, Double> properties,String name) {
        super(position, color, fillColor, properties,name);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        Double width = getProperties().get("width");
        Double height = getProperties().get("height");
        if (width != null && height != null) {
            int x = (int) getPosition().getX();
            int y = (int) getPosition().getY();
            int w = width.intValue();
            int h = height.intValue();
            graphicsContext.setFill(getFillColor());
            graphicsContext.fillRect(x, y, w, h);
            graphicsContext.setStroke(getColor());
            graphicsContext.strokeRect(x, y, w, h);
        }
    }
}