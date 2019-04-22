
//PETICIÓN AJAX
function login(){
var un = document.forms["loginForm"]["username"].value;
var pw = document.forms["loginForm"]["password"].value;

var xmlhttp = new XMLHttpRequest();
xmlhttp.open("POST","http://localhost:8080/login", true); 
xmlhttp.onreadystatechange = function(){
    if (xmlhttp.readyState == 4){
        loginResults(xmlhttp);
    }
    xmlhttp.send("user="+un+"&password="+pw+"");
}

//FUNCIÓN COJO RESPUESTA DE JSON
function loginResults(xmlhttp) {

    if (xmlhttp.status===200){
        let idUser = xmlhttp.resposeText;
        if(idUser==0){
            alert("User or password is incorrect!");
        }else{
            window.location.replace("http://stackoverflow.com"); //SUSTITUIR POR SEGUNDA PAGINA
        }
    }
  

    }
}

