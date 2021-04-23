package CIS210M.jenks.com;
/*Matthew Jenks
4.23.2021
getHired game to show employers what I know how to do.
Each class will attempt to show a specific area of Java
This class will run most of the code
Clean up code to work with GUI*/



import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gameplay {

    private static Character userPlayer;
    private List<String> movementOptions = new ArrayList<String>();
    private String location = "Town";


    //build a constructor to initialize the game. This constructor will be called once, and run most of the important functions of the game
    Gameplay(String userName, String className) throws IOException {
        userPlayer = new Character(userName, className);
        setMovementOptions(userPlayer.movementList);
        Inventory userInventory = new Inventory(); //constructor creates a list of lists for treasure, initializes user inventory
        /*this.location = movement();
        while(true) {
            if (location.equals("Town")) {
                System.out.println("Welcome to town");
                System.out.println("Would you like to buy or sell something?");
                //Town will allow the player to buy, sell, and craft treasure. Also intended to contain quests
                this.location = movement();
            } else if (location.equals("Adventure")) { //Adventure is where the player fights monsters. Currently only warrior type monsters are set up
                System.out.println("Be careful, the woods are full of monsters");
                Random rand = new Random();
                /* uses the second kind of constructor. I am allowed to put two same name constructors in one class
                as long as they have different parameters, which is called constructor overloading
                rand is set to get between 1 and 5 evil creatures for the player to fight, of the players level.
                This may need further balancing, I could see monster numbers getting out of hand
                 */
               /* Character evilCreature = new Character("Warrior", userPlayer.getLevel(), (rand.nextInt(4)+ 1));
                fight(userPlayer.getAttributes(), evilCreature.getAttributes(), userPlayer, evilCreature);
                userInventory.generateTreasure(evilCreature);
                if(!checkHealth(userPlayer)){
                    break;
                }
                this.location = movement();

            } else { //finally home, else is used as a bad user input safeguard. If the input is bad the player will simply go home
                //home allows the user to heal and levelup if they have the required experience. Experience will be gained from fights
                System.out.println("Welcome home");
                userPlayer.heal(5);
                if (userPlayer.getExperience() == 10) {
                    if (userPlayer.getLevel() <= 5) {
                        userPlayer.levelUp(2);
                    }
                }
                this.location = movement();
            }

        } */


    }


    public void setMovementOptions(List<String> movementOptions) {
        this.movementOptions = movementOptions; //This sets the movement options. They aren't really different for this game, but I might make changes later
    }

    public String movement() throws IOException { //movement function, movement options are contained in enum
        System.out.println("Where would you like to move to?");
        for(String element : movementOptions){ //for loops are quite easy with lists enumerators
            System.out.println(element);
        }
        BufferedReader userMovement = new BufferedReader(new InputStreamReader(System.in)); //personally prefer bufferedreader over scanner
        String userChoice = userMovement.readLine(); //I feel buffered reader has more functionality, and I have more experience with it
        // No loop/error message to ensure user picks one of the three choices because I intend to make an interface for this
        //That would move it beyond the command line, and make user playability easier. For now the default is the classes home
        if(movementOptions.contains(userChoice)){
            System.out.println("You have chosen to move to " + userChoice);
        }
        return userChoice;


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
        StackPane mainLayout = new StackPane();
        Text playerAttributes = new Text();
        playerAttributes.setText(userPlayer.getAttributesAsString());
        mainLayout.setAlignment(playerAttributes, Pos.TOP_LEFT);

        mainLayout.getChildren().addAll(playerAttributes);
        return(mainLayout);
      }
    }





