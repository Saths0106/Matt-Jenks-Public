#Matthew Jenks
#Text-based game
#Introduction to Scripting IT-140
# 2/20/21

rooms = { #lists rooms and movement directions for those rooms
    'Stables': {'West': 'Entrance'},
    'Entrance': {'South': 'Banquet Hall', 'East': 'Stables'},
    'Banquet Hall': {'North': 'Entrance', 'South': 'Servants Quarters', 'West': 'Kitchen', 'East': 'Study'},
    'Kitchen': {'East': 'Banquet Hall'},
    'Study': {'North': 'Library', 'West': 'Banquet Hall'},
    'Library': {'South': 'Study'},
    'Servants Quarters': {'North': 'Banquet Hall', 'East': 'Master Bedroom'},
    'Master Bedroom': {'West': 'Servants Quarters'}
}
itemsDict = { #lists the items that can be found in the rooms
    'Stables': 'Diamond Ring',
    'Entrance': 'Spear',
    'Banquet Hall': 'Broom',
    'Kitchen': 'Glasses',
    'Study': 'Knife',
    'Library': 'Pocketwatch',
    'Servants Quarters': 'Gold Coin',
    'Master Bedroom': 'Artifact'
}
inventory = [] #creates empty inventory
def addToIventory(location = 'Stables'): #function that adds to inventory
    inventory.append(itemsDict[location])

def getInventory(): #function that gets inventory
    return inventory

