package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main143 extends Application {

    private static final String MESSAGE = "Hello, JavaFX!"; // Message to be scrolled
    private static final int SCROLL_SPEED = 1; // Scroll speed in pixels

    @Override
    public void start(Stage primaryStage) {
        Text messageText = new Text(MESSAGE);
        ToggleGroup directionGroup = new ToggleGroup();

        RadioButton rightToLeftRadioButton = new RadioButton("Right to Left");
        RadioButton leftToRightRadioButton = new RadioButton("Left to Right");

        rightToLeftRadioButton.setToggleGroup(directionGroup);
        leftToRightRadioButton.setToggleGroup(directionGroup);

        rightToLeftRadioButton.setSelected(true); // Default direction is right to left

        HBox hbox = new HBox(10, rightToLeftRadioButton, leftToRightRadioButton);
        hbox.setTranslateY(10);

        Thread scrollThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10); // Delay for smooth scrolling
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (rightToLeftRadioButton.isSelected()) {
                    messageText.setTranslateX(messageText.getTranslateX() - SCROLL_SPEED);
                    if (messageText.getTranslateX() <= -messageText.getBoundsInLocal().getWidth()) {
                        messageText.setTranslateX(primaryStage.getWidth());
                    }
                } else if (leftToRightRadioButton.isSelected()) {
                    messageText.setTranslateX(messageText.getTranslateX() + SCROLL_SPEED);
                    if (messageText.getTranslateX() >= primaryStage.getWidth()) {
                        messageText.setTranslateX(-messageText.getBoundsInLocal().getWidth());
                    }
                }
            }
        });

        scrollThread.setDaemon(true); // Set the thread as daemon so it will terminate when the application exits
        scrollThread.start(); // Start the scrolling thread

        primaryStage.setScene(new Scene(new HBox(10, messageText, hbox), 400, 100));
        primaryStage.setTitle("Message Scrolling App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

