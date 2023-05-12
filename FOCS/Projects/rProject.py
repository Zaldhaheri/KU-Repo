from class1 import class1
from class2 import class2
from class3 import class3
c1 = class1()
c2 = class2()
c3 = class3()

def main():
    while True:
        print("American converter:")
        print("1. feet to inches")
        print("2. yard to inches")
        print("3 yard to feet")
        print("4 furlong to inches")
        print("5 furlong to feet")
        print("6 furlong to yards")
        print("7 mile to inches")
        print("8 mile to feet")
        print("9 mile to yards")
        print("10 mile to furlong")
        num = input("Enter your choice or 0 to exit: ")

        if num == "1":
            feet = float(input("feet: "))
            c1.set_feet(feet)
            print("inches: ", c1.feet_to_inch())
        elif num == "2":
            yard = float(input("yard: "))
            c1.set_yard(yard)
            print("inch: ", c1.yard_to_inch())
        elif num == "3":
            yard = float(input("yard: "))
            c1.set_yard(yard)
            print("feet: ", c1.yard_to_feet())
        elif num == "4":
            furlong = float(input("furlong: "))
            c2.set_furlong(furlong)
            print("inch: ", c2.furlong_to_inch())
        elif num == "5":
            furlong = float(input("furlong: "))
            c2.set_furlong(furlong)
            print("feet: ", c2.furlong_to_feet())
        elif num == "6":
            furlong = float(input("furlong: "))
            c2.set_furlong(furlong)
            print("yard: ", c2.furlong_to_yard())
        elif num == "7":
            mile = float(input("mile: "))
            c3.set_mile(mile)
            print("inch: ",c3.mile_to_inch())
        elif num == "8":
            mile = float(input("mile: "))
            c3.set_mile(mile)
            print("feet: ",c3.mile_to_feet())
        elif num == "9":
            mile = float(input("mile: "))
            c3.set_mile(mile)
            print("yard: ",c3.mile_to_yard())
        elif num == "10":
            mile = float(input("mile: "))
            c3.set_mile(mile)
            print("furlong: ",c3.mile_to_furlong())
        elif num == "0":
            break
        else:
            print("invalid input")
        
main()

