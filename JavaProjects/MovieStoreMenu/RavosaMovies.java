//
// Christopher Ravosa
// Prog 4
// 2/19/18 before 1:30pm
//
// This program tracks prices of pay-per-view movies using methods and loops;
// it then displays all of the information processed on the customers for the
// user to view.
//

import java.util.*;
import java.text.DecimalFormat;

public class RavosaMovies {
	
	public static void main(String[] args) {
		
		//Declare variables for main
		int id = 0;
		int ordered = 0;
		String name = "";
		double returnChooseMovie = 0;
		double service = 0;
		double totalAmountDue = 0;
		int processed = 0;
		double maxSoFar = 0;
		int maxPatient = 0;
		double minSoFar = Integer.MAX_VALUE;
		int minPatient = 0;
		double absoluteTotal = 0;
		double avg = 0;

		//Make decimal format
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		//Add scanner
		Scanner input = new Scanner(System.in);	
		
		//Prompt for and validate ID
		do
		{
			System.out.println("Enter customer ID (Integer between 25000 and 99999), or enter '0' to finish: ");
			id = input.nextInt();
		}
		while ((id != 0)&&(id < 25000)||(id > 99999));
		
		//Start big loop
		while (id != 0)
		{
			//Prompt for customer name
			System.out.println("Enter customer first name: ");
			name = input.next();
		
			//Prompt for and validate movies ordered
			while (ordered < 1)
			{
				System.out.println("Enter number of movies ordered: ");
				ordered = input.nextInt();
			}//while
		
			//run chooseMovie method
			returnChooseMovie = chooseMovies(ordered);
		
			//run calcServiceCharge method
			service = calcServiceCharge(ordered, returnChooseMovie);
		
			//run totalAmountDue method
			totalAmountDue = calcTotalDue(service, returnChooseMovie);
		
			//run outputResults method
			outputResults(name, id, ordered, returnChooseMovie, service, totalAmountDue);
		
			//calculate maximum
			if (maxSoFar < totalAmountDue)
			{
				maxSoFar = totalAmountDue;
				maxPatient = id;
			}//if
			
			//calculate minimum
			if (minSoFar > totalAmountDue)
			{
				minSoFar = totalAmountDue;
				minPatient = id;
			}//if
			
			//increment number of processed customers
			processed++;
			
			//calculate the total bill for the customer
			absoluteTotal = absoluteTotal + totalAmountDue;
			
			System.out.println();
			
			//Prompt for ID again
			do
			{
				System.out.println("Enter customer ID (Integer between 25000 and 99999), "+
				"or enter '0' to finish: ");
				id = input.nextInt();
			}//do
			while ((id != 0)&&(id < 25000 || id > 99999));
			
			//reset ordered to zero for next customer
			ordered = 0;
		}//big while
		
		//calculate average and get rid of divide by 0 error
		if (processed == 0)
			avg = 0;
		else
			avg = absoluteTotal / processed;
				
		//display results of previous customer inputs
		System.out.println("Number of customers processed: " + processed);
		System.out.println("Highest bill charged: " + (moneyStyle.format(maxSoFar)));
		System.out.println("ID of customer who paid highest bill: " + maxPatient);
		//make sure minimum is 0 if no customers are processed
		if (minSoFar == 2147483647)
			System.out.println("Lowest bill charged: $0.00");
		else
			System.out.println("Lowest bill charged: " + (moneyStyle.format(minSoFar)));
		System.out.println("ID of customer who paid lowest bill: " + minPatient);
		System.out.println("Total charged for all downloads: " + (moneyStyle.format(absoluteTotal)));
		System.out.println("Average of all bills: " + (moneyStyle.format(avg)));
	}//main	
	
	//Create chooseMovies method
	public static double chooseMovies(int numMovies) 
	{
		//Declare method variables
		Scanner input = new Scanner(System.in);
		int count = 0;
		int length = 0;
		int valid = 0;
		String temp;
		char rating = 'n';
		double cost = 0;
		double costOfAll = 0;
		double total = 0;
		
		//create for loop for number of movies customer ordered
		for (count = 1; count <= numMovies; count++)
		{
			//Prompt for length of movies and tell customer which movie their on
			while ((length < 1) || (length > 240))
			{
				System.out.println("Enter the length of movie " + count + " (1-240 minutes): ");
				length = input.nextInt();
				if ((length < 1) || (length > 240))
					System.out.println("Invalid input");
			}//while
			
			//Prompt for rating of movies
			while (valid == 0)
			{
				System.out.println("Enter rating of movie " + count + ": ");
				System.out.println("G for G-rated");
				System.out.println("P for PG-rated");
				System.out.println("R for R-rated");
				System.out.println("X for X-rated");
				System.out.println("O for Other: ");
				temp = input.next();
				rating = temp.charAt(0);
				//calculate cost per movie using if/else statement
					if ((rating == 'G') ^ (rating == 'g'))
					{
						cost = 0.039 * length;
						valid = 1;
						total = total + cost;
					}//if
					else if ((rating == 'P') ^ (rating == 'p'))
					{
						cost = 0.054 * length;
						valid = 1;
						total = total + cost;
					}//else if
					else if ((rating == 'R') ^ (rating == 'r'))
					{
						cost = 0.068 * length;
						valid = 1;
						total = total + cost;
					}//else if
					else if ((rating == 'X') ^ (rating == 'x'))
					{
						cost = 0.273 * length;
						valid = 1;
						total = total + cost;
					}//else if
					else if ((rating == 'O') ^ (rating == 'o'))
					{	
						cost = 0.04 * length;
						valid = 1;
						total = total + cost;
					}//else if
					else
						System.out.println("Invalid input");
			}//while
			
			//reset values of valid and length and put total into costOfAll
			costOfAll = total;
			length = 0;
			valid = 0;
		}//for
		return costOfAll;
	}//numMovies

	//Create calcServiceCharge method
	public static double calcServiceCharge(int orders, double price) 
	{
		//calc service charge based on number of films
		double serviceCharge = 0;
		
		if (orders <= 3)
			serviceCharge = (price/100) * 18;
		else if (orders <= 7)
			serviceCharge = (price/100) * 15;
		else if (orders <= 11)
			serviceCharge = (price/100) * 11;
		else
			serviceCharge = (price/100) * 5;
		
		return serviceCharge;
	}//calcServiceCharge

	//Create calcTotalDue method
	public static double calcTotalDue(double charge, double totalCost)
	{
		//calculate final bill with tax
		double totalDue = charge + totalCost;
		double tax = (totalDue/100) * 7;
		totalDue = totalDue + tax;
		return totalDue;
	}//calcTotalDue

	//Create calcTotalDue method
	public static void outputResults(String firstName, int customerId, int numPurchased, 
			double totalCost, double serviceFee, double bill) 
	{
		//Input money format into this method
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		//Display results of all processed customers
		System.out.println("Customer ID: " + customerId);
		System.out.println("Customer Name: " + firstName);
		System.out.println("Number of Movies Purchased: " + numPurchased);
		System.out.println("Total Cost of Movies: " + (moneyStyle.format(totalCost)));
		System.out.println("Service Charge: " + (moneyStyle.format(serviceFee)));
		System.out.println("Total Bill: " + (moneyStyle.format(bill)));
	}//outputResults

}//prog
