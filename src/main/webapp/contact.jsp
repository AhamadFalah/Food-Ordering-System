<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta charset="ISO-8859-1">
<title>contact us</title>
</head>
<body>

    <header>
        <jsp:include page="header.jsp" />
    </header>
    
    <input type="hidden" value="<%=request.getAttribute("update") %>" id="update">
    <section id="contact" style="">
      <div class="contact-container container">
        <div class="contact-img" style="margin-top:15px;">
          <img src="images/ContactUs.jpg" alt="contactimage" />
        </div>
		<form action="http://localhost:8080/JAVAWebApplication/ContactInsert" method="post">
        <div class="form-container" style="margin-top: 10px; width: 100%;">
          <h2>Contact Us</h2>
          <input type="hidden" value="<%=session.getAttribute("id") %>" name="userID">
          <input type="text"  placeholder="Your name" name="uname" required="required"/>
          <input type="email"  placeholder="Your email" name="uemail" required="required"/>
          <textarea name="question" required="required"
            cols="30"
            rows="6"
            placeholder="Type Your Message"
          ></textarea>
          <input type="submit" value="submit" class="btn btn-primary">  
          </form>        
        </div>
        </section>
      <br><br>
      <div class="googlemap">
      <center>  <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3960.815187508914!2d79.84810437445958!3d6.912688093086815!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae2596aaa8742d9%3A0xced655398fd4d621!2sSLIIT%20Metropolitan%20Campus!5e0!3m2!1sen!2slk!4v1685965819365!5m2!1sen!2slk" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
      </center>
        </div>
    </section>
    
    <footer>
        <jsp:include page="footer.jsp" />
    </footer>
    
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">	
<script type="text/javascript">
let update=document.getElementById("update").value;
if(update=="success"){
	swal("Your message was successfully submitted","We will response soon to your inquiry","success");
}
else if(update=="error"){
	swal("Fail in storing the message","Try again","error");
}
</script>
</body>
</html>