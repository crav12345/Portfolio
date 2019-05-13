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

//StackRavosa class is made to work with a Node class for the linked
//list implementation
public class StackRavosa {
	private NodeRavosa myTop;

	public StackRavosa() {
		myTop = null;
	}//null
	
	public void setTop(NodeRavosa newTop) {
		myTop = newTop;
	}//setTop
	
	public NodeRavosa getTop() {
		return myTop;
	}//getTop
	
	public boolean isFull() {
		return false;
	}//isFull
	
	public boolean isEmpty() {
		boolean ans = false;
		if(myTop == null)
			ans = true;
		return ans;
	}//isEmpty
	
	public boolean push(CardRavosa newGuy) {
		boolean ans = false;
		if(!isFull()) {
			ans = true;
			NodeRavosa push = new NodeRavosa();
			push.setNext(myTop);
			push.setData(newGuy);
			myTop = push;
		}//if
		return ans;
	}//push
	
	public CardRavosa pop() {
		CardRavosa ans = null;
		if(!isEmpty()) {
			ans = myTop.getData();
			myTop = myTop.getNext();
		}//if
		return ans;
	}//pop
	
	public void printDetails() {
		NodeRavosa current = myTop;
		while (current != null) {
			if (current.getData().getValue()<11)
				System.out.print(current.getData().getValue());
			else if (current.getData().getValue()==11)
				System.out.print("J");
			else if (current.getData().getValue()==12)
				System.out.print("Q");
			else if (current.getData().getValue()==13)
				System.out.print("K");
			else
				System.out.print("A");
			System.out.print(current.getData().getSuit());
			if(current.getNext()!=null)
				System.out.print(", ");
			current = current.getNext();
		}//while
		System.out.println();
	}//printDetails
}//StackRavosa
