//
//Christopher Ravosa
//Prog 6
//Due 3/5/18 1:30pm
//
//This program will use a separate class to customize and print rectangles as 
//specified by the user. The purpose of the program is to refine students' 
//knowledge of classes and methods.
//

import java.util.*;

public class RectangleDemoRavosa {

	public static void main(String[] args) {
		
		//Define variables for main method
		Scanner input = new Scanner(System.in);
		String temp = "";
		String tempFill = "";
		char fill = ' ';
		char choice = 'k';
		int valid = 1;
		int height = 0;
		int width = 0;

		//Create a new instance variable of class Rectangle
		Rectangle rec = new Rectangle(10, 5, '*');
		
		//Wrap menu in while loop to repeat the menu after actions are done
		while (valid == 1)
		{
			//Display menu
			System.out.println("Enter the character that corresponds with the action you'd like to perform:");
			System.out.println("W : Assign the width");
			System.out.println("H : Assign the height");
			System.out.println("F : Assign the fill style");
			System.out.println("A : Calculate the area");
			System.out.println("P : Calculate the perimeter");
			System.out.println("T : Text description of the rectangle");
			System.out.println("D : Draw the rectangle");
			System.out.println("O : Draw the outline of the rectangle");
			System.out.println("Q : Quit");
			//Store user's input
			temp = input.next();
			choice = temp.charAt(0);
		
			//Use a switch to determine which method to run based on user input
			switch(choice)
			{
				//W will call setters to update width; bad values reset width to default
				case 'w':
				case 'W':
					System.out.println("Enter a new integer for width:");
					width = input.nextInt();
					if(width > 1)
						rec.setWidth(width);
					else
					{
						System.out.println("Invalid input; width is now 10");
						rec.setWidth(10);
					}//else
					break;
				//H will call setters to update height; bad values reset height to default
				case 'h':
				case 'H':
					System.out.println("Enter a new integer for height:");
					height = input.nextInt();
					if(height > 1)
						rec.setHeight(height);
					else
					{
						System.out.println("Invalid input; height is now 5");
						rec.setHeight(5);
					}//else
					break;
				//F will call setters to update the fill style
				case 'f':
				case 'F':
					System.out.println("Enter a new character for fill style:");
					tempFill = input.next();
					fill = tempFill.charAt(0);
					rec.setFillStyle(fill);
					break;
				//A and P will call methods to print area and perimeter
				case 'a':
				case 'A':
					System.out.println("The area of the rectangle is " + rec.calcArea() + " units.");
					break;
				case 'p':
				case 'P':
					System.out.println("The perimeter of the rectangle is " + rec.calcPerimeter() + " units.");
					break;
				//T will call getters to print a description of the rectangle in question
				case 't':
				case 'T':
					System.out.println("The rectangle has a width of " + rec.getWidth() + " units " +
							"and a height of " + rec.getHeight() + " units. The fill style of the " +
							"rectangle is '" + rec.getFillStyle() + "'.");
					break;
				//D and O will call methods to print the rectangle and its outline	
				case 'd':
				case 'D':
					rec.drawRectangle();
					break;
				case 'o':
				case 'O':
					rec.drawOutline();
					break;
				case 'q':
				case 'Q':
					valid = 0;
					break;
				//Default/bad values just loops the menu again and informs the user of the bad value
				default:
					System.out.println("Invalid input");
					break;
			}//switch
		}//while
	}//main	
}//RectangleDemoRavosa
