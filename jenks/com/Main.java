package CIS210M.jenks.com;
/*Matthew Jenks
4.27.2021
getHired game to show employers what I know how to do.
Classes are set up to explicitly try to show a Java capability
I will update dates on classes as I write more code and update that class
otherwise dates are accurate for the specific day I wrote that code
Important to note too - I work full time and I'm a full time college student.
I am also doing this game without psuedocode or a flow chart, I just wanted to put something out there
My apologies, I have been busy
*/


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
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
        ListView listView = new ListView();
        listView.setMaxWidth(100);
        listView.setMaxHeight(75);
        listView.getItems().addAll("WARRIOR", "MAGE", "CLERIC");
        Label label1 = new Label("Welcome to Luna's Realm! Start by building your character");
        StackPane layout = new StackPane();
        TextField textBox = new TextField();
        textBox.setText("Please enter your username");
        layout.setAlignment(textBox, Pos.BOTTOM_CENTER);
        layout.setAlignment(label1, Pos.TOP_CENTER);
        layout.getChildren().addAll(label1, listView, textBox);
        startScene = new Scene(layout, 500, 500);
        //this is an example of extremely helpful lambda
        listView.setOnMouseClicked(e -> { //need to update classes to move information to mainScene, not IDE console
            try {
                new Gameplay(textBox.getText(), (String) listView.getSelectionModel().getSelectedItem());
                mainScene = new Scene(Gameplay.populateSecondScreen(), 500, 500);
                primaryStage.setScene(mainScene);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        primaryStage.setScene(startScene);
        primaryStage.show();


    }
}
