package lab6.lab6.backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

import java.util.Map;

public class Line extends DrawableShape {
    public Line(Point2D position, Color color, Color fillColor, Map<String, Double> properties,String name) {
        super(position, color, fillColor, properties,name);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        Double startX = getProperties().get("startX");
        Double startY = getProperties().get("startY");
        Double endX = getProperties().get("endX");
        Double endY = getProperties().get("endY");
        if (startX != null && startY != null && endX != null && endY != null) {
            graphicsContext.setStroke(getColor());
            graphicsContext.strokeLine(startX.intValue(), startY.intValue(), endX.intValue(), endY.intValue());
        }
    }
}