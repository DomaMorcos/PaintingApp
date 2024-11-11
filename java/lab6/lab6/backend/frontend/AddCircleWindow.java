package lab6.lab6.backend.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import lab6.lab6.backend.Circle;

import java.util.HashMap;
import java.util.Map;

public class AddCircleWindow {
    GridPane grid;
    Button addButton;
    Label radiusLabel, xCenterLabel, yCenterLabel, fillColorLabel, borderColorLabel;
    TextField radiusField, xCenterField, yCenterField;
    ColorPicker fillColorPicker, borderColorPicker;
    static int counter = 0;


    public void start() throws Exception {
        Stage stage = new Stage();
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(15);


        radiusLabel = new Label("Radius");
        grid.add(radiusLabel, 0, 0);

        radiusField = new TextField();
        grid.add(radiusField, 1, 0);

        xCenterLabel = new Label("X");
        grid.add(xCenterLabel, 0, 1);

        xCenterField = new TextField();
        grid.add(xCenterField, 1, 1);


        yCenterLabel = new Label("Y");
        grid.add(yCenterLabel, 0, 2);
        yCenterField = new TextField();
        grid.add(yCenterField, 1, 2);


        fillColorLabel = new Label("Fill Color");
        grid.add(fillColorLabel, 0, 3);
        fillColorPicker = new ColorPicker();
        grid.add(fillColorPicker, 1, 3);

        borderColorLabel = new Label("Border Color");
        grid.add(borderColorLabel, 0, 4);
        borderColorPicker = new ColorPicker();
        grid.add(borderColorPicker, 1, 4);

        addButton = new Button("Add");
        addButton.setOnAction(e -> {
            addCircle();
            stage.close();
        });
            grid.add(addButton, 1, 5);
            Scene scene = new Scene(grid, 500, 300);
            scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
            stage.setScene(scene);
            stage.showAndWait();


        }
        public void addCircle () {
            String radius = radiusField.getText();
            String xCenter = xCenterField.getText();
            String yCenter = yCenterField.getText();
            Color fillColor = fillColorPicker.getValue();
            Color borderColor = borderColorPicker.getValue();

            if (radius.isEmpty() || xCenter.isEmpty() || yCenter.isEmpty() || fillColor == null || borderColor == null) {
                AlertUtils.showErrorMessage("Empty fields", "Please fill all the Required Fields !");
            } else {
                double radiusDouble = Double.parseDouble(radius);
                float xCenterFloat = Float.parseFloat(xCenter);
                float yCenterFloat = Float.parseFloat(yCenter);
                String name = "Circle " + String.valueOf(++counter);
                Point2D centerPoint = new Point2D(xCenterFloat, yCenterFloat);
                Map<String, Double> properties = new HashMap<>();
                properties.put("radius", radiusDouble);
                Circle circle = new Circle(centerPoint, borderColor, fillColor, properties,name);
                DrawingEngineImplementation drawingEngineImplementation = new DrawingEngineImplementation();
                drawingEngineImplementation.addShape(circle);

            }
        }

    }
