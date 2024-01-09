/**
 * 
 */
package saveplanet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author matthewbrennan
 *
 */
public class Player2 {

	final double PLAYER_FUNDS = 2000.00;

    private String name;
    private String piece;
    private Square spot;
	private double funds;
	
    private List<BuildSquare> collections = new ArrayList<>();
  

    /**
     * Default Constructor
     */
	public Player2(){
        
	}

    /**
     * Constructor with parameters
     * @param name
     * @param piece
     * @param spot
     */
	public Player2(String name, String piece, Square spot){
        setName(name);
		this.funds = PLAYER_FUNDS;
		this.piece = piece;
		this.spot = spot;
	}

	/**
	 * 
	 * @return name
	 */
    public String getName(){
        return this.name;
    }
    
    /**
     * 
     * @param name
     * throws illegal argument exception if name is too short or blank
     */
    public void setName(String name) throws IllegalArgumentException{
    	if (name.length() > 0) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Name too short - must be longer than 0");
		}
    	
    	if (name.isBlank()) {
    		throw new IllegalArgumentException("Name blank...");
    	}
    
    }

    /**
     * 
     * @return funds
     */
	public double getFunds(){
		return this.funds;
	}
	
	 /**
     * 
     * @param funds
     */
	public void addFunds(double cash){
		this.funds = this.funds + cash;
	}

	/**
	 * 
	 * @param funds
	 */
	public void removeFunds(double cash){
		this.funds = this.funds - cash;
	}


	/**
	 * 
	 * @return piece
	 */
    public String getPiece(){
        return this.piece;
    }
    
    /**
	 * 
	 * @param piece
	 */
	public void setPiece(String piece){
		this.piece = piece;
	}

    /**
     * 
     * @return spot
     */
    public Square getSpot(){
        return this.spot;
    }
    
    /**
	 * 
	 * @param spot
	 */
	public void setSpot(Square spot){
		this.spot = spot;
	}
	
	 /**
     * adds a players purchased greenhouse to their collection
     * @param purchase
     */
    public void addCollection(BuildSquare purchase){
        this.collections.add(purchase);
    }
    
    public int getCollection() {
    	
        return this.collections.size();
    }
    
   /**
    * loops through players
    * if player owns a square then they can buy a greenhouse
    * if player decides to buy then the collection is updated
    */
    public void offerToBuyGreenHouse(){
    	
        Scanner scanner = new Scanner(System.in);

        if (!collections.isEmpty()){
            for (BuildSquare collection : collections){
            	System.out.println("** Option to buy **");
                System.out.println("You own " + collection.getName());
                System.out.println("Do you want to purchase a greenhouse for " + collection.getName() + "? Y or N");
                                    
                char decision = scanner.next().charAt(0);

                if (decision == 'y' || decision == 'Y'){
                    collection.addGreenHouse(this);
                    System.out.println("This collection now has " + collection.getNumGreenHouses() + " greenhouse.");
                }
                
                System.out.println();
               
            }        
        }
        
    }

}
