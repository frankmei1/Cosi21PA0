//Qingtian Mei
//frankmei@brandeis.edu
//01 19,2019
//PA0
/**/
/**/
package src;
public class House {
	int rooms;
	int price;
	boolean petsAllowed;
	
	//constructor
	public House(int rooms, int price, boolean petsAllowed) {
		this.rooms = rooms;
		this.price = price;
		this.petsAllowed = petsAllowed;
	}
	
	public int getRooms() {
		return rooms;
	}
	
	public int getPrice() {
		return price;
	}
	
	public boolean petsAllowed() {
		return petsAllowed;
	}
	
	public String toString() {
		return (rooms + ", " + price + ", " + petsAllowed + "\n");
	}
}
