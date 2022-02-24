package main;

/**
An interface that describes the operations of a bag of objects.
@author Frank M. Carrano
@author Timothy M. Henry
@version 5.0
*/
public interface BagInterface<T>
{
	/** Gets the current number of entries in this bag.
		 @return  The integer number of entries currently in the bag. */
	public int getCurrentSize();
	
	/** Sees whether this bag is empty.
		 @return  True if the bag is empty, or false if not. */
	public boolean isEmpty();
	
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry);

	/** Removes one unspecified entry from this bag, if possible.
    	@return  Either the removed entry, if the removal.
             was successful, or null. */
	public T remove();

	/** Removes one occurrence of a given entry from this bag, if possible.
    	@param anEntry  The entry to be removed.
    	@return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry);
	
	/** Removes all entries from this bag. */
	public void clear();
	
	/** Counts the number of times a given entry appears in this bag.
		 @param anEntry  The entry to be counted.
		 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry);
	
	/** Tests whether this bag contains a given entry.
		 @param anEntry  The entry to find.
		 @return  True if the bag contains anEntry, or false if not. */
	public boolean contains(T anEntry);

	/** Retrieves all entries that are in this bag.
		 @return  A newly allocated array of all the entries in the bag.
             Note: If the bag is empty, the returned array is empty. */
	public T[] toArray();
	
	/** Combines the method caller collection with the aBag collection into a single collection
	 *  that will store duplicates of the entries if there are any.
	 * @param A collection or bag aBag to be combined with method caller.
	 * @return  The combined collection bag with duplicates.
	 */
	public BagInterface<T> union(BagInterface<T> aBag);
	
	/** Combines the method caller collection with the aBag collection into a single collection
	 *  in a way where only entries that exist in both will be kept in the new collection.
	 * @param A collection aBag to be compared to method caller.
	 * @return	A collection bag with only entries that exist in both the compared collections. 
	 */
	public  BagInterface<T> intersection(BagInterface<T> aBag);
	
	
	/** Combines the method caller collection with the aBag collection into a single collection in a way
	 * where only the entries that do not exist in aBag are kept. Keeps only what exist solely on caller collection.
	 * @param A collection aBag to be compared to the method caller collection.
	 * @return	A collection bag that will have entries that do not overlap between both collections. 
	 */
	public BagInterface<T> difference(BagInterface<T> aBag);
	
} // end BagInterface
