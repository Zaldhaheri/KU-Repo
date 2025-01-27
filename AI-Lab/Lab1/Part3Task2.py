def main () :
    # Part a: Sum of numbers from 1 to 100
    sum_numbers = 0
    for num in range (1 , 101) :
        sum_numbers += num
        # Part b: Sum of odd numbers from 1 to 100
    sum_odd_numbers = 0
    for num in range (1 , 101) :
        if num % 2 != 0:
            sum_odd_numbers += num
    # Part c: Sum of multiples of 5 from 1 to 100
    sum_multiples_of_5 = 0
    for num in range (1 , 101) :
        if num % 5 == 0:
            sum_multiples_of_5 += num
    # Print the results
    print ("Sum of numbers from 1 to 100: ", sum_numbers )
    print ("Sum of odd numbers from 1 to 100: ", sum_odd_numbers )
    print ("Sum of multiples of 5 from 1 to 100: ",sum_multiples_of_5 )
if __name__ == "__main__":
    main ()
