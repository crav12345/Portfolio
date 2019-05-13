//Define terrain objects
function terrain(name, imageUrl, milesCovered) {
	this.name = name;
	this.imageUrl = imageUrl;
	this.milesCovered = milesCovered;
}//terrain

//Store all terrains in a private array
allTerrains = [];
allTerrains.push(new terrain("Plains", 
	'./images/countryNoTree.png', 1));
allTerrains.push(new terrain("Forest",
	'./images/forestBack.jpg', 1));
allTerrains.push(new terrain("Mountains",
	'./images/mountainsBack.png', 1));
allTerrains.push(new terrain("Desert",
	'./images/monumentValleyPixels.jpg', 1));

//Make terrain array available
exports.getAllTerrains = allTerrains;

//Function to get a random terrain object
 exports.generateTerrain = function() {
	//generate a random number between 0 and 100
	var random = Math.floor(Math.random() * 100);
	var newTerrain;
	if (random < 25)
		newTerrain = allTerrains[0];
	else if (random < 50)
		newTerrain = allTerrains[1];
	else if (random < 75)
		newTerrain = allTerrains[2];
	else
		newTerrain = allTerrains[3];
	
	return newTerrain;
}//getRandomTerrain