var token = localStorage.getItem("token");

//ajax para TOTAL EMPLOYEE
document.addEventListener("DOMContentLoaded",
    function totalEmployee() {

        var xmlhttp = new XMLHttpRequest();
        url = "http://localhost:8080/totalEmployee";

        let encodedURL = encodeURI(url);
        xmlhttp.open("GET", url);

        xmlhttp.setRequestHeader("Content-type", "application/json");
        xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
        xmlhttp.setRequestHeader("Authorization", token);
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4) {
                showTotalEmployees(xmlhttp);
            }
        }
        xmlhttp.send();
    })
//respuesta
function showTotalEmployees(xmlhttp) {

    if (xmlhttp.status == 200) {

        let data = xmlhttp.responseText;
        document.getElementById("tEmployee").innerHTML = data;

    }


}

//FUNCION PARA TOTAL SOFTWARE
document.addEventListener("DOMContentLoaded", function totalSoftware() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/totalSoftware";

    let encodedURL = encodeURI(url);
    xmlhttp.open("GET", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            showTotalSoftware(xmlhttp);
        }
    }
    xmlhttp.send();
})
//respuesta 
function showTotalSoftware(xmlhttp) {

    if (xmlhttp.status == 200) {

        let data = xmlhttp.responseText;
        document.getElementById("tSoftware").innerHTML = data;

    }


}
//TOTAL LAPTOP
document.addEventListener("DOMContentLoaded", function totalLaptop() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/totalLaptop";

    let encodedURL = encodeURI(url);

    xmlhttp.open("GET", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            showTotalLaptop(xmlhttp);
        }
    }
    xmlhttp.send();
})
//respuesta 
function showTotalLaptop(xmlhttp) {

    if (xmlhttp.status == 200) {

        let data = xmlhttp.responseText;
        document.getElementById("tLaptop").innerHTML = data;
    }


}
//SHOW EMPLOYEE PER OFFICE
document.addEventListener("DOMContentLoaded", function employeeAtOffice() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/employeeAtOffice";

    let encodedURL = encodeURI(url);
    xmlhttp.open("GET", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            showOffice(xmlhttp);
        }
    }
    xmlhttp.send();
})
//respuesta 
function showOffice(xmlhttp) {

    if (xmlhttp.status === 200) {

        let data = JSON.parse(xmlhttp.responseText);
        let office = [];

        let employee = [];
        for (var i = 0; i < data.length; i++) {
            office.push(data[i].office.name);
        }

        for (var i = 0; i < data.length; i++) {
            employee.push(data[i].idEmployee);
        }
        //let data= JSON.parse(d);

        var ctx = document.getElementById("myBarChart");


        var myLineChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: office,
                datasets: [{
                    label: "employee",
                    backgroundColor: "rgba(2,117,216,1)",
                    borderColor: "rgba(2,117,216,1)",
                    data: employee,
                }],
            },
            options: {
                scales: {
                    xAxes: [{
                        time: {
                            unit: 'office'
                        },
                        gridLines: {
                            display: false
                        },
                        ticks: {
                            maxTicksLimit: 6
                        }
                    }],
                    yAxes: [{
                        ticks: {
                            min: 0,
                            max: 15,
                            //maxTicksLimit: 5
                        },
                        gridLines: {
                            display: true
                        }
                    }],
                },
                legend: {
                    display: false
                }
            }
        });

    }


}
//SHOW EMPLOYEE PER POSITION    
document.addEventListener("DOMContentLoaded", function employeePosition() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/employeePosition";

    let encodedURL = encodeURI(url);
    xmlhttp.open("GET", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            showPosition(xmlhttp);
        }
    }
    xmlhttp.send();
})
//respuesta
function showPosition(xmlhttp) {

    if (xmlhttp.status === 200) {


        let data = JSON.parse(xmlhttp.responseText);
        let position = [];
        let employee = [];

        for (var i = 0; i < data.length; i++) {
            position.push(data[i].position.name);
        }

        for (var i = 0; i < data.length; i++) {
            employee.push(data[i].idEmployee);
        }

        var ctx = document.getElementById("myPieChart");

        var myPieChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: position,//["Blue", "Red", "Yellow", "Green"],
                datasets: [{
                    data: employee, //NO ES NUMBER-VER EN JSON QUE MANDA
                    backgroundColor: ['#007bff', '#dc3545', '#ffc107'],
                }],
            },
        });

    }


}

//SHOW EMPLOYEE DARA MAIN TABLE    
document.addEventListener("DOMContentLoaded", function employeeData() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/employeeData";

    let encodedURL = encodeURI(url);
    xmlhttp.open("GET", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    xmlhttp.send();
})
//respuesta
function loginResults(xmlhttp) {

    if (xmlhttp.status === 200) {


        let data = JSON.parse(xmlhttp.responseText);

        // function createRow(d) {
        let t = document.getElementById("dataTable");

        var tr = "<tr>";
        for (var i = 0; i < data.length; i++) {
            let row = t.insertRow(-1);
            var cellName = row.insertCell(-1);
            cellName.innerHTML = data[i].name;

            cellName = row.insertCell(-1);
            cellName.innerHTML = data[i].surname;

            cellName = row.insertCell(-1);
            cellName.innerHTML = data[i].office.name;

            cellName = row.insertCell(-1);
            cellName.innerHTML = data[i].position.name;

            cellName = row.insertCell(-1);
            cellName.innerHTML = data[i].extra.name;

            cellName = row.insertCell(-1);
            cellName.innerHTML = data[i].arrivalDate;

            cellName = row.insertCell(-1);
            cellName.innerHTML = data[i].comment;


        }
        tr += "</tr>";





    }


}

//LOGOUT
function goodbye() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/logout";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Authorization", token);
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            adios(xmlhttp);
        }
    }
    xmlhttp.send();
}

//respuesta
function adios(xmlhttp) {

    if (xmlhttp.status === 200) {

        window.location.replace("welcome.html");
    }
}
