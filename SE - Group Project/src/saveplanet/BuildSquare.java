/**
 * 
 */
package saveplanet;

import java.util.Scanner;

/**
 * @author matthewbrennan
 *
 */
public class BuildSquare extends PurchaseSquare {

private final int ARRAY_SIZE = 4;
	
	private String colour;
	private boolean[] greenHouses;
	private double heating;
	private double greenHouseA;
	private double greenHouseB;
	private double greenHouseC;
	private double greenHouseD;

	/**
	 * Default constructor
	 */
	public BuildSquare(){
		
	}

	/**
	 * constructor with parameters
	 * @param name
	 * @param next
	 * @param cost
	 * @param colour
	 * @param rent
	 * @param greenHouseA
	 * @param greenHouseB
	 * @param greenHouseC
	 * @param greenHouseD
	 */
	public BuildSquare(String name, Square next, double cost, String colour, double heating, double greenHouseA, double greenHouseB, double greenHouseC, double greenHouseD){
		super(name, next, cost, null, false);
		this.colour = colour;
		this.heating = heating;
		this.greenHouseA = greenHouseA;
		this.greenHouseB = greenHouseB;
		this.greenHouseC = greenHouseC;
		this.greenHouseD = greenHouseD;
		this.greenHouses = new boolean[ARRAY_SIZE];
		for (int loop = 0; loop < ARRAY_SIZE; loop++)
			this.greenHouses[loop] = false;
	}

	/**
	 * 
	 * @return colour
	 */
	public String getColour(){
		return this.colour;
	}
	
	/**
	 * 
	 * @param colour
	 */
	public void setColour(String colour){
		this.colour = colour;
	}

	/**
	 * 
	 * @return heating
	 */
	public double getHeating(){
		return this.heating;
	}
	
	/**
	 * 
	 * @param heating
	 */
	public void setHeating(double heating){
		this.heating = heating;
	}

	/**
	 * 
	 * @return greenHouseA
	 */
	public double getGreenHouseA(){
		return this.greenHouseA;
	}

	/**
	 * 
	 * @param greenHouseA
	 */
	public void setGreenHouseA(double greenHouseA){
		this.greenHouseA = greenHouseA;
	}
	
	/**
	 * 
	 * @return greenHouseB
	 */
	public double getGreenHouseB(){
		return this.greenHouseB;
	}
	
	/**
	 * 
	 * @param greenHouseB
	 */
	public void setGreenHouseB(double greenHouseB){
		this.greenHouseB = greenHouseB;
	}

	/**
	 * 
	 * @return greenHouseC
	 */
	public double getGreenHouseC(){
		return this.greenHouseC;
	}
	
	/**
	 * 
	 * @param greenHouseC
	 */
	public void setGreenHouseC(double greenHouseC){
		this.greenHouseC = greenHouseC;
	}

	/**
	 * 
	 * @return greenHouseD
	 */
	public double getGreenHouseD(){
		return this.greenHouseD;
	}
	
	/**
	 * 
	 * @param greenHouseD
	 */
	public void setGreenHouseD(double greenHouseD){
		this.greenHouseD = greenHouseD;
	}


    /**
     * adds greenhouse to the greenhouse array
     * sets rent as greenhouse cost
     * @param player
     */
	public void addGreenHouse(Player2 player){
		for (int loop = 0; loop < ARRAY_SIZE; loop++){
			if (!greenHouses[loop]){
				switch(loop){
					case 0:
						setHeating(greenHouseA);
						break;
					case 1:
						setHeating(greenHouseB);
						break;						
					case 2:
						setHeating(greenHouseC);
						break;
					case 3:
						setHeating(greenHouseD);
						break;
				}
				greenHouses[loop] = true;				
				System.out.print("Greenhouse purchased.");
				System.out.println();
				System.out.println(player.getName() +"'s funds after purchasing greenhouse: £" + player.getFunds());
				return;
			}
		}
		System.out.println("Collection full - unable to purchase anymore greenhouses for this square");
	}

   /**
    * 
    * @return count
    * returns number of greenhouses
    */
    public int getNumGreenHouses(){
        int count = 0;
        for (int loop = 0; loop < ARRAY_SIZE; loop++){
			if (greenHouses[loop])
				count++;
        }
        return count;
    }
    
   /**
    * If user does not own square - asks them if they want to purchase
    * Adds square to user collection
    * If owned, then tells user how much they owe to other player
    */
    @Override
    public void squareAction(Player2 player){
        Scanner scanner = new Scanner(System.in);

        if (!owned){
            System.out.println("For Sale. £" + this.cost + " Would you like to purchase? Y or N");
            char decision = scanner.next().charAt(0);
            
            if (decision == 'Y' || decision == 'y'){
                if (player.getFunds() < this.cost)
                    System.out.println("Not enough funds to make purchase");
                else{
                    this.owner = player;                    
                    this.owned = true;                	
                	player.addCollection(this);
                    player.removeFunds(this.cost);
                }
            }
        }
        else{
            System.out.println("This collection is owned by " + owner.getName());
            System.out.println("You owe " + owner.getName() + " £" + this.heating);        
            player.removeFunds(this.heating);
            owner.addFunds(this.heating); } 
        
	}
}
