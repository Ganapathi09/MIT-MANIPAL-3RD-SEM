package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main142 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Label languagesLabel = new Label("Languages:");

        CheckBox englishCheckbox = new CheckBox("English");
        CheckBox spanishCheckbox = new CheckBox("Spanish");
        CheckBox frenchCheckbox = new CheckBox("French");

        Button submitButton = new Button("Submit");

        Canvas canvas = new Canvas(400, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String age = ageField.getText();
            StringBuilder languages = new StringBuilder("Languages: ");
            if (englishCheckbox.isSelected()) {
                languages.append("English ");
            }
            if (spanishCheckbox.isSelected()) {
                languages.append("Spanish ");
            }
            if (frenchCheckbox.isSelected()) {
                languages.append("French ");
            }

            // Clear the canvas
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

            // Draw resume details on the canvas
            gc.fillText("Name: " + name, 50, 50);
            gc.fillText("Age: " + age, 50, 70);
            gc.fillText(languages.toString(), 50, 90);
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(nameLabel, nameField, ageLabel, ageField, languagesLabel, englishCheckbox,
                spanishCheckbox, frenchCheckbox, submitButton, canvas);

        Scene scene = new Scene(vbox, 400, 300);

        primaryStage.setTitle("Resume Builder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
