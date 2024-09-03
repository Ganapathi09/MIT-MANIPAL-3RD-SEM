package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GCDApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating labels, text fields, button, and label for displaying result
        Label number1Label = new Label("Enter the first positive integer:");
        TextField number1TextField = new TextField();
        Label number2Label = new Label("Enter the second positive integer:");
        TextField number2TextField = new TextField();
        Button calculateButton = new Button("Calculate GCD");
        Label resultLabel = new Label();

        // Handling button click event to calculate GCD and display the result
        calculateButton.setOnAction(event -> {
            try {
                int number1 = Integer.parseInt(number1TextField.getText());
                int number2 = Integer.parseInt(number2TextField.getText());

                // Calculate GCD using Euclidean algorithm
                int gcd = calculateGCD(number1, number2);
                resultLabel.setText("Numbers: " + number1 + ", " + number2 + "\nGCD: " + gcd);
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter positive integers.");
            }
        });

        // Creating a VBox layout and adding nodes to it
        VBox vbox = new VBox(10); // Vertical gap between nodes
        vbox.getChildren().addAll(number1Label, number1TextField, number2Label, number2TextField, calculateButton, resultLabel);
        vbox.setPadding(new javafx.geometry.Insets(10, 10, 10, 10)); // Setting padding

        // Creating a Scene with VBox layout
        Scene scene = new Scene(vbox, 300, 200);

        // Setting the Scene to the Stage
        primaryStage.setScene(scene);

        // Setting the title of the Stage
        primaryStage.setTitle("GCD Calculator");

        // Displaying the Stage
        primaryStage.show();
    }

    // Method to calculate GCD using Euclidean algorithm
    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
