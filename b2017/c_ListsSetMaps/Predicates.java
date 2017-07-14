package c_ListsSetMaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Predicates {
	public interface Predicate<T> {
	    public boolean test( T obj );
	}
	public static <T> void remove(Collection<T> coll, Predicate<T> pred){}
	   // Remove every object, obj, from coll for which
	   // pred.test(obj) is true.
	   
	public static <T> void retain(Collection<T> coll, Predicate<T> pred){}
	   // Remove every object, obj, from coll for which
	   // pred.test(obj) is false.  (That is, retain the
	   // objects for which the predicate is true.)
	   
	public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred){
		return null;}
	   // Return a List that contains all the objects, obj,
	   // from the collection, coll, such that pred.test(obj)
	   // is true.
	   
	public static <T> int find(ArrayList<T> list, Predicate<T> pred){
		return 0;}
	   // Return the index of the first item in list
	   // for which the predicate is true, if any.
	   // If there is no such item, return -1.
	



		/*https://www.javacodegeeks.com/2012/05/functional-style-in-java-with.html
		 * **********************************************************************
		
		public List<PurchaseOrder> listOrders(Predicate<PurchaseOrder> condition) {
		  final List<PurchaseOrder> selection = new ArrayList<PurchaseOrder>();
		  for (PurchaseOrder order : orders) {
		    if (condition.apply(order)) {
		      selection.add(order);
		    }
		  }
		  return selection;
		}

		final Customer customer = new Customer("BruceWaineCorp");
		final Predicate<PurchaseOrder> condition = new Predicate<PurchaseOrder>() {
		  public boolean apply(PurchaseOrder order) {
		    return order.getCustomer().equals(customer);
		  }
		};



		/*---------------------------------------------------------------------------
		public List<PurchaseOrder> listRecentOrders(Date fromDate) {
		  final List<PurchaseOrder> selection = new ArrayList<PurchaseOrder>();
		  for (PurchaseOrder order : orders) {
		    if (order.getDate().after(fromDate)) {
		      selection.add(order);
		    }
		  }
		  return selection;
		}*/
}


