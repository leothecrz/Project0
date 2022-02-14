package main;

/** OUTLINE
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full and will dynamically expand and contract as needed.
    @version 0.1
*/
public class LinkedBag<T> implements BagInterface<T> {
	private Node<T> nodeReference; /* Bag start*/
	private int numberOfEntries; /* Counts entries in the bag */

	public LinkedBag() {
		nodeReference = null;
		numberOfEntries = 0;
	}
	
	public boolean add(T Entry) {
		Node<T> newNode = new Node<T>(Entry);
		newNode.setNextNode(nodeReference);
		numberOfEntries++;
		nodeReference = newNode;
		return true;
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	public T remove() {
		T entry = null;
		if (nodeReference != null) {
			entry = nodeReference.getData();
			nodeReference = nodeReference.getNextNode();
			numberOfEntries--;
		}
		return entry;
	}

	private Node<T> getReferenceTo(T anEntry) {
		
		boolean found = false;
		Node<T> currentNode = nodeReference;
		
		while (!found && (currentNode != null)) { // while not found or not end of list
			
			if (anEntry.equals(currentNode.getData())) {
				found = true;
			} else {
				currentNode = currentNode.getNextNode();
			}
		}
		return currentNode;
	}
	
	public boolean remove(T anEntry) {
		
		boolean removed = false;
		Node<T> entryNode = getReferenceTo(anEntry);
		
		if (entryNode != null) {
			entryNode.setData(nodeReference.getData()); // first nodes data overrides the entry node's data. Entry node is replaced by first node. 
			nodeReference = nodeReference.getNextNode(); // first node is a redundant copy and is removed
			numberOfEntries--;
			removed = true;
		}
		return removed;
	}
		
	public void clear() {
		while(!isEmpty()) {
			remove();
		}
	}

	public int getFrequencyOf(T anEntry) {
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

	public boolean contains(T anEntry) {
		
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

	public T[] toArray() {
		
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

	
	public BagInterface<T> union(T aBag) { // ######################################
		
		Node<T> currentNode = nodeReference;
		LinkedBag<T> unionBag = new LinkedBag<>();
		
		
		for (int i=0; i < this.getCurrentSize(); i++ ) {
			unionBag.add(currentNode.getData());
		}
		if (aBag != null) {
			
		}
		
		return unionBag;
	}

	
	public BagInterface<T> intersection(T aBag) { // ######################################
		// TODO Auto-generated method stub
		return null;
	}

	
	public BagInterface<T> difference(T aBag) { // ######################################
		// TODO Auto-generated method stub
		return null;
	}
	
}
