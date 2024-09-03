package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main141 extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField number1TextField = new TextField();
        TextField number2TextField = new TextField();
        Label resultLabel = new Label();

        Button computeButton = new Button("Compute");
        computeButton.setOnAction(event -> {
            try {
                double number1 = Double.parseDouble(number1TextField.getText());
                double number2 = Double.parseDouble(number2TextField.getText());

                double sum = number1 + number2;
                double product = number1 * number2;
                double difference = number1 - number2;
                double quotient = number1 / number2;

                resultLabel.setText("Sum: " + sum + "\nProduct: " + product +
                        "\nDifference: " + difference + "\nQuotient: " + quotient);

                // Draw calculator image on the canvas
                drawCalculatorImage(primaryStage);
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter valid numbers.");
            }
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(number1TextField, number2TextField, computeButton, resultLabel);

        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setTitle("Calculator App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawCalculatorImage(Stage primaryStage) {
        Canvas canvas = new Canvas(150, 150);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Image calculatorImage = new Image("calculator.png");

        gc.drawImage(calculatorImage, 0, 0, 150, 150);

        VBox vbox = (VBox) primaryStage.getScene().getRoot();
        vbox.getChildren().add(canvas);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
