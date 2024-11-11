package lab6.lab6.backend.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.StringConverter;
import lab6.lab6.backend.DrawingEngine;
import lab6.lab6.backend.Shape;


public class Paint extends Application {
    private DrawingEngineImplementation drawingEngine;
    private BorderPane root;
    private Scene scene;
    private HBox shapesBox, optionsBox;
    private ComboBox<Shape> selectionComboBox;
    private Canvas canvas;
    private GraphicsContext gc;
    private Pane canvasPane;
    private VBox vbox;
    private Button colorizeButton, deleteButton, circleButton, lineButton, squareButton, rectangleButton;

    @Override
    public void start(Stage stage) throws Exception {
        drawingEngine = new DrawingEngineImplementation();
        root = new BorderPane();
        shapesBox = new HBox();
        shapesBox.setId("shapesBox");
//        shapesBox.setSpacing(100);
//        shapesBox.setPadding(new Insets(10,10,10,500));
        optionsBox = new HBox();
        optionsBox.setId("optionsBox");
//        optionsBox.setSpacing(40);
//        optionsBox.setPadding(new Insets(350,10,10,20));
        vbox = new VBox();
        vbox.setId("Options");
        selectionComboBox = new ComboBox<>(drawingEngine.getShapes());

        vbox.getChildren().addAll(selectionComboBox, optionsBox);
        canvas = new Canvas(500, 250);
        canvasPane = new Pane();
        gc = canvas.getGraphicsContext2D();
        canvasPane.setId("canvasPane");
        canvasPane.getChildren().add(canvas);
        canvasPane.setMaxWidth(500);
        canvasPane.setMaxHeight(500);
        canvasPane.setStyle("-fx-background-color: Red");
        colorizeButton = new Button("Colorize");
        colorizeButton.setOnAction(e -> {
            try {
                Colorize colorize = new Colorize();
                colorize.start(selectionComboBox.getSelectionModel().getSelectedItem());
                drawingEngine.refresh(gc);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
                    Shape selectedShape = selectionComboBox.getSelectionModel().getSelectedItem();
                    drawingEngine.removeShape(selectedShape);
                    drawingEngine.refresh(gc);
                }

        );
        optionsBox.getChildren().addAll(colorizeButton, deleteButton);
        circleButton = new Button("Circle");
        circleButton.setOnAction(e -> {
            try {
                AddCircleWindow acw = new AddCircleWindow();
                acw.start();
                drawingEngine.refresh(gc);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        lineButton = new Button("Line");
        lineButton.setOnAction(e -> {
            try {
                AddLineWindow alw = new AddLineWindow();
                alw.start();
                drawingEngine.refresh(gc);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        squareButton = new Button("Square");
        squareButton.setOnAction(e -> {

            try {
                AddSquareWindow asw = new AddSquareWindow();
                asw.start();
                drawingEngine.refresh(gc);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        rectangleButton = new Button("Rectangle");
        rectangleButton.setOnAction(e -> {

            try {
                AddRectangleWindow arw = new AddRectangleWindow();
                arw.start();
                drawingEngine.refresh(gc);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        selectionComboBox.setConverter(new StringConverter<Shape>() {
            @Override
            public String toString(Shape shape) {
                return shape != null ? shape.getName() : "Shape";
            }

            @Override
            public Shape fromString(String string) {
                return null; // Implement as needed
            }
        });

        shapesBox.getChildren().addAll(vbox, circleButton, lineButton, squareButton, rectangleButton);
        root.setLeft(optionsBox);
        root.setTop(shapesBox);
        root.setCenter(canvasPane);
        scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Paint");
        scene.getStylesheets().add(getClass().getResource("Paint.css").toExternalForm());
        stage.show();
//        colorizeButton.setOnAction(e -> colorizeAction());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
