package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main133 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating labels, text fields, password field, button, and text control
        Label userLabel = new Label("UserName:");
        TextField userTextField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button signInButton = new Button("Sign in");
        Text welcomeText = new Text();

        // Creating a GridPane layout and setting padding, hgap, and vgap
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));
        gridPane.setHgap(10); // Horizontal gap between nodes
        gridPane.setVgap(10); // Vertical gap between nodes

        // Adding nodes to the GridPane
        gridPane.add(userLabel, 0, 0);
        gridPane.add(userTextField, 1, 0);
        gridPane.add(passwordLabel, 0, 1);
        gridPane.add(passwordField, 1, 1);
        gridPane.add(signInButton, 1, 2);
        gridPane.add(welcomeText, 1, 3);

        // Handling button click event to display welcome message
        signInButton.setOnAction(event -> {
            String userName = userTextField.getText();
            welcomeText.setText("Welcome " + userName);
        });

        // Creating a Scene with GridPane layout
        Scene scene = new Scene(gridPane, 300, 200);

        // Setting the Scene to the Stage
        primaryStage.setScene(scene);

        // Setting the title of the Stage
        primaryStage.setTitle("Login Application");

        // Displaying the Stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
