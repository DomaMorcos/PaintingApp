package lab6.lab6.backend.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lab6.lab6.backend.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class AddRectangleWindow {
    GridPane grid;
    Button addButton;
    Label widthLabel, heightLabel, xCenterLabel, yCenterLabel, fillColorLabel, borderColorLabel;
    TextField widthField, heightField, xCenterField, yCenterField;
    ColorPicker fillColorPicker, borderColorPicker;
    static int counter = 0;

    public void start() throws Exception {
        Stage stage = new Stage();
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(15);
        grid.setVgap(15);


        widthLabel = new Label("Width");
        grid.add(widthLabel, 0, 0);

        widthField = new TextField();
        grid.add(widthField, 1, 0);

        heightLabel = new Label("Height");
        grid.add(heightLabel, 0, 1);
        heightField = new TextField();
        grid.add(heightField, 1, 1);

        xCenterLabel = new Label("X");
        grid.add(xCenterLabel, 0, 2);

        xCenterField = new TextField();
        grid.add(xCenterField, 1, 2);


        yCenterLabel = new Label("Y");
        grid.add(yCenterLabel, 0, 3);
        yCenterField = new TextField();
        grid.add(yCenterField, 1, 3);


        fillColorLabel = new Label("Fill Color");
        grid.add(fillColorLabel, 0, 4);
        fillColorPicker = new ColorPicker();
        grid.add(fillColorPicker, 1, 4);

        borderColorLabel = new Label("Border Color");
        grid.add(borderColorLabel, 0, 5);
        borderColorPicker = new ColorPicker();
        grid.add(borderColorPicker, 1, 5);

        addButton = new Button("Add");
        addButton.setOnAction(e -> {
            addRectangle();
            stage.close();
        });
        grid.add(addButton, 1, 6);
        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
        stage.setScene(scene);
        stage.showAndWait();

    }

    public void addRectangle() {
        String width = widthField.getText();
        String height = heightField.getText();
        String xCenter = xCenterField.getText();
        String yCenter = yCenterField.getText();
        Color fillColor = fillColorPicker.getValue();
        Color borderColor = borderColorPicker.getValue();

        if (width.isEmpty() || height.isEmpty() || xCenter.isEmpty() || yCenter.isEmpty() || fillColor == null || borderColor == null) {
            AlertUtils.showErrorMessage("Empty fields", "Please fill all the Required Fields !");

        } else {
            double widthDouble = Double.parseDouble(width);
            double heightDouble = Double.parseDouble(height);
            double xCenterDouble = Double.parseDouble(xCenter);
            double yCenterDouble = Double.parseDouble(yCenter);

            Point2D centerPoint = new Point2D(xCenterDouble, yCenterDouble);
            Map<String, Double> properties = new HashMap<>();
            properties.put("width", widthDouble);
            properties.put("height", heightDouble);
            String name = "Rectangle " + String.valueOf(++counter);
            Rectangle rectangle = new Rectangle(centerPoint, borderColor, fillColor, properties,name);
            DrawingEngineImplementation drawingEngineImplementation = new DrawingEngineImplementation();
            drawingEngineImplementation.addShape(rectangle);
        }
    }

}
