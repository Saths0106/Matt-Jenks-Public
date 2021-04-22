#Matthew Jenks
#Devin Colwell
#computer science in action
#week 4 assignment

#changing the list to a dictionary then back to a list
#removes any duplicates because dictionaries can not have duplicate keys

courses = ['Math', 'Science', 'Physics', 'Math', 'English', 'Science', 'History','Math' , 'Physics']
for x in range(len(courses)):
    print courses[x]

nodupe = list(dict.fromkeys(courses))
print 
for y in range(len(nodupe)):
    print nodupe[y]
