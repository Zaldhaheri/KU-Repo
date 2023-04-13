num = int(input("Enter a number to find common factors: "))


while num>1:
    for i in range(2,101):
        if num%i==0:
            num = num/i
            print(i)
            break