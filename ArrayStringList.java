
package cs1302.p2;

import java.lang.Exception;
import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;



/**
 * @author Moffatt
 * Class that extends BaseStringList.
 */

public class ArrayStringList extends BaseStringList {

	private String[] items;
	
	
	
	/**
     * Creates an {@code ArrayStringList} object and copies all strings from a specified list.
     * @param other the list whose strings are to be copied
     */
	
	public ArrayStringList() {
		super();
		items  = new String[20];
		
	} //ArrayStringList
	
	  /**
     * Creates a deep copy of the list and then
     * appends a copy of the specified list to the end.
     * @param other the list whose strings are to be copied
     */
	
	public ArrayStringList (StringList other) {
		this.items = new String [other.size()];
		for (int i = 0; i < other.size(); i++) {
		append(other.get(i));
		}
		} // Constructor

    /**
     * Inserts the specified string at the specified position in this list.
     * @param index index at which the specified string is to be inserted
     * @param s string to be inserted
     * @return true if this list changed as a result of the call; false otherwise
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index {@literal <} 0 || index {@literal >} size())
     */
	public boolean add (int index, String item)
			throws NullPointerException, IllegalArgumentException, IndexOutOfBoundsException {
			if (item == null) {
			throw new NullPointerException ("The item is Null");
			}
			if (item == "") {
			throw new IllegalArgumentException ("The item is empty");
			}
			if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException ("Index is out of bounds.");
			}
			String [] temp = new String [size()];
			for (int i = 0; i < size(); i++) {
			temp[i] = get(i);
			}
			if (size() == items.length - 1) {
			items = new String [size() + 3];
			}
			int x = 0;
			for (int i = 0; i < size() + 1; i++) {
			if (i == index) {
			items[i] = item;
			x = 1;
			} else {
			items[i] = temp [i - x];
			}
			}
			size++;
			return true;
			} // add

    
    /** 
     * Removes all of the strings from this list. 
     * The list will be empty after this call returns.
     * Essentially clears the list.  
     */
    
	public void clear () {
		this.items = new String [20];
		super.size = 0;
		} // clear
    /**
     * Appends the specified string to the end of this list.
     * @param s string to be appended
     * @return true if this list changed as a result of the call; false otherwise
     */
    
    public boolean append(String s) {
    	boolean append = false;
    	add(size(), s);
    	append = true;
        return append;
        		
        		
    } //append
    
    /**
     * Builds and returns a new {@code StringList} that contains the strings from this list between
     * the specified {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. If 
     * {@code fromIndex} and {@code toIndex} are in bounds and equal, then the returned list is 
     * empty.
     * @param fromIndex low endpoint (inclusive) of the splice
     * @param toIndex high endpoint (exclusive) of the splice
     * @return a new {@code StringList} with the strings from this list from the specified range
     * @throws IndexOutOfBoundsException for an illegal endpoint index value 
     * (fromIndex {@literal <} 0 || toIndex {@literal >} size || fromIndex {@literal >} toIndex)
     */
    
    @Override
    public StringList slice (int start, int stop) throws IndexOutOfBoundsException {
    if (start < 0 || stop > size() || start > stop) {
    throw new IndexOutOfBoundsException ("Index out of bounds");
    }
    StringList slicedString = new ArrayStringList();
    for (int i = start; i < stop; i++) {
    slicedString.append(items[i]);
    }
    return slicedString;
    } // slice
    
        /**
         * Removes the string at the specified position in this list. 
         * Shifts any subsequent elements to the left (subtracts one from their indices). 
         * Returns the string that was removed from the list.
         * @param index index of the string to remove
         * @return the string previously at the specified position in this list
         * @throws IndexOutOfBoundsException if the index is out of range 
         */
    
    public String remove (int index) {
    	if (index < 0 || index >= size()) {
    	throw new IndexOutOfBoundsException ("Index is out of bounds.");
    	}
    	String removed = get(index);
    	for (int i = index; i < items.length - 1; i++) {
    	items[i] = items[i + 1];
    	}
    	super.size--;
    	return removed;
    	} // remove
         
         /**
          * Returns the string at the specified position in this list.
          * @param index index of the string to return
          * @return the string at the specified position in this list
          * @throws IndexOutOfBoundsException if the index is out of range
          */
    public String get (int index) throws IndexOutOfBoundsException {
    	if (index < 0 || index >= size()) {
    	throw new IndexOutOfBoundsException ("Index is out of bounds.");
    	}
    	return items[index];
    	} // get
         
		/**
		 * Makes a string from the items in a list.
		 * @param start the starting character
		 * @param sep the character that separates the items
		 * @param end the string the ends the 'list'
		 * @return returns the printed list 
		 */
		@Override
		
		public String makeString(String start, String sep, String end) {
			return super.makeString(start, sep, end);
			} //makeString
		
		/**
	     * Returns the reverse of the list.
	     * @return the the reversed list
	     */
		
		@Override
		public FancyStringList reverse () {
		FancyStringList fsl = new ArrayStringList();
		for (int i = 0; i < size(); i++) {
		fsl.prepend(get(i));
		}
		return fsl;
		} // reverse
	    
	    /**
	     * Inserts the specified list of strings at the specified position in this list.
	     * @param index index at which the specified string is to be inserted
	     * @param items list of strings to be inserted
	     * @return true if this list changed as a result of the call; false otherwise
	     */
	    
	    public boolean add​(int index, StringList items) {
	    	return super.add(index, items);
	    }
	    
	    /**
		 * Appends the specified list of strings to the end of this list.
		 * @param items string to be appended
		 * @return true if this list changed as a result of the call; false otherwise
		 */
	    
		public boolean append​(StringList items) {
			return super.append(items);
		}
		
		/** 
		 * Returns true if the list contains the item.
		 * @param start where the start looking
		 * @param target what string to look for 
		* specified start index (inclusive) and stop index (exclusive) by step for
		* an arrayStringList.
		* @return the sliced list
		*/
		
		public boolean contains​(int start, String target) {
			return super.contains(start, target);
			
		}
		  /**
	     * Returns the index of the first occurrence of the specified string in this list, or -1 if 
	     * this list does not contain the string.
	     * @param start where to start looking for the object
	     * @param target string to search for
	     * @return the index of the first occurrence of the specified string in this list, or -1 if
	     * this list does not contain the string
	     */
		
		public int indexOf​(int start, String target) {
			
			return super.indexOf(start, target);
		}
		
		/**
		 * Prepends a list of items at index 0.
		 * @param items list of strings to be appended
		 * @return true if this list changed as a result of the call; false otherwise
		 */
		
		public boolean prepend​(StringList items) {
			return super.prepend​(items);
		}
		
		/** 
		 * Returns a string list that contains the items from this list between the
		* specified start index (inclusive) and stop index (exclusive) by step for
		* an arrayStringList.
		* @param start where the start the slice
		* @param stop where the stop the slice
		* @param step how much to increment by
		* @return the sliced list
		*/
		
		public FancyStringList slice​(int start, int stop, int step) {
			if (start < 0 || stop > size() || start > stop || step < 1) {
				throw new IndexOutOfBoundsException ("The index is out of bounds.");
				}
				FancyStringList fsl = new ArrayStringList();
				for (int i = start; i < stop; i = i + step) {
				fsl.append(get(i));
				}
				return fsl;
				} // slice
		
			
		} // ArrayStringList
	    


         


 

