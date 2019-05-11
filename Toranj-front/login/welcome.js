

var t="token";

//PETICIÓN AJAX
function login() {

    un = document.forms["loginForm"]["username"].value;
    var pw = document.forms["loginForm"]["password"].value;

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/login";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    let body = '{"userName":"' + un + '", "password":"' + pw + '"}';
    xmlhttp.send(body);
}
//FUNCIÓN COJO RESPUESTA DE JSON
function loginResults(xmlhttp) {

    if (xmlhttp.status === 200) {
        let user = JSON.parse(xmlhttp.responseText);
        localStorage.setItem(t, user.token);

     
         window.location.replace("index.html");
        
    }else if (xmlhttp.status === 500){
        alert("In this moment the server is not available. We will be back soon");
    }else if(xmlhttp.status === 401){

        alert("User or password are incorrect");
    }


}


