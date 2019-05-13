//check if music should be playing and make a variable to display on/off
if (sessionStorage.toggle == 1){
	var musicState = 1;
	document.getElementById('goMusic').innerHTML = 'Turn sound OFF';
}//if
else {
	musicState = 0;
	document.getElementById('goMusic').innerHTML = 'Turn sound ON';
}//else

/*This function session stores the value of var toggle (audio's 
current play state) based on on/off display*/
function toggleStorage() {
	if(typeof(Storage) !== "undefined") {
		sessionStorage.toggle = Number(musicState);
	}//if
	else {
		console.log("Sorry, your browser does not support web storage...");
	}//else
}//toggleStorage

//function to check which key is pressed and which action to perform
document.addEventListener('keypress', function menuOption(event) {
	//if '1' then get setup.html
	if (event.key === '1') {
		event.preventDefault();
		console.log('Travel the Trail');
		window.location.href = 'setup', {root: 'client/views'};
	}//if
	//if '2' then get Oregon Trail wikipedia
	else if  (event.key === '2') {
		event.preventDefault();
		console.log('Opening wikipedia I guess');
		window.open("https://en.wikipedia.org/wiki/The_Oregon_Trail_(series)");
	}//else if
	//if '3' then get topTen.html
	else if (event.key === '3') {
		event.preventDefault();
		console.log('Top Ten List');
		window.location.href = 'topTen', {root: 'client/views'};
	}//else if
	//if '4' then toggle music on/off
	else if (event.key === '4') {
		event.preventDefault();
		//check if the music is on and turn it off
		if (musicState == 1){
			document.getElementById('goMusic').innerHTML = 'Turn sound ON';
			musicState--;
			console.log('Toggled Music Off');
			toggleStorage();
		}//if
		//check if the music is off and just bump the tunes man
		else {
			document.getElementById('goMusic').innerHTML = 'Turn sound OFF';
			musicState++;
			console.log('Toggled Music On');
			toggleStorage();
		}//else
		if (sessionStorage.toggle == 1){
			audio.play();
		}//if
		else {
			audio.pause();
		}//else
	}//else if
});//menuOption