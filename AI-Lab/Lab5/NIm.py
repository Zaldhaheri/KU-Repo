import matplotlib.pyplot as plt

def print_piles(piles):
    print("Current piles:")
    for i, pile in enumerate(piles):
        print(f"Pile {i + 1}: {pile}")
    plot_piles(piles)

def plot_piles(piles):
    plt.figure(figsize=(8, 4))
    plt.bar(range(1, len(piles) + 1), piles)
    plt.xlabel('Pile')
    plt.ylabel('Size')
    plt.title('Nim Game')
    plt.show()

def get_valid_move(piles):
    while True:
        try:
            pile_index = int(input("Enter pile number: ")) - 1
            if pile_index < 0 or pile_index >= len(piles):
                raise ValueError
            if piles[pile_index] == 0:
                raise ValueError("Chosen pile is empty. Choose another.")
            break
        except (ValueError, IndexError) as e:
            print("Invalid input. Please enter a valid pile number.")
            print_piles(piles)
    return pile_index

def nim():
    piles = [3, 4, 5]  # You can adjust the initial number of items in each pile here
    player_turn = True

    print("Welcome to Nim!")
    print_piles(piles)

    while sum(piles) > 0:
        if player_turn:
            print("\nYour turn.")
            pile_index = get_valid_move(piles)
        else:
            print("\nComputer's turn.")
            # Implement a basic strategy (XOR the piles)
            pile_index = next(i for i, pile in enumerate(piles) if pile ^ max(piles) < pile)
            print(f"Computer chooses pile {pile_index + 1}.")

        piles[pile_index] -= 1
        print_piles(piles)
        player_turn = not player_turn

    if player_turn:
        print("\nCongratulations! You win!")
    else:
        print("\nComputer wins! Better luck next time.")

nim()
