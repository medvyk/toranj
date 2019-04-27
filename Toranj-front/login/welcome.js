
//PETICIÓN AJAX
function login(){
var un = document.forms["loginForm"]["username"].value;
var pw = document.forms["loginForm"]["password"].value;

var xmlhttp = new XMLHttpRequest();
url="http://localhost:8080/login?user="+un+"&password="+pw;

let encodedURL = encodeURI(url);
xmlhttp.open("POST",url); 

xmlhttp.setRequestHeader("Content-type","text/plain");
xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
xmlhttp.onreadystatechange = function(){
    if (xmlhttp.readyState == 4){
        loginResults(xmlhttp);
    }
}
xmlhttp.send();
}
//FUNCIÓN COJO RESPUESTA DE JSON
function loginResults(xmlhttp) {

    if (xmlhttp.status==200){

        let idUser = xmlhttp.resposeText;
        
        if(idUser==0){
            alert("User or password is incorrect!");
        }else{
            window.location.replace("http://localhost:8080/registration.com");
        }
    }
  

    }


