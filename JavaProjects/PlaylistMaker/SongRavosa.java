//
// Christopher Ravosa
// Prog 7
// Due March 26 before 1:30pm
//
// This program will run a menu to create a mix tape CD. The user will be able
// to add and remove songs from the track. The purpose of this program is to 
// continue referencing separate classes from main.
//
public class SongRavosa {
	private String myTitle;
	private String myArtist;
	private int myRunTime;
	
	//Create empty constructor to initialize variables
	public SongRavosa() {
		myTitle = "";
		myArtist = "";
		myRunTime = 0;
	}//empty constructor
	
	//Create full constructor to set variables to new inputs
	public SongRavosa(String newTitle, String newArtist, int newRunTime) {
		myTitle = newTitle;
		myArtist = newArtist;
		myRunTime = newRunTime;
	}//full constructor
	
	//Create setters to change values of variables
	public void setTitle(String newTitle) {
		myTitle = newTitle;
	}//setTitle
	
	public void setArtist(String newArtist) {
		myArtist = newArtist;
	}//setArtist
	
	public void setRunTime(int newRunTime) {
		myRunTime = newRunTime;
	}//setRunTime
	
	//Create getters to retrieve values of variables
	public String getTitle() {
		return myTitle;
	}//getTitle
	
	public String getArtist() {
		return myArtist;
	}//getArtist
	
	public int getRunTime() {
		return myRunTime;
	}//getRuntime

	//Create a method to create a descriptive string out of a SongRavosa object
	public String songToString() {
		String songDetails = myTitle + " by " + myArtist + ", Run Time: " + myRunTime/60 + " minutes and "
				+ myRunTime%60 + " seconds.";
		return songDetails;
	}//songToString
	
}//SongRavosa
