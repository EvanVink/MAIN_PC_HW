
function loadRaces(file, callback) {

    const xhr = new XMLHttpRequest();

    //console.log("xhr", xhr);
    xhr.onload = function() {
        if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {

            callback(this.responseText);

        }
    }
    xhr.open("GET", file);
    xhr.send();


}







document.querySelector("#races2021").addEventListener("click", function (e) {
    loadRaces("/races2021", function load2021(data) {

        let parsedData = JSON.parse(data);


        let race2021 = "<table>";
        for(let i = 0; i < parsedData.length; i++) {
            let item = parsedData[i];
            race2021 += "<tr><td>" + item["Location"] + "</td><td>" + item["Date"] + "</td><td>" + item["Winner"]
                + "</td><td>" + item["Car"]
                + "</td><td>" + item["Laps"] + "</td><td>" + item["Time"] + "</td></tr>";
        }
        race2021 += "</table>";



        document.getElementById("races1").innerHTML = race2021;
        document.getElementById("races1").style.display = "block";

       
        
    });
});


document.querySelector("#races2022").addEventListener("click", function (e){
    loadRaces("/races2022", function load2022(data) {
        document.getElementById("races2").innerHTML = data;
        document.getElementById("races2").style.display = "block";
    })
})

function clearTable1(){
    document.getElementById("races1").style.display = "none";
}

function clearTable2(){
    document.getElementById("races2").style.display = "none";
}