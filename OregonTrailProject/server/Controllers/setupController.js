//Require all necessary files
var gameController = require('../controllers/gameController');
var gameData = require('../models/gameData');

//Make HTML contents of each setup screen
var setupScreen1 = "<p>Many kinds of people made the trip to Oregon.</p>"
+ "<p>You may:</p>"
+ "<p class = \"menuText\" id = \"bankerItem\">"
+ "1. Be a banker from Boston ($2000)</p>"
+ "<p class = \"menuText\" id = \"carpenterItem\">"
+ "2. Be a carpenter from Ohio ($1800)</p>"
+ "<p class = \"menuText\" id = \"farmerItem\">"
+ "3. Be a farmer from Illinois ($1500)</p>"
+ "<p class = \"menuText\">Select your choice!</p>";
 
var setupScreen2 = "<p>Who is leading your wagon?</p>"
+ "<form>"
+ "Wagon leader's name: "
+ "<input id = \"player\" type = \"text\" name = \"leaderName\" >"
+ "</form>"
+ "<p class = \"menuText\" id = \"continue\">'Enter' to continue!</p>"
+ "<br/><br/><br/><br/><br/><br/><br/>";
 
var setupScreen3 = "<p>Who else is in your party?</p>"
+ "<form>"
+ "Party member two: "
+ "<input id = \"player2\" type = \"text\" name = \"memberTwo\" >"
+ "</form>"
+ "<form>"
+ "Party member three: "
+ "<input id = \"player3\" type = \"text\" name = \"memberThree\" >"
+ "</form>"
+ "<form>"
+ "Party member four: "
+ "<input id = \"player4\" type = \"text\" name = \"memberFour\" >"
+ "</form>"
+ "<form>"
+ "Party member five: "
+ "<input id = \"player5\" type = \"text\" name = \"memberFive\" >"
+ "</form>"
+ "<p class = \"menuText\" id = \"continue\">'Enter' to continue!</p>"
+ "<br/><br/><br/><br/>";
 
var setupScreen4 = "<p>What month will you start your journey?</p>"
+ "<p class = \"menuText\" id = \"marchItem\">1. March</p>"
+ "<p class = \"menuText\" id = \"aprilItem\">2. April</p>"
+ "<p class = \"menuText\" id = \"mayItem\">3. May</p>"
+ "<p class = \"menuText\" id = \"juneItem\">4. June</p>"
+ "<p class = \"menuText\" id = \"julyItem\">5. July</p>"
+ "<p class = \"menuText\">Select your choice!</p>";

//var setupScreen5 = display profession, party, and month;
var setupScreen5 = "<p>Looks like you're about ready to go,</p>"
+ "<p id = \"goTrail\">     press 'Enter' to continue!</p>"
+ "<br/>"
+ "<br/>";


//Make setupScreens array
exports.setupScreens = [];
exports.setupScreens.push(setupScreen1);
exports.setupScreens.push(setupScreen2);
exports.setupScreens.push(setupScreen3);
exports.setupScreens.push(setupScreen4);
exports.setupScreens.push(setupScreen5);

//Returns JSON of playerNames in gameData
exports.getPlayers = function(req, res) {
	res.setHeader('Content-Type', 'application/json');
	res.send(gameData.gameSettings.playerNames);
}//getPlayers

//Gets playerName and playerId from JSON post request and saves a new player
exports.savePlayer = function(req, res) {
	var newPlayer = gameData.addPlayer
		(req.body.playerName, req.body.playerId);
	gameData.gameSettings.playerNames.push(newPlayer);
	res.setHeader('Content-Type', 'application/json');
	res.send(req.body);
}//savePlayer

//Gets playerProfession from JSON post request & saves profession of leader
exports.saveProfession = function(req, res) {
	gameData.gameSettings.playerProfession = req.body.profession;
	
	//Grant cash based on wagon leader's profession
	if(gameData.gameSettings.playerProfession == "farmer")
		gameData.gameSettings.playerMoney = 1500;
	else if(gameData.gameSettings.playerProfession == "carpenter")
		gameData.gameSettings.playerMoney = 1800;
	else
		gameData.gameSettings.playerMoney = 2000;
		
	res.setHeader('Content-Type', 'application/json');
	res.send(req.body);
}//saveProfession

//Gets startMonth from JSON post request and saves it
exports.saveStartMonth = function(req, res) {
	gameData.gameSettings.startMonth = req.body.startMonth;
	res.setHeader('Content-Type', 'application/json');
	res.send(req.body);
}//saveStartMonth

//Gets ID of gameScreen from JSON request for setup's single-page-application
exports.getGameScreen = function(req, res) {
	var gameScreen = req.params.id;
	console.log(gameScreen);
	res.setHeader('Content-Type', 'application/json');
	res.send(exports.setupScreens[gameScreen]);
}//getGameScreen
