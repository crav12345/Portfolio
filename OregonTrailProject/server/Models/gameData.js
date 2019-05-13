//Require necessary files
var pace = require('../models/pace');
var weather = require('../models/weather');
var terrain = require('../models/terrain');

//Define gameData object
function gameData(playerNames, playerStatus, playerProfession, playerMoney,
	startMonth, milesTraveled, groupHealth, daysOnTrail, currentPace, 
	currentWeather, currentTerrain, messages) {
		this.playerNames = playerNames;
		this.playerStatus = playerStatus;
		this.playerProfession = playerProfession;
		this.playerMoney = playerMoney;
		this.startMonth = startMonth;
		this.milesTraveled = milesTraveled;
		this.groupHealth = groupHealth;
		this.daysOnTrail = daysOnTrail;
		this.currentPace = currentPace;
		this.currentWeather = currentWeather;
		this.currentTerrain = currentTerrain;
		this.messages = messages;
}//gameData

//Define player object
function player(playerName, playerId){
	this.playerName = playerName;
	this.playerId = playerId;
}//player

//Function to add a player
exports.addPlayer = function(playerName, playerId){
	return new player(playerName, playerId);
}//addPlayer

//Make gameData object available for manipulation during gameplay
exports.gameSettings = new gameData([], [true, true, true, true, true], "",	
	null, "", 0, 100, 0, pace.allPaces[0], weather.getRandomWeather, 
	terrain.getRandomTerrain, "");