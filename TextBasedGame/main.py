#Matthew Jenks
#Text-based game
#Introduction to Scripting IT-140
# 2/20/21
import gameplay # contains most of the functions
gameplay.gameplayInstructions() #tells user how to play
currentRoom = 'Stables' #user starts in stables and with three lives
life = 3
while True: #constant loop until win or loss
    gameplay.playerLife(life) #informs player of their life each move
    life = gameplay.interact(currentRoom, life) #keeps track of life easily this way, initiates room interactions
    if life == 0: #loss condition
        print("You have died")
        break
    if currentRoom == 'Master Bedroom': #win condition
        print("Congrats! You have won")
        break
    currentRoom = gameplay.movement(currentRoom)  #keeps the player moving





