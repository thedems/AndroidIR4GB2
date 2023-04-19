/*
* Copyright (c) 1998, Regents of the University of California
* All rights reserved.
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*
*     * Redistributions of source code must retain the above copyright
*       notice, this list of conditions and the following disclaimer.
*     * Redistributions in binary form must reproduce the above copyright
*       notice, this list of conditions and the following disclaimer in the
*       documentation and/or other materials provided with the distribution.
*     * Neither the name of the University of California, Berkeley nor the
*       names of its contributors may be used to endorse or promote products
*       derived from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND ANY
* EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
* WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY
* DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
var myVar;
var plateformes = new Array();
var heros;

function initialisation() {
	createPlateformes(0, 150000);
	GAME_PAUSE = true;

	heros = new Doodle();
	heros.print();
	heros.jump(30);	
}

function pauseButtonPrint() {
	//canvas.drawImage(BUTTON_PAUSE, 368, 0);
}

function rand(min, max) {
	return Math.floor(Math.random() * (max - min + 1) + min);
}

function addPoint(point) {
	currentPoint += point;
	document.getElementById('score').innerHTML = 'Point: ' + currentPoint;
}
document.addEventListener('click', function(e) {
	if (GAME_DIE) {
		GAME_DIE = false;		
		document.getElementById('state').innerHTML = '';		
		clearInterval(myVar);
		myVar = setInterval(function(){ go() }, 40);
	}
	
	if (GAME_PAUSE) {
		GAME_PAUSE = false;			
		document.getElementById('state').innerHTML = '';
		clearInterval(myVar);		
		myVar = setInterval(function(){ go() }, 40);		
	}
}, false);

function sceneUp() {
	var up = Math.floor((heros.y + 250) / 10); 
	addPoint(up);
	heros.y += up;
	upPlateformes(up);
}

function go() {
	if (GAME_DIE) {		
		displayMenu();	
		document.getElementById('state').innerHTML = "GAME OVER !<br /><br /> CLIQUEZ POUR JOUER";
		document.getElementById('score').innerHTML = "Point: " + currentPoint;		
		clearInterval(myVar);	
		currentPoint = 0;
		return;
	}
	
	if (GAME_PAUSE) {
		displayMenu();
		document.getElementById('state').innerHTML = 'CLIQUEZ POUR JOUER';		
		clearInterval(myVar);	
		return;
	} else {		
		// On rempli l'�cran de blanc
		canvas.fillStyle = 'white';
		canvas.fillRect(0, 0, 300, 600);
		pauseButtonPrint();
		printPlateformes(plateformes);
		heros.go();
		
		if(heros.y <= 250) {
			sceneUp();	
		}
		//document.getElementById('debug').innerHTML = 'X: ' + heros.x + ' <br />Y: ' + heros.y + '<br />Speed: ' + heros.speed + '<br /><br />Plateforme 3:<br />X : ' + plateformes[2].x + '<br />Y : ' + plateformes[2].y;
	}
}

function displayMenu() {
	canvas.fillStyle = 'white';
	canvas.fillRect(0, 0, 300, 600);	
}

initialisation();
myVar = setInterval(function(){ go() }, 40);