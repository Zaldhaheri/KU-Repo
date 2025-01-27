def calculate_cost ( distance ) :
    if distance >= 0 and distance < 100:
        return 5
    elif distance >= 100 and distance < 500:
        return 8
    elif distance >= 500 and distance < 1000:
        return 10
    elif distance >= 1000:
        return 12
    else :
        return None # Invalid input
def main () :
    distance = float ( input (" Enter the distance (in km):") )
    cost = calculate_cost ( distance )
    if cost is not None :
        print ( f"The cost for { distance } km is { cost } Dhs.")
    else :
        print (" Invalid input . Please enter a positive distance .")
if __name__ == "__main__":
    main ()