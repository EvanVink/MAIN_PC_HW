const express = require("express");
const app = express();
app.use(express.json());
const fs = require("fs");


app.use("/js", express.static("./public/js"));
app.use("/css", express.static("./public/css"));
app.use("/img", express.static("./public/img"));


app.get("/", (req, res) => {
    let doc = fs.readFileSync("./page/index.html", "utf8");
    res.send(doc);
})

app.get("/table", function (req, res){
    res.send("<html><body>hello world!</body></html>");
})









let port = 8000;
app.listen(port, function() {
    console.log("This Page is Listening on port " + port + "!")
});
