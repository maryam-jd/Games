import random
def get_choices():
    player_choice=input("Enter your choice(rock, paper, scissor): ")
    options=["rock","paper","scissor"]#list for options
    computer_choice=random.choice(options)#computer will choose randomly
    choices={"player":player_choice,"computer":computer_choice}#dictionary
    return choices

def check_win(player, computer):
    print("You chose "+player)#concatenation
    print("Computer chose "+computer)#concatenation
    #another way to concatenate is f string
    #age=25
    #print(f"Your age is {age}")
    if player == computer:
        return "It's a tie"
    elif player=="rock":
        if computer=="scissors":
            return "Rock smashes scissors. You win!"
        else:
            return"Paper covers rock. You lose."

    elif player=="scissors":
        if computer=="rock":
            return "Rock breaks scissor.You lose."
        else:
            return "Scissors cuts paper. You win!"

    elif player=="paper":
        if computer=="rock":
            return"Paper covers rock.You win!"
        else:
            return"Scissors cuts paper. You lose."



choices=get_choices()
result=check_win(choices["player"],choices["computer"])
print(result)
