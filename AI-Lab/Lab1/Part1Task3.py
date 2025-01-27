def main () :
    # Get input values from the user
    variable1 = int( input (" Enter the value for Variable 1: ") )
    variable2 = int( input (" Enter the value for Variable 2: ") )
    # Swap the contents of the variables
    variable1 , variable2 = variable2 , variable1
    # Print the swapped values
    print ("Swapped Values :")
    print ("variable1 =", variable1 )
    print ("variable2 =", variable2 )
if __name__ == "__main__":
    main()