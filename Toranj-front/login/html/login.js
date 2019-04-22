//var attempt = 3; // Variable to count number of attempts.

// Below function Executes on click of login button.

function login(){
var un = document.getElementById("username").value;
var pw = document.getElementById("password").value;

var xmlhttp = new XMLHttpRequest();
xmlhttp.open("POST","login", true);
xmlhttp.onreadystatechange = function(){
    if (xmlhttp.readyState == 4 && xmlhttp.status==200){
        loginResults();
    }
}

function loginResults() {
    var loggedIn = document.getElementById("LoggedIn");
    var badLogin = document.getElementById("BadLogin");
    if (xmlhttp.responseText.indexOf("failed") == -1) {
        loggedIn.innerHTML = "Logged in as " + xmlhttp.responseText;
        loggedIn.style.display = "block";
        form.style.display = "none";
    } else {
        badLogin.style.display = "block";
        form.Username.select();
        form.Username.className = "Highlighted";
        setTimeout(function() {
            badLogin.style.display = 'none';
        }, 3000);
    }
}

/* if ( username == "Formget" && password == "formget#123"){
alert ("Login successfully");
window.location = "success.html"; // Redirecting to other page.
return false;
}
else{
attempt --;// Decrementing by one.
alert("You have left "+attempt+" attempt;");
// Disabling fields after 3 attempts.
if( attempt == 0){
document.getElementById("username").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("submit").disabled = true;
return false;
}
}
} */