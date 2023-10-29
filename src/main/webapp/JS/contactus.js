function generateAnswer(){
    let question=document.getElementById("QAquestion").value;
    if(question=="How many venues offered by the hotel?"){
        document.getElementById("answer").innerHTML="<h1>"+4+"</h1><br>";
    }
    else if(question=="Where is the store location?"){
        document.getElementById("answer").innerHTML="<h1>Colombo 3 Kollupitiya</h1><br>";
    }
    else if(question=="Are we open on poya days?"){
        document.getElementById("answer").innerHTML="<h1>We are closed on poya days :( </h1><br>";
    }
    else if(question=="What is our customers favourite Ramen?"){
        document.getElementById("answer").innerHTML="<img src='MenuItemImages/chickenramen.jpg' hegiht=200px width=200px/><h1>Chicken Tokatsu Ramen</h1><br>";
    }
    else if(question=="Are we open on sundays?"){
        document.getElementById("answer").innerHTML="<h1>Yes we are :)</h1><br>";
    }
    else if(question=="Most ordered dessert item?"){
        document.getElementById("answer").innerHTML="<img src='MenuItemImages/DaifukuMochi.jpg' hegiht=200px width=200px/><h1>Daifuku Mochi</h1><br>";
    }
    else if(question=="Are we onUber Eats and Pick Me?"){
        document.getElementById("answer").innerHTML="<h1>Yes we are in both platforms but advice you to use Uber since pick me had a breach</h1><br>";
    }
    else if(question=="Do we host birthday parties?"){
        document.getElementById("answer").innerHTML="<h1>Yes we do :)</h1><br>";
    }
    else if(question=="Do we cater to events?"){
        document.getElementById("answer").innerHTML="<h1>Nope :(</h1><br>";
    }
    else{
        document.getElementById("answer").innerHTML="";
    }
}