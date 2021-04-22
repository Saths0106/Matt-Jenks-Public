package CIS210M;

import java.io.*;
import java.util.*;

public class GCD {


    public void run() throws IOException {
        timer timed = new timer(); //timer for timing how long task takes
        timed.runtimer();
        compute result = new compute(); //initialize compute for later use
        File input = new File("C:\\Users\\saths\\IdeaProjects\\GCDuclidsmethod\\input.txt"); // create two input files
        File input2 = new File("C:\\Users\\saths\\IdeaProjects\\GCDuclidsmethod\\input2.txt");
        try (FileOutputStream inputContent = new FileOutputStream(input)) { //file outputstream and print writer allow us to write to files
            PrintWriter pw = new PrintWriter(inputContent);
            Random randomNumberContent = new Random(); //for random numbers
            HashMap<String, String> dict = new HashMap<String, String>(); //hashmaps are unordered which is what was asked for
            for (int y = 0; y <= 100000; y++) { //creates a hashmap with 100,000 entries
                int x = randomNumberContent.nextInt();
                dict.put(String.valueOf(y), String.valueOf(x)); //adds a y key and an x value to the dictionary
                if (y == 100000) { //prints dictionary to file once the dictionary has 100,000 entries
                    for (Map.Entry<String, String> m : dict.entrySet()) {
                        pw.format("%s%n", m.getKey() + " " + m.getValue()); // %s typecasts values to strings (maybe unnecessary here), %n creates a new line
                    }
                }
            }
        }
        catch (IOException e) { //catch the io exception
            e.printStackTrace();
        }
        try (FileOutputStream inputContent2 = new FileOutputStream(input2)) { //creating the second file output stream to make 500,000 entry input
            PrintWriter pw2 = new PrintWriter(inputContent2); //second printwriter for printing to second file
            Random randomNumberContent2 = new Random();
            HashMap<String, String> dict2 = new HashMap<String, String>();
            for (int y = 0; y <= 500000; y++) {
                int x = randomNumberContent2.nextInt();
                dict2.put(String.valueOf(y), String.valueOf(x)); //adds random number into hashmap next to y key
                if (y == 500000) {
                    for (Map.Entry<String, String> m : dict2.entrySet()) { //prints map to input file
                        pw2.format("%s%n", m.getKey() + " " + m.getValue());
                    }
                }
            }
        }
        catch (IOException e) { //catches the second exception from try
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedReader br2 = new BufferedReader(new FileReader(input2));
        String line;
        String[] arrayOfNumbers = new String[0]; //our input files are in key entry format - we need to seperate those numbers
        //sets up both files to be read
        File output = new File("C:\\Users\\saths\\IdeaProjects\\GCDuclidsmethod\\output.txt");
        FileOutputStream outputContent = new FileOutputStream(output);
        PrintWriter outpw = new PrintWriter(outputContent);
        File output2= new File("C:\\Users\\saths\\IdeaProjects\\GCDuclidsmethod\\output2.txt");
        FileOutputStream outputContent2 = new FileOutputStream(output2);
        PrintWriter outpw2 = new PrintWriter(outputContent2);
        //loops through the first file line by line splitting the values into two entries in an array
        while ((line = br.readLine()) != null) {
            arrayOfNumbers = line.split(" "); //splits at the space
            //after the program splits the values it runs those values through Euchlid's method for gcd and outputs all of the numbers
            outpw.format("%s%n", arrayOfNumbers[0] + " " + arrayOfNumbers[1] + " " + result.gcd(Integer.valueOf(arrayOfNumbers[0]) , Integer.valueOf(arrayOfNumbers[1])));
        //the array is then written over by the next line in the file until every line of the file has been read
        }
        while ((line = br2.readLine()) != null) { //same loop as above, with the larger file
            arrayOfNumbers = line.split(" ");
            //outputs to the second output file
            outpw2.format("%s%n", arrayOfNumbers[0] + " " + arrayOfNumbers[1] + " " + result.gcd(Integer.valueOf(arrayOfNumbers[0]) , Integer.valueOf(arrayOfNumbers[1])));
        }
        System.out.println("Seconds Passed " + timed.secondspast); //output how many seconds have passed
        timed.timer.cancel(); //cancel timer

    }
}