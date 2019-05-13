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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BattleDemoRavosa {

	public static void main(String[] args) {
	    
		//declare variables for main method
		CardRavosa p1Card = new CardRavosa();
	    CardRavosa p2Card = new CardRavosa();
		StackRavosa player1 = new StackRavosa();
	    StackRavosa player2 = new StackRavosa();
	    StackRavosa discard1 = new StackRavosa();
	    StackRavosa discard2 = new StackRavosa();
	    int playNum = 1;
	    int totalCards = 0;
	    int player1Cards = 0;
	    int player2Cards = 0;
	    boolean staleMate = false;
	    
	    //call method to read input file and distribute card objects between players
	    deal(player1, player2);
	    System.out.println("====================");
	    
	    //Use a while loop to call play(), compare(), and copy() methods 
	    //until a winner is found or until game takes too long. This loop
	    //also prints every play.
	    while (((!player1.isEmpty())&&(!player2.isEmpty())&&(playNum<=1000))) {
	    	System.out.println("Play #: " + playNum);
	    	System.out.print("Player1 Playstack: ");
	    	player1.printDetails();
	    	System.out.print("Player1 Discard:");
	    	discard1.printDetails();
	    	System.out.print("Player2 Playstack: ");
	    	player2.printDetails();
	    	System.out.print("Player2 Discard:");
	    	discard2.printDetails();
	    	System.out.println("====================");	    	
	    	p1Card = play(player1);
	    	p2Card = play(player2);
	    	if(compare(p1Card, p2Card)==p1Card)
	    		winPlay(discard1, p1Card, p2Card);
	    	else if(compare(p1Card,p2Card)==p2Card)
	    		winPlay(discard2, p2Card, p1Card);
	    	else {
	    		discard1.push(p1Card);
	    		discard2.push(p2Card);
	    	}//else
	    	copy(player1, discard1);
	    	copy(player2, discard2);
	    	playNum++;
	    }//while
	    
	    //use countCards() method and analyze certain values to get info for printResults()
	    player1Cards = countCards(player1)+countCards(discard1);
	    player2Cards = countCards(player2)+countCards(discard2);
   	    totalCards = player1Cards+player2Cards;
   	    if (playNum-1 >= 1000)
	    	staleMate = true;
   	    
   	    //print results of game
	    printResults(playNum, totalCards, staleMate, player1Cards, player2Cards);
	}//main
	
	//create readInputFile method to be referenced by deal() method
	public static StackRavosa readInputFile(File theDeck) {
		StackRavosa myDeck = new StackRavosa();
	    StackRavosa tempOrder = new StackRavosa();
    	try {
    		//Create a second Scanner object, this one for reading from the file
    		Scanner inputFile = new Scanner(theDeck);
    		int numCards = 0;
    		int n = 0;
    		int cardValue = 0;
    		int suit = 1;
    		numCards = inputFile.nextInt();
    		for (n = 0; n<numCards; n++) {
    			cardValue = inputFile.nextInt();
    			CardRavosa newCard = new CardRavosa();
    			newCard.setValue(cardValue);
    			//use a switch to determine suits of cards
    			switch(suit) {
    				case 1:
    					newCard.setSuit('H');
    					break;
    				case 2:
    					newCard.setSuit('S');
    					break;
    				case 3:
    					newCard.setSuit('C');
    					break;
    				case 4:
    					newCard.setSuit('D');
    					break;
    			}//switch
    			myDeck.push(newCard);
    			suit++;
    			if (suit == 5)
    				suit = 1;
    		}//for
    		while (!myDeck.isEmpty())
    			tempOrder.push(myDeck.pop());
    		//Close inputFile
    		inputFile.close();
    	}//try
    	catch(FileNotFoundException ex){
    		System.out.println("Failed to find file: " + theDeck.getAbsolutePath()); 
    	}//catch
    	catch(InputMismatchException ex){
    		System.out.println("Type mismatch for the number I just tried to read.");
    		System.out.println(ex.getMessage());
    	}
    	catch(NumberFormatException ex){
    		System.out.println("Failed to convert String text into an integer value.");
    		System.out.println(ex.getMessage());
    	}//catch
    	catch(NullPointerException ex){
    		System.out.println("Null pointer exception.");
    		System.out.println(ex.getMessage());
    	}//catch
    	catch(Exception ex){
    		// Like an "else" catch(Exception should come last as the catchall.
    		System.out.println("Something went wrong");
    		ex.printStackTrace();
    	}//catch
    	return tempOrder;
    }//readInputFile

	public static void deal(StackRavosa player1, StackRavosa player2) {
		int count = 1;
		Scanner input = new Scanner(System.in);
		
		//ask the user for the path and name to the file
	    System.out.print("Enter the name of a file that contains a pre-shuffled " +
		"deck of up  to 52 cards: ");
	    String fileName = input.next();        
	    
	    //create the reference to the file
	    File myFile = new File(fileName);
	    StackRavosa dealDeck = readInputFile(myFile);
		
	    //use a while loop to distribute the input deck between the two play stacks
	    while (!dealDeck.isEmpty()) {
	    	if(count == 1)
	    		player1.push(dealDeck.pop());
	    	else if(count == 2)
	    		player2.push(dealDeck.pop());
	    	count++;
	    	if(count == 3)
	    		count = 1;
	    }//while
	    input.close();
	}//deal

	//create a method to find the number of cards in a specific stack
	public static int countCards(StackRavosa playerStack) {
		int myNumCards = 0;
		NodeRavosa current = playerStack.getTop();
		while (current != null) {
			myNumCards++;
			current = current.getNext();
		}//while
		return myNumCards;
	}//countCards
	
	//create a method to get a card from a designated stack
	public static CardRavosa play(StackRavosa playerStack) {
		CardRavosa playedCard = playerStack.pop();
		return playedCard;
	}//play
	
	//create a method to compare cards gotten from play() method and return
	//high card
	public static CardRavosa compare(CardRavosa player1, CardRavosa player2) {
		CardRavosa ans = null;
		if(player1.getValue()>player2.getValue())
			ans = player1;
		else if (player1.getValue()<player2.getValue())
			ans = player2;
		else
			ans = null;
		return ans;
	}//compare
	
	//give cards to winner; high card first and then low card
	public static void winPlay(StackRavosa winner, CardRavosa winCard, CardRavosa loseCard) {
		winner.push(winCard);
		winner.push(loseCard);
	}//winPlay
	
	//create a method to refill play stacks with discard stacks in the same order
	public static void copy(StackRavosa playStack, StackRavosa discardStack) {
		//declare a temp stack to help in transition between discard and play stacks
		StackRavosa tempStack = new StackRavosa();
		if(playStack.isEmpty()) {
    		while(!discardStack.isEmpty()) 
    			tempStack.push(discardStack.pop());
    		while (!tempStack.isEmpty())
    			playStack.push(tempStack.pop());
    	}//if
	}//copy
	
	//create a method to be called after the game has been played to print the required results
	public static void printResults(int plays, int total, boolean noWinner, int player1, int player2) {
		System.out.println("Battle Game Summary");
		System.out.println("====================");
		System.out.println("The game started with " +total+ " cards.");
		System.out.println("There were " +(plays-1)+ " plays in the game.");
		if(noWinner == false)
			System.out.println("The game ended with a clear winner.");
		else
			System.out.println("The game took too long.");
		System.out.println("Player 1 ended up with " +player1+ " cards.");
		System.out.println("Player 2 ended up with " +player2+ " cards.");
		if(noWinner == false) {
			if(player1>player2) 
				System.out.println("The winner was player 1.");
			else if(player1<player2)
				System.out.println("The winner was player 2.");
		}//if
		else
			System.out.println("The game resulted in a tie.");
	}//printResults

}//BattleDemoRavosa
