<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Automated QA</title>
<link rel="icon" type="image/png" href="images/ramen78.png"/>
<style>
.automatedQaA {
display: flex;
justify-content: space-between;
max-width: 800px;
margin: 20px auto;
padding: 40px;
background-color: #f2f2f2;
border: 1px solid #ccc;
border-radius: 5px;
}

.automatedQaA fieldset {
border: none;
padding: 0;
margin-bottom: 20px;
flex: 1;
}

.automatedQaA legend {
font-size: 24px;
font-weight: bold;
margin-bottom: 20px;
}

.automatedQaA label {
display: block;
font-size: 16px;
font-weight: bold;
margin-bottom: 8px;
text-align: left;
}

.automatedQaA select {
width: 100%;
padding: 10px;
border: 1px solid #ccc;
border-radius: 4px;
font-size: 16px;
margin-bottom: 20px;
}

.automatedQaA input[type="submit"] {
background-color: #007bff;
color: #fff;
border: none;
padding: 10px 20px;
font-size: 16px;
cursor: pointer;
border-radius: 4px;
}
/* Style the button */
#btn {
    background-color: #007BFF;
    color: #fff;
    border: none;
    padding: 10px 20px;
    cursor: pointer;
    border-radius: 5px;
    font-size: 18px;
    margin-top: 20px;
}


#btn:hover {
    background-color: #0056b3;
}

/* Style the answer paragraph */
#answer {
    font-size: 8px;
    margin-top: 20px;
}
#Automatedbtn:hover{
background-color: #0056b3;
}
.automatedQaA input[type="submit"]:hover {
background-color: #0056b3;
}

</style>
</head>
<body>

    <header>
        <jsp:include page="header2.jsp" />
    </header>
    <br><br>
    <script src="JS/contactus.js"></script>
    <br>
<div class="automatedQaA">
            <fieldset>
                <legend>Automated QaA</legend>
                    <label>Select question:  </label>
                    <select id="QAquestion">
                        <option value="How many venues offered by the hotel?"></option>
                        <option value="Where is the store location?">Where is the restaurant location?</option>
                        <option value="Are we open on poya days?">Are we open on Poya days?</option>
                        <option value="What is our customers favourite Ramen?">What is our customers favourite Ramen?</option>
                        <option value="Are we open on sundays?">Are we open on Sundays?</option>
                        <option value="Most ordered dessert item?">Most ordered Dessert item?</option>
                        <option value="Are we onUber Eats and Pick Me?">Are we on Uber Eats and Pick Me?</option>
                        <option value="Do we host birthday parties?">Do we host birthday parties?</option>
                        <option value="Do we cater to events?">Do we cater to events?</option>
                    </select>
                    <br>
                    <button type="button" value="Generate automated answer" id="btn" onclick="generateAnswer()">Generate automated answer</button>
                    <br>
                    <h4 id="answer"></h4>
            </fieldset>
        </div>
	<footer>
        <jsp:include page="footer.jsp" />
    </footer>
</body>
</html>