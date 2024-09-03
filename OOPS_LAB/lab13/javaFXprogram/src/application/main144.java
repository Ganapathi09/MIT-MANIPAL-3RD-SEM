package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main144 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label diameterLabel = new Label("Enter Diameter:");
        TextField diameterTextField = new TextField();
        diameterTextField.setPrefWidth(60);

        ListView<String> optionsListView = new ListView<>(FXCollections.observableArrayList("Area", "Radius", "Diameter", "Circumference"));
        optionsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Button calculateButton = new Button("Calculate");
        Canvas canvas = new Canvas(200, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        calculateButton.setOnAction(event -> {
            try {
                double diameter = Double.parseDouble(diameterTextField.getText());
                double radius = diameter / 2;
                double area = Math.PI * radius * radius;
                double circumference = 2 * Math.PI * radius;

                String selectedOption = optionsListView.getSelectionModel().getSelectedItem();
                String result = "";

                if ("Area".equals(selectedOption)) {
                    result = "Area: " + area;
                } else if ("Radius".equals(selectedOption)) {
                    result = "Radius: " + radius;
                } else if ("Diameter".equals(selectedOption)) {
                    result = "Diameter: " + diameter;
                } else if ("Circumference".equals(selectedOption)) {
                    result = "Circumference: " + circumference;
                }

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.fillText("Circle", canvas.getWidth() / 2 - 20, canvas.getHeight() / 2);
                gc.strokeOval(50, 50, diameter, diameter);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Result");
                alert.setHeaderText(null);
                alert.setContentText(result);
                alert.showAndWait();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input. Please enter a valid number.");
                alert.showAndWait();
            }
        });

        VBox vbox = new VBox(10, diameterLabel, diameterTextField, new HBox(10, optionsListView, calculateButton), canvas);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinWidth(300);
        vbox.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Circle Information");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

