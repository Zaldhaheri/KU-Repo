def main () :
    print (" Enter 5 numbers :")
    count_even = 0
    count_odd = 0
    min_num = float ("inf ")
    max_num = float ("-inf ")
    i = 1
    while i <= 5:
        num = float ( input ( f" Number {i}: ") )
        if num % 2 == 0:
            count_even += 1
        else :
            count_odd += 1
        min_num = min ( min_num , num )
        max_num = max ( max_num , num )
        i += 1
    print ("\ nResults :")
    print (f" Number of even numbers : { count_even }")
    print (f" Number of odd numbers : { count_odd }")
    print (f" Minimum number : { min_num }")
    print (f" Maximum number : { max_num }")
if __name__ == "__main__":
    main ()