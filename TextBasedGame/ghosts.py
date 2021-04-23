#Matthew Jenks
#Text-based game
#Introduction to Scripting IT-140
# 2/20/21
ghostsDict = { #important dictionary, assigns ghost to room
    'Stables': 'Stable Boy',
    'Entrance': 'Butler',
    'Banquet Hall': 'Servers',
    'Kitchen': 'Chef',
    'Study': 'The Lady',
    'Library': 'Librarian',
    'Servants Quarters': 'Guard',
    'Master Bedroom': 'The Lord'
}
ghostsDialog = { #assigns dialog to ghosts
    'Stable Boy': 'I am the ghost of the stables and I am looking for my broom, can you help me find it?',
    'Butler': 'I will permit you to look around the mansion as long as you find my pocketwatch',
    'Servers': 'Would you like some food?',
    'Chef': 'Unless you have my knife, I have nothing for you. Leave this place',
    'The Lady': 'Have you seen my diamond ring anywhere? My husband probably sold it',
    'Librarian': 'I cannot permit you to enter the library until I find my glasses',
    'Guard': 'The Lord allows none to pass by these quarters',
    'The Lord': 'I see the guard has let you pass, you must be the one sent to free us. The artifact is in the corner'
}
ghostsItems = { #lists what items the ghosts want
    'Stable Boy': 'Broom',
    'Butler': 'Pocketwatch',
    'Servers': 'Nothing',
    'Chef': 'Knife',
    'The Lady': 'Diamond Ring',
    'Librarian': 'Glasses',
    'Guard': 'Spear',
    'The Lord': 'Gold Coin'
}
ghostsDialog2 = { #assigns new dialog to ghosts after finding their items
    'Stable Boy': 'Thank you for finding my broom! I found this ring you can have',
    'Butler': 'It is said that if the guard will let you pass the Lord will hand over the artifact',
    'Chef': 'Thanks for your help',
    'The Lady': 'I am surprised you found it, and in the stables of all places',
    'Librarian': 'Thank you! I can finally read again. Feel free to enjoy the library, but stay quiet',
    'Guard': 'You have surprised me. You may pass',
    'The Lord': 'I see the guard has let you pass, you must be the one sent to free us. The artifact is in the corner'
}