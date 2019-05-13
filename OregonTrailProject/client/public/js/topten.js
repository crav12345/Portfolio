//I commented all this out because it prevented my party members from
// dying for some reason.

//Using the array from SQL, call setTopTen
/*function getTopTen(){
	fetch('/api/topTen')
	.then(function(res) {
		if (res.status !== 200) {
			console.log("Oops, an error occurred! "
			+ res.status + " msg: " + res.value);
			return;
		}//if
		else {
			res.json().then(function(data) {
				console.log(data);
				setTopTen(data);
			});//res
		}//else
	})//.then
}//getTopTen


//Given the array, convert to HTML and display it
function setTopTen(input) {
	console.log(input);
	var topTen = [];
	var parser = JSON.parse(input);
	
	for (i in parser) {
		topTen.push(parser[i]);
		console.log(topTen[i]);
	}//for
	
	var myHtml = 
	"<ol>" +
		"<li id = \"topScore1\">" + topTen[0] + "</li>" +
		"<li id = \"topScore1\">" + topTen[1] + "</li>" +
		"<li id = \"topScore1\">" + topTen[2] + "</li>" +
		"<li id = \"topScore1\">" + topTen[3] + "</li>" +
		"<li id = \"topScore1\">" + topTen[4] + "</li>" +
		"<li id = \"topScore1\">" + topTen[5] + "</li>" +
		"<li id = \"topScore1\">" + topTen[6] + "</li>" +
		"<li id = \"topScore1\">" + topTen[7] + "</li>" +
		"<li id = \"topScore1\">" + topTen[8] + "</li>" +
		"<li id = \"topScore1\">" + topTen[9] + "</li>" +
	"</ol>";

	document.getElementById('topTen').innerHTML = (myHtml);
	
}//setTopTen


//new object type topScorer
function topScore (gamerTag, date, score) {
	this.gamerTag = gamerTag;
	this.date = date;
	this.score = score;
}//topScorer

/*when the page loads, this function will print the array backwards to display
highest value first*/
window.addEventListener('load', function(){
	getTopTen();
	/*var theTopTenList = document.getElementById('topTen');
	var counter = 0;
	for(var i = 9; i > -1; i--) {
		counter++;
		console.log(leaders[i].gamerTag);
		theTopTenList.innerHTML += (counter) + ". " + leaders[i].score + "  " +
			leaders[i].gamerTag + "  " + leaders[i].date + "<br /><br />";
	}//for*/
});//function*/