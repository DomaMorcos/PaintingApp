package lab6.lab6.backend.frontend;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import lab6.lab6.backend.DrawingEngine;
import lab6.lab6.backend.Shape;

public class DrawingEngineImplementation implements DrawingEngine {
    private static ObservableList<Shape> shapes = FXCollections.observableArrayList();
    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public ObservableList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void refresh(GraphicsContext graphicsContext) {
        graphicsContext.clearRect(0, 0, graphicsContext.getCanvas().getWidth(), graphicsContext.getCanvas().getHeight());
        for(Shape shape : shapes) {
           shape.draw(graphicsContext);
        }
    }
}
