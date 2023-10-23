<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="images/ramen78.png"/>
<style>
*{
   font-family: 'Nunito', sans-serif;
   margin:0; padding:0;
   box-sizing: border-box;
   outline: none; border:none;
   text-decoration: none;
   transition: all .2s linear;
   text-transform: capitalize;
}

#contact {
  padding: 5rem 0;
  background: rgb(226, 226, 226);
}

.contact-container {
  display: flex;
  background: #fff;
}

.contact-img {
  width: 50%;
}

.contact-img img {
  display: block;
  height: 400px;
  width: 100%;
  object-position: center;
  object-fit: cover;
}

.form-container {
  padding: 1rem;
  width: 50%;
  margin: auto;
}

.form-container input {
  display: block;
  width: 100%;
  border: none;
  border-bottom: 2px solid #ddd;
  padding: 1rem 0;
  box-shadow: none;
  outline: none;
  margin-bottom: 1rem;
  color: #444;
  font-weight: 500;
}

.form-container textarea {
  display: block;
  width: 100%;
  border: none;
  border-bottom: 2px solid #ddd;
  color: #444;
  outline: none;
  padding: 1rem 0;
  resize: none;
}

.form-container h2 {
  font-size: 2.7rem;
  font-weight: 500;
  color: #444;
  margin-bottom: 1rem;
  margin-top: -1.2rem;
}

.form-container a {
  font-size: 1.3rem;
}

#footer h2 {
  text-align: center;
  font-size: 1.8rem;
  padding: 2.6rem;
  font-weight: 500;
  color: #fff;
  background: rgb(65, 65, 65);
}

</style>
<meta charset="ISO-8859-1">
<title>contact us</title>
</head>
<body>

    <header>
        <jsp:include page="header2.jsp" />
    </header>
    <script src="JS/formValidation.js"></script>
    <input type="hidden" value="<%=request.getAttribute("update") %>" id="update">
    <section id="contact" style="">
      <div class="contact-container container">
        <div class="contact-img" style="margin-top:15px;">
          <img src="images/ContactUs.jpg" alt="contactimage" />
        </div>
		<form action="http://localhost:8080/JAVAWebApplication/ContactInsert" method="post" id="ContactForm">
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
      <div class="googlemap" style="margin-top:-40px;">
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