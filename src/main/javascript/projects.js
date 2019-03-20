let XMLHttpRequest = require('xmlhttprequest').XMLHttpRequest;
const url = 'http://localhost:8080/';

let response = '';
const request = new XMLHttpRequest();
request.onreadystatechange = function () {
    if (request.readyState === 4 && request.status === 200) {
        // response = JSON.parse(request.responseText);
        console.log(request)
    }
};
request.open('GET', url, true);
request.send();
