def convertTemp(temp, unit, size):
    for i in range(size):
        valid = False
        while not valid:
            if unit[i].upper() != 'C' and unit[i].upper() != 'F':
                valid = False
                print("invalid input")
                t = int(input(f"Enter temperature {i + 1}: "))
                u = input(f"Enter unit for temperature {i + 1} (F or C)")
                temp[i] = t
                unit[i] = u.upper()
            else:
                valid = True
    conv_temp = []
    conv_letter = []
    for i in range(size):
        if unit[i].upper() == 'F':
            conv_temp.append((temp[i] - 32) * (5 / 9))
            conv_letter.append('C')
        else:
            conv_temp.append(temp[i] * (9 / 5) + 32)
            conv_letter.append('F')
    return conv_temp, conv_letter

def main():
    temp = []
    letter = []
    print("5 inputs.")
    size = 5
    for j in range(size):
        temp.append(int(input("Enter a number: ")))
        letter.append(input("Enter a letter (F or C): "))
    newT, newU = convertTemp(temp, letter, size)
    for i in range(size):
        print(f"temp[{i + 1}]: {newT[i]}")
        print(f"unit[{i + 1}]: {newU[i]}")
if __name__ == "__main__":
    main ()
