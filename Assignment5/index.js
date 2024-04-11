const express = require("express");
const app = express();
app.use(express.json());
const fs = require("fs");



app.use("/js", express.static("./public/js"));
app.use("/css", express.static("./public/css"));
app.use("/img", express.static("./public/img"));




app.get("/", function (req, res) {
    let doc = fs.readFileSync("./page/index.html", "utf8");
    res.send(doc);
    
})

app.get("/races2021", function (req, res) {

    let doc = fs.readFileSync("./page/races2021.js", "utf8");
    res.setHeader("Content-Type", "application/json");
    res.send(doc);
});



app.get("/races2022", function (req, res) {

    let doc = fs.readFileSync("./page/races2022.html", "utf8");
    res.setHeader("Content-Type", "text/html");
    res.send(doc);
});

app.get("/timeline", function (req, res) {
    const mysql = require("mysql");
    const connection = mysql.createConnection({
        host: "localhost",
        user: "root",
        password: "",
        database: "a01381720_user_timeline"
    });
    let myResults = null;
    connection.connect();

    let usr = "EVINK";
    let pwd = "227";
    connection.execute(
        "SELECT * FROM user WHERE user.user_name = ? AND user.password = ?",
        [usr, pwd],
        function (error, results, fields) {
            console.log("results: ", results);

            myResults = results;

            if(error) {
                console.log(error);
            }

            let table = "<table><tr><th>ID</th><th>DATE</th><th>TEXT</th><th>TIME</th><th>TIME</th><th>VIEWS</th>";
            for (let i = 0; results.length; i++) {
                table += "<tr><td>" + results[i].ID + "</td><td>" + results[i].date + "</td><td>" + results[i].text
                    + "</td><td>" + results[i].time + "</td><td>" + results[i].views + "</td></tr>";
            }

            table += "</table>";
            res.send(table);
            connection.end();




        }




    );

    
});


let port = 8000;
app.listen(port, function () {
    
});

