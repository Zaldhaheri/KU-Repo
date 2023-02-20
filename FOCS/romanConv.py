num = int(input("Enter any number to convert into roman numerals: "))
conv = ""


if num >= 1000:
    while num >= 1000:
        conv += "M"
        num -= 1000

if num >= 900:
    conv += "CM"
    num -= 900

if num >= 500:
    conv += "D"
    num-=500
    
if num >= 400:
    conv += "CD"
    num -= 400

if num >= 100:
    while num >= 100:
        conv += "C"
        num -= 100
    
if num >= 90:
    conv += "XC"
    num-=90
    
if num >= 50:
    conv += "L"
    num -= 50
    
if num >= 40:
    conv += "XL"
    num -= 40
    
if num >= 10:
    while num >= 10:
        conv += "X"
        num-= 10
    
if num >= 9:
    conv += "IX"
    num -= 9

if num >= 5:
    conv +="V"
    num -=5
    
if num >= 4:
    conv += "IV"
    num -= 4
    
if num >= 1:
    while num >=1:
        conv += "I"
        num -= 1
    
print(conv)