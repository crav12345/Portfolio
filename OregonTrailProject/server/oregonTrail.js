//Require necessary module and call it
const express = require('express');
const app = express();


//Use express to start server
app.use(express.static('client/public'));
const port = 1337;


//Allows server to read JSON
var bodyParser = require('body-parser');
app.use(bodyParser.json({type: 'application/json'}));


//Require necessary modules
var gameController = require('./controllers/gameController');
var topTenController = require('./controllers/topTenController');
var setupController = require('./controllers/setupController');

//Tell server how to respond when user searches for files
app.get('/', function (req, res) {
	res.sendFile('index.html', {root: 'client/views'})
});
app.get('/mainmenu', function (req, res) {
	res.sendFile('mainmenu.html', {root: 'client/views'})
});
app.get('/topten', function (req, res) {
	res.sendFile('topten.html', {root: 'client/views'})
});
app.get('/setup', function (req, res) {
	res.sendFile('setup.html', {root: 'client/views'})
});
app.get('/trail', function (req, res) {
	res.sendFile('trail.html', {root: 'client/views'})
});


//Routes for Game Controller
app.route('/api/gameData')
	.get(gameController.getGameData);
app.route('/api/changePace')
	.get(gameController.getPace)
	.post(gameController.changePace);
app.route('/api/updateGame')
	.get(gameController.updateGame);
app.route('/api/resetGame')
	.get(gameController.resetGame);
app.route('/api/getTerrain')
	.get(gameController.getTerrain);
	

//Route for topTenController
app.route('/api/topTen')
	.get(topTenController.getTopScores)
	.post(topTenController.setNewTopScore);


//Routes for setup
app.route('/api/setup/screen/:id')
	.get(setupController.getGameScreen);
app.route('/api/setup/players')
	.get(setupController.getPlayers)
	.post(setupController.savePlayer);
app.route('/api/setup/saveProfession')
	.post(setupController.saveProfession);
app.route('/api/setup/saveStartMonth')
	.post(setupController.saveStartMonth);

//Print message to let you know server is running
app.listen(port, () => console.log("Server listening on port " + 
port + "!"));

//Win/loss conditions
//Wagon needs to travel across screen