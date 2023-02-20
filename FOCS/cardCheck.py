s = input("Enter the card notation: ")

tap = s[-1]
pos = s[:-1]
number = True

if tap=="S":
    tap = "Spades"
elif tap=="C":
    tap = "Clubs"
elif tap=="D":
    tap = "Diamonds"
elif tap=="H":
    tap = "Hearts"
else:
    print("this card type doesnt exist")
    number = False
    
if pos == "A":
    pos = "Ace"
elif pos == "J":
    pos = "Jack"    
elif pos == "Q":
    pos = "Queen"    
elif pos == "K":
    pos = "King"    
else:
    num = int(pos)
    if num>10 and num<2:
        number = False

if number:
    print("%s of %s"%(pos,tap))
else:
    print("you entered a wrong number")