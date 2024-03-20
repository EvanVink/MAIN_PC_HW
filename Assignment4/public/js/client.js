
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





var collapse1 = document.getElementsByClassName("collapsible1");
var collapse2 = document.getElementsByClassName("collapsible2");
let truth;
function table1() {
    for (var i = 0; i < collapse1.length; i++) {
        collapse1[i].addEventListener("click", function() {
          const desk = matchMedia("(min-width: 1281px)", "(max-width: 1600px)");
          const tab = matchMedia("min-width: 701px)", "(max-width: 1280px)");
          this.classList.toggle("active");
          var content = this.nextElementSibling;
          if (content.style.maxHeight){
            content.style.maxHeight = null;
            truth = false;
            
            if (window.innerWidth >= 701 && window.innerWidth <= 1280){
                document.getElementById("imgcol1").style.gridRow = "38/44";
                document.getElementById("imgcol2").style.gridRow = "38/44";
                document.getElementById("imgcol1").style.marginTop = "0px";
                document.getElementById("imgcol2").style.marginTop = "0px";
      
                document.getElementById("col1H").style.gridRow = "44/53";
                document.getElementById("col2H").style.gridRow = "44/53";
      
                document.getElementById("col1B").style.gridRow = "47/55";
                document.getElementById("col2B").style.gridRow = "47/55";

                document.getElementById("undercol1").style.gridRow = "56";
                document.getElementById("undercol2").style.gridRow = "56";

                document.getElementById("break").style.gridRow = "70";

                document.getElementById("footer").style.gridRow = "71";
                document.getElementById("insta").style.gridRow = "72/74";

                document.getElementById("imgcol3").style.gridRow = "38/44";
                document.getElementById("imgcol4").style.gridRow = "38/44";
                document.getElementById("imgcol3").style.marginTop = "0px";
                document.getElementById("imgcol4").style.marginTop = "0px";
      
                document.getElementById("col3H").style.gridRow = "44/53";
                document.getElementById("col4H").style.gridRow = "44/53";
      
                document.getElementById("col3B").style.gridRow = "47/55";
                document.getElementById("col4B").style.gridRow = "47/55";

                document.getElementById("undercol3").style.gridRow = "56";
                document.getElementById("undercol4").style.gridRow = "56";

            }


            if (window.innerWidth >= 1281 && window.innerWidth <= 1600) {
                document.getElementById("imgcol1").style.gridRow = "9/11";
                document.getElementById("imgcol2").style.gridRow = "9/11";
                document.getElementById("imgcol1").style.marginTop = "40px";
                document.getElementById("imgcol2").style.marginTop = "40px";
      
                document.getElementById("col1H").style.gridRow = "10/11";
                document.getElementById("col2H").style.gridRow = "10/11";
      
                document.getElementById("col1B").style.gridRow = "11/13";
                document.getElementById("col2B").style.gridRow = "11/13";

                document.getElementById("undercol1").style.gridRow = "12";
                document.getElementById("undercol2").style.gridRow = "12";

                document.getElementById("break").style.gridRow = "13";

                document.getElementById("footer").style.gridRow = "14";
                document.getElementById("insta").style.gridRow = "14";


              }
          } else {
            content.style.maxHeight = content.scrollHeight + "px";
            truth = true;
            
            if (window.innerWidth >= 701 && window.innerWidth <= 1280){
              document.getElementById("imgcol1").style.gridRow = "38/44";
              document.getElementById("imgcol2").style.gridRow = "38/44";
              document.getElementById("imgcol1").style.marginTop = "0px";
              document.getElementById("imgcol2").style.marginTop = "0px";
    
              document.getElementById("col1H").style.gridRow = "44/53";
              document.getElementById("col2H").style.gridRow = "44/53";
    
              document.getElementById("col1B").style.gridRow = "47/55";
              document.getElementById("col2B").style.gridRow = "47/55";

              document.getElementById("undercol1").style.gridRow = "56";
              document.getElementById("undercol2").style.gridRow = "56";

              document.getElementById("break").style.gridRow = "70";

              document.getElementById("footer").style.gridRow = "71";
              document.getElementById("insta").style.gridRow = "72/74";

              document.getElementById("imgcol3").style.gridRow = "38/44";
              document.getElementById("imgcol4").style.gridRow = "38/44";
              document.getElementById("imgcol3").style.marginTop = "0px";
              document.getElementById("imgcol4").style.marginTop = "0px";
    
              document.getElementById("col3H").style.gridRow = "44/53";
              document.getElementById("col4H").style.gridRow = "44/53";
    
              document.getElementById("col3B").style.gridRow = "47/55";
              document.getElementById("col4B").style.gridRow = "47/55";

              document.getElementById("undercol3").style.gridRow = "56";
              document.getElementById("undercol4").style.gridRow = "56";

          }
           



            if (window.innerWidth >= 1281 && window.innerWidth <= 1600) {
                document.getElementById("imgcol1").style.gridRow = "17/19";
                document.getElementById("imgcol2").style.gridRow = "17/19";
                document.getElementById("imgcol1").style.marginTop = "25px";
                document.getElementById("imgcol2").style.marginTop = "25px";

                document.getElementById("col1H").style.gridRow = "18";
                document.getElementById("col2H").style.gridRow = "18";
      
                document.getElementById("col1B").style.gridRow = "19/21";
                document.getElementById("col2B").style.gridRow = "19/21";

                document.getElementById("undercol1").style.gridRow = "20";
                document.getElementById("undercol2").style.gridRow = "20";

                document.getElementById("break").style.gridRow = "21";

                document.getElementById("footer").style.gridRow = "22";
                document.getElementById("insta").style.gridRow = "22";
              
              }
          } 
        });
      
      }
}

function table2() {
    for (var i = 0; i < collapse2.length; i++) {
        collapse2[i].addEventListener("click", function() {
          const desk = matchMedia("(min-width: 1281px)", "(max-width: 1600px)");
          const tab = matchMedia("min-width: 701px)", "(max-width: 1280px)");
          this.classList.toggle("active");
          var content = this.nextElementSibling;
          if (content.style.maxHeight){
            content.style.maxHeight = null;

            if (window.innerWidth >= 701 && window.innerWidth <= 1280){
              document.getElementById("imgcol1").style.gridRow = "38/44";
              document.getElementById("imgcol2").style.gridRow = "38/44";
              document.getElementById("imgcol1").style.marginTop = "0px";
              document.getElementById("imgcol2").style.marginTop = "0px";
    
              document.getElementById("col1H").style.gridRow = "44/53";
              document.getElementById("col2H").style.gridRow = "44/53";
    
              document.getElementById("col1B").style.gridRow = "47/55";
              document.getElementById("col2B").style.gridRow = "47/55";

              document.getElementById("undercol1").style.gridRow = "56";
              document.getElementById("undercol2").style.gridRow = "56";

              document.getElementById("break").style.gridRow = "70";

              document.getElementById("footer").style.gridRow = "71";
              document.getElementById("insta").style.gridRow = "72/74";

              document.getElementById("imgcol3").style.gridRow = "38/44";
              document.getElementById("imgcol4").style.gridRow = "38/44";
              document.getElementById("imgcol3").style.marginTop = "0px";
              document.getElementById("imgcol4").style.marginTop = "0px";
    
              document.getElementById("col3H").style.gridRow = "44/53";
              document.getElementById("col4H").style.gridRow = "44/53";
    
              document.getElementById("col3B").style.gridRow = "47/55";
              document.getElementById("col4B").style.gridRow = "47/55";

              document.getElementById("undercol3").style.gridRow = "56";
              document.getElementById("undercol4").style.gridRow = "56";

          }
           

            


            if (window.innerWidth >= 1281 && window.innerWidth <= 1600) {
              document.getElementById("imgcol3").style.gridRow = "9/11";
              document.getElementById("imgcol4").style.gridRow = "9/11";
              document.getElementById("imgcol3").style.marginTop = "40px";
              document.getElementById("imgcol4").style.marginTop = "40px";
      
              document.getElementById("col3H").style.gridRow = "10/11";
              document.getElementById("col4H").style.gridRow = "10/11";
      
              document.getElementById("col3B").style.gridRow = "11/13";
              document.getElementById("col4B").style.gridRow = "11/13";

              document.getElementById("undercol3").style.gridRow = "12";
              document.getElementById("undercol4").style.gridRow = "12";

              document.getElementById("break").style.gridRow = "13";

              document.getElementById("footer").style.gridRow = "14";
              document.getElementById("insta").style.gridRow = "14";

            }
          } else {
            content.style.maxHeight = content.scrollHeight + "px";


            if (window.innerWidth >= 701 && window.innerWidth <= 1280){
              document.getElementById("imgcol1").style.gridRow = "38/44";
              document.getElementById("imgcol2").style.gridRow = "38/44";
              document.getElementById("imgcol1").style.marginTop = "0px";
              document.getElementById("imgcol2").style.marginTop = "0px";
    
              document.getElementById("col1H").style.gridRow = "44/53";
              document.getElementById("col2H").style.gridRow = "44/53";
    
              document.getElementById("col1B").style.gridRow = "47/55";
              document.getElementById("col2B").style.gridRow = "47/55";

              document.getElementById("undercol1").style.gridRow = "56";
              document.getElementById("undercol2").style.gridRow = "56";

              document.getElementById("break").style.gridRow = "70";

              document.getElementById("footer").style.gridRow = "71";
              document.getElementById("insta").style.gridRow = "72/74";

              document.getElementById("imgcol3").style.gridRow = "38/44";
              document.getElementById("imgcol4").style.gridRow = "38/44";
              document.getElementById("imgcol3").style.marginTop = "0px";
              document.getElementById("imgcol4").style.marginTop = "0px";
    
              document.getElementById("col3H").style.gridRow = "44/53";
              document.getElementById("col4H").style.gridRow = "44/53";
    
              document.getElementById("col3B").style.gridRow = "47/55";
              document.getElementById("col4B").style.gridRow = "47/55";

              document.getElementById("undercol3").style.gridRow = "56";
              document.getElementById("undercol4").style.gridRow = "56";

          }



            if (window.innerWidth >= 1281 && window.innerWidth <= 1600) {

              document.getElementById("imgcol3").style.gridRow = "17/19";
              document.getElementById("imgcol4").style.gridRow = "17/19";
              document.getElementById("imgcol3").style.marginTop = "25px";
              document.getElementById("imgcol4").style.marginTop = "25px";

              document.getElementById("col3H").style.gridRow = "18";
              document.getElementById("col4H").style.gridRow = "18";
      
              document.getElementById("col3B").style.gridRow = "19/21";
              document.getElementById("col4B").style.gridRow = "19/21";

              document.getElementById("undercol3").style.gridRow = "20";
              document.getElementById("undercol4").style.gridRow = "20";

              document.getElementById("break").style.gridRow = "21";

              document.getElementById("footer").style.gridRow = "22";
              document.getElementById("insta").style.gridRow = "22";
            }
          } 
        });
      
      }
}


