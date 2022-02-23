package main;

/** OUTLINE
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full and will dynamically expand and contract as needed.
    @version 0.1
*/
public class LinkedBag<T> implements BagInterface<T> {
	private Node<T> nodeReference; /* reference to bag. By default points to head of bag*/
	private int numberOfEntries; /* Counts entries in the bag */

	public LinkedBag() { // O(1)
		nodeReference = null;
		numberOfEntries = 0;
	}
	
	public boolean add(T Entry) { // O(1) adds to front of list
		Node<T> newNode = new Node<T>(Entry);
		newNode.setNextNode(nodeReference);
		numberOfEntries++;
		nodeReference = newNode;
		return true;
	}
	
	public int getCurrentSize() { // O(1)
		return numberOfEntries;
	}

	public boolean isEmpty() { // O(1)
		return (numberOfEntries == 0);
	}

	public T remove() { // O(1) removes first entry
		T entry = null; // creates return object
		if (nodeReference != null) {	// checks if bag is empty
			entry = nodeReference.getData();	
			nodeReference = nodeReference.getNextNode();
			numberOfEntries--;
		}
		return entry;
	}
	
	public boolean remove(T anEntry) { // O(n)
		
		boolean removed = false;
		Node<T> entryNode = getReferenceTo(anEntry); //getReference dominates method with O(n). Returns null if entry not found.
		
		if (entryNode != null) { // if it was found it will be removed. 
			entryNode.setData(nodeReference.getData()); // first nodes data overrides the entry node's data. Entry node is replaced by first node. 
			nodeReference = nodeReference.getNextNode(); // first node is a redundant copy and is removed
			numberOfEntries--;
			removed = true;
		}
		return removed;
	}
		
	public void clear() { // O(1)
		this.nodeReference = null;
		this.numberOfEntries = 0;
	}

	public int getFrequencyOf(T anEntry) { //O(n) runs through all elements once.
		int frequency = 0;
		int i = 0;
		Node<T> currentNode = nodeReference;
		
		while ((i < numberOfEntries) && (currentNode != null)) {
			
			if (anEntry.equals(currentNode.getData())) {
				frequency++;
			}
			i++;
			currentNode = currentNode.getNextNode();	
		}
		
		return frequency;
	}

	public boolean contains(T anEntry) { //O(n)
		
		boolean contained = false;
		Node<T> currentNode = nodeReference;
		while( (!contained) && (currentNode != null) ) {
			if (anEntry.equals(currentNode.getData())){
				contained = true;
			} else {
				currentNode = currentNode.getNextNode();
			}
		}
		return contained;
	}

	public T[] toArray() { // O(n)
		
		@SuppressWarnings("unchecked")
		T[] array = (T[])new Object[this.numberOfEntries];
		
		int i = 0;
		Node<T> currentNode = nodeReference;
		while ((i < numberOfEntries) && (currentNode != null)) {
			array[i] = currentNode.getData();
			i++;
			currentNode = currentNode.getNextNode();
		}
		return array;
	}
	
	/**
	 * 
	 * @param anEntry
	 * @return Reference to T anEntry or null if entry is not in the list searched.
	 */
	private Node<T> getReferenceTo(T anEntry) { 
		
		boolean found = false;
		Node<T> currentNode = nodeReference;
		
		while (!found && (currentNode != null)) { // while not found and node exist
			
			if (anEntry.equals(currentNode.getData())) {
				found = true;
			} else {	currentNode = currentNode.getNextNode();	}
		}
		return currentNode;
	}
	
	/**
	 * Clones current bag by running through every element in current bag and adding them to it. 
	 * Takes O(n) time
	 * @return	An outBag with the contents of the current bag. Any changes to outBag do not affect the original.
	 */
	private LinkedBag<T> makeClone(){ // O(n)
		LinkedBag<T> outBag = new LinkedBag<>();
		
		int i = 0;
		Node<T> currentNode = nodeReference; // sets working node
		while ((i < numberOfEntries) && (currentNode != null)) { // goes through every entry and checks if empty
			outBag.add(currentNode.getData());
			i++;
			currentNode = currentNode.getNextNode();
		}
		
		return outBag;
	}
	
	@Override
	public BagInterface<T> union(BagInterface<T> aBag){
		
		LinkedBag<T> unionBag = this.makeClone();
		T[] transferArray = aBag.toArray();
		for (int i=0;i<transferArray.length;i++) {
			unionBag.add(transferArray[i]);
		}
		
		return unionBag;
	}
	
	@Override
	public BagInterface<T> intersection(BagInterface<T> aBag) {
		LinkedBag<T> intersectionBag = new LinkedBag<>();
		T[] input = aBag.toArray();
		T[] source = this.toArray();
		
		for(int i=0; i<source.length;i++) {
			for (int j=0;j<input.length;j++) {
				if (source[i].equals(input[j])){
					intersectionBag.add(source[i]);
					input[j]=null;
					break;
				}
			}
			if (input[input.length-1]== null) break;
		}
		
		return intersectionBag;
	}
	
	/**
	 * 
	 */
	@Override
	public BagInterface<T> difference(BagInterface<T> aBag) {
		LinkedBag<T> differenceBag = this.makeClone();
		T[] input = aBag.toArray();	
		
		for (int i=0; i<input.length;i++) {
			if (differenceBag.contains(input[i])) {
				differenceBag.remove(input[i]);
			}
		}
		
		return differenceBag;
	}
	
}
