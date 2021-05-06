package CIS210M.jenks.com;
/*Matthew Jenks
4.27.2021
getHired game to show employers what I know how to do.
Each class will attempt to show a specific area of Java
This class will run most of the code
Heavily updated code to work with GUI
We are getting there, I intend to finish this into a fully working text based game
*/



import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Gameplay {

    private static Character userPlayer;
    private List<String> movementOptions = new ArrayList<String>();
    private String location = "Town";
    private TextArea gamePlayField = new TextArea();
    private static StackPane mainLayout = new StackPane();
    private TextField userInput = new TextField();


    //build a constructor to initialize the game. This constructor will be called once, and run most of the important functions of the game
    Gameplay(String userName, String className) throws IOException {
        userPlayer = new Character(userName, className);
        setMovementOptions(userPlayer.movementList);
        gamePlayField.setEditable(false);
        gamePlayField.setStyle("-fx-padding: 100 10 50 10");
        userInput.setPrefColumnCount(15);
        mainLayout.setAlignment(userInput, Pos.BOTTOM_CENTER);
        mainLayout.getChildren().addAll(gamePlayField , userInput);
        Inventory userInventory = new Inventory(); //constructor creates a list of lists for treasure, initializes user inventory
        movement();
        /*while(true) {

            } else if (location.equals("Adventure")) { //Adventure is where the player fights monsters. Currently only warrior type monsters are set up
                System.out.println("Be careful, the woods are full of monsters");
                Random rand = new Random();
                /* uses the second kind of constructor. I am allowed to put two same name constructors in one class
                as long as they have different parameters, which is called constructor overloading
                rand is set to get between 1 and 5 evil creatures for the player to fight, of the players level.
                This may need further balancing, I could see monster numbers getting out of hand
                 */
                /*Character evilCreature = new Character("Warrior", userPlayer.getLevel(), (rand.nextInt(4)+ 1));
                fight(userPlayer.getAttributes(), evilCreature.getAttributes(), userPlayer, evilCreature);
                userInventory.generateTreasure(evilCreature);
                if(!checkHealth(userPlayer)){
                    break;
                }
                movement();

            } else { //finally home, else is used as a bad user input safeguard. If the input is bad the player will simply go home
                //home allows the user to heal and levelup if they have the required experience. Experience will be gained from fights
                System.out.println("Welcome home");
                userPlayer.heal(5);
                if (userPlayer.getExperience() == 10) {
                    if (userPlayer.getLevel() <= 5) {
                        userPlayer.levelUp(2);
                    }
                }
                movement();
            }

        } */


    }
    //press enter to change screens -- need to add that to user instructions. Also, using Lambda a lot more.
    public void locationEvents(String location){
        if (location.equals("Town")) {
            gamePlayField.setText("Welcome to town \r\n" + "Would you like to buy something?");
            //Town will allow the player to buy, sell, and craft treasure. Also intended to contain quests
            userInput.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode() == KeyCode.ENTER) {
                    movement();
                }
            });

        }
    }


    public void setMovementOptions(List<String> movementOptions) {
        this.movementOptions = movementOptions; //This sets the movement options. They aren't really different for this game, but I might make changes later
    }

    public void movement()  { //movement function, movement options are contained in enum
        gamePlayField.setText("Where would you like to move to?" +"\r\n" + movementOptions.get(0) + "\r\n" + movementOptions.get(1) + "\r\n" + movementOptions.get(2));
        userInput.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER){
                location = userInput.getText();
                locationEvents(location);
            }
        });
    }
    public void fight(List userAttributes, List creatureAttributes, Character userPlayer , Character evilCreature) {
        //this function simulates the fight. I made the monsters a bit strong, and wanted to add a random factor to the fight
        //so the player gets a random bonus every round
        //the intent is to eventually allow the player to choose an attribute to fight with but doing all is simpler for now
        Random rand = new Random();
        int userStrength = (int) userAttributes.get(0); //There is likely a better way to get attribute values. works for now
        int userAgility = (int) userAttributes.get(1);
        int userIntellect = (int) userAttributes.get(2);
        int creatureStrength = (int) creatureAttributes.get(0);
        int creatureAgility = (int) creatureAttributes.get(1);
        int creatureIntellect = (int) creatureAttributes.get(2);
        while (true) { //loop until creature or player is dead
            int x = rand.nextInt(5); //potentially gives the player a bonus, some creatures can be strong
            if ((userStrength + x) > creatureStrength) { //if and else if for every attribute, either you win or the creature does
                evilCreature.takeDamage(userStrength + x - creatureStrength);
                System.out.println("You have dealt " + (userStrength + x - creatureStrength) + " damage!");
                System.out.println("The creature has " + evilCreature.takeDamage(0) + " health left!");
                if(!checkHealth(userPlayer, evilCreature)){ //breaks the loop if someone dies
                    break;
                }
            } else if ((userStrength + x) < creatureStrength) {
                userPlayer.takeDamage(creatureStrength - userStrength - x);
                System.out.println("The creature has dealt " + (creatureStrength - userStrength - x) + " damage!");
                System.out.println("You have " + userPlayer.takeDamage(0) + "health left!");
                if(!checkHealth(userPlayer, evilCreature)){
                    break;
                }
            }
            if ((userIntellect + x) > creatureIntellect) {
                evilCreature.takeDamage(userIntellect + x - creatureIntellect);
                System.out.println("You have dealt " + (userIntellect + x - creatureIntellect) + " damage!");
                System.out.println("The creature has " + evilCreature.takeDamage(0) + " health left!");
                if(!checkHealth(userPlayer, evilCreature)){
                    break;
                }
            }
            else if ((userIntellect + x) < creatureIntellect) {
                userPlayer.takeDamage(creatureIntellect - userIntellect - x);
                System.out.println("The creature has dealt " + (creatureIntellect - userIntellect - x) + " damage!");
                System.out.println("You have " + userPlayer.takeDamage(0) + "health left!");
                if(!checkHealth(userPlayer, evilCreature)){
                    break;
                }
            }
            if ((userAgility + x) > creatureAgility) {
                evilCreature.takeDamage(userAgility + x - creatureAgility);
                System.out.println("You have dealt " + (userAgility + x - creatureAgility) + " damage!");
                System.out.println("The creature has " + evilCreature.takeDamage(0) + " health left!");
                if(!checkHealth(userPlayer, evilCreature)){
                    break;
                }
            }
            else if ((userAgility + x) < creatureAgility) {
                userPlayer.takeDamage(creatureAgility - userAgility - x);
                System.out.println("The creature has dealt " + (creatureAgility - userAgility - x) + " damage!");
                System.out.println("You have " + userPlayer.takeDamage(0) + "health left!");
                if(!checkHealth(userPlayer, evilCreature)){
                    break;
                }
            }
        }
    }
        public boolean checkHealth(Character userPlayer, Character evilCreature){
        /*this function was created to reduce the code above, since I needed a break every statement or the program would keep going
          even after someone died. This also provides a natural place to call treasure functions */
            if (evilCreature.takeDamage(0) < 1) { //take damage was not initially intended to return health values, but it made sense
                System.out.println("You have killed the creature");
                int experience = 0;
                for( Object entry : evilCreature.getAttributes()){ //provides user with experience based off creatures highest attribute
                    if(Integer.valueOf(String.valueOf(entry)) > experience){
                        experience = Integer.valueOf(String.valueOf(entry));
                    }
                }
                System.out.println("You have gained " + experience + " experience");
                userPlayer.gainExperience(experience);
                return false;
            } else if (userPlayer.takeDamage(0) < 1) {
                System.out.println("You have died");
                return false;
            }
            return true;
        }
        public boolean checkHealth(Character playerCharacter){ //method overloading, this one is specifically to check if the player is dead outside of fight
        if(playerCharacter.takeDamage(0) < 1) {
            return false;
        }
        return true;
        }
        public static StackPane populateSecondScreen() throws NullPointerException{
        Text playerAttributes = new Text();
        playerAttributes.setText(userPlayer.getAttributesAsString());
        mainLayout.setAlignment(playerAttributes, Pos.TOP_LEFT);
        mainLayout.getChildren().add(playerAttributes);
        return(mainLayout);
      }
    }





