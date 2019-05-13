//
// Christopher Ravosa
// Prog 1
// 1/29/18 before 1:30
//
// This program will modify the ChangeMaker program to include one, five, ten and twenty dollar bills
//

import java.util.*;
//Declare a class
public class ChangeMakerRavosa 
{
	public static void main(String[] args) 
	{
		//Adding a scanner
		Scanner input = new Scanner(System.in);
		
		//Prompt user to enter an amount of money
		System.out.println("Enter a whole number.");
		System.out.println("I will output a combination of bills and coins"); 
		System.out.println("that equals that amount of change.");
		
		//Get money from user input
		int value = input.nextInt();
		
		//Store user input in variable to retain original value
		int originalValue = value;
		
		//Calculate how many times 2000 goes into the input value
		int numberOfTwenties = value / 2000;
		value = value % 2000;
		
		//Calculate how many times 1000 goes into the remainder
		int numberOfTens = value / 1000;
		value = value % 1000;
		
		//Calculate how many times 500 goes into the remainder
		int numberOfFives = value / 500;
		value = value % 500;
		
		//Calculate how many times 100 goes into the remainder
		int numberOfOnes = value / 100;
		value = value % 100;
		
		//Calculate how many times 25 goes into the remainder
		int numberOfQuarters = value / 25;
		value = value % 25;
		
		
		//Calculate how many times 10 goes into the remainder
		int numberOfDimes = value / 10;
		value = value % 10;
		
		//Calculate how many times 5 goes into the remainder
		int numberOfNickels = value / 5;
		value = value % 5;
		
		//Designate the remainder of value to number of pennies
		int numberOfPennies = value;
		
		//Find total number of bills used
		int numberOfBills = numberOfTwenties + numberOfTens + numberOfFives + numberOfOnes;

		//Find total number of coins used
		int numberOfCoins = numberOfQuarters + numberOfDimes + numberOfNickels + numberOfPennies;
		
		//Display results
		System.out.println(originalValue + " cents can be given as:");
		System.out.println(numberOfTwenties + " twenty dollar bills");
		System.out.println(numberOfTens + " ten dollar bills");
		System.out.println(numberOfFives + " five dollar bills");
		System.out.println(numberOfOnes + " one dollar bills");
		System.out.println(numberOfQuarters + " quarters");
		System.out.println(numberOfDimes + " dimes");
		System.out.println(numberOfNickels + " nickels");
		System.out.println(numberOfPennies + " pennies");
		System.out.println("The total number of bills and coins to make change is:");
		System.out.println(numberOfBills + " paper bills");
		System.out.println(numberOfCoins + " coins");

	} //main

} //Prog1
