//
//Christopher Ravosa
//Prog 6
//Due 3/5/18 1:30pm
//
//This program will use a separate class to customize and print rectangles as 
//specified by the user. The purpose of the program is to refine students' 
//knowledge of classes and methods.
//

import java.util.Scanner;

public class Rectangle{
	private int myWidth;
	private int myHeight;
	private char myFillStyle;

	//Define the null constructor
	public Rectangle() 
	{
		myWidth = 0;
		myHeight = 0;
		myFillStyle = ' ';
	}//nullConstructor
	
	//Define full constructor to initialize values
	public Rectangle(int newWidth, int newHeight, char newFillStyle)
	{
		myWidth = newWidth;
		myHeight = newHeight;
		myFillStyle = newFillStyle;
	}//fullConstructor
	
	//Define setter to update value of width
	public void setWidth(int newWidth)
	{
		myWidth = newWidth;
	}//setWidth
	
	//Define setter to update value of height
	public void setHeight(int newHeight)
	{
		myHeight = newHeight;
	}//setHeight
	
	//Define setter to update the fill that will be printed in the shape of the rectangle
	public void setFillStyle(char newFillStyle)
	{
		myFillStyle = newFillStyle;
	}//setFillStyle
	
	//Define getter to return the value of width to RectangleDemo.java
	public int getWidth()
	{
		return myWidth;
	}//getWidth
	
	//Define getter to return the value of height to RectangleDemo.java
	public int getHeight()
	{
		return myHeight;
	}//getHeight
	
	//Define getter to return the fill style's value to RectangleDemo.java
	public char getFillStyle()
	{
		return myFillStyle;
	}//getFillStyle
		
	//Define calcArea method that will multiply myWidth by myHeight and return the value when 'A' is chosen
	public int calcArea()
	{
		int area = myWidth*myHeight;
		return area;
	}//calcArea
	
	//Define calcArea method that will multiply myWidth & myHeight by 2 and return the sum of the values
	//when 'P' is chosen
	public int calcPerimeter()
	{
		int perimeter = (myWidth*2) + (myHeight*2);
		return perimeter;
	}//calcPerimeter
	
	//Define drawRectangle which sees how many rows there are in the rectangle and prints the fillStyle for
	//each column in that row
	public void drawRectangle()
	{
		int r = 0;
		int c = 0;
		for (r=0; r<myHeight; r++)
		{
				for (c=0; c<myWidth; c++)
					System.out.print(myFillStyle);
			System.out.println();
		}//for
	}//drawRectangle

	//Define drawOutline which prints fillStyle for each column in the first and last rows.
	//For rows in between, the method prints fillStyle for the first and last columns and " "
	//for every row in between.
	public void drawOutline()
	{
		int r = 0;
		int c = 0;
		for (r=0; r<myHeight; r++)
		{
			if (r == 0)
			{
				for (c=0; c<myWidth; c++)
					System.out.print(myFillStyle);
			}//if
			else if (r == myHeight - 1)
			{
				for (c=0; c<myWidth; c++)
					System.out.print(myFillStyle);
			}//else if
			else
			{
				System.out.print(myFillStyle);
				for (c=0; c<myWidth-2; c++)
					System.out.print(" ");
				System.out.print(myFillStyle);
			}//else
			System.out.println();
		}//for
	}//drawOutline
}//class Rectangle
