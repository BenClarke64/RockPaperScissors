
package com.mthree.rockpaperscissors;

/**
 * 13/07/2020
 * @author Ben
 */

import java.util.Scanner;
import java.util.Random;


public class RockPaperScissors {

    
    public static void main(String[] args) {
        
        //variable init
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int rounds =0, computer, player;
        int wins, draws, losses, result;
        String input = "";
        boolean validMove = false;
        
        
        System.out.println("Welcom to Rock Paper Scissors.");
        for(;;){//only exit the loop with a break;
            wins = 0; losses = 0; draws = 0;
            System.out.println("How many rounds would you like to play? ");
            try{
                rounds = Integer.parseInt(scan.nextLine());//waits for player input and converts that input into an integer
            }
            catch(NumberFormatException ex){//catches an input that can not be made into an int. eg letters ro symbols
                System.out.println("That was not a whole number. You can only enter a whole number between 1 and 10!!!!");
            }
            if(rounds > 10){//check to see if the player inputted a number that is between 1 and 10
                System.out.println("ERROR: Maximum of 10 rounds has been exceeded!!!");
                break;
            }
            else if(rounds < 1) {
                System.out.println("ERROR: Value entered is below the minimum of 1 round!!!");
                break;
            }
            
            for(int x = 0; x < rounds;x++){//will loop for the amount of rounds the player input
                validMove = false;
                while(!validMove){//ensures that the player inputs the correct string without exiting the program
                    System.out.println("Rock, Paper, or Scissors?");
                    input = scan.nextLine();
                    //ensure that the player has input rock paper or scissors
                    if(!input.equals("Rock") && !input.equals("Paper") && !input.equals("Scissors") && !input.equals("rock") && !input.equals("paper") && !input.equals("scissors")){
                        System.out.println("Please enter a valid move. "+input+" is not valid!");
                    }         
                    else validMove = true;//this will exit the loop
                }
                
                //turn the player input into an int value that corresponds to a move. 0 = rock, 1 = paper, 2 = scissors
                if(input.equals("Rock") || input.equals("rock")){
                    player = 0;
                }
                else if(input.equals("Paper") || input.equals("paper")){
                    player = 1;
                }
                else player = 2;//scissors
                
                computer = rand.nextInt(3);//computer chooses a random number between 0 and 2
                result = winner(player,computer);                
                
                //add the result to the corresponding action
                if(result == 0){
                    draws++;
                    System.out.println("tie");
                }
                else if(result == 1){
                    losses++;
                    System.out.println("computer win");
                }
                else{
                    wins++;
                    System.out.println("player win");
                }
            }
            
            //print the number of ties wins and losses
            System.out.println("There were: "+draws+" ties, "+wins+" wins, and "+losses+" losses.");
            System.out.println("The winner is...");
            //print who the winner is depending on the number of wins and losses
            if(wins > losses){
                System.out.println("The Player.");
            }
            else if(losses > wins) System.out.println("The Computer.");
            else System.out.println("No one, its a tie.");
            validMove = false;
            while(!validMove){//check to make sure the player inputs correctly
                System.out.println("Would you like to play again? ");
                input = scan.nextLine();
                if(input.equals("yes") || input.equals("no")){
                    validMove = true;//exit the loop, input was valid
                }
                else{
                    System.out.println("Invalid input, please answer with yes or no");
                }
            }
            if(input.equals("no")) break;//if the user doesnt want to play again then exit the infinite for loop
            
        }
        System.out.println("Thanks for playing");        
    }
    
    
    
    public static int winner (int player, int computer){
        //return 0 for a draw, 1 for a computer win and 2 for a player win
        if(player == computer){
            return 0;
        }
        else if(player == 0){
            if(computer == 1) return 1;
            else return 2;
        }
        else if(player == 1){
            if(computer == 2) return 1;
            else return 2;
        }
        else{
            if(computer == 0) return 1;
            else return 2;
        }
    }
    
}
