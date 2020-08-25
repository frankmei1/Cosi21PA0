//Qingtian Mei
//frankmei@brandeis.edu
//01 19,2019
//PA0
/**/
/**/
package src;
public class Pet {
	String name;
	String species;
	int age;
	
	//constructor
	public Pet (String name, String species, int age) {
		this.name = name;
		this.species = species;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return (name + ", " + species + ", " + age);
	}
}
