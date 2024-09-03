package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class main131 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Creating a Label with the specified text
        Label label = new Label("Welcome to JavaFX programming");

        // Setting text color to Magenta
        label.setTextFill(Color.MAGENTA);

        // Creating a FlowPane layout and setting hgap and vgap
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10); // Horizontal gap between nodes
        flowPane.setVgap(10); // Vertical gap between nodes
        flowPane.getChildren().add(label); // Adding the label to the FlowPane

        // Creating a Scene with FlowPane layout, width, and height
        Scene scene = new Scene(flowPane, 500, 200);

        // Setting the Scene to the Stage
        primaryStage.setScene(scene);

        // Setting the title of the Stage
        primaryStage.setTitle("This is the first JavaFX Application");

        // Displaying the Stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
