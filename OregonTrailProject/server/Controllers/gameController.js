//Require all necessary files
var pace = require('../models/pace');
var terrain = require('../models/terrain');
var weather = require('../models/weather');
var gameData = require('../models/gameData');

var health = gameData.gameSettings.groupHealth;
var statusArray = gameData.gameSettings.playerStatus;
var paceArray = pace.allPaces;
var daysPassed = 0;

//Make gameData available
exports.getGameData = function(req, res) {
	//return JSON of the game data
	res.setHeader('Content-Type', 'text/html');
	res.send(gameData.gameSettings);
}//getGameData

exports.getTerrain = function(req, res) {
	res.setHeader('Content-Type', 'application/json');
	res.send(gameData.gameSettings.currentTerrain);
}//getTerrain

//Get the current pace
exports.getPace = function(req, res) {
	res.setHeader('Content-Type', 'application/json');
	res.send(gameData.gameSettings.currentPace);
}//getPace

//Set pace to user's selection
exports.changePace = function(req, res){
	var input = req.body.id;
	gameData.gameSettings.currentPace = paceArray[input - 1];
	res.setHeader('Content-Type', 'application/json');
	res.send(paceArray[input - 1]);
}//setPace

//Update all data to move to the next day
exports.updateGame = function(req, res) {
	//Don't need to update names, profession, money, or start month
	//Pace is updated as a post
	updateTerrain();
	updateWeather();
	daysPassed ++;
	gameData.gameSettings.daysOnTrail = daysPassed;
	updateHealth();
	updateStatus();
	updateMiles();
	gameData.gameSettings.messages = dailyMessage();
	console.log(gameData.gameSettings);
	res.setHeader('Content-Type', 'application/json');
	res.send(gameData.gameSettings);
}//updateGame

//Reset all data to start a new game
exports.resetGame = function(req, res) {
	gameData.gameSettings.playerNames = [];
	gameData.gameSettings.playerStatus = [true, true, true, true, true];
	gameData.gameSettings.playerProfession = "";
	gameData.gameSettings.playerMoney = null;
	gameData.gameSettings.startMonth = "";
	gameData.gameSettings.milesTraveled = 0;
	gameData.gameSettings.groupHealth = 100;
	gameData.gameSettings.daysOnTrail = 0;
	gameData.gameSettings.currentPace = pace.allPaces[0];
	gameData.gameSettings.currentTerrain = terrain.getRandomTerrain;
	gameData.gameSettings.currentWeather = weather.getRandomWeather;
	gameData.gameSettings.messages = "";
	
	res.setHeader('Content-Type', 'application/json');
	res.send(gameData.gameSettings);
}//resetGame

//Edit groupHealth based on health effects
function updateHealth() {
	var healthEffect; 
	
	//If gameSettings current pace is resting
	if(gameData.gameSettings.currentPace == pace.allPaces[3])
		healthEffect = +5;
	//If gameSettings current pace is anything else
	else {
		healthEffect = gameData.gameSettings.currentWeather.healthChange +
			gameData.gameSettings.currentPace.healthChange;
	}//else
	console.log("The healthEffect is: " + healthEffect);

	health = health + healthEffect;
	
	if (health > 100)
		health = 100;
	if (health < 0)
		health = 0;
	
	gameData.gameSettings.groupHealth = health;
}//updateHealth

//Edit living and dead members by probability based on groupHealth
function updateStatus() {
	var random = 0;
	if (health >= 80)
		console.log('The party is in good health');
	else if (health >= 50)
		console.log('The party is in fair health');
	else if(health >= 20 && health < 50){
		console.log('The party is in poor health');
		for (var i in statusArray){
			if (statusArray[i] == true){
				random = Math.floor(Math.random() * 100) +1;
				if (random < 4)
					statusArray[i] = false;
			}//if
		}//for
	}//else if
	else if (health > 0 && health < 20){
		console.log('The party is in very poor health');
		for (var i in statusArray){
			if (statusArray[i] == true){
				random = Math.floor(Math.random() * 100) +1;
				if (random < 11)
					statusArray[i] = false;
			}//if
		}//for
	}//else if
	else {
		for (var i in statusArray) {
			if (statusArray[i] == true)
				statusArray[i] = false;
		}//for
		console.log('There are no living party members');
	}//else
}//updateStatus

//Edit milesTraveled
function updateMiles() {
	var totalMiles = gameData.gameSettings.milesTraveled;
	var milesToday = gameData.gameSettings.currentPace.miles;
	var mileMod = gameData.gameSettings.currentWeather.mileChange;
	totalMiles = totalMiles + (milesToday * mileMod);
	gameData.gameSettings.milesTraveled = totalMiles;
}//updateMiles

//Display a message each day to express # of living members
function dailyMessage(){
	livingMembers = 5;
	var newMessage = "";
	for (var i in statusArray){
		if (statusArray[i] == false)
			livingMembers--;
	}//for
	if(livingMembers > 0)
		newMessage = "There are " + livingMembers + " living party members.";
	else
		newMessage = "GAME OVER: The party has died";
	return newMessage
}//dailyMessage

//Get a random terrain for the next day
function updateTerrain(){
	gameData.gameSettings.currentTerrain = terrain.generateTerrain();
}//updateTerrain

//Get a random weather for the next day
function updateWeather(){
	gameData.gameSettings.currentWeather = weather.generateWeather();
}//updateWeather