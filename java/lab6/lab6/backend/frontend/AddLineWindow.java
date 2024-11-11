package lab6.lab6.backend.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lab6.lab6.backend.Line;

import java.util.HashMap;
import java.util.Map;

public class AddLineWindow {
    GridPane grid;
    Button addButton;
    Label startXLabel, startYLabel, endXLabel, endYLabel, fillColorLabel, borderColorLabel;
    TextField startXField, startYField, endXField, endYField;
    ColorPicker fillColorPicker, borderColorPicker;
    static int counter = 0;


    public void start() throws Exception {
        Stage stage = new Stage();
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(15);


        startXLabel = new Label("Starting X Position: ");
        grid.add(startXLabel, 0, 0);
        startXField = new TextField();
        grid.add(startXField, 1, 0);
        startYLabel = new Label("Starting Y Position: ");
        grid.add(startYLabel, 0, 1);
        startYField = new TextField();
        grid.add(startYField, 1, 1);
        endXLabel = new Label("Ending X Position: ");
        grid.add(endXLabel, 0, 2);
        endXField = new TextField();
        grid.add(endXField, 1, 2);
        endYLabel = new Label("Ending Y Position: ");
        grid.add(endYLabel, 0, 3);
        endYField = new TextField();
        grid.add(endYField, 1, 3);
        fillColorLabel = new Label("Fill Color: ");
        grid.add(fillColorLabel, 0, 4);
        fillColorPicker = new ColorPicker();
        grid.add(fillColorPicker, 1, 4);
        borderColorLabel = new Label("Border Color: ");
        grid.add(borderColorLabel, 0, 5);
        borderColorPicker = new ColorPicker();
        grid.add(borderColorPicker, 1, 5);


        addButton = new Button("Add");
        addButton.setOnAction(e -> {
            addLine();
            stage.close();
            });
        grid.add(addButton, 1, 6);
        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
        stage.setScene(scene);
        stage.showAndWait();


    }

    public void addLine() {
        String startX = startXField.getText();
        String startY = startYField.getText();
        String endX = endXField.getText();
        String endY = endYField.getText();
        Color fillColor = fillColorPicker.getValue();
        Color borderColor = borderColorPicker.getValue();

        if (startX.isEmpty() || startY.isEmpty() || endX.isEmpty() || endY.isEmpty() || fillColor == null || borderColor == null) {
            AlertUtils.showErrorMessage("Empty fields", "Please fill all the Required Fields !");

        } else {
            double startXDouble = Double.parseDouble(startX);
            double startYDouble = Double.parseDouble(startY);
            double endXDouble = Double.parseDouble(endX);
            double endYDouble = Double.parseDouble(endY);
            Point2D centerPoint = new Point2D((startXDouble + endXDouble) / 2, (startYDouble + endYDouble) / 2);
            Map<String, Double> properties = new HashMap<>();
            properties.put("startX", startXDouble);
            properties.put("startY", startYDouble);
            properties.put("endX", endXDouble);
            properties.put("endY", endYDouble);
            String name = "Line " + String.valueOf(++counter);
            Line line = new Line(centerPoint, borderColor, fillColor, properties,name);
            DrawingEngineImplementation drawingEngineImplementation = new DrawingEngineImplementation();
            drawingEngineImplementation.addShape(line);
        }
    }

}
