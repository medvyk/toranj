
/* PARA MOSTAR OFFICE */

let office= getElementById("selectOffice");

var xmlOffice = new XMLHttpRequest();
url="http://localhost:8080/offices";

let encodedURL = encodeURI(url);
xmlOffice.open("GET",url); 

xmlOffice.setRequestHeader("Content-type","text/plain");
xmlOffice.setRequestHeader("Access-Control-Allow-Origin", "*");

/*on loan*/ 
xmlOffice.onload  = function() {
  if (request.status === 200) {
    const data = JSON.parse(xmlOffice.responseText);
    let option;
    for (let i = 0; i < data.length; i++) {

      option = document.createElement('option');
      option.text = data[i].name;
      option.value = data[i].idOffice;
      office.add(option);
    }
   } else {
    // Reached the server, but it returned an error
  }   
}

request.send();