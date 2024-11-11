package lab6.lab6.backend;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Map;

public abstract class DrawableShape implements Shape {
    private String name;
    private Point2D position;
    private Color color,fillColor;
    private Map<String,Double> properties;


    public DrawableShape(Point2D position, Color color,Color fillColor, Map<String,Double> properties,String name) {
        this.position = position;
        this.color = color;
        this.fillColor = fillColor;
        this.properties = properties;
        this.name = name;
    }
    public void setPosition(Point2D Position){
        this.position = Position;
    }
    public Point2D getPosition(){
        return position;
    }
    public void setProperties(Map<String,Double> properties){
        this.properties = properties;
    }
    public Map<String,Double> getProperties(){
        return properties;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }

    public void setFillColor(Color fillColor){
        this.fillColor = fillColor;
    }
    public Color getFillColor(){
        return fillColor;
    }

    public String getName() {
        return name;
    }

    public abstract void draw(GraphicsContext graphicsContext);
}
