package lab6.lab6.backend;

import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public interface DrawingEngine {
    public void addShape(Shape shape);
    public void removeShape(Shape shape);
    public ObservableList<Shape> getShapes();
    public void refresh(GraphicsContext graphicsContext);
}
