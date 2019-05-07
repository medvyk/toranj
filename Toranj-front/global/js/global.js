//ajax para TOTAL EMPLOYEE
function totalEmployee() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/totalEmployee";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "text/plain");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    xmlhttp.send();
}
//respuesta
function loginResults(xmlhttp) {

    if (xmlhttp.status == 200) {


    }


}

//FUNCION PARA TOTAL SOFTWARE
function totalSoftware() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/totalSoftware";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "text/plain");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    xmlhttp.send();
}
//respuesta 
function loginResults(xmlhttp) {

    if (xmlhttp.status == 200) {


    }


}
//TOTAL LAPTOP
function totalLaptop() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/totalLaptop";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "text/plain");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    xmlhttp.send();
}
//respuesta 
function loginResults(xmlhttp) {

    if (xmlhttp.status == 200) {


    }


}
//SHOW EMPLOYEE PER OFFICE
function employeeAtOffice() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/employeeAtOffice";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "text/plain");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    xmlhttp.send();
}
//respuesta 
function loginResults(xmlhttp) {

    if (xmlhttp.status == 200) {

        let d = xmlhttp.resposeText;
        let data = JASON.parse(d);

        var ctx = document.getElementById("myBarChart");
        var myLineChart = new Chart(ctx, {
          type: 'bar',
          data: {
            labels: ["'" + data[i].nombre + "'"],//["January", "February", "March", "April", "May", "June"],
            datasets: [{
              label: "employee",
              backgroundColor: "rgba(2,117,216,1)",
              borderColor: "rgba(2,117,216,1)",
              data: [data[i].number], //NO ES NUMBER-VER EN JSON QUE MANDaA  //[4215, 5312, 6251, 7841, 9821, 14984],
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
                  max: 15000,
                  maxTicksLimit: 5
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
function employeePosition() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/employeePosition";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "text/plain");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    xmlhttp.send();
}
//respuesta
function loginResults(xmlhttp) {

    if (xmlhttp.status == 200) {

        let d = xmlhttp.resposeText;
        let data = JASON.parse(d);

        var ctx = document.getElementById("myPieChart");
        for (var i = 0; i < data.length; i++) {
            var myPieChart = new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ["'" + data[i].nombre + "'"],//["Blue", "Red", "Yellow", "Green"],
                    datasets: [{
                        data: [data[i].number], //NO ES NUMBER-VER EN JSON QUE MANDA
                        backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
                    }],
                },
            });
        }
    }


}

//SHOW EMPLOYEE DARA MAIN TABLE    
function employeeData() {

    var xmlhttp = new XMLHttpRequest();
    url = "http://localhost:8080/employeeData";

    let encodedURL = encodeURI(url);
    xmlhttp.open("POST", url);

    xmlhttp.setRequestHeader("Content-type", "text/plain");
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            loginResults(xmlhttp);
        }
    }
    xmlhttp.send();
}
//respuesta
function loginResults(xmlhttp) {

    if (xmlhttp.status == 200) {

        let d = xmlhttp.resposeText;
        let data = JSON.parse(data);

        function createRow(d) {
            var tr;
            for (var i = 0; i < data.length; i++) {
                tr = "<tr/>";
                tr.append("<td>" + data[i].name + "</td>");
                let t = document.getElementById("dataTable");
                t.append(tr);
            }
        }

        /* POR SI HAY QUE HACER LA TABLA EN JS
      
        posiciona el <tbody> debajo del elemento <table>
        tabla.appendChild(tblBody);
        appends <table> into <body>
        body.appendChild(tabla);
           modifica el atributo "border" de la tabla y lo fija a "2";
        tabla.setAttribute("border", "2"); */
    }


}

