//
// Christopher Ravosa
// Prog 7
// Due March 26 before 1:30pm
//
// This program will run a menu to create a mix tape CD. The user will be able
// to add and remove songs from the track. The purpose of this program is to 
// continue referencing separate classes from main.
//

import java.util.*;

public class MusicDemoRavosa {

	public static void main(String[] args) {

		//Define variables for main method
		Scanner input = new Scanner(System.in);
		String temp = "";
		char choice = 'k';
		int valid = 1;
		int songRunTime = 0;
		String songTitle = "";
		String songArtist = "";
		int minutes = 0;
		int seconds = 0;
		int minutesToSeconds = 0;
		
		//Create a new instance variable
		MixCDRavosa myCD = new MixCDRavosa();			
		
		//Wrap menu in while loop to repeat the menu after actions are done
		while (valid == 1)
		{
			//Display menu
			System.out.println("Enter the character that corresponds with the action you'd like to perform:");
			System.out.println("A : Add a song to the CD");
			System.out.println("L : Find the song with the longest runtime");
			System.out.println("S : Find the song with the shortest runtime");
			System.out.println("N : Find the number of songs on the CD");
			System.out.println("R : Find the total remaining time of the CD");
			System.out.println("P : Print out details about all the songs on the CD");
			System.out.println("D : Delete the longest song from the CD");
			System.out.println("Q : Quit");
			//Store user's input
			temp = input.next();
			choice = temp.charAt(0);
		
			//Use a switch to determine which method to run based on user input
			switch(choice)
			{
				case 'a':
				case 'A':
					//Prompt user for song details and convert minutes and seconds to just seconds
					System.out.println("Enter the details of the song:");
					System.out.println("Title: ");
					songTitle = input.next();
					System.out.println("Artist: ");
					songArtist = input.next();
					System.out.println("Runtime minutes and seconds (enter separately). ");
					System.out.println("Minutes: ");
					minutesToSeconds = input.nextInt()*60;
					System.out.println("Seconds: ");
					seconds = input.nextInt();
					songRunTime = minutesToSeconds+seconds;
					SongRavosa mySong = new SongRavosa(songTitle, songArtist, songRunTime);
					//Attempt to add the song to the CD and inform the user what happens
					if(myCD.addToCD(mySong)==true)
						System.out.println("New song added to CD.");
					else if (myCD.getSize()==12)
						System.out.println("Song not added, the CD is full.");
					else
						System.out.println("Song not added, the CD is limited to 80 minutes of music.");
					break;
				case 'l':
				case 'L':
					//Display longest song
					if (myCD.getSize()>0)
						System.out.println("The longest song is: " + (myCD.findLongestSong()).songToString());
					else
						System.out.println("The CD is empty.");
					break;
				case 's':
				case 'S':
					//Display shortest song
					if (myCD.getSize()>0)
						System.out.println("The shortest song is: " + (myCD.findShortestSong()).songToString());
					else
						System.out.println("The CD is empty.");
					break;
				case 'n':
				case 'N':
					//Display number of songs
					System.out.println("Number of songs on the CD: " + myCD.getSize());
					break;
				case 'r':
				case 'R': 
					//Display unused space on the CD in minutes and seconds
					minutes = myCD.calcRemainingTime()/60;
					seconds = myCD.calcRemainingTime()%60;
					System.out.println("Unused space on CD: " + minutes + " minute(s) and " + 
							seconds + " second(s).");
					break;
				case 'p':
				case 'P':
					//if the CD is not empty, display all songs on the CD
					if(myCD.getSize()>0)
					{
						System.out.println("Songs on your CD: ");
						myCD.printSongList();
						System.out.println();
					}//if
					else
						System.out.println("The CD is empty.");
					break;
				case 'd':
				case 'D':
					//Supposed to delete longest song, couldn't figure out how to remove an item from an array
					if (myCD.getSize()>0) {
						myCD.deleteLongest();
					}//if
					else
						System.out.println("The CD is empty.");
					break;
				case 'q':
				case 'Q':
					//Terminate program
					System.out.println("Goodbye!");
					valid = 0;
					break;
				//Default/bad values just loops the menu again and informs the user of the bad value
				default:
					System.out.println("Invalid input");
					break;
			}//switch
		}//while
		//close the Scanner object
		input.close();
	}//main
}//MusicDemoRavosa