//Define pace objects
function pace(name, miles, healthChange) {
	this.name = name;
	this.miles = miles;
	this.healthChange = healthChange;
}//pace

//Store all paces
exports.allPaces = [];
exports.allPaces.push(new pace("Steady", 20, 0));
exports.allPaces.push(new pace("Strenuous", 30, -3));
exports.allPaces.push(new pace("Grueling", 35, -8));
exports.allPaces.push(new pace("Resting", 0, 5));

//Make pace array available
exports.getAllPaces = exports.allPaces;