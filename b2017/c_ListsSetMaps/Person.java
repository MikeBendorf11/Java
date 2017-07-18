package c_ListsSetMaps;

import java.util.*;

public class Person {
	enum Gender {MALE, FEMALE};
	int age;
	Gender sex;

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
		Person p1 = new Person(35, Gender.FEMALE);
		Person p2 = new Person(30, Gender.MALE);
		Person p3 = new Person(25, Gender.FEMALE);
		Person p4 = new Person(15, Gender.MALE);
		
		ArrayList<Person> people = new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4));
		
		System.out.println("Initial List:");
		print(people);
		
		Predicate<Person> adults = new Predicate<Person>(){
			public boolean test(Person person) {
				return person.getAge() > 15;
			}	
		};
		Predicate<Person> male = new Predicate<Person>(){
			public boolean test(Person person) {
				return person.getGender() == Gender.MALE;
			}	
		};
		Predicate<Person> match = new Predicate<Person>(){
			public boolean test(Person person) {
				return person.getAge() == 15;
			}	
		};
		
		List<Person> people2 = (ArrayList<Person>)Predicates.keep(people, adults); 
		List<Person> people3 = (ArrayList<Person>)Predicates.discard(people, male);
		
		System.out.println("Retain adults:");
		print(people2);
		System.out.println("Remove male:");
		print(people3);
		System.out.println("Index of person with age 35:");
		System.out.println(Predicates.find(people, match));
		
	}
	
	static void print(List<Person> l){
		for (Person p : l)
			System.out.println(p.getAge() + " " + p.getGender());
		System.out.println();
	}
}
