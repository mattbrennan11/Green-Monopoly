/**
 * 
 */
package saveplanet;

/**
 * @author matthewbrennan
 *
 */
public class PurchaseSquare extends Square {

	protected Player2 owner;
	protected boolean owned;
	protected double cost;

    /**
     * Default constructor  
     */
	public PurchaseSquare(){
		
	}

	/**
	 * Constructor with parameters
	 * @param name
	 * @param next
	 * @param cost
	 * @param owner
	 * @param owned
	 */
	public PurchaseSquare(String name, Square next, double cost, Player2 owner, boolean owned){
		super(name, next);
		setCost(cost);
		this.owner = owner;
		this.owned = owned;
	}

	/**
	 * 
	 * @return cost
	 */
	public double getCost(){
		return this.cost;
	}
	
	/**
	 * 
	 * @param cost
	 */
	public void setCost(double cost) throws IllegalArgumentException {
		
		if((cost>0.00) && (cost<1000.00)) {
		this.cost = cost;
		} else {
			throw new IllegalArgumentException("Cost out of range...");
		}
	}

	/**
	 * 
	 * @return owner
	 */
	public Player2 getOwner(){
		return this.owner;
	}

	/**
	 * 
	 * @param owner
	 */
	public void setOwner(Player2 owner){
		this.owner = owner;
	}

	/**
	 * 
	 * @return owned
	 */
	public boolean getOwned(){
		return this.owned;
	}

	/**
	 * 
	 * @param owned
	 */
	public void setOwned(boolean owned){
		this.owned = owned;
	}
}
