//variable declares mp3 audio file
var audio = new Audio('/music/countryRoads.mp3');

/*check session storage for the value of .toggle and determine whether 
to play audio*/
var toggle = sessionStorage.toggle;
console.log(toggle);
if (toggle == 1){
	console.log("Music is playing")
	audio.play();
}//if
	
//Check to see if the document has a "return to menu" message
if (document && document.getElementById("goMenu")){
	/*if the user presses a key, the system checks if it is the spacebar and 
	gets the mainmenu document, also resets gameSettings*/
	document.addEventListener('keypress', function pressSpace(space) {
		if (space.key === ' ') {
			space.preventDefault();
			console.log('Space pressed');
			window.location.href = 'mainmenu', {root: 'client/views'};
		}//if
	});//pressSpace
	
	/*if the user clicks the paragraph element with the id "goMenu", the system
	gets the mainmenu document, also resets gameSettings*/
	document.getElementById("goMenu").addEventListener("click", clickStart);
	function clickStart() {
		window.location.href = 'mainmenu', {root: 'client/views'};
	}//clickStart
}//if