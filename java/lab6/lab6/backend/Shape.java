package lab6.lab6.backend;


import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

import java.util.Map;

public interface Shape {
    public void setPosition(Point2D Position);
    public Point2D getPosition();
    public void setProperties(Map<String,Double> properties);
    public Map<String,Double> getProperties();
    public void setColor(Color color);
    public  Color getColor();
    public void setFillColor(Color color);
    public  Color getFillColor();
    public void draw(GraphicsContext graphicsContext);
    public String getName() ;

}
