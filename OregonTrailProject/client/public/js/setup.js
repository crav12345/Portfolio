//Declare all necessary variable
var currentScreen = 0;
var myProfession = "";
var month = "";
var player1 = "";
var player2 = "";
var player3 = "";
var player4 = "";
var player5 = "";

//Reset the screen at the beginning of the async app
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

//Get screen fetch
function getScreen(screenId) {
	fetch('/api/setup/screen/'+screenId)
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! "
			+ res.status + " msg: " + res.value);
			return;
		}//if
		res.text().then(function(data) {
			menuItems.innerHTML = data;
		});//res
	});//promise
}//getScreen


//Save profession fetch
function saveProfession(profession) {
	console.log('Profession: ' + profession);
	fetch('/api/setup/saveProfession', {
		method: 'POST',
		headers: {
			'Content-type': 'application/json; charset = UTF-8'
		},//headers
		body: JSON.stringify({"profession": profession}),
	})//fetch
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! "
			+ res.status + " msg: " + res.value);
			return;
		}//if
		else {
			currentScreen++;
			getScreen(currentScreen);
		}//else
	});//promise
}//saveProfession


//Save the input from the playerName forms
function savePlayer(name, id) {
	fetch('/api/setup/players', {
		method: 'POST',
		headers: {
			'Content-type': 'application/json; charset = UTF-8'
		},//headers
		body: JSON.stringify({"playerName" : name, "playerId": id}),
	})//fetch
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! " 
			+ res.status + " msg: " + res.value);
			return;
		}//if
		else {
			console.log('Name: ' + name);
		}//else
	});//promise
}//savePlayer



//Save month fetch
function saveStartMonth(month) {
	console.log('We will leave in ' + month);
	fetch('api/setup/saveStartMonth', {
		method: 'POST',
		headers: {
			'Content-type': 'application/json; charset = UTF-8'
		},//headers
		body: JSON.stringify({"startMonth": month}),
	})//fetch
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! " 
			+ res.status + " msg: " + res.value);
			return;
		}//if
		else {
			currentScreen++;
			getScreen(currentScreen);
		}//else
	});//promise
}//saveStartMonth


//Call screen
getScreen(currentScreen);


//Check what user clicks on
document.addEventListener('keypress', function menuOption(event) {
	if (currentScreen == 0) {
		
		//look for menu item
		if (event.key === '1') {
			saveProfession("banker");
			myProfession = "banker";
		}//if
		else if (event.key === '2') {
			saveProfession("carpenter");
			myProfession = "carpenter";
		}//else if
		else if (event.key === '3') {
			saveProfession("farmer");
			myProfession = "farmer";
		}//else if
	}//if
	
	else if (currentScreen == 1) {
		if (event.keyCode === 13) {
			player1 = document.getElementById('player').value;
			savePlayer(player1, '1');
			currentScreen++;
			getScreen(currentScreen);
		}//if
	}//else if
	
	else if (currentScreen == 2) {
		if (event.keyCode === 13) {
			player2 = document.getElementById('player2').value;
				savePlayer(player2, '2');
			player3 = document.getElementById('player3').value;
				savePlayer(player3, '3');
			player4 = document.getElementById('player4').value;
				savePlayer(player4, '4');
			player5 = document.getElementById('player5').value;
				savePlayer(player5, '5');
			currentScreen++;
			getScreen(currentScreen);
		}//if
	}//else if
	
	else if (currentScreen == 3) {
		
		if (event.key === '1') {
			saveStartMonth("March");
			month = "March";
			getScreen(currentScreen);
		}//if
		else if (event.key === '2') {
			saveStartMonth("April");
			month = "April";
			getScreen(currentScreen);
		}//else if
		else if (event.key === '3') {
			saveStartMonth("May");
			month = "May";
			getScreen(currentScreen);
		}//else if
		else if (event.key === '4') {
			saveStartMonth("June");
			month = "June";
			getScreen(currentScreen);
		}//else if
		else if (event.key === '5') {
			saveStartMonth("July");
			month = "July";
			getScreen(currentScreen);
		}//else if
		console.log(currentScreen);
	}//else if
	
	else {
		console.log('Screen 4 has arrived');
		if (event.keyCode === 13){
				window.location.href = 'trail', {root: 'client/views'};
		}//if
	}//else
});//end of setup