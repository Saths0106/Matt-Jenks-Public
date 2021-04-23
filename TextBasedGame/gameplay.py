#Matthew Jenks
#Text-based game
#Introduction to Scripting IT-140
# 2/20/21

import items_and_rooms
import ghosts
def gameplayInstructions():
    #prints instructions for the user
    print("Welcome to Night in a Haunted Mansion")
    print("This is a text based game where you will be provided options about the actions you can take.")
    print("You have been asked to retrieve an artifact from this mansion, however")
    print("the ghosts in this mansion are angry and searching for their missing possesions.")
    print("Some ghosts will help you after you help them, others will attack you if you approach them without the correct item.")
    print("When you find the last item a door may appear where there once was none! But Beware!")
    print("You only have three lives to get the artifact you were asked to retrieve")


def playerLife(life = 3): #function to print out life left
    print("Your character has", life, "life left")

def damageDealt(damage = 1, life = 3): #function for the player to take damage
    print("You have taken damage")
    health = life - damage
    return health


def movement(x = 'Stables'): #movement function
    print("You are in the", x)
    movement_options = items_and_rooms.rooms[x]
    if x == "Servants Quarters" : #removes the master bedroom from options if the player doesn't have the correct item
        if "Gold Coin" not in items_and_rooms.getInventory() :
            movement_options.popitem()
    print("Your movement options are", movement_options)
    moving = input("Please enter one of the movement options\n")
    moving = moving.title()
    while True: #asks for movement option until correct answer is given
        if moving == "North" or moving == "South" or moving == "West" or moving == "East":
            new_room = items_and_rooms.rooms[x][moving]
            break
        else:
            print("Your movement options are", movement_options)
            moving = input("That direction is not available. Please try typing one of the available options\n")
            moving = moving.title()
    return new_room

def interact(x = 'Stables', health = 3): #function that determines players interactions with ghosts
    current_ghost = ghosts.ghostsDict[x]
    print("You are approached by the" , current_ghost)
    if len(items_and_rooms.getInventory()) > 0: #this checks to see if the player has the right item
        iterate = 1
        for item in items_and_rooms.getInventory(): #loops through item list
            if item == ghosts.ghostsItems[current_ghost]: #checks if any of the items match the ghosts item
                print(ghosts.ghostsDialog2[current_ghost]) #since the item list is checked for duplicates this can only occur once
                if items_and_rooms.itemsDict[x] not in items_and_rooms.getInventory() : #checks the item list for duplicates
                    items_and_rooms.addToIventory(x) #adds item to itemslist
                    print(items_and_rooms.itemsDict[x], "has been added to your inventory") #informs player of the addition
                break #breaks loop
            if iterate == len(items_and_rooms.getInventory()): #if the item is not in the items list it prints original dialog
                print(ghosts.ghostsDialog[current_ghost])
                if current_ghost == 'Guard' or current_ghost == 'Chef' or current_ghost == 'Librarian': #if the player finds an angry ghost before getting their item, the ghost hurts them
                     health = damageDealt(1, health)
            iterate = iterate + 1
    else:
        print(ghosts.ghostsDialog[current_ghost]) #this works until player gets their first item. this function also gives the player than first item when they make it to the banquet hall
        if x == 'Banquet Hall':
            if 'Broom' not in items_and_rooms.getInventory() :
                print("Broom has been added to your inventory")
                items_and_rooms.addToIventory(x)

    return health







