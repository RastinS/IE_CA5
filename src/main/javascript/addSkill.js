let XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;
const url = 'http://localhost:8080/addSkill';

let response = '';
const request = new XMLHttpRequest();

request.open('POST', url, true);
request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

request.onreadystatechange = function () {
	if (request.readyState === XMLHttpRequest.DONE && request.status === 200) {
		response = request.responseText;
		getResponse(response);
	}
};

function getResponse(res) {
	console.log(res);
}

request.send('data={"skillName"="Node.js"}');