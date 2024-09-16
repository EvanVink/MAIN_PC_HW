const express = require("express");
const app = express();
app.use(express.json());
const fs = require("fs");
const mysql = require("mysql2");
    
const connection = mysql.createConnection({
host: "localhost",
user: "root",
password: "",
database: "assignment5"
});


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
    

    connection.connect(function(err) {
        if (err) throw err;
        connection.query("SELECT * FROM a01381720_user_timeline", function (err, result, fields) {
          if (err) throw err;
          res.send(result);
        });
      });
    
});


let port = 8000;
app.listen(port, function () {
    
});

