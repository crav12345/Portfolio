//
// Christopher Ravosa
// Prog 9
// Due April 16 before 1:30pm
//
// This program will create a grocery shopping menu that will replicate the same
// actions as program 8 but implement the actions with a linked list instead of
// an array list.
//

//Create the Node class to create objects that will hold the values of the items
// in the list. This will allow the linked list to exist because the nodes
// will attach the items and can be rerouted
public class NodeRavosa {
	private ItemRavosa myData;
	private NodeRavosa myNext;
	
	public NodeRavosa() {
		myData = null;
		myNext = null;
	}//null constructor
	
	public NodeRavosa(ItemRavosa newItem) {
		myData = newItem;
		myNext = null;
	}//full constructor
	
	public void setData(ItemRavosa newItem) {
		myData = newItem;
	}//setData
	
	public void setNext(NodeRavosa newNext) {
		myNext = newNext;
	}//setNext
	
	public ItemRavosa getData() {
		return myData;
	}//getData
	
	public NodeRavosa getNext() {
		return myNext;
	}//getNext
}//NodeRavosa
