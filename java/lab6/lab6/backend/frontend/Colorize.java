package lab6.lab6.backend.frontend;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lab6.lab6.backend.Shape;

public class Colorize {
    GridPane grid;
    Label fillColorLabel, borderColorLabel;
    ColorPicker fillColorPicker, borderColorPicker;
    Button addButton;

    public void start(Shape shape){
        Stage stage = new Stage();
        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(15);

        fillColorLabel = new Label("Fill Color");
        fillColorPicker = new ColorPicker();
        borderColorLabel = new Label("Border Color");
        borderColorPicker = new ColorPicker();
        grid.add(fillColorLabel, 0, 0);
        grid.add(fillColorPicker, 1, 0);
        grid.add(borderColorLabel, 0, 1);
        grid.add(borderColorPicker, 1, 1);

        addButton = new Button("Add Color");
        addButton.setOnAction(e -> {
            Color c = fillColorPicker.getValue();
            Color b = borderColorPicker.getValue();
            shape.setColor(b);
            shape.setFillColor(c);
            stage.close();
        });
        grid.add(addButton, 0, 2);
        Scene scene = new Scene(grid);
        scene.getStylesheets().add(getClass().getResource("window.css").toExternalForm());
        stage.setScene(scene);
        stage.showAndWait();
    }
}
