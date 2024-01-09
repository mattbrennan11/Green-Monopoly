/**
 * 
 */
package saveplanet;

/**
 * @author matthewbrennan
 *
 */
public class Square {
	
	protected String name;
	protected Square next;

	/**
	 * default constructor
	 */
	public Square(){
		
	}

	/**
	 * constructor with args...
	 * String name
	 * Square next
	 */
	public Square(String name, Square next){
		setName(name);
		this.next = next;
	}

	/**
	 * @return name
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * @param name
	 * sets name
	 * throws illegal argument exception if name is too short or blank
	 */ 
	public void setName(String name) throws IllegalArgumentException {
		
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
	 * @return next
	 */
	public Square getNext(){
		return this.next;
	}

	/**
	 * @param next
	 * sets next
	 */
	public void setNext(Square next){
		this.next = next;
	}
   	
	/**
	 * action for other methods
	 */
    public void squareAction(Player2 player){
        
    }

}
