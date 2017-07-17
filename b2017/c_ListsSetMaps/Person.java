package c_ListsSetMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Person {
	public enum Gender {MALE, FEMALE};
	private int age;
	private Gender sex;

	Person(int age, Gender sex) {
		this.age = age;
		this.sex = sex;
	}
	int getAge(){
		return age;
	}
	Gender getGender(){
		return sex;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person(35, Gender.MALE);
		Person p2 = new Person(30, Gender.MALE);
		Person p3 = new Person(25, Gender.FEMALE);
		Person p4 = new Person(15, Gender.FEMALE);
		
		//changed this to Arraylist (type Arrays only doesn't support remove)
		List<Person> people = new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4));
		
		for (Person person : people) 
			System.out.println(person.getAge() + " " + person.getGender());
		System.out.println("Next");
		
		Predicate<Person> reMinor = new Predicate<Person>(){
			public boolean test(Person person) {
				return person.getAge() < 18;
			}	
		};
		
		Predicates rem = new Predicates();
		
		rem.remove(people, reMinor); //ConcurrentModificationException
		
		for (Person person : people) 
			System.out.println(person.getAge() + " " + person.getGender());
		System.out.println("Next");
		

		
		
		
		
	}
}
