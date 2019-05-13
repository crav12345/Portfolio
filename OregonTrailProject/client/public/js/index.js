/* This function session-stores the value of the 
var toggle (audio's current play state).
sessionStorage.toggle is then used by global.js
to determine whether music should play. */

function toggleStorage() {
	if(typeof(Storage) !== "undefined") {
		sessionStorage.toggle = Number(1);
	}//if
	else {
		console.log("Sorry, your browser does not support web storage...");
	}//else
}//toggleStorage

toggleStorage();

console.log(sessionStorage.toggle);