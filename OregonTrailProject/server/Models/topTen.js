//Define a topscore object
function topTen(playerName, playerScore, dateEarned) {
	this.playerName = playerName;
	this.playerScore = playerScore;
	this.dateEarned = dateEarned;
}//topTen

exports.addTopTen = function(playerName, playerScore, dateEarned) {
	return new topTen(playerName, playerScore, dateEarned);
}//addTopTen