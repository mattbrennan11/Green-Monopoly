/**
 * 
 */
package saveplanet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author matthewbrennan
 *
 */
public class SavePlanet {


	private final String READ_SQUARES = "board_squares.txt";
    private final String READ_PIECES = "board_pieces.txt";   
	private final double PASS_GO = 200.00;

	private Square go;
    private String[] gamePieces; 

    /**
     * Default Constructor
     */
	public SavePlanet(){
		this.go = null;
        this.gamePieces = new String[5];
		for (int loop = 0; loop < 5; loop++){
            this.gamePieces[loop] = " ";
		}
		readSquares();
        readPieces();
	}

	/**
	 * 
	 * @return go
	 */
	public Square getGo(){
		return this.go;
	}

	/**
	 * 
	 * @param go
	 */
	public void setGo(Square go){
		this.go = go;
	}

	/**
	 * reads board squares and creates a list
	 */
	public void readSquares(){
		try{
			Scanner scanner = new Scanner(new FileInputStream(READ_SQUARES));
			Square prev = null;
			int ref;

			while (scanner.hasNextLine()){
				String[] line = scanner.nextLine().split(",");
				ref = Integer.parseInt(line[0]);

				if (go == null){
					go = new Square(line[1], go);
					prev = go;          
				} else {
					switch (ref){
						//go square
						case 1:
							prev.setNext(new Square(line[1], go));
							prev = prev.getNext();
							break;
						//build squares
						case 2:
							prev.setNext(new BuildSquare(line[1], go,Double.parseDouble(line[3]),line[2], Double.parseDouble(line[4]),Double.parseDouble(line[5]),Double.parseDouble(line[6]),Double.parseDouble(line[7]),Double.parseDouble(line[8])));
							prev = prev.getNext();
							break;
							//nothing square
						case 3:
							prev.setNext(new Square(line[1], go));
							prev = prev.getNext();
							break;
					}
				}
			}

			scanner.close();

		} catch (FileNotFoundException e){
			System.out.println(e);
		}
	}

        
	/**
	 * 
	 * reads in game pieces from READ_PIECES txt file
	 */
    public void readPieces(){
		try{
			Scanner scanner = new Scanner(new FileInputStream(READ_PIECES));

			for (int loop = 0; loop < 5; loop++)
				gamePieces[loop] = scanner.nextLine();

			scanner.close();

		} catch (FileNotFoundException f){
			System.out.println("File does not exist...");
		}
	}
        
	/**
	 * goes through game pieces and gives player one that is free
	 * @return piece
	 */
	public String getAvailablePiece(){
		
        Random random = new Random();
        String piece;
        int num = 0;

        do {
            num = random.nextInt(5);
        } while (gamePieces[num].equals("null"));

        piece = gamePieces[num];
        gamePieces[num] = "null";

        return piece;
    }

	/* 
     * 	movePlayer(Player player, int roll)
	 * 	Moves the player across the board by updating their current location.
	 *  Determined by dice roll.
     */ 
	public void movePiece(Player2 player, int roll){
		Square currentSpot = player.getSpot();

		for (int loop = 0; loop < roll; loop++){
			currentSpot = currentSpot.getNext();

			if (currentSpot == go){
				player.addFunds(PASS_GO);
                System.out.println(player.getName() + "(" + player.getPiece() + ")" + " passed go.");
            }
		}
		player.setSpot(currentSpot);
	}
}
