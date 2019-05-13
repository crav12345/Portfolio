//
// Christopher Ravosa
// Prog 7
// Due March 26 before 1:30pm
//
// This program will run a menu to create a mix tape CD. The user will be able
// to add and remove songs from the track. The purpose of this program is to 
// continue referencing separate classes from main.
//

public class MixCDRavosa {
	private SongRavosa[] mySongs;
	private int mySize;
	
	//Create empty constructor to initialize all variables and elements of the SongRavosa array
	public MixCDRavosa() {
		int i = 0;
		mySongs = new SongRavosa[12];
			for(i=0;i<mySongs.length;i++)
				mySongs[i] = new SongRavosa("","",0);
		mySize = 0;
	}//empty constructor
	
	//Create full constructor to set values of variables to new values
	public MixCDRavosa(SongRavosa[] newSongs, int newSize) {
		mySongs = newSongs;
		mySize = newSize;
	}//full constructor
	
	//Create setters to set the value of variables to input values
	public void setSongs(SongRavosa[] newSongs) {
		mySongs = newSongs;
	}//setSongs
	
	public void setSize(int newSize) {
		mySize = newSize;
	}//setSize
	
	//Create getters to retrieve the values of the variables
	public SongRavosa[] getSongs() {
		return mySongs;
	}//getSongs
	
	public int getSize() {
		return mySize;
	}//getSize
	
	//Create method to determine whether there is space for the user's new song
	//If there is space, place it in the array. If there is no space, inform the user
	public boolean addToCD(SongRavosa newSong) {
		boolean ans = false;
		if (mySize < mySongs.length)
		{
			mySongs[mySize] = newSong;
			mySize++;
			if (calcRemainingTime()<0)
				ans = false;
			else
				ans = true;
		}//if
		return ans;
	}//addToCD
	
	//Create a method to shuffle through the array and keep track of the longest myRunTime
	public SongRavosa findLongestSong() {
		int i = 0;
		int longestSoFar = 0;
		SongRavosa longestSong = mySongs[0];
		
		for (i=0;i<mySongs.length;i++) {
			if(mySongs[i].getRunTime()>longestSoFar) {
				longestSoFar = mySongs[i].getRunTime();
				longestSong = mySongs[i];
			}//if
		}//for
		return longestSong;
	}//findLongestSong
	
	//Create a method to shuffle through the array and keep track of the shortest myRunTime
	public SongRavosa findShortestSong() {
		int i = 0;
		int shortestSoFar = 4800;
		SongRavosa shortestSong = mySongs[0];
		
		for (i=0;i<mySongs.length;i++) {
			if(mySongs[i].getRunTime()!=0)
				if(mySongs[i].getRunTime()<shortestSoFar) {
					shortestSoFar = mySongs[i].getRunTime();
					shortestSong = mySongs[i];
			}//if
		}//for
		return shortestSong;
	}//findShortestSong

	//Create a method to add the run times of all songs together. Determine how much
	//of the 80 minutes of space are available.
	public int calcRemainingTime() {
		int i = 0;
		int sum = 0;
		int remainingTime = 0;
		for (i=0;i<mySongs.length;i++) {
			sum = sum+mySongs[i].getRunTime();
		}//for
		remainingTime = 4800-sum;
		return remainingTime;
	}//calcRemainingTime
	
	//Shuffle through the array and use songToString method to print a list of the CD
	public void printSongList() {
		int i = 0;
			for (i=0;i<mySongs.length;i++) {
				if (mySongs[i].getTitle()!="")
				System.out.println(mySongs[i].songToString());
			}//for
	}//printSongList

	//Create a method to delete the object with the longest runTime in the array**
	public void deleteLongest() {
		System.out.println("This option is currently out of order.");
	}//deleteLongest
}//MixCDRavosa
