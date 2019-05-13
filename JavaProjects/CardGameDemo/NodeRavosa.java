//
//Christopher Ravosa
//Prog 10
//Due 4/30/18 before 1:30pm
//
//This program requires students to create a program that runs an instance
//of the simple card game "War" using an input file from the user. The
//game will run using the Stack abstract data type. This can  be implemented
//using arrays and linked lists. In this program, I used a linked list class
//to create my stacks.
//


//Create NodeRavosa stack for linked list implementation
public class NodeRavosa {
	private CardRavosa myData;
	private NodeRavosa myNext;
	
	public NodeRavosa() {
		myData = null;
		myNext = null;
	}//null constructor
	
	public NodeRavosa(CardRavosa newItem) {
		myData = newItem;
		myNext = null;
	}//full constructor
	
	public void setData(CardRavosa newItem) {
		myData = newItem;
	}//setData
	
	public void setNext(NodeRavosa newNext) {
		myNext = newNext;
	}//setNext
	
	public CardRavosa getData() {
		return myData;
	}//getData
	
	public NodeRavosa getNext() {
		return myNext;
	}//getNext
}//NodeRavosa
