/*
 * TheZoo.cpp
 *
 *  Created on: Dec 13, 2020
 *      Author: Matthew Jenks
 */
#include <iostream>
#include <iterator>
#include <algorithm>
#include <jni.h>
#include <vector>
#include <fstream>
using namespace std;

void GenerateData()               //DO NOT TOUCH CODE IN THIS METHOD
{
     JavaVM *jvm;                      // Pointer to the JVM (Java Virtual Machine)
     JNIEnv *env;                      // Pointer to native interface
                                                              //================== prepare loading of Java VM ============================
     JavaVMInitArgs vm_args;                        // Initialization arguments
     JavaVMOption* options = new JavaVMOption[1];   // JVM invocation options
     options[0].optionString = (char*) "-Djava.class.path=";   // where to find java .class
     vm_args.version = JNI_VERSION_1_6;             // minimum Java version
     vm_args.nOptions = 1;                          // number of options
     vm_args.options = options;
     vm_args.ignoreUnrecognized = false;     // invalid options make the JVM init fail
                                                                          //=============== load and initialize Java VM and JNI interface =============
     jint rc = JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);  // YES !!
     delete options;    // we then no longer need the initialisation options.
     if (rc != JNI_OK) {
            // TO DO: error processing...
            cin.get();
            exit(EXIT_FAILURE);
     }
     //=============== Display JVM version =======================================
     cout << "JVM load succeeded: Version ";
     jint ver = env->GetVersion();
     cout << ((ver >> 16) & 0x0f) << "." << (ver & 0x0f) << endl;

     jclass cls2 = env->FindClass("ZooFileWriter");  // try to find the class
     if (cls2 == nullptr) {
            cerr << "ERROR: class not found !";
     }
     else {                                  // if class found, continue
            cout << "Class MyTest found" << endl;
            jmethodID mid = env->GetStaticMethodID(cls2, "createZooFile", "()V");  // find method
            if (mid == nullptr)
                   cerr << "ERROR: method void createZooFile() not found !" << endl;
            else {
                   env->CallStaticVoidMethod(cls2, mid);                      // call method
                   cout << endl;
            }
     }


     jvm->DestroyJavaVM();
     cin.get();
}

vector<string> AddAnimal(vector<string> userVector) //Add animal to vector function
{
	string userInput;
	string animalTrack;
	string animalName;
	string animalType;
	string animalSubType;
	string animalEggs;
	string animalNursing;
	cin.ignore(); //this code is similar to the java code we started with, and will turn anything into a string. no need for try/catch
		 cout << "Track Number: " << endl;
		 getline(cin, animalTrack);
		 cout << "Enter Animal Name: " << endl;
		 getline(cin, animalName);
		 cout << "Enter Animal Type: " << endl;
		 getline(cin, animalType);
		 cout << "Enter Animal Sub-type: " << endl;
		 getline(cin, animalSubType);
		 cout << "Enter Number of Eggs: " << endl;
		 getline(cin, animalEggs);
		 cout << "Enter 1 if Nursing, 0 if not: " << endl;
		 getline(cin, animalNursing);
		 cout << "Please press 1 to confirm the addition or anything to cancel" << endl;
		 userInput = cin.get(); //if the user confirms pressing 1, animal is added. Otherwise animal is not
		 if(userInput ==  "1"){ //pushback adds the entries to the vector in order
			 userVector.push_back(animalTrack);
			 userVector.push_back(animalName);
			 userVector.push_back(animalType);
			 userVector.push_back(animalSubType);
			 userVector.push_back(animalEggs);
			 userVector.push_back(animalNursing);
			 return userVector; //returns changed vector
		 }
		 else{
			 return userVector; //returns original vector
		 }
}


vector<string> RemoveAnimal(vector<string> userVector, string trackNumber)
{
	string userInput;
 for(int i = 0; i < userVector.size(); i ++){ //not the best code, but it works. iterator would have been better, but this did work.
	 if(userVector.at(i) == trackNumber){
		 cout << "Please press 1 to confirm the deletion or anything to cancel"; //asks for confirmation
		 userInput = cin.get();
		 if(userInput == "1"){
			 for(int x = i; x < i + 6; x ++){
				 userVector.erase(userVector.begin() + x); //erases the chosen animal
			 }
			 return userVector; //returns changed vector
		 }
		 else{
			 return userVector; //returns unchanged vector
		 }
	 }

 }
 return userVector;
 }

vector<string> LoadDataFromFile()
{
     ifstream myFile("zoodata.txt"); //simple code that loads information from file and turns it into a vector
     istream_iterator<string> open(myFile), end;
     vector<string> zooFile(open, end);

return zooFile;

}

void SaveDataToFile(vector<string> currentFile)
{
	ofstream myFile("zoodata.txt"); //takes information from vector and adds it to file
	 int i = 0;
		  for (auto it = currentFile.begin(); it != currentFile.end(); ++it){ //this is a better example of how a vector for loop should look.
		         myFile << *it << " ";
		         i ++;
		         if(i == 6){ //makes a new line every entry
		        	 myFile << endl;
		        	 i = 0;
		         }

	        }
	myFile.close(); //closes the file when done
}

void DisplayMenu()
{
	string userInput;
	vector<string> currentFile; // stores the current vector
	bool loop = true; //works for the loop, allows the user to
	//press 7 to exit the loop but doesn't change the programs function if the user presses something else
	while(loop){
   cout << "Welcome to WildLife Zoo's user menu" << endl; //menu options
   cout << "Select an option below" << endl;
   cout << "1: Load animal data" << endl;
   cout << "2: Generate a file" << endl;
   cout << "3: Display animal data" << endl;
   cout << "4: Add record" << endl;
   cout << "5: Delete record" << endl;
   cout << "6: Save animal data" <<endl;
   cout << "7: Exit" << endl;

   userInput = cin.get();

   if(userInput == "1"){
	   currentFile = LoadDataFromFile(); //loads file data into vector

   }
   else if(userInput == "2"){
   	   GenerateData(); //points to initial java code
      }
   else if(userInput == "3"){
	   int i = 0;
	  for (auto it = currentFile.begin(); it != currentFile.end(); ++it){ //iterates the vector to console output
	         cout << *it << " ";
	         i ++;
	         if(i == 6){ //adds a new line every entry
	        	 cout << endl;
	        	 i = 0;
	         }

        }
	  	  cout << endl;
	  	   cin.ignore();
	  	   cin.get(); //pauses the output so the user can view it before moving on
   }
   else if(userInput == "4"){
currentFile = AddAnimal(currentFile); //adds animal entry to vector
        }
   else if(userInput == "5"){
	   cin.ignore();
	   cout << "What is the animals track number?" << endl;
	   getline(cin, userInput);
	   currentFile = RemoveAnimal(currentFile, userInput); //removes animal based off of track number

        }
   else if(userInput == "6"){
	   SaveDataToFile(currentFile); //saves the data to zoodata.txt

        }
   else if(userInput == "7"){
	   loop = false; //closes the program

          }

	}
}



int main()
{
	DisplayMenu(); //starts the program
	return 1;
}
