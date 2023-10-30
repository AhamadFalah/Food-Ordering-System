<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Close Complaint</title>
<link rel="icon" type="image/png" href="images/ramen78.png"/>
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
String ComplaintID = request.getParameter("ComplaintID");
String OrderID = request.getParameter("OrderID");
String UserID = request.getParameter("UserID");
String Status = request.getParameter("Status");
String Reason = request.getParameter("Reason");
String OtherReason = request.getParameter("OtherReason");
String Date = request.getParameter("Date");
%>
<input type="text" id="updateStatus" value="<%= request.getAttribute("updateStatus") %>">

<div>
<section class="vh-100">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">
        <div class="px-5 ms-xl-4" style="margin-top:-2px" >
          <center><img alt="Logo png" src="images/ramen78.png" width=300px height=300px></center>
        </div>

        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
          <form style="width: 23rem;" action="http://localhost:8080/JAVAWebApplication/ComplaintClose" method="post">
            <br>
            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Close Complaint</h3>
            <div class="form-group">
              <input type="hidden" class="form-control" name="complaintId" value="<%= ComplaintID %>" required readonly>            
              <input type="hidden" class="form-control" name="userId" value="<%= UserID %>" required readonly>
            </div>
            <br>
            <div class="form-group">            
              <label>Order ID</label>
              <input type="text" class="form-control" name="orderId" value="<%= OrderID %>" required readonly>
            </div>
            <br>
            <div class="form-group">
              <label for="reason">Reason</label>
              <input type="text" class="form-control" name="reason" value="<%= Reason %>" required readonly>
            </div>
            <br>
            <div id="otherReasonOutput" style="display: none;">
              <div class="form-group">
                <label for="otherReason">Other Reason : </label>
                <input type="text" class="form-control" name="otherReason" value="<%= OtherReason %>" id="otherReason">
              </div>
            </div>
            <br>
            <div class="form-group">
              <label for="status">Status</label>
               <select name="status" class="form-control" id="status">
	                <option value="Pending">Pending</option>
	                <option value="Rejected">Rejected</option>
	                <option value="Resolved">Resolved</option>
	                <option value="Escalated">Escalated</option>
	                <option value="Not Resolved">Not Resolved</option>
	                <option value="n Progress">n Progress</option>
	            </select> 
            </div>
            <br>
            <div class="form-group">
              <label for="reason">Date Of Complaint</label>
              <input type="text" class="form-control" name="date" value="<%= Date %>" required readonly>  
            </div>
            <div class="pt-1 mb-4" style="margin-top:5px">
              <input type="submit" value="Submit" type="button" class="btn btn-info btn-lg btn-block" />
              <p><a href="http://localhost:8080/JAVAWebApplication/ComplaintManage.jsp" class="link-info">Go back</a> to AdminUI</p>
            </div>
          </form>
        </div>
      </div>
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="images/p8.jpg" alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
  </div>
</section>
</div>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script>
  function showOtherReasonOutput() {
    var reasonValue = '<%= Reason %>'; // Get the value of the "Reason" parameter
    var otherReasonInput = document.getElementById("otherReasonOutput");

    if (reasonValue === "Other") {
    	otherReasonInput.style.display = "block"; // Show the div
    } else {
    	otherReasonInput.style.display = "none"; // Hide the div
    }
  }

  // Call the function to initialize the visibility based on the initial value
  showOtherReasonOutput();
</script>

<script type="text/javascript">
let updateStatus=document.getElementById("updateStatus").value;
if(updateStatus=="success"){
	swal("Status Was Updated","The Customer Will Be Notified","success");
}
else if(updateStatus=="error"){
	swal("Status Was Not Updated","Please Try Again Later","error");
}

</script>

</body>
</html>
