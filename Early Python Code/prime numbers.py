#Matthew Jenks
#9/8/2019
#Computer Science in Action 1
# assignment week two, prime numbers using range

user = int(input("Please enter a number to check if it is prime \n"))
#asks for user input and converts that input to an integer
for i in range( 2, user):
    if user % i == 0:
#these last two lines divide user by each number between 2 and user to see if
# any divide evenly. If they do the number is not prime        
        print(str(user) + " is not a prime number")
        break
else:
    print(str(user) + " is a prime number")
        
