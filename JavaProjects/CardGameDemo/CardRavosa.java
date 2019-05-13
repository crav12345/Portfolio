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

public class CardRavosa {
	private char mySuit;
	private int myValue;
	
	public CardRavosa() {
		mySuit = ' ';
		myValue = 0;
	}//null
	
	public CardRavosa(int newValue, char newSuit) {
		myValue =  newValue;
		mySuit = newSuit;
	}//full
	
	public void setValue(int newValue) {
		myValue = newValue;
	}//setValue
	
	public void setSuit(char newSuit) {
		mySuit = newSuit;
	}//setSuit
	
	public int getValue() {
		return myValue;
	}//getValue
	
	public char getSuit(){
		return mySuit;
	}//getSuit
	
	//format a print details method that will accurately
	//tell a card's value and of which suit it is.
	public void printDetails() {
		switch(getValue()) {
			case 11:
				System.out.print("Jack");
				break;
			case 12:
				System.out.print("Queen");
				break;
			case 13:
				System.out.print("King");
				break;
			case 14:
				System.out.print("Ace");
				break;
			default:
				System.out.print(getValue());
				break;
		}//switch
		
		switch(getSuit()) {
			case 'd':
			case 'D':
				System.out.println(" of diamonds");
				break;
			case 'c':
			case 'C':
				System.out.println(" of clubs");
				break;
			case 'h':
			case 'H':
				System.out.println(" of hearts");
				break;
			case 's':
			case 'S':
				System.out.println(" of spades");
				break;
			default:
				System.out.println("no value");
				break;
		}//switch
	}//printDetails
}//CardRavosa
