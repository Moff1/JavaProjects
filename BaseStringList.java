package cs1302.p2;

import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

  /**
   * This is an abstract class that implements StringList Interface.
   * Abstract so does not implement any methods or return anything.
   */

public abstract class BaseStringList implements FancyStringList {
	
	
	protected int size;
	
	 /**
	   * Constructor for a BaseStringList.
	   */

	public BaseStringList() {
		size = 0;		
	} //Constructor
	
	/**
	 * Appends the specified string to the end of this list.
	 * @param s string to be appended
	 * @return true if this list changed as a result of the call; false otherwise
	 * @throws NullPointerException if the specified string is null
	 * @throws IllegalArgumentException if the specified string is empty
	 */
	
	@Override
	public boolean append (String item) {
	if (item == null) {
	throw new NullPointerException ("The item was null.");
	}
	if (item == "") {
	throw new IllegalArgumentException ("The item was empty.");
	}
	add(size(), item);
	return true;
	} // append //APPEND
	
	 /**
	  * A boolean returning true if the size of list is 0.
	  * @return Returns false is size of list is not 0.
	  * @Override
	  */
	public boolean isEmpty() {
	     if (size() == 0) {
	         return true;
	     } else {
	         return false;
	     }
	 }//isEmpty
	
	/**
	 * Takes certain items of the array list and makes them a into string.
	 * @param starts off the string
	 * @param sep what the separator should be
	 * @param what the ending string should be
	 */
	@Override
	
	public String makeString (String start, String sep, String end) {
	String stringRep = start;
	try {
	for (int i = 0; i < size(); i++) {
	if (i != size() - 1) {
	stringRep = stringRep.concat(get(i)).concat(sep);
	} else if (i == size() - 1) {
	stringRep = stringRep.concat(get(i));
	}
	}
	} catch (NullPointerException npe) {
	System.out.println("Something is null");
	}
	stringRep = stringRep.concat(end);
	return stringRep;
	} // makeString

	/**
	
	/**
	 * Prepends an item at index 0.
	 * @param s string to be appended
	 * @return true if this list changed as a result of the call; false otherwise
	 * @throws NullPointerException if the specified string is null
	 * @throws IllegalArgumentException if the specified string is empty
	 */

	@Override
	public boolean prepend(String item) {
		boolean prepend = false;
		if (item == null) {
	        throw new NullPointerException("String is null");
	    } else if (item.equals("")) {
	        throw new IllegalArgumentException("String is empty");
	    } else {
		add(0,item);
		prepend = true;
		return prepend;
	} //else
		
	} //prepend
	
 /**
  * Simply a integer giving the size of a list.
  * @return size of the list
  * @Override
  */

public int size() {
	return size;
     } //size


public String toString() {
return makeString("[",",","]");
} //toString

/**
 * Inserts the specified list of strings at the specified position in this list.
 * @param index index at which the specified string is to be inserted
 * @param items list of string to be inserted
 * @return true if this list changed as a result of the call; false otherwise
 */

public boolean add(int index, StringList items) {
	if (items == null) {
		throw new NullPointerException ("The item was null");
		}
		if (index < 0 || index > size()) {
		throw new IndexOutOfBoundsException ("The index was out of bounds");
		}
		int j = 0;
		for (int i = index ; i < index + items.size(); i++) {
		add (i,items.get(j));
		j++;
		}
		return !items.isEmpty();
		} // add

/**
 * Appends the specified list of strings to the end of this list.
 * @param items string to be appended
 * @return true if this list changed as a result of the call; false otherwise
*/


public boolean append(StringList items) {
	if (items == null) {
		throw new NullPointerException ("The item was null.");
		}
		for (int i = 0; i < items.size(); i++) {
		append (items.get(i));
		}
		return !items.isEmpty();
		} // append
 

/**
 * Returns true if this list contains the specified string.
 * More formally, returns true if, and only if, this list contains at least 
 * one element s such that target.equals(s).
 * @param target string whose presence in this list is to be tested
 * @return true if this list contains the specified string
 * @throws NullPointerException if the specified string is null
 * @throws IllegalArgumentException if the specified string is empty
 */	


public boolean contains (int start, String target) {
boolean contains = false;
for (int i = start; i < size(); i++) {
if (get(i).equals(target)) {
contains = true;
}
}
return contains;
} // contains


 
 /**
     * Returns the index of the first occurrence of the specified string in this list, or -1 if 
     * this list does not contain the string. 
     * @param target string to search for
     * @param start where to start looking
     * @return the index of the first occurrence of the specified string in this list, or -1 if
     * this list does not contain the string
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     */
	public int indexOf (int start, String target) {
		int index = -1;
		for (int i = start; i < size(); i++) {
			if (get(i).equals(target)) {
				index = i;
				return index;
			}
		}
		return index;
	} // indexOf
    
	/**
	 * Prepends a list of items at index 0.
	 * @param items list of strings to be appended
	 * @return true if this list changed as a result of the call; false otherwise
	 * @throws NullPointerException if the specified string is null
	 */

public boolean prepend​(StringList items) {
    if (items == null) {
        throw new NullPointerException("StringList is null");
    } else {
    	for (int i = 0; i < items.size(); i++) {
    		add(i,items.get(i));
    		}
    		return !items.isEmpty();
    		} // else
    
} //prepend

} //BaseStringList
