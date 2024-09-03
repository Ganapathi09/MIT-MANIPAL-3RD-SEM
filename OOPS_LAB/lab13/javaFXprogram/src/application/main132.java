package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class main132 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating labels and text field
        Label inputLabel = new Label("Enter a number:");
        TextField numberField = new TextField();
        Label resultLabel = new Label();

        // Creating a FlowPane layout and setting hgap and vgap
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10); // Horizontal gap between nodes
        flowPane.setVgap(10); // Vertical gap between nodes
        flowPane.getChildren().addAll(inputLabel, numberField, resultLabel); // Adding nodes to the FlowPane

        // Handling user input and displaying multiplication table
        numberField.setOnAction(event -> {
            try {
                int number = Integer.parseInt(numberField.getText());
                StringBuilder table = new StringBuilder("Multiplication Table for " + number + ":\n");
                for (int i = 1; i <= 10; i++) {
                    table.append(number).append(" * ").append(i).append(" = ").append(number * i).append("\n");
                }
                resultLabel.setText(table.toString());
            } catch (NumberFormatException e) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            }
        });

        // Creating a Scene with FlowPane layout
        Scene scene = new Scene(flowPane, 300, 200);

        // Setting the Scene to the Stage
        primaryStage.setScene(scene);

        // Setting the title of the Stage
        primaryStage.setTitle("Multiplication Table Application");

        // Displaying the Stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
