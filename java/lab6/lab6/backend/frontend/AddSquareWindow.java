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
import lab6.lab6.backend.Rectangle;
import lab6.lab6.backend.Square;

import java.util.HashMap;
import java.util.Map;

public class AddSquareWindow {
    GridPane grid;
    Button addButton;
    Label sideLengthLabel, xCenterLabel, yCenterLabel, fillColorLabel, borderColorLabel;
    TextField sideLengthField, xCenterField, yCenterField;
    ColorPicker fillColorPicker, borderColorPicker;
    static int counter = 0 ;


    public void start() throws Exception {
        Stage stage = new Stage();
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(15);

        sideLengthLabel = new Label("Side Length");
        grid.add(sideLengthLabel, 0, 0);

        sideLengthField = new TextField();
        grid.add(sideLengthField, 1, 0);

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
            addSquare();
            stage.close();
        });
        grid.add(addButton, 1, 5);
        Scene scene = new Scene(grid, 500, 300);
        scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
        stage.setScene(scene);
        stage.showAndWait();


    }

    public void addSquare() {
        String sideLength = sideLengthField.getText();
        String xCenter = xCenterField.getText();
        String yCenter = yCenterField.getText();
        Color fillColor = fillColorPicker.getValue();
        Color borderColor = borderColorPicker.getValue();
        if (sideLength.isEmpty() || xCenter.isEmpty() || yCenter.isEmpty() || fillColor == null || borderColor == null) {
            AlertUtils.showErrorMessage("Empty fields", "Please fill all the Required Fields !");
        } else {
            double sideLengthDouble = Double.parseDouble(sideLength);

            double xCenterDouble = Double.parseDouble(xCenter);
            double yCenterDouble = Double.parseDouble(yCenter);
            String name = "Square " + String.valueOf(++counter);
            Point2D centerPoint = new Point2D(xCenterDouble, yCenterDouble);
            Map<String, Double> properties = new HashMap<>();
            properties.put("sideLength", sideLengthDouble);

            Square square = new Square(centerPoint, borderColor, fillColor, properties,name);
            DrawingEngineImplementation drawingEngineImplementation = new DrawingEngineImplementation();
            drawingEngineImplementation.addShape(square);
        }
    }

}
