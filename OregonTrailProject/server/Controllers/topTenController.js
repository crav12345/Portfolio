//Require necessary file
var topTen = require('../models/topTen');
var mysql = require('mysql');


//Enter password to connect to SQL
var con = mysql.createConnection({
	host: "localhost",
	user: "root",
	password: "Whopper1!"
});


//Connect to ottopten DB 
con.connect(function(err){
	if (err) throw err;
	console.log("MySQL DB Connected!");
	var sql = "use ottopten;";
	con.query(sql, function (err, result){
		if (err) throw err;
	});
});//connected


//Function to respond with topTen array
exports.getTopScores = function(req, res) {
	var sql = "select playerName, playerScore, playerDate from topTen order " +
	"by playerScore desc limit 10;";
	var myArray = [];
	con.query(sql, function  (err, rows, fields) {
		if (err) throw err;
		for(var i = 0; i < rows.length; i++) {
			myArray[i] = topTen.
			addTopTen(rows[i].playerName,
			rows[i].playerScore,
			rows[i].playerDate)
		}//for
		res.setHeader('Content-Type', 'application/json');
		res.send(topTen);
	});//con.query
}//getTopTen


//Function to store a new score
exports.setNewTopScore = function(req, res) {
	var sql = "insert into topten (playerName, playerScore, playerDate) values " +
	"(\'" + req.body.playerName + "\',\'" + req.body.playerScore + "\',\'" + 
	req.body.playerDate + "\');";
	con.query(sql, function (err, res) {
		if (err) throw err;
		console.log('Score Added!');
	});//con.query
	res.setHeader('Content-Type', 'application/json');
	res.send(req.body);
}//setNewTopScore