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

	@Override
	public BagInterface<T> union(BagInterface<T> aBag) {
		Node<T> currentNode = nodeReference;
		
		LinkedBag<T> unionBag = new LinkedBag<>();
		
		for (int i=0; i < this.getCurrentSize(); i++ ) {
			if ( currentNode != null) {
				unionBag.add(currentNode.getData());
				currentNode = currentNode.getNextNode();
			}
		}
		T[] transferArray = aBag.toArray();
		for (int i = 0; i < transferArray.length; i++) {
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

	@Override
	public BagInterface<T> difference(BagInterface<T> aBag) {
		LinkedBag<T> differenceBag = new LinkedBag<>();
		T[] input = aBag.toArray();
		T[] source = this.toArray();
		
		for (int i=0; i<source.length;i++) {
			if (!aBag.contains(source[i])) {
				differenceBag.add(source[i]);
				source[i]=null;
			}
		}
		for (int i=0; i<input.length;i++) {
			if (!this.contains(input[i])) {
				differenceBag.add(input[i]);
				input[i]=null;
			}
		}
		
		return differenceBag;
	}
	
}
