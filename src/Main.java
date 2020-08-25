//Qingtian Mei
//frankmei@brandeis.edu
//01 19,2019
//PA0
/**/
/**/
package src;
import java.io.*;
import java.util.*;

public class Main {
	public static Family[] f;
	public static House[] h;
	public static int[][] assignment;
	/**
	 * 
	 * @author Qingtian Mei
	 * This main method creates two Scanner variables for both house file and family file. 
	 * Second, it calls other methods within the class with parameter of these two Scanner variables to read files.
	 * Then, by calling other method within the class,it assigns the different family to each home.
	 * Finally, it prints String of assigning situation of family that got by calling other method  to the terminal.
	 */
	public static void main (String[] args) throws FileNotFoundException{
		//TODO: Implement me!
		 File family = new File("familyUnits.txt");
		 Scanner F = new Scanner(family);
		 File house = new File("housingUnits.txt");
		 Scanner H = new Scanner(house);
		 createFamily(F);
		 createHomes(H);
		 assignFamilyToHome();
		 System.out.println(displayAssignment()); //Do not modify this line!
	}
	
	/**
	 * 
	 * @param Scanner variable, F
	 * @void no return
	 * This method receives the Scanner variable, family, from the main method. 
	 * It use one while-loop, with two for-loops, to read each line from the files.
	 * 
	 */
	
	public static void createFamily(Scanner s) {
		f = new Family[s.nextInt()]; //Do not modify this line!
		//TODO: Implement me!
		int count = 0, pets,person; 
		String [] linearray; 
		String line;
		Person people;
		Pet pet;
		Family family;
		while(count<f.length) { // this while-loop iterates based on the number of families the file given.
			person = s.nextInt(); 
			pets = s.nextInt(); 
			line = s.nextLine();
			family = new Family(person,pets);// a new family is declared with empty people, and pets.
			family.status = false;// false means the family is not assigned yet.
			for (int i = 0;i<person;i++) {	// this loop is to read person from each family. 
				line = s.nextLine();
				linearray = line.split(" ");
				people = new Person(linearray[0],Integer.parseInt(linearray[1]),Integer.parseInt(linearray[2]));
				if(!family.addMember(people)) {
					System.out.println("More People than Given");
				}
			}
			for(int i = 0;i<pets;i++) {// this loop is to read pet from the family
				if(pets!=0) family.pets= true;
				linearray = s.nextLine().split(" ");
				pet = new Pet(linearray[0],linearray[1],Integer.parseInt(linearray[2]));
				if(!family.addPet(pet)) {
					System.out.println("More Pets than Given");
				}
			}
			family.giveBudget(); // this movement to sum up a family's budget;
			f[count++] = family;// the family then is store into the array, and the count plus to the next family.
		}
	}
	/**
	 * 
	 * @param 
	 * this method take in a Scanner variable.
	 * it reads the home file use one while-loop.
	 */

	public static void createHomes(Scanner s) {
		h = new House[s.nextInt()]; //Do not modify this line!
		//TODO: Implement me!
		int count = 0,rooms = 0,cost = 0;
		String skip; // this line is to skip the empty space;
		boolean pets;
		House house;
		while(count<h.length) {
			skip = s.nextLine();
			rooms = s.nextInt();
			cost = s.nextInt();
			pets = Boolean.parseBoolean(s.next());
			house = new House(rooms,cost,pets);// declare new house with the parameter read from the file;
			h[count++] = house;
		}
	}
	
/**
 * This method does not need a parameter.
 * It assigns the families into the right houses;
 * This method used three for-loops, one for-loop to iterate family, and one iterate houses. One is to check unassigned family;
 */
	public static void assignFamilyToHome() {
		assignment = new int[2][f.length]; //Do not modify this line!
		Family F;
		House H;
		for(int j =0; j<h.length;j++){// read each house from the house array;
			H = h[j];
			label1:
			for(int i = 0; i<f.length;i++) {// read each family from the family array;
				assignment[0][i]=i;
				F = f[i];
				if(F.status) { // check whether this family has been assign, if it is then skip them.
				continue label1;
				}
				if(F.getBudget()>=H.price && F.numberOfPeople()<= H.rooms) { // condition one;
					if(F.pets == true && F.pets!=H.petsAllowed()) {// condition two to limit other possibility;
						continue label1;
					}
					assignment[1][i]=j;
					F.status = true; // change the family status to assigned;
					break label1;// break the for loop to avoid the house being assigned twice;
				}
			}
		}
		for(int i = 0; i<f.length;i++) { // this loop is to check the unassigned family;
			if(!f[i].status) {
				assignment[1][i] = h.length ;
			}
		}
		//TODO: Implement me!
	}

	public static String displayAssignment() {
		String toReturn = "";
		int unassigned = 0;
		for (int i:assignment[1]) {
			if (i==h.length) {
				unassigned++;
			}
		}
		toReturn += f.length-unassigned + " families assigned" + "\n" + unassigned + " families unassigned\n\n";
		for (int i = 0 ; i<assignment[0].length; i++) {
			if (assignment[1][i]>=h.length) {
				toReturn += "Family:\n"+f[assignment[0][i]].toString() + "NOT ASSIGNED TO HOME\n\n";
			}else {
				toReturn += "Family:\n"+f[assignment[0][i]].toString() + "Home:\n"+h[assignment[1][i]].toString()+"\n";
			}
		}
		return toReturn;
	}
}

