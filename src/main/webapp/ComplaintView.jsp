<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ComplaintCha</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
 .body{
 
 }
 
 .page-container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    
  }

  .containerr {
    width: 1140px;
    border: 1px solid #ddd;
    padding: 10px;
    background-color: #F8F7F3;
    overflow: auto; 
    max-height: 400px;
    
  }
 
 .container {
    width: 100%;
    align: center;
    border: 1px solid #ddd;
    padding: 10px;
    background-color: #F8F7F3;
    overflow: auto; 
    max-height: 400px;
}



 .message p {
    margin: 0;
 }

 .message .timestamp {
    position: absolute;
    bottom: 10px;
    right: 10px;
    color: #075e54;
    font-size: 12px;
 }


 
 .message {
     margin-bottom: 10px;
     width: 80%;
     clear: both;
    position: relative;
    background-color: #f5f5f5;
   }

   .receiver  {
     float: right;
     background-color: 	#ece5dd;
     padding: 10px;
     border-radius: 10px 0px 10px  10px;
     position: relative;
   }

   .sender{
     float: left;
     background-color: #DCF8C6;
     padding: 10px;
     border-radius: 0px 10px 10px 10px;
     position: relative;
   }
   
   .p{
   margin: 50px;
   }
   

   .input-container {
            width: 1140px;
            height: auto;
            margin: 0 auto;
            background-color: #d;
            border-radius: 5px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            
        }
   .input-box {
            width: 1140px;
            height: 40px;
            border: none;
            border-radius: 5px;
            padding: 5px;
            font-size: 18px;
            color: grey;
            background-color: #d;
        }
   .send-button {
            width: 80px;
            height: 40px;
            border: none;
            border-radius: 5px;
            background-color: #DCF8C6;
            color: white;
            font-size: 24px;
            cursor: pointer;
        }
        
   .button{
   float: right;}
   
</style>
</head>
<body>

<header>
        <jsp:include page="header2.jsp" />
    </header>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

<div class="page-container">
  <div class="containerr">
    <h2><b>Complaint Chat</b></h2>
	    <a href="AdminUI.jsp" class="btn btn-danger" style="float: right;"><i class="material-icons">&#xE15C;</i> <span>Go Back</span></a>
  </div>
  </div>

    
<div class="container" >
     <div class="message sender">
         <p>Hi!</p>
  		 <span class="timestamp">You | 20:00</span>
     </div>
     <div class="message receiver">
         <p>Hi! How are you?</p>
         <span class="timestamp">Manager | 20:01</span> 
     </div>
     <div class="message sender">
         <p>I'm fine. What about you?</p>
         <span class="timestamp">You | 20:02</span>
     </div> 
     <div class="message receiver"> 
         <p>I'm good, thank you!</p>
         <span class="timestamp">Manager | 20:03</span>
      </div>
      <div class="message sender">
         <p>Hi!</p>
  		 <span class="timestamp">You | 20:00</span>
     </div>
     <div class="message receiver">
         <p>Hi! How are you?</p>
         <span class="timestamp">Manager | 20:01</span> 
     </div>
     <div class="message sender">
         <p>I'm fine. What about you?</p>
         <span class="timestamp">You | 20:02</span>
     </div> 
     <div class="message receiver"> 
         <p>I'm good, thank you!</p>
         <span class="timestamp">Manager | 20:03</span>
      </div>
      <div class="message sender">
         <p>Hi!</p>
  		 <span class="timestamp">You | 20:00</span>
     </div>
     <div class="message receiver">
         <p>Hi! How are you?</p>
         <span class="timestamp">Manager | 20:01</span> 
     </div>
     <div class="message sender">
         <p>I'm fine. What about you?</p>
         <span class="timestamp">You | 20:02</span>
     </div> 
     <div class="message receiver"> 
         <p>I'm good, thank you!</p>
         <span class="timestamp">Manager | 20:03</span>
      </div>
      
	  </div>
	  <div class="input-container">
        <input class="input-box" type="text" placeholder="Type a message...">
        <button class="send-button">Send</button>
    </div>
	
      


</body>
</html>