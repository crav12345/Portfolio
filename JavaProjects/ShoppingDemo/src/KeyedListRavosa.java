//
// Christopher Ravosa
// Prog 9
// Due April 16 before 1:30pm
//
// This program will create a grocery shopping menu that will replicate the same
// actions as program 8 but implement the actions with a linked list instead of
// an array list.
//

public class KeyedListRavosa {
	private NodeRavosa myHead;
	
	public KeyedListRavosa() {
		myHead = null;
	}//null constructor
	
	public void setHead (NodeRavosa newHead) {
		myHead = newHead;
	}//setHead
	
	public NodeRavosa getHead() {
		return myHead;
	}//getHead
	
	//reference node class to create a linked list and add an object in alphabetical order
	public boolean add(ItemRavosa newGuy) {
		boolean found = false; 
		NodeRavosa previous = null;
		NodeRavosa current = myHead;
		while((current != null)&&(found==false)) {
			if(current.getData().getName().compareToIgnoreCase(newGuy.getName())>0) 
				found = true;
			else {
				previous = current;
				current = current.getNext();
			}//else
		}//while
		//first if is for empty lists or putting an object in the beginning
		if(previous == null) {
			NodeRavosa newNode = new NodeRavosa();
			newNode.setData(newGuy);
			newNode.setNext(current);
			myHead = newNode;
		}//if
		//the else is for putting objects in the middle or at the end of the list
		else {
			NodeRavosa newNode = new NodeRavosa();
			newNode.setData(newGuy);
			newNode.setNext(current);
			previous.setNext(newNode);
		}//else
		return found;
	}//add

	//reference node class to reroute nodes to not interact with the node the user wishes to remove
	public boolean remove (String target) {
		boolean found = false;
		NodeRavosa previous = null;
		NodeRavosa current = myHead;
		while((current!=null)&&(found==false)) {
			if(current.getData().getName().equalsIgnoreCase(target))
				found = true;
			else {
				previous = current;
				current = current.getNext();
			}//else
		}//while
		if(current == myHead)
			myHead = current.getNext();
		else {
			previous.setNext(current.getNext());
			current = previous.getNext();
		}//else
		return found;
	}//remove
	
	//reset linked list to hold no values. Other instances of the node class will be trashed
	public void clear() {
		NodeRavosa previous = null;
		myHead = null;
	}//clear

	//Shuffle through the list until a node's object's name equals the target and return that target item
	public ItemRavosa retrieve(String keyValue) {
		NodeRavosa current = myHead;
		NodeRavosa previous = null;
		ItemRavosa retrieveItem = new ItemRavosa();
		while(current!=null) {
			if(current.getData().getName().equalsIgnoreCase(keyValue))
				retrieveItem = current.getData();
				previous = current;
				current = current.getNext();
		}//while
		return retrieveItem;
	}//retrieve

	//determine if the list empty by seeing if the head is equal to null
	public boolean isEmpty() {
		boolean ans = false;
		if (myHead == null)
			ans = true;
		return ans;
	}//isEmpty

	//Shuffle through the list and print all objects and stop when current is null
	public void print() {
		NodeRavosa current = myHead;
		NodeRavosa previous = null;
		while(current!=null) {
			current.getData().printDetails();
			previous = current;
			current = current.getNext();
		}//while
	}//print

	//Add values of all object's quantities and return it
	public int getCount() {
		NodeRavosa current = myHead;
		NodeRavosa previous = null;
		int count = 0;
		while(current!=null) {
			count = count + current.getData().getQuantity();
			previous = current;
			current = current.getNext();
		}//while
		return count;
	}//getCount

	//Multiply all object's prices by their quantities and find the total sum and return it
	public double calcTotal() {
		NodeRavosa current = myHead;
		NodeRavosa previous = null;
		double total = 0;
		while(current!=null) {
			total = total + (current.getData().getPrice() * current.getData().getQuantity());
			previous = current;
			current = current.getNext();
		}//while
		return total;
	}//calcTotal

}//keyedListRavosa