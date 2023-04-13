sum = 0
ex = None
small = None
large = None
count = 0

while ex != "done":
    num = input("Enter float or 'done' to exit: ")
    if num != "done":
        num = float(num)
        count+=1
        sum+=num
        if small is None or num < small:
            small = num
        if large is None or num > large:
            large = num

    else:
        ex = num

print("Average is: ", sum/count)
print("Smallest number: ",small)
print("Largest number: ", large)
print("Range is: ", large-small)