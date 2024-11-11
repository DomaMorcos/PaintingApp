package lab6.lab6.backend;

import javafx.geometry.Point2D;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Map;

public class Square extends DrawableShape {
    public Square(Point2D position, Color color, Color fillColor, Map<String, Double> properties,String name) {
        super(position, color, fillColor, properties,name);
    }
    @Override
    public void draw(GraphicsContext graphicsContext) {
        Double sideLength = getProperties().get("sideLength");
        if (sideLength != null) {
            int x = (int) getPosition().getX();
            int y = (int) getPosition().getY();
            int l =  sideLength.intValue();
            graphicsContext.setFill(getFillColor());
            graphicsContext.fillRect(x,y,l,l);
            graphicsContext.setStroke(getColor());
            graphicsContext.strokeRect(x,y,l,l);

        }
    }
}
