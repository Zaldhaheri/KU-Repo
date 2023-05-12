#quiz

import random
import sys

guesses = 1
random_num = random.randint(1,50)
print("guess the number game!!!")
while guesses <= 5:
    n = int(input("Enter your guess: "))
    if (n == random_num):
        print("you found the correct number in %d guesses!!" %(guesses))
        sys.exit()
    elif(n > random_num):
        print("Too High")
    else:
        print("Too Low")
    guesses += 1

if guesses == 6:
    print("Sorry you lost, the number was %d" %(random_num))
    sys.exit()