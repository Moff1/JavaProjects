/**
 * 
 */
package cs1302.p2;
import cs1302.adt.Node;
import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;
import java.lang.Exception;
/**
 *  Class that extends BaseStringList.
 * @author Moffatt
 *
 */

public class LinkedStringList extends BaseStringList{
    
	private Node head;
	
    /**
     * Constructor for an empty LinkedStringList with head equal to null.
     */
	
	public LinkedStringList(){
		super();
        Node head = null;
        
    } //LinkedStringList
	
	  /**
     * Creates a {@code LinkedStringList} object with an empty node as its first node and then
     * appends a copy of the specified list to the end.
     * @param other the list whose strings are to be copied
     */
	
	public LinkedStringList (StringList other) {
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
	
	@Override
	 
	public boolean add (int index, String item) {
			if (item == null) {
			throw new NullPointerException ("The item is Null");
			}
			if (item == "") {
			throw new IllegalArgumentException ("The item is empty");
			}
			if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException ("Index is out of bounds.");
			}
			if (index == 0 && size() == 0) {
			this.head = new Node (item);
			} else if (index == 0 && size() > 0) {
			Node temp = new Node (item, head);
			this.head = temp;
			} else {
			Node temp = head;
			Node newNode = new Node (item);
			for (int i = 0; i < index - 1; i++) {
			temp = temp.getNext();
			}
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
			}
			super.size++;
			return true;
			} // add

    /**
     * Returns the string at the specified position in this list.
     * @param index index of the string to return
     * @return the string at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * (index {@literal <} 0 || index {@literal >}= size())
     */
    
	public String get (int index) {
		if (index < 0 || index >= size()) {
		throw new IndexOutOfBoundsException("Index out of bounds");
		}
		String get;
		Node temp = head;
		for (int i = 0; i < index; i++) {
		temp = temp.getNext();
		}
		get = temp.getItem();
		return get;
		} // get
         
	 
    /** 
     * Removes all of the strings from this list. 
     * The list will be empty after this call returns.
     * Essentially clears the list.  
     */
	
    public void clear(){
    	this.head = null;
        super.size = 0;
    }
    
    /**
     * Removes the string at the specified position in this list. 
     * Shifts any subsequent elements to the left (subtracts one from their indices). 
     * Returns the string that was removed from the list.
     * @param index index of the string to remove
     * @return the string previously at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index {@literal <} 0 || index {@literal >}= size())
     */
    
    public String remove (int index) {
    	if (index < 0 || index >= size()) {
    	throw new IndexOutOfBoundsException ("Index out of bounds");
    	}
    	String removed;
    	Node temp = head;
    	if (index == 0) {
    	removed = temp.getItem();
    	} else {
    	for (int i = 0; i < index - 1; i++) {
    	temp = temp.getNext();
    	}
    	removed = temp.getNext().getItem();
    	}
    	if (removed == null) {
    	throw new NullPointerException("Item was null");
    	}
    	temp.setNext(temp.getNext().getNext());
    	super.size--;
    	return removed;
    	} // remove
    
    /**
     * Builds and returns a new StringList that contains the strings from this list between
     * the specified start and stop. 
     * @param start low endpoint (inclusive) of the splice
     * @param stop high endpoint (exclusive) of the splice
     * @return a new list with the strings from this list from the specified range
     * @throws IndexOutOfBoundsException for an illegal endpoint index value 
     * (fromIndex {@literal <} 0 || toIndex {@literal >} size || fromIndex {@literal >} toIndex)
     */
    
    public StringList slice (int start, int stop) {
    	if (start < 0 || stop > size() || start > stop) {
    	throw new IndexOutOfBoundsException("Index was out of bounds.");
    	}
    	StringList newList = new LinkedStringList();
    	int j = 0;
    	for (int i = start; i < stop; i++) {
    	String item = get(i);
    	newList.add(j,item);
    	j++;
    	}
    	return newList;
    	} // slice
    
    /**
     * Inserts the specified list of strings at the specified position in this list.
     * @param index index at which the specified string is to be inserted
     * @param items list of string to be inserted
     * @return true if this list changed as a result of the call; false otherwise
     */
    
    public boolean add​(int index, StringList items) {
    	return super.add(index, items);
    }
    
	/**
	 * Appends the specified list of strings to the end of this list.
	 * @param items string to be appended
	 * @return true if this list changed as a result of the call; false otherwise
	 * @throws NullPointerException if the specified string is null
	 * @throws IllegalArgumentException if the specified string is empty
	 */
    
	public boolean append​(StringList items) {
		return super.append(items);
	};

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
     * this list does not contain the string. More formally, returns the lowest index i such that 
     * s.equals(get(i))), or -1 if there is no such index.
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
	 * @throws NullPointerException if the specified string is null
	 * @throws IllegalArgumentException if the specified string is empty
	 */
	
	public boolean prepend​(StringList items) {
		return super.prepend​(items);
	}
	
	public FancyStringList slice​(int start, int stop, int step) {
		if (start < 0 || stop > size() || start > stop || step < 1) {
			throw new IndexOutOfBoundsException ("The index is out of bounds.");
			}
			FancyStringList fsl = new LinkedStringList();
			for (int i = start; i < stop; i = i + step) {
			fsl.append(get(i));
			}
			return fsl;
	}
	
	/** 
	 * Returns a string list that contains the items from this list between the
	* specified start index (inclusive) and stop index (exclusive) by step for
	* an arrayStringList.
	* @return the sliced list
	*/
	

		
    /**
     * Returns the reverse of the list.
     * @return the the reversed list
     */
	
	public FancyStringList reverse () {
		FancyStringList fsl = new LinkedStringList();
		for (int i = 0; i < size(); i++) {
		fsl.prepend(get(i));
		}
		return fsl;
		} // reverse
} // LinkedStringList
