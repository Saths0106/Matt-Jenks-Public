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
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application  {

    private Button startButton;
    private Scene startScene;
    private Scene mainScene;

    public static void main(String[] args) throws IOException {
        launch(args);
	//new Gameplay();


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Luna's Realm");
        startButton = new Button();
        startButton.setText("Start");
        StackPane layout = new StackPane();
        layout.getChildren().add(startButton);
        startScene = new Scene(layout, 500, 500);
        startButton.setOnAction(e -> {
            try {
                new Gameplay();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        primaryStage.setScene(startScene);
        primaryStage.show();


    }
}
