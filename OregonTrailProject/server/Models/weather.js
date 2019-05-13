//Define weather objects
function weather(id, type, healthChange, mileChange, probability) {
	this.id = id;
	this.type = type;
	this.healthChange = healthChange;
	this.mileChange = mileChange;
	this.probability = probability;
}//weather

//Store all weathers in a private array
var allWeathers = [];
allWeathers.push(new weather(1, 'Very Hot', -8, .7, .1));
allWeathers.push(new weather(2, 'Hot', -3, .9, .1));
allWeathers.push(new weather(3, 'Warm', +1, 1, .2));
allWeathers.push(new weather(4, 'Cool', +1, .95, .1));
allWeathers.push(new weather(5, 'Cold', -5, .8, .1));
allWeathers.push(new weather(6, 'Very Cold', -12, .7, .1));
allWeathers.push(new weather(7, 'Rain', -4, .6, .1));
allWeathers.push(new weather(8, 'Heavy Rain', -8, .4, .05));
allWeathers.push(new weather(9, 'Snow', -15, .3, .05));
allWeathers.push(new weather(10, 'Blizzard', -30, .1, .05));
allWeathers.push(new weather(11, 'Heavy Fog', -3, .5, .05));

//Make weather array available
exports.getAllWeathers = allWeathers;

//Function to get a random weather
exports.generateWeather = function() {
	//generate random integer between 0 and 100
	var random = Math.floor(Math.random() * 100);
	var newWeather = null;
	
	//Find a weather based on its probability and the random int
	if (random < 10)
		newWeather = allWeathers[0];
	else if (random < 20)
		newWeather = allWeathers[1];
	else if (random < 40)
		newWeather = allWeathers[2];
	else if (random < 50)
		newWeather = allWeathers[3];
	else if (random < 60)
		newWeather = allWeathers[4];
	else if (random < 70)
		newWeather = allWeathers[5];
	else if (random < 80)
		newWeather = allWeathers[6];
	else if (random < 85)
		newWeather = allWeathers[7];
	else if (random < 90)
		newWeather = allWeathers[8]
	else if (random < 95)
		newWeather = allWeathers[9]
	else
		newWeather = allWeathers[10]

	return newWeather;
}//generateWeather