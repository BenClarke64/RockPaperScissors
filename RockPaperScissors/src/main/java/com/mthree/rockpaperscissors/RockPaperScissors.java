
package com.mthree.rockpaperscissors;

/**
 *
 * @author Ben
 */

import java.util.Scanner;
import java.util.Random;


public class RockPaperScissors {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int rounds =0, computer, player;
        int wins, draws, losses, result;
        String input = "";
        boolean validMove = false;
        
        
        System.out.println("Welcom to Rock Paper Scissors.");
        for(;;){
            wins = 0; losses = 0; draws = 0;
            System.out.println("How many rounds would you like to play? ");
            try{
                rounds = Integer.parseInt(scan.nextLine());
            }
            catch(NumberFormatException ex){
                System.out.println("That was not a whole number. You can only enter a whole number between 1 and 10!!!!");
            }
            if(rounds > 10){
                System.out.println("ERROR: Maximum of 10 rounds has been exceeded!!!");
                break;
            }
            else if(rounds < 1) {
                System.out.println("ERROR: Value entered is below the minimum of 1 round!!!");
                break;
            }
            
            for(int x = 0; x < rounds;x++){
                validMove = false;
                while(!validMove){
                    System.out.println("Rock, Paper, or Scissors?");
                    input = scan.nextLine();
                    if(!input.equals("Rock") && !input.equals("Paper") && !input.equals("Scissors")){
                        System.out.println("Please enter a valid move. "+input+" is not valid!");
                    }         
                    else validMove = true;
                }
                if(input.equals("Rock")){
                    player = 0;
                }
                else if(input.equals("Paper")){
                    player = 1;
                }
                else player = 2;//scissors
                
                computer = rand.nextInt(3);
                result = winner(player,computer);
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
            
            System.out.println("There were: "+draws+" ties, "+wins+" wins, and "+losses+" losses.");
            System.out.println("The winner is...");
            if(wins > losses){
                System.out.println("The Player.");
            }
            else if(losses > wins) System.out.println("The Computer.");
            else System.out.println("No one, its a tie.");
            validMove = false;
            while(!validMove){
                System.out.println("Would you like to play again? ");
                input = scan.nextLine();
                if(input.equals("yes") || input.equals("no")){
                    validMove = true;
                }
                else{
                    System.out.println("Invalid input, please answer with yes or no");
                }
            }
            if(input.equals("no")) break;
            
        }
        System.out.println("Thanks for playing");        
    }
    
    
    
    public static int winner (int player, int computer){
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
