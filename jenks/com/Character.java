package CIS210M.jenks.com;
/*Matthew Jenks
4.21.2021
getHired game to show employers what I know how to do.
This one is intended to show multiple constructors as constructor overloading
and encapsulation*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.round;

public class Character {
    public List<String> movementList;
    private String name;
    private String characterClass;
    private int strength;
    private int agility;
    private int intellect;
    private int healthPoints;
    private int experience = 0;
    private int level = 1;
    Character() throws IOException { //this is the constructor for new user character
        //creates user character
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your name");
        this.name = userInput.readLine();
        System.out.println("Please pick a class from the options");
        for(Classes x : Classes.values()){ //for loop to print all the values of enum
            System.out.println(x);
        }
        while(true) { //while loops makes sure user enters correct information
            String input = userInput.readLine().toUpperCase(); //makes it easier, user just has to spell correctly
            if (input.equals("CLERIC") || input.equals("MAGE") || input.equals("WARRIOR")) {
                this.characterClass = input; //changes character class to user input
                String attributeString = Classes.returnValues(input); //gets information from enum about starting values for character
                List attributeList = Arrays.asList(attributeString.split(","));
                this.strength = Integer.parseInt((String) attributeList.get(0));
                this.agility= Integer.parseInt((String) attributeList.get(1));
                this.intellect = Integer.parseInt((String) attributeList.get(2));
                this.healthPoints = Integer.parseInt((String) attributeList.get(3));
                this.movementList = attributeList.subList(4, 7);
                System.out.println("Your name is " + name + " Your class is " + characterClass);
                System.out.println("And your attributes are as follows");
                System.out.println("Strength " + strength +  " Agility " + agility + " Intellect " +  intellect + " Health " + healthPoints);
                break;
            } else {
                System.out.println("Please enter a correct class");
            }
        }
    }
    Character(String type, int level, int amount){ //this constructor is used to create creatures to fight
        this.characterClass = type;
        String attributeString = Classes.returnValues(type);
        List attributeList = Arrays.asList(attributeString.split(","));
        //follows in the footsteps of the other constructor to get default enum values, but divides them and rounds for an attempt at balancing
        this.strength = round((Integer.parseInt((String) attributeList.get(0)) * level * amount)/3);
        this.agility= round((Integer.parseInt((String) attributeList.get(1)) * level * amount)/3);
        this.intellect = round((Integer.parseInt((String) attributeList.get(2)) * level * amount)/3);
        this.healthPoints = round((Integer.parseInt((String) attributeList.get(3)) * level * amount)/3);
    }
    public void levelUp(int increaseValue){
        //level up values for each class, I would prefer to change this to a user choice, but that is a little much for a command line game
       if(characterClass.equals("Warrior")){
           intellect += increaseValue/2;
           agility += increaseValue/2;
           strength += increaseValue;
           healthPoints += 2;
       }
       else{ //Cleric and mage both see the same value increase
           intellect += increaseValue;
           agility += increaseValue/2;
           strength += increaseValue/2;
           healthPoints += 2;
       }

    }
    public void gainExperience(int increaseValue){ //unused so far, grants the player experience after a monster kill
        this.experience += increaseValue;
    }
    public int getExperience(){ //returns amount of experience player has
        return experience;
    }
    public int getLevel(){ //returns level of player
        return level;
    }
    public List getAttributes(){ //gets player and monster attributes as a list
        return Arrays.asList(strength, agility, intellect);
    }
    public int takeDamage(int damage){ //changes hp when player or monster takes damage. Also works to get hp level back, if you send 0 as parameter
        healthPoints -= damage;
        return healthPoints;
    }
    public void heal( int healValue){ //heals the player to a max of full health
        healthPoints += healValue;
        if (healthPoints > (10 + 2 * (level - 1))) {
            healthPoints = (10 + 2* (level -1));
            System.out.println("Your healthpoints are full");
        }
        System.out.println("Your healthpoints are " + healthPoints);
    }

}
