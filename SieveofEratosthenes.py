"""
Matthew Jenks
12/12/2019
Computer Science in Action 1
Upgrade of Assignment week 2
changed from finding if one int is prime to finding all of the prime numbers
between two ints
I chose this one because I felt I could incorporate a lot of what we've learned
into this algorithm
"""
import sys

def SieveofEratosthenes(user):
#asks for user input and converts that input to an integer
    primeArray = [True for number in range(user +1)]
    x = 2
    while(x * x <= user):
        if(primeArray[x] == True):
            for number in range(x *2, user + 1, x):
                primeArray[number] = False
        x += 1
    primeArray[0] = False
    primeArray[1] = False
    y = 1
    for x in range(user + 1):
        if primeArray[x]:
            if(y == 11):
                sys.stdout.write("\n")
                y = 0
            else:
                sys.stdout.write(x)
                sys.stdout.write(" ")
            y+=1        


print("The Sieve of Eratosthenes is a simple ancient algorithm that finds all of the")
print("prime numbers between 2 and any given number")
user = int(input("Please input the number you wish to check \n"))
SieveofEratosthenes(user)
