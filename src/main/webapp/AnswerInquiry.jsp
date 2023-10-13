<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
/>

<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.css"
  rel="stylesheet"
/>

<!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.1/mdb.min.js"
></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


<style type="text/css">

div{
  width: auto;
  margin: auto;
}


.img{
transform: translateX(150%);
transition-timing-function: cubic-bezier(0.25, 0.1, 0.25, 1);
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
</head>
<body>
<%
String id=request.getParameter("id");
String CustomerName=request.getParameter("CustomerName");
String CustomerEmail=request.getParameter("CustomerEmail");
String question=request.getParameter("CustomerQuestion");
String answer=request.getParameter("Answer");
%>
<input type="hidden" id="present" value="<%=request.getAttribute("present")%>">
<input type="hidden" id="update" value="<%=request.getAttribute("update")%>">
<div>
<section class="vh-100">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">

        <div class="px-5 ms-xl-4" style="margin-top:-2px" >
          <center><img alt="Logo png" src="images/logo9.png" width=200px height=200px></center>
        </div>

        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
        
         <form style="width: 23rem;" action="http://localhost:8080/JAVAWebApplication/AnswerInquiry" method="post">
			<br>
			<br>
            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Answer to Inquiry</h3>

			<div class="form-group">
							<input type="hidden" id="menuid" value="<%=id %>" name="contactID">
							<label>Customer Name</label>
							<input type="text" class="form-control" name="name" value="<%=CustomerName%>" readonly="readonly">
			  </div>
			  
			<div class="form-group">
							<label>Customer Email</label>
							<input type="text" class="form-control" name="email" value="<%=CustomerEmail%>" readonly="readonly">
			</div>
			  
			<div class="form-group">
							<label>Customer Question</label>
							<input type="text" class="form-control" name="question" value="<%=question%>" readonly="readonly">
			  </div>	
			  
			  <div class="form-group">
							<label>Answer</label>
							<input type="text" class="form-control" name="answer" value="<%=answer%>"required>
			  </div>
			  
            
            <div class="pt-1 mb-4" style="margin-top:5px">
            <input type="submit" value="Update" type="button" class="btn btn-info btn-lg btn-block" />
            <p>Go back to Admin DashBoard<a href="http://localhost:8080/JAVAWebApplication/ManageInquiryCRUD.jsp" class="link-info">Go back</a></p>
            </div>

          </form>

        </div>

      </div>
      
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="images/pp12.jpg"
          alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
  </div>
</section>
</div>			
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
let update=document.getElementById("update").value;
if(update=="success"){
	swal("Answer submitted successfully","","success");
}

</script>

<script type="text/javascript">
let present=document.getElementById("present").value;
if(present=="error"){
	swal("Food item already present in the database","Add a different item","error");
}

</script>

				


</body>
</html>