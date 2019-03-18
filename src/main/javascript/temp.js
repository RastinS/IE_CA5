let XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;
const url = 'http://142.93.134.194:8000/joboonja/projects';

let response = '';
const request = new XMLHttpRequest();
request.onreadystatechange = function () {
    if (request.readyState === 4 && request.status === 200) {
        response = JSON.parse(request.responseText);
        console.log(response)
    }
};
request.open('GET', url, true);
request.send();
