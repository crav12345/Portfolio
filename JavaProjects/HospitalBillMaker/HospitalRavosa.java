//
// Christopher Ravosa
// Prog 3
// Due 2/12/18 before 1:30pm
//
/* This program will use loops and conditional statements to present 
 * costs of hospital stays based on
 * various insurance plans. It'll also store information*/
//

import java.util.*;
import java.text.DecimalFormat;

public class HospitalRavosa {

	public static void main(String[] args) {
		
		//Declaring user keyboard as input device
		Scanner input = new Scanner(System.in);
		
		//Declare display format for currency values
		DecimalFormat moneyStyle = new DecimalFormat("$0.00");
		
		//Declare program variables
		double admit = 500;
		double diem = 1;
		double service = 1;
		double weeks = 1;
		double discount = 1;
		double total = 1;
		double income = 0;
		char insurance = 'N';
		String temp = "";
		int days = 1;
		int id = 1;
		int processed = 0;
		double maxSoFar = 0;
		int maxPatient = 0;
		double all = 0;
		double avg = 0;
		int valid = 0;
		String patientInsurance = "Invalid Input";

		//Get other variables from user
		//Prompt user to enter patient ID and store it as int
		do
		{
			System.out.println("Enter patient info. Enter ID as '0' to finish.");
			System.out.println("Enter patient ID:");
			id = input.nextInt();
		}//do
		while (id < 0);
		
		//start big loop
		while (id != 0)
		{
			income = 0;
			//Prompt user to enter patient income and store it as a double
			do
			{
			System.out.println("Enter household income:");
			income = input.nextDouble();
			}//do
			while (income <= 0);
			
			//Prompt user to enter patient insurance plan and store the char
			do
			{
				System.out.println("Enter the corressponding letter of the patient's insurance plan:");
				System.out.println("'B' for Blue Plus");
				System.out.println("'M' for Med-Health");
				System.out.println("'H' for Health Plan");
				System.out.println("'N' for no insurance");
				//Convert the input which is a string into a single char to be stored as a variable
				//and then converting that character into a full name
				temp = input.next();
				insurance = temp.charAt(0);
			
				//Switch user character input to strings containing insurance names
				switch (insurance) 
					{
					case 'b':
					case 'B':
						patientInsurance = "Blue Plus";
						if (income > 67500)
							diem = 150;
						else if (income >= 15000)
							diem = 85;
						else if (income < 15000) 
							diem = 50;
							valid = 1;
							break;
					case 'm':
					case 'M':
						patientInsurance = "Med-Health";
						if (income > 75000)
							diem = 200;
						else if (income >= 20000)
							diem = 100;
						else if (income < 20000) 
							diem = 65;
							valid = 1;
							break;
					case 'h':
					case 'H':
						patientInsurance = "Health Plan";
						if (income > 63000)
							diem = 150;
						else if (income >= 17500)
							diem = 90;
						else if (income < 17500) 
							diem = 55;
							valid = 1;
							break;
					case 'n':
					case 'N':
						patientInsurance = "No insurance";
						diem = 500;
						valid = 1;
						break;
					default: 
						System.out.println("Invalid input for insurance");
						valid = 0;
					} //switch
				}//do
				while (valid == 0);
				
			//Prompt the user to enter the length of the patient's stay and store it as an int
			do {
				System.out.println("Enter the number of days of the patient's stay (must be from 1-365):");
				days = input.nextInt();
			}//do
			while((days < 1)||(days > 365));
		
			//Change value of service
			service = diem*days;
		
			//Change value of weeks for discount
			weeks =  days / 7;
		
			//Calculate patient discount
			if (weeks >= 1)
				discount = weeks * 300;
			else
				discount = 0;

			//Calculate total
			total = (admit + service) - discount;
			
			//Display bill
			System.out.println("Patient ID: " + id);
			System.out.println("Household income: " + (moneyStyle.format(income)));
			System.out.println("Patient insurance: " + patientInsurance);
			System.out.println("Number of days of patient's stay: " + days);
			System.out.println("Admittance fee: " + (moneyStyle.format(admit)));
			System.out.println("Per diem rate: " + (moneyStyle.format(diem)));
			System.out.println("Service fee: " + (moneyStyle.format(service)));
			System.out.println("Discount: " + (moneyStyle.format(discount)));
			System.out.println("Total bill: " + (moneyStyle.format(total)));

			//Increment # of patients processed
			processed++;
			
			//Determine the maximum paid and match it with a patient
			if (maxSoFar < total)
			{
				maxSoFar = total;
				maxPatient = id;
			}//if
			
			//Add to total amount paid
			all = all + total;
			
			//Add to avg
			avg = avg + total;
			
			//check for sentinel
			if (id != 0)
			{
			System.out.println();
			System.out.println("Enter patient info. Enter ID as '0' to finish.");
			System.out.println("Enter patient ID:");
			id = input.nextInt();
			}//if
		}//while
		
		//Calculate avg	
		avg = avg / processed;
			
		//display stored results
		System.out.println("Patients processed: " + processed);
		System.out.println("Highest recorded bill: " + (moneyStyle.format(maxSoFar)));
		System.out.println("Patient who paid highest bill: Patient " + maxPatient);
		System.out.println("Total of all processed bills: " + (moneyStyle.format(all)));
		System.out.println("Average price per bill: " + (moneyStyle.format(avg)));
		
		}//main

	}//Prog2