def main () :
    X = int( input (" Enter an integer : ") )
    if X % 2 == 1: # If X is odd
        X = 3 * X + 1
    else : # If X is even
        X = X // 2
    print ("New value of X:", X )
if __name__ == "__main__":
    main()