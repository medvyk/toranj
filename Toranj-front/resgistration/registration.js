
var token = localStorage.getItem("token");
let laptops;
let softwares;
let extras;

//back to Main
function backToMain(){
  window.location.replace("index.html");
}
/* SELECT OFFICE */

document.addEventListener("DOMContentLoaded", function office() {

  var xmlhttp = new XMLHttpRequest();
  url = "http://localhost:8080/offices";

  let encodedURL = encodeURI(url);
  xmlhttp.open("GET", url);

  xmlhttp.setRequestHeader("Content-type", "application/json");
  xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
  xmlhttp.setRequestHeader("Authorization", token);
  xmlhttp.onreadystatechange = function () {
    if (xmlhttp.readyState == 4) {
      theOffices(xmlhttp);
    }
  }
  xmlhttp.send();
})
//respuesta
function theOffices(xmlhttp) {

  if (xmlhttp.status === 200) {

    let offices = JSON.parse(xmlhttp.responseText);

    var select = document.getElementById("selectOffice");

    for (let i = 0; i < offices.length; i++) {

      option = document.createElement('option');
      option.text = offices[i].name;
      option.value = offices[i].idOffice;
      select.appendChild(option);
    }
  }
}

/* SELECT POSITION */

document.addEventListener("DOMContentLoaded", function position() {

  var xmlhttp = new XMLHttpRequest();
  url = "http://localhost:8080/positions";

  let encodedURL = encodeURI(url);
  xmlhttp.open("GET", url);

  xmlhttp.setRequestHeader("Content-type", "application/json");
  xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
  xmlhttp.setRequestHeader("Authorization", token);
  xmlhttp.onreadystatechange = function () {
    if (xmlhttp.readyState == 4) {
      thePositions(xmlhttp);
    }
  }
  xmlhttp.send();
})
//respuesta
function thePositions(xmlhttp) {

  if (xmlhttp.status === 200) {

    let positions = JSON.parse(xmlhttp.responseText);

    var select = document.getElementById("selectPosition");

    for (let i = 0; i < positions.length; i++) {

      option = document.createElement('option');
      option.text = positions[i].name;
      option.value = positions[i].idPosition;
      select.appendChild(option);
    }
  }
}

/* SELECT SOFTWARE */

document.addEventListener("DOMContentLoaded", function software() {

  var xmlhttp = new XMLHttpRequest();
  url = "http://localhost:8080/softwares";

  let encodedURL = encodeURI(url);
  xmlhttp.open("GET", url);

  xmlhttp.setRequestHeader("Content-type", "application/json");
  xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
  xmlhttp.setRequestHeader("Authorization", token);
  xmlhttp.onreadystatechange = function () {
    if (xmlhttp.readyState == 4) {
      theSoftware(xmlhttp);
    }
  }
  xmlhttp.send();
})
//respuesta
function theSoftware(xmlhttp) {

  if (xmlhttp.status === 200) {

    softwares = JSON.parse(xmlhttp.responseText);

    var select = document.getElementById("selectSoftware");

    for (let i = 0; i < softwares.length; i++) {

      option = document.createElement('option');
      option.text = softwares[i].name;
      option.value = softwares[i].idSoftware;
      select.appendChild(option);
    }
  }
}

/* SELECT EXTRA */

document.addEventListener("DOMContentLoaded", function extra() {

  var xmlhttp = new XMLHttpRequest();
  url = "http://localhost:8080/extras";

  let encodedURL = encodeURI(url);
  xmlhttp.open("GET", url);

  xmlhttp.setRequestHeader("Content-type", "application/json");
  xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
  xmlhttp.setRequestHeader("Authorization", token);
  xmlhttp.onreadystatechange = function () {
    if (xmlhttp.readyState == 4) {
      theExtra(xmlhttp);
    }
  }
  xmlhttp.send();
})
//respuesta
function theExtra(xmlhttp) {

  if (xmlhttp.status === 200) {

    extras = JSON.parse(xmlhttp.responseText);

    var select = document.getElementById("selectExtra");

    for (let i = 0; i < extras.length; i++) {

      option = document.createElement('option');
      option.text = extras[i].name;
      option.value = extras[i].idExtra;
      select.appendChild(option);
    }
  }
}

/* SELECT LAPTOP */

document.addEventListener("DOMContentLoaded", function laptop() {

  var xmlhttp = new XMLHttpRequest();
  url = "http://localhost:8080/laptops";

  let encodedURL = encodeURI(url);
  xmlhttp.open("GET", url);

  xmlhttp.setRequestHeader("Content-type", "application/json");
  xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
  xmlhttp.setRequestHeader("Authorization", token);
  xmlhttp.onreadystatechange = function () {
    if (xmlhttp.readyState == 4) {
      theLaptops(xmlhttp);
    }
  }
  xmlhttp.send();
})
//respuesta


function theLaptops(xmlhttp) {

  if (xmlhttp.status === 200) {

    laptops = JSON.parse(xmlhttp.responseText);

    var select = document.getElementById("selectLaptop");

    for (let i = 0; i < laptops.length; i++) {

      option = document.createElement('option');
      option.text = laptops[i].name;
      option.value = laptops[i].idLaptop;
      /* option.price=laptops[i].price; */
      select.appendChild(option);
    }

  }
}

//SHOW PRICE
function price() {
  let priceLaptop = 0;
  let priceSoftware = 0;
  let priceExtra = 0;

  var lap = document.getElementById("selectLaptop").value;
  var l = parseInt(lap);

  for (let i = 0; i < laptops.length; i++) {
    if (laptops[i].idLaptop == l) {
      priceLaptop = laptops[i].price;
    }
  }

  var sof = document.getElementById("selectSoftware").value;
  var s = parseInt(sof);

  for (let i = 0; i < softwares.length; i++) {
    if (softwares[i].idSoftware == s) {
      priceSoftware = softwares[i].price;
    }
  }

  var ex = document.getElementById("selectExtra").value;
  var e = parseInt(ex);
  for (let i = 0; i < extras.length; i++) {
    if (extras[i].idExtra == e) {
      priceExtra = extras[i].money;
    }
  }
  var price = priceLaptop + priceSoftware + priceExtra;

  document.getElementById("price").innerHTML = price + " €";

}



/* SELECT EMPLOYEE */
function emplo() {

  var xmlhttp = new XMLHttpRequest();
  url = "http://localhost:8080/employee";

  let encodedURL = encodeURI(url);
  xmlhttp.open("GET", url);

  xmlhttp.setRequestHeader("Content-type", "application/json");
  xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
  xmlhttp.setRequestHeader("Authorization", token);
  xmlhttp.onreadystatechange = function () {
    if (xmlhttp.readyState == 4) {
      theEmplo(xmlhttp);
    }
  }
  xmlhttp.send();
}
document.addEventListener("DOMContentLoaded", emplo());
//respuesta
function theEmplo(xmlhttp) {

  if (xmlhttp.status === 200) {

    let employees = JSON.parse(xmlhttp.responseText);

    var select = document.getElementById("selectEmployee");

    for (let i = 0; i < employees.length; i++) {

      option = document.createElement('option');
      let name = employees[i].name;
      let surname = employees[i].surname;
      option.text = name + " " + surname;
      option.value = employees[i].idEmployee;
      select.appendChild(option);
    }
  }
}



//REGISTER NEW EMPLOYEE 
function addEmployee() {

  var name = document.getElementById("name").value;
  var surname = document.getElementById("surname").value;

  var arrivalDate = document.getElementById("date").value;

  var o = document.getElementById("selectOffice").value;
  var office = parseInt(o);

  var p = document.getElementById("selectPosition").value;
  var position = parseInt(p);

  if (name !== "" && surname != "" && arrivalDate != "" && office != 0 && position != 0) {
    var ad = new Date(arrivalDate);
    var adJson = ad.toJSON();

    var comment = document.getElementById("comment").value;

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/addEmployee";

    let encodedURL = encodeURI(url);
    xmlhttp.open("PUT", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
      if (xmlhttp.readyState == 4) {
        newEmplo(xmlhttp);
      }
    }
    let body = '{"name":"' + name + '", "surname":"' + surname + '", "arrivalDate":"' + adJson + '", "comment":"' + comment + '", "office" :{"idOffice":' + office + '}, "position" : {"idPosition":' + position +
      '}, "laptop" :{"idLaptop":1}, "software" :{"idSoftware":1},"extra" :{"idExtra":5}}';


    xmlhttp.send(body);
  } else {
    alert('Obligatory fields are not filled.')
  }

}
//FUNCIÓN COJO RESPUESTA DE JSON
function newEmplo(xmlhttp) {

  if (xmlhttp.status === 200) {

    alert("Our departments are preparing the arrival of the new employee");
    emplo();
  }
}


//REGISTER NEW MATERIAL 
function addMaterial() {

  var e = document.getElementById("selectEmployee").value;
  var employee = parseInt(e);

  var l = document.getElementById("selectLaptop").value;
  var laptop = parseInt(l);

  var s = document.getElementById("selectSoftware").value;
  var software = parseInt(s);

  var ex = document.getElementById("selectExtra").value;
  var extra = parseInt(ex);

  if (employee != 0) {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/order";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
      if (xmlhttp.readyState == 4) {
        newOrder(xmlhttp);
      }
    }

    let body = '{"idEmployee":' + employee;
    if (laptop != 0) {
      body += ', "idLaptop":' + laptop;
    }
    if (software != 0) {
      body += ', "idSoftware":' + software;
    }
    if (extra != 0) {
      body += ', "idExtra":' + extra;
    }
    body += '}';

    xmlhttp.send(body);
  } else {
    alert('Employee must be selected.')
  }

}
//FUNCIÓN COJO RESPUESTA DE JSON
function newOrder(xmlhttp) {

  if (xmlhttp.status === 200) {

    alert("Our departments are preparing the material");

    document.getElementById("selectEmployee").value = 0;
    document.getElementById("selectLaptop").value = 0;
    document.getElementById("selectSoftware").value = 0;
    document.getElementById("selectExtra").value = 0;
    document.getElementById("price").value = "0 €";

  }
}



