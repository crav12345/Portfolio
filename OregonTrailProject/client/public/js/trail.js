//Update pace based on the input from the user
function updatePace(id) {
	fetch('api/changePace',{
		method: 'POST',
		headers: {
			'Content-type': 'application/json; charset = UTF-8'
		},//headers
		body: JSON.stringify({"id": id}),
	})//fetch
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! "
			+ res.status + " msg: " + res.value);
			return;
		}//if
		res.text().then(function(data) {
			console.log(data);
		});//res
	})//promise
}//setPace

//Display game data in console and on UI
function getGameData() {
	fetch('/api/gameData')
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! "
			+ res.status + " msg: " + res.value);
			return;
		}//if
		else{
			res.json().then(function(data) {
				updateDisplay(data);
				return data;
			});//res
		}//else
	})//promise

	function updateDisplay(input) {
		var alive = 5;
		var image = input.currentTerrain.imageUrl;
		var myArray = input.playerStatus;
		for (i = 0; i < myArray.length; i++){
			if(myArray[i] == false)
				alive--;
		}//for
		document.getElementById("party").innerHTML = 
			alive;
		document.getElementById("terrain").innerHTML = 
			input.currentTerrain.name;
		document.getElementById("image").innerHTML = 
			"<img id = \"terrainImage\" src = \"" + image + "\" >";
		document.getElementById("health").innerHTML = 
			input.groupHealth;
		document.getElementById("miles").innerHTML = 
			input.milesTraveled;
		document.getElementById("daysPassed").innerHTML = 
			input.daysOnTrail;
		document.getElementById("weather").innerHTML = 
			input.currentWeather.type;
	}//updateDisplay
}//getGameData

//Update the game
function updateGame() {
	fetch('/api/updateGame')
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! " 
			+ res.status + " msg: " + res.value);
			return;
		}//if
		res.text().then(function(data){
			console.log(data);
		});//res
	})//promise
}//updateGame

//Set the display to what the day 0 values are
function initDisplay(){
	document.getElementById("terrain").innerHTML = " The path ahead is clear";
	document.getElementById("health").innerHTML = "100";
	document.getElementById("party").innerHTML = "5";
	document.getElementById("miles").innerHTML = "0";
	document.getElementById("weather").innerHTML = " A good day to travel";
	document.getElementById("pace").innerHTML = " Steady";
	document.getElementById("daysPassed").innerHTML = " 0";
}//displayPace

initDisplay();

//Change pace display
function displayPace(id) {
	document.getElementById("pace").innerHTML = id;
}//displayPace

//Check for win
/*function checkWin(){
	fetch('/api/gameData')
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! "
			+ res.status + " msg: " + res.value);
			return;
		}//if
		else{
			res.json().then(function(data) {
				console.log(data.milesTraveled);
				if(data.milesTraveled >= 450) {
					alert("YOU SURVIVED THE TRAIL!");
					fetch('/api/resetGame')
					.then(function(res) {
						if (res.status !== 200) {
							console.log("Oops, an error occurred! "
							+ res.status + " msg: " + res.value);
						return;
						}//if
						else
							console.log('game reset');
					});//promise
				}//if
			});//res
		}//else
	})//promise
}//checkWin*/


//Execute functions based on user input
document.addEventListener("keypress", playerOption);
function playerOption() {
	
	console.log(event.key);
	
	//If user presses 1,2,3, or 4, update the pace
	if (event.key === '1'){
		console.log("I'll change the pace to steady!");
		updatePace(1);
		displayPace("Steady");
	}//else if
	else if (event.key === '2'){
		console.log("I'll change the pace to strenuous!");
		updatePace(2);
		displayPace("Strenuous");
	}//else if
	else if (event.key === '3'){
		console.log("I'll change the pace to grueling!");
		updatePace(3);
		displayPace("Grueling");
	}//else if
	else if (event.key === '4'){
		console.log("I'll change the pace to resting!");
		updatePace(4);
		displayPace("Resting");
	}//else if
	
	//If user presses enter, update the game and display
	else if (event.key === 'Enter') {
		console.log("I'll update the game for you!");
		updateGame();
		getGameData();
		document.getElementById('wagon')
		if(checkWin() == true)
			alert("You survived the trail!");
	}//else if
}//paceOption