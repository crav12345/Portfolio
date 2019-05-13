//
// Christopher Ravosa
// Assignment 1
// Due February 13
//
// This program implements stacks, queues, arrays, and linked lists to read
// items from a list of "magic items". The program then determines which of
// the items' names are palindromes and prints them.
//

public class NodeRavosa {
	//Declare necessary variables for NodeRavosa objects
	private char myData;
	private NodeRavosa myNext;
	
	//Initialize variables with constructors
	public NodeRavosa() {
		myData = '\u0000';
		myNext = null;
	}//null constructor
	
	public NodeRavosa(char newData) {
		myData = newData;
		myNext = null;
	}//full constructor
	
	//Getter and setter methods for each variable are used to update values of
	//instances of NodeRavosa
	public void setData(char newData) {
		myData = newData;
	}//setData
	
	public void setNext(NodeRavosa newNext) {
		myNext = newNext;
	}//setNext
	
	public char getData() {
		return myData;
	}//getData
	
	public NodeRavosa getNext() {
		return myNext;
	}//getNext
}//NodeRavosa