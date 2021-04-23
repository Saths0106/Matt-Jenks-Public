package CIS210M.jenks.com;
/*Matthew Jenks
4.23.2021
getHired game to show employers what I know how to do.
Classes are set up to explicitly try to show a Java capability
I will update dates on classes as I write more code and update that class
otherwise dates are accurate for the specific day I wrote that code
Important to note too - I work full time and I'm a full time college student.
I am also doing this game without psuedocode or a flow chart, I just wanted to put something out there
Main updated to include JavaFX GUI, finally have a name for the game
Also shows use of lambda
*/


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application  {
    private Scene startScene, mainScene;

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // I'm learning JavaFX, never used this. I've used Jframe, but this is learning as I go right now
        primaryStage.setTitle("Luna's Realm");
        Button startButton = new Button();
        Label label1 = new Label("Welcome to Luna's Realm! Start by building your character");
        startButton.setText("WARRIOR");
        StackPane layout = new StackPane();
        TextField textBox = new TextField();
        textBox.setText("Please enter your username");
        layout.setAlignment(textBox, Pos.BOTTOM_CENTER);
        layout.setAlignment(label1, Pos.TOP_CENTER);
        layout.getChildren().addAll(label1, startButton, textBox);
        startScene = new Scene(layout, 500, 500);
        //these are examples of extremely helpful lambda (e->)
        startButton.addEventHandler(ActionEvent.ACTION, e -> primaryStage.setScene(mainScene)); //addEventHandler allows for multiple events
        startButton.addEventHandler(ActionEvent.ACTION , e -> { //need to update classes to move information to mainScene, not IDE console 
            try {
                new Gameplay(textBox.getText(), startButton.getText());

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        primaryStage.setScene(startScene);
        primaryStage.show();

        Button button2 = new Button();
        button2.setText("Second button");

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        mainScene = new Scene(layout2, 500, 500);

    }
}
