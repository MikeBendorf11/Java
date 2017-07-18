package c_ListsSetMaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Predicates{
	
	/*Return elements that match*/
	public static <T> Collection <T> keep(Collection<T> coll, Predicate<T> pred)
	{
		Collection<T> result = new ArrayList<T>();
		for (T element : coll) 
			if (pred.test(element)) 
				result.add(element);
			return result;
	}

	/*Remove elements that don't match*/
	public static <T> Collection <T> discard(Collection<T> coll, Predicate<T> pred)
	{
		Collection<T> result = new ArrayList<T>();
		for (T element : coll) 
			if (!pred.test(element)) 
				result.add(element);
			return result;
	}
	/*Returns an index for the first match or -1 if not found*/
	public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
		int m = -1;
		for (T element : list) 
			if (pred.test(element)) 
				m = list.indexOf(element);	
		return m;
	}


	/*
	 * https://www.javacodegeeks.com/2012/05/functional-style-in-java-with.html
	 * **********************************************************************
	 * 
	 */
}
