//
// Christopher Ravosa
// Prog 9
// Due April 16 before 1:30pm
//
// This program will create a grocery shopping menu that will replicate the same
// actions as program 8 but implement the actions with a linked list instead of
// an array list.
//

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class ShoppingDemoRavosa {

	public static void main(String[] args) {

		//Declare program variables and scanner object
		Scanner input = new Scanner(System.in);
		int userChoice = -1;
		boolean valid = true;
		String itemName = "";
		int itemQuantity = 0;
		double itemPrice = 0.0;
		KeyedListRavosa myList = new KeyedListRavosa();
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		String target = "";
		
		//ask the user for the path and name to the file
	    System.out.print("Enter a filename: ");
	    String fileName = input.next();        
	    
	    //create the reference to the file
	    File myFile = new File(fileName);

		try {
			//Create a second Scanner object, this one for reading from the file
			Scanner inputFile = new Scanner(myFile);
			int numItems = 0;
			int n = 0;
			numItems = inputFile.nextInt();
			for (n = 0; n<numItems; n++) {
				itemName = inputFile.next();
				itemQuantity = inputFile.nextInt();
				itemPrice = inputFile.nextDouble();
				ItemRavosa newItem = new ItemRavosa(itemName, itemQuantity, itemPrice);
				myList.add(newItem);
			}//for
			//Close inputFile
			inputFile.close();
		}//try
		catch(FileNotFoundException ex)
	    {
	      System.out.println("Failed to find file: " + myFile.getAbsolutePath()); 
	    }//catch
	    catch(InputMismatchException ex)
	    {
	    	System.out.println("Type mismatch for the number I just tried to read.");
	        System.out.println(ex.getMessage());
	    }
	    catch(NumberFormatException ex)
	    {
	      System.out.println("Failed to convert String text into an integer value.");
	      System.out.println(ex.getMessage());
	    }//catch
	    catch(NullPointerException ex)
	    {
	      System.out.println("Null pointer exception.");
	      System.out.println(ex.getMessage());
	    }//catch
	    catch(Exception ex)
	    {
	      // Like an "else" catch(Exception should come last as the catchall.
	    	System.out.println("Something went wrong");
	      ex.printStackTrace();
	    }//catch
		
	    //Loop the menu to appear until the user quits
		while(valid==true){
			System.out.println("Enter the corresponding integer of the action you'd like to perform:");
			System.out.println("1. Add an item to the list");
			System.out.println("2. Delete an item from the list");
			System.out.println("3. Print each item in the list");
			System.out.println("4. Search for a user-specified item in the list");
			System.out.println("5. Count the total number of items in the list");
			System.out.println("6. Total the cost of the items in the list");
			System.out.println("7. Determine whether the list is empty");
			System.out.println("8. Clear the list");
			System.out.println("0. Quit");
			userChoice = input.nextInt();
			
			//Switch the user's input to run the desired action
			switch(userChoice) {
			case 1:
				//Get info from user to create new item object
				System.out.println("Enter details of the product you'd like to add:");
				System.out.println("Item name (a string):");
				itemName = input.next();
				System.out.println("Item quantity(an integer):");
				itemQuantity = input.nextInt();
				System.out.println("Item price(a double):");
				itemPrice = input.nextDouble();
				ItemRavosa addItem = new ItemRavosa(itemName, itemQuantity, itemPrice); 
				if(myList.retrieve(itemName).getName()=="") {
					if(myList.add(addItem)==true)
						System.out.println("Item added!");	
				}//if
				else
					System.out.println("Item not added!");
				break;
			case 2:
				System.out.println("Please enter the name of the item to delete from your cart:");
				itemName = input.next();
				try {
				if(myList.remove(itemName)==true)
					System.out.println("Item removed!");
				}//try
				catch(NullPointerException notFound) {
					System.out.println("Item not found on list!");
				}//catch
				break;
			case 3:
				if(myList.isEmpty()==false)
					myList.print();
				else
					System.out.println("The list is empty!");
				break;
			case 4:
				System.out.println("Enter the name of the item you are searching for: ");
				target = input.next();
				if(myList.retrieve(target).getName()!="")
					myList.retrieve(target).printDetails();
				else
					System.out.println("Item not found!");
				break;
			case 5:
				System.out.println("There are " + myList.getCount() + " items in the list.");
				break;
			case 6:
				//Create try/catch to avoid null pointer exception
				try {
				System.out.println("The total is " + (moneyStyle.format(myList.calcTotal()) + "."));
				}//try
				catch(NullPointerException noCost){
					System.out.println("The total is $0.00.");
				}//catch
				break;
			case 7:
				if(myList.isEmpty()==true)
					System.out.println("The list is empty.");
				else
					System.out.println("The list is not empty.");
				break;
			case 8:
				//Just reset mySize to 0 to avoid more work
				myList.clear();
				System.out.println("The list has been emptied.");
				break;
			case 0:
				System.out.println("Goodbye!");
				valid = false;
				break;
			default:
				System.out.println("Invalid input!");
			}//switch
		}//while
		//Close input scanner
		input.close();
	}//main
}//ShoppingDemoRavosa