//Qingtian Mei
//frankmei@brandeis.edu
//01 19,2019
//PA0
/**/
/**/
package src;
public class Person {
	String name;
	int age;
	int salary;
	
	//constructor
	public Person(String name, double age, int salary) {
		this.name = name;
		this.age = (int)age;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public int getSalary() {
		return this.salary;
	}
	
	public String toString() {
		return (name + ", " + age + ", " + salary);
	}
}
