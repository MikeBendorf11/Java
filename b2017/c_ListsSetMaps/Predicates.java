package c_ListsSetMaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Predicates{
	
	public <T> void remove(Collection<T> coll, Predicate<T> pred)
	// Remove every object, obj, from coll for which
	// pred.test(obj) is true.
	{
		Collection<T> result = new ArrayList<T>();
		for (T element : coll) 
			if (pred.test(element)) 
				coll.remove(element);			
	}

	public static <T> void retain(Collection<T> coll, Predicate<T> pred)
	// Remove every object, obj, from coll for which
	// pred.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	{
		
	}

	public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
		// Return a List that contains all the objects, obj,
		// from the collection, coll, such that pred.test(obj)
		// is true.
		return null;
	}

	public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
		// Return the index of the first item in list
		// for which the predicate is true, if any.
		// If there is no such item, return -1.
		return 0;
	}


	/*
	 * https://www.javacodegeeks.com/2012/05/functional-style-in-java-with.html
	 * **********************************************************************
	 * 
	 */
}
