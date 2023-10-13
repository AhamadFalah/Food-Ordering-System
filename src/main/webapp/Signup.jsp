<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
</style>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
<input type="hidden" id="status2" value="<%=request.getAttribute("status2")%>">
<div>
<section class="vh-100">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">

        <div class="px-5 ms-xl-4" style="margin-top:-2px" >
          <!-- </center> -->
        </div>

        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5" style="margin-top: -15px;">
			<script type="text/javascript" src="JS/UserDataValidate.js"></script>
          <form style="width: 23rem;" action="http://localhost:8080/JAVAWebApplication/Register" method="post" onsubmit="return validateData()">
			<br>
			<br>
            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign up</h3>
            
            
           <div class="form-group">
              <label class="form-label" for="form2Example18">Name</label>
              <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name" name="user_name" required/>
            </div>

            <div class="form-group">
              <label class="form-label" for="form2Example18">Email address</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="user_email" required/>
            </div>
						
			<div class="form-group">
              <label class="form-label" for="form2Example28">Password</label>
              <input type="password"  class="form-control" id="pwd1" placeholder="Password" name="user_password"/>
            </div>
            
            <div class="form-group">
              <label class="form-label" for="form2Example28">Confirm Password</label>
              <input type="password"  class="form-control" id="pwd2" placeholder="Confirm Password" name="user_password_confirm"/>
            </div>
            
            <div class="pt-1 mb-4" style="margin-top:10px">
            <input type="submit" value="Sign up" type="button" class="btn btn-info btn-lg btn-block" onclick="validateData()"/>
            </div>
            <p>Go back to the home page?<a href="index.jsp" class="link-info">Home page</a></p>
			<p>Do you already have an account?<a href="Login.jsp" class="link-info">Log in</a></p>
          </form>

        </div>

      </div>
      
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="images/ramen3.jpg"
          alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
  </div>
</section>
</div>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
let status1=document.getElementById("status2").value;
if(status1=="error"){
	swal("Email already in use","Use another Email or login","error");
}

</script>

<script type="text/javascript">
let status=document.getElementById("status").value;

if(status=="success"){
	swal("Your account is created successfully","Please click log in","success");
}
else if(status=="error"){
	swal("Creation of the account failed","Try again","error");
}

</script>






</body>
</html>