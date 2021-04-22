#Matthew Jenks
#Devin Colwell
#computer science in action
#week 6 assignment

def printTable():
    tableData = [['apples', 'oranges', 'cherries', 'banana'],
             ['Alice', 'Bob', 'Carol', 'David'],
             ['dogs', 'cats', 'moose', 'goose']]
    for entry in tableData:
        print(' '.join(entry))
