package CIS210M.jenks.com;
/*Matthew Jenks
4.22.2021
getHired game to show employers what I know how to do.
This is the child of Treasure. Used to show explicit inheritance
Also used to show multidimensional lists, although I chose to add a map in the middle
I have a list of maps that are maps of lists.
several functions are still null, and the treasure is still unusable. needs much more work
*/

import java.util.*;


public class Inventory extends Treasure {
    private List treasure = new ArrayList(); //private list treasure
    private int gold = 0;


    @Override
    public List generateTreasure(Character evilCreature) { //This function generates treasure based off of creature level/luck
        Random randomNumber = new Random();
        Map itemList;
        List generatedItem = new ArrayList();
        List items = new ArrayList();
        items.add("Sword"); items.add("Shield"); items.add("Libram"); items.add("Light Armor"); items.add("Heavy Armor"); items.add("Cloth Armor");
        String item = (String) items.get(randomNumber.nextInt(6));
        generatedItem.add(item);
        int rarity = randomNumber.nextInt(9) + 1;
        if(rarity >= 10 - evilCreature.getLevel()){ //legendary rarity is more likely to drop the higher level creatures are
            itemList = (Map) treasure.get(4); //treasure is a list of maps, had to add it to maps
            generatedItem.add(itemList.get(item)); //itemlist is now a map of lists, best to add it a list to return
        }
        else if(rarity >= 9 - evilCreature.getLevel()){
            itemList = (Map) treasure.get(3);
            generatedItem.add(itemList.get(item));
        }
        else if(rarity >= 8 - evilCreature.getLevel()){
            itemList = (Map) treasure.get(2);
            generatedItem.add(itemList.get(item));
        }
        else if(rarity >= 7 - evilCreature.getLevel()){
            itemList = (Map) treasure.get(1);
            generatedItem.add(itemList.get(item));
        }
        else{
            itemList = (Map) treasure.get(0);
            generatedItem.add(itemList.get(item));
        }
        return generatedItem; //returns item in list format, name first then stats
    }
       Inventory() { //List linked to hashmap which links to lists. I think I overdid the linked lists a little, but it works
        //once treasure is initiated this is a private list that can not be changed, so I can continue to grab items from it no problem
        Map common = new HashMap();
        Map uncommon = new HashMap();
        Map rare = new HashMap();
        Map epic = new HashMap();
        Map legendary = new HashMap();
        List sword = new ArrayList();
        List shield = new ArrayList();
        List libram = new ArrayList();
        List clothArmor = new ArrayList();
        List lightArmor = new ArrayList();
        List heavyArmor = new ArrayList();
        sword.add(3); sword.add(0); sword.add(0);
        shield.add(2); shield.add(1); shield.add(0);
        libram.add(0); libram.add(0); libram.add(3);
        clothArmor.add(0); clothArmor.add(0); clothArmor.add(3);
        lightArmor.add(1); lightArmor.add(2); lightArmor.add(0);
        heavyArmor.add(2); heavyArmor.add(1); heavyArmor.add(0);
        common.put("Sword", sword); common.put("Shield", shield);common.put("Libram", libram);
        common.put("Cloth Armor", clothArmor); common.put("Light Armor", lightArmor); common.put("Heavy Armor", heavyArmor);
        for(Object key : common.keySet()){
            uncommon.put(String.valueOf(key), incrementList((List) common.get(key), 1));
            rare.put(String.valueOf(key), incrementList((List) common.get(key), 2));
            epic.put(String.valueOf(key), incrementList((List) common.get(key), 3));
            legendary.put(String.valueOf(key), incrementList((List) common.get(key), 4));

        }
        treasure.add(common);
        treasure.add(uncommon);
        treasure.add(rare);
        treasure.add(epic);
        treasure.add(legendary);
    }

    @Override
    public String sellTreasure() {
        return null;
    }

    @Override
    public String buyTreasure() {
        return null;
    }

    @Override
    public String pickUpLoot() {
        return null;
    }

    @Override
    public String craftTreasure() {
        return null;
    }

    @Override
    public String salvageTreasure() {
        return null;
    }
    public List incrementList(List listToIncrease, int increase){ //I found this would be very helpful for the way I decided to create my item lists;
        List increasedList = new ArrayList(); //needs to send back a new list each time, that way it doesn't modify current list
        increasedList.addAll(listToIncrease); //list needs to be the same size as input list
        for(int i = 0; i < listToIncrease.size(); i ++){
            int oldVal = (int) listToIncrease.get(i);
            int newVal = oldVal + increase;
            increasedList.set(i, newVal);
        }
        return increasedList;
    }
}
