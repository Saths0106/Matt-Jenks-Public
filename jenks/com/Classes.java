package CIS210M.jenks.com;
/*Matthew Jenks
4.21.2021
getHired game to show employers what I know how to do.
this module is made to show how to use enum */
public enum Classes {
    WARRIOR("5,3,1,10,Guild,Town,Adventure"),
    MAGE("1,2,5,10,Tower,Town,Adventure"),
    CLERIC("3,2,4,10,Church,Town,Adventure");
    private String attributeValues;


    Classes(String attributeValues) { this.attributeValues = attributeValues; }
    //enum constructor that returns values based off player choice, defaults to warrior on bad user input
    public static String returnValues(String s){
        if(s.equals("CLERIC")){
            return Classes.CLERIC.attributeValues;
        }
        else if(s.equals("Mage")){
            return Classes.MAGE.attributeValues;
        }
        else{
            return Classes.WARRIOR.attributeValues;
        }
    }
}
