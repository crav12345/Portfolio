//
// Christopher Ravosa
// Prog 9
// Due April 16 before 1:30pm
//
// This program will create a grocery shopping menu that will replicate the same
// actions as program 8 but implement the actions with a linked list instead of
// an array list.
//

public class ItemRavosa {
	private String myName;
	private int myQuantity;
	private double myPrice;
	
	//Set null constructor
	public ItemRavosa(){
		myName = "";
		myQuantity = 0;
		myPrice = 0.0;
	}//null constructor
	
	//Set full constructor
	public ItemRavosa(String newName, int newQuantity, double newPrice) {
		myName = newName;
		myQuantity = newQuantity;
		myPrice = newPrice;
	}//full constructor
	
	//Declare setters
	public void setName(String newName) {
		myName = newName;
	}//setName
	
	public void setQuantity(int newQuantity) {
		myQuantity = newQuantity;
	}//setQuantity
	
	public void setPrice(double newPrice) {
		myPrice = newPrice;
	}//setPrice
	
	//Declare getters
	public String getName() {
		return myName;
	}//getName
	
	public int getQuantity() {
		return myQuantity;
	}//getQuantity
	
	public double getPrice() {
		return myPrice;
	}//getPrice
	
	//Create method to convert ItemRavosa objects into strings of data
	public void printDetails() {
		System.out.println("    Item: " + getName());
		System.out.println("    Quantity: " + getQuantity());
		System.out.println("    Price: " + getPrice() + " each");
		System.out.println();
	}//toString
}//ItemRavosa
