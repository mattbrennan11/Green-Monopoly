/**
 * 
 */
package saveplanet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * @author matthewbrennan
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String winner ="";
    	double max = -1;
        int playerNum = 0;
        int rollDice = 0;
        int turns = 10;

        SavePlanet sp = new SavePlanet();        
        Player2[] players;
        


       //Read in number of players from user and set
        do{
            System.out.println("How many players are playing? 2-4");
            playerNum = scanner.nextInt();
            scanner.nextLine();
        } while (playerNum < 2 || playerNum > 4);
        
        System.out.println();

        players = new Player2[playerNum];

    	//Read in user name and assign a random board piece
        for (int loop = 0; loop < playerNum; loop++){
            System.out.print("Enter player " + (loop + 1) + " name: ");
            
           
            	players[loop] = new Player2(scanner.nextLine(), sp.getAvailablePiece(), sp.getGo());
            

            System.out.println(players[loop].getName() + " is the " + players[loop].getPiece());
            System.out.println();
        }
        
        //loop through how many turns
        for (int loop = 0; loop < turns; loop++){
        	//loop through the players
            for (int loop2 = 0; loop2 < playerNum; loop2++){

            	
                    System.out.println(players[loop2].getName() + "'s turn");
                    System.out.println("------------------------");

                    //asks player if they would like to purchase
                    players[loop2].offerToBuyGreenHouse();
                    
                    
                    //dice roll - 2 dice
                    System.out.println("Roll:");
                    rollDice = random.nextInt(12) + 1;

					//move players piece on board depending on dice roll
                    sp.movePiece(players[loop2], rollDice);

                    System.out.println( "Dice roll = " + rollDice); 
                    
                    System.out.println("Gamepiece: " + players[loop2].getPiece());
                    System.out.println("Landed on: " + players[loop2].getSpot().getName());
                    System.out.println("Player Funds: £" + players[loop2].getFunds());
                    

                    //switchs on square - gives action depending on spot
                    switch(players[loop2].getSpot().getName()){

                    	//nothing - players funds updated in movePiece in SavePlanet
                        case "GO":
                            break;
         
                        //other squares - actions based on squareAction                          
                        default:
                             players[loop2].getSpot().squareAction(players[loop2]);
                             break;
                    }
                    
                    System.out.println(players[loop2].getName() + "'s funds after turn: " + players[loop2].getFunds());
                    System.out.println();
                }
            }         
        
        System.out.println("** Final player funds **");
        //prints out the funds that players have left after 10 turns
        for (int loop = 0; loop < players.length; loop++) {
        	
        	System.out.println(players[loop].getName() + ": £" + players[loop].getFunds());
        	
        }
        
        //prints out the winner based on which player has the most funds after 10 turns
        for (int loop = 0; loop < players.length; loop++) {
        	
        	
        	if(players[loop].getFunds() > max) {
        		max= players[loop].getFunds();
        		winner=players[loop].getName();
        	}
        	
        }
        
        System.out.println();
        System.out.println("Winner: " + winner);
        System.out.println("Funds: £" + max);
        
        
       
       
        

    	
	}

}
