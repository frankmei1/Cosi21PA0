//Qingtian Mei
//frankmei@brandeis.edu
//01 19,2019
//PA0
/**/
/**/
package src;
public class Family {
	private Person[] familyMembers;
	private Pet[] familyPets;
	private int budget;
	public boolean pets;
	public boolean status;
	
	/**
	 * 
	 * @param humans
	 * @param pets
	 * this constructor creates a human object, humans and pets int as length;
	 */
	public Family(int humans, int pets) {
		//TODO: Implement me!
		this.familyMembers = new Person[humans];
		this.familyPets = new Pet[pets];
	}
	
	
	/**
	 * this method sums up every person's salary to get the budget of the family;
	 */
	public void giveBudget() {
		int count = 0;;
		for(Person p: familyMembers) {
			count = count + p.salary;
		}
		this.budget = count;
	}
	
	/**
	 * 
	 * @return person array
	 * this method return the people of the family object;
	 * 
	 */
	public Person[] getPeople() {
		//TODO: Implement me!
		return this.familyMembers;
	}
	
	/**
	 * 
	 * @return pet array
	 * this method returns the pets of the family object;
	 */
	
	public Pet[] getPets() {
		//TODO: Implement me!
		return this.familyPets;
	}
	/**
	 * 
	 * @return integer
	 * this method return the budget of the family;
	 */
	public int getBudget() {
		//TODO: Implement me!
		return this.budget;
	}
	
	/**
	 * 
	 * @return integer
	 * this method return the number of people living in the family;
	 */
	public int numberOfPeople() {
		//TODO: Implement me!
		return this.familyMembers.length;
	}
	/**
	 * 
	 * @return integer
	 * this method return the number of pets living in the family;
	 */
	
	public int numberOfPets() {
		//TODO: Implement me!
		return this.familyPets.length;
	}
	
	/**
	 * 
	 * @param p
	 * @return boolean statement 
	 * this method put the person from the parameter into the person, and return if it is successful or not;
	 * 
	 */
	
	public boolean addMember(Person p) {
		//TODO: Implement me!
		int count = 0;
		if(familyMembers[0]==null) { // check if the family have been added a person;
			familyMembers[0] = p;
			return true; 
		}
		while(familyMembers[count]!=null) { // check if the current index if filled with family or not;
			if(count+1==familyMembers.length) { // if the count is the last index, and it is not null. Then, the array is filled, there should not be anymore index coming in; 
				return false;
			}
			if(familyMembers[++count]==null){
				familyMembers[count]= p;// if the next count is null, replace it with p and return true to end;
				return true;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param p
	 * @return boolean statement 
	 * this method put the pets  into the pet array, and return if it is successful or not;
	 * 
	 */
	
	public boolean addPet(Pet p) {
		//TODO: Implement me!
		int count = 0;
		if(familyPets[0]==null) { // check if the family have been added a person;
			familyPets[0] = p;
			return true; 
		}
		while(familyPets[count]!=null) { // check if the current index if filled with family or not;
			if(count+1==familyPets.length) { // if the count is the last index, and it is not null. Then, the array is filled, there should not be anymore index coming in; 
				return false;
			}
			if(familyPets[++count]==null){
				familyPets[count]= p;// if the next count is null, replace it with p and return true to end;
				return true;
			}
		}
		return true;
	}
	
	public String toString() {
		String toReturn = "";
		for (Person p : familyMembers) {
			if (p!=null) {
				toReturn += p.toString()+"\n";
			}
		}
		for (Pet p : familyPets) {
			if (p!=null) {
				toReturn += p.toString() + "\n";
			}
		}
		return toReturn;
	}
}
