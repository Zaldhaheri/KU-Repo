#To make the opponent pick random attacks
import random
#To better show the dialogue
import time
#starting introduction
print("=====================================================")
print("Welcome to the rock paper scissors championship!!")
print("You will have to battle 3 challengers to win!!")
print("")
print("Rule 1. pick R for Rock, P for Paper and, S for Scissors")
print("Rule 2. If you lose, you will be kicked out of the championship")
print("")
print("Let the championship begin!!!!!!!!")
print("=====================================================")
time.sleep(2)

#makes sure that its upper to avoid errors
def mUpper(s):
    return s.upper()

#writes what you and the opponent pickes
def dbattle(hit,ahit):
    if hit == "R" or hit == "P" or hit == "S":
        rpsDict = {"R": "Rock", "P": "Paper" , "S": "Scissors"}
        print("You picked " + rpsDict[hit] + " and they picked " + rpsDict[ahit] + "!")
        time.sleep(1)
    else:
        print("We do not tolerate rule breaking")
        print("*you left the championship with shame*")
        exit()
    

#battle, win and losing condition
def battle(h,a,n):
    b = ["R","P","S"]
    win = False
    #loop is for the draw condition
    while not win:
        dbattle(h,a)
        #draw condition
        if h==a:
            #for rockie (only rock)
            if n==1:
                print("DRAW! pick again")
                print("")
                h = mUpper(input("ROCK, PAPERS, SCISSORS SHOOT!: "))
                continue
            #for other opponents (random)
            elif n==2 or n==3:
                print("DRAW! pick again")
                print("")
                h = mUpper(input("ROCK, PAPERS, SCISSORS SHOOT!: "))
                a = b[random.randint(0,2)]
                continue
        #lose condition
        elif (h=="R" and a=="P")  or (h=="S" and a=="R") or (h=="P" and a=="S"):
            print("LOST! Try again later!")
            print("")
            return False
        #win condition
        elif (h=="R" and a=="S") or (h=="S" and a=="P") or (h=="P" and a=="R"):
            print("WIN! You will continue to the next round!")
            print("")
            return True

#1st opponent(only picks rock)
def rockie(hit,ahit,n):
    print("Battle 1!! VS. Rockie the heavyweight boxing champion")
    print("Rockie: Today is the day I rock your world!")
    print("")
    #makes user input into upper
    hit = mUpper(input("ROCK, PAPERS, SCISSORS SHOOT!: "))
    ahit = "R"
    #runs battle and returns true or false
    if battle(hit,ahit,n):
        print("Rockie: NOOOOOOOOOOOOOOOOOOOOOOOOOOOO!!!!")
        print("=====================================================")
        time.sleep(2)
    else:
        print("Rockie: You were nothing but a pebble in front of me")
        print("=====================================================")
        exit()
    
#2nd opponent(picks random)
def knight(hit,ahit,n):
    a = ["R","P","S"]
    print("battle %d !!! VS. The Mighty Knight of Light"%(n))
    time.sleep(1)
    print("Knight: Hark! This lowly peasant, a foe forsooth, ")
    time.sleep(1)
    print("Is naught but a mere babbler, weak and uncouth.")
    time.sleep(1)
    print("No match is he for me, the mighty knight,")
    time.sleep(1)
    print("Whose prowess doth shine in the glimmering light.")
    time.sleep(1)
    print("")
    hit = mUpper(input("ROCK, PAPERS, SCISSORS SHOOT!: "))
    #picks a random RPS from the list using random index
    ahit = a[random.randint(0,2)]
    #runs battle
    if battle(hit,ahit,n):
        print("Knight: Alack! This lowly peasant, whom I did scorn,")
        time.sleep(1)
        print("Hath proved himself a master, and I forlorn.")
        time.sleep(1)
        print("His humble guise did cloak his cunning art,")
        time.sleep(1)
        print("And with one fell swoop, he did break my heart.")
        print("=====================================================")
        time.sleep(2)
    else:
        print("Knight: Ha! This lowly peasant, whom I did thrash,")
        time.sleep(1)
        print("Hath proved himself no match for me, by gash!")
        time.sleep(1)
        print("My skill and might did shine in the fray,")
        time.sleep(1)
        print("And he did crumble, as I held my sway.")
        print("=====================================================")
        exit()

#3rd opponent(picks random)
def bob(hit,ahit,n):
    a = ["R","P","S"]
    print("battle %d!!! VS. Bob(just bob)"%(n))
    print("Bob: I am bob")
    print("")
    hit = mUpper(input("ROCK, PAPERS, SCISSORS SHOOT!: "))
    #picks first index for opponent hit
    ahit = a[random.randint(0,2)]
    if battle(hit,ahit,n):
        print("Bob: Bob lose :(")
        print("")
        print("You won the championship!!! your prize is the title of ROCK PAPER SCISSORS champion!!!")
        print("=====================================================")
    else:
        print("Bob: Bob win!! :)")
        print("=====================================================")
        exit()


a = ""
b = ""
#Calling functions
rockie(a,b,1)
knight(a,b,2)
bob(a,b,3)