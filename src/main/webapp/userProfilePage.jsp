<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="icon" type="image/png" href="images/ramen78.png"/>
<% 
String profileImage;
profileImage=(String)session.getAttribute("profileImage");
request.setAttribute("profileImage",profileImage);%>
<!--<%=request.getAttribute("profileImage") %>  -->
<% %>
<input type="hidden" value="<%=request.getAttribute("update1") %>" id="update_1">
<input type="hidden" value="<%=request.getAttribute("phone") %>" id="phone">
<input type="hidden" value="<%=request.getAttribute("update") %>" id="update">
<input type="hidden" value="<%=request.getAttribute("present") %>" id="present">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User profile page</title>
    <link rel="stylesheet" href="css/profile.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style>
.customer-photo img {
  display: block;
  width: 300px;
  height: 300px;
  object-fit: cover;
  object-position: center;
  border-radius: 50%;
  margin: auto;
}

</style>
</head>

<body>
    <div class="container light-style flex-grow-1 container-p-y">
        <h4 class="font-weight-bold py-3 mb-4">
            Account settings
        </h4>
        <div class="card overflow-hidden">
            <div class="row no-gutters row-bordered row-border-light">
                <div class="col-md-3 pt-0">
                    <div class="list-group list-group-flush account-settings-links">
                       <a class="list-group-item list-group-item-action active" data-toggle="list"
                            href="#account-info">Account Information</a>
                        <a class="list-group-item list-group-item-action" data-toggle="list"
                            href="#account-general">Update Profile Details</a>
                        <a class="list-group-item list-group-item-action" data-toggle="list"
                            href="#account-change-Email">Change Email</a>
                        <a class="list-group-item list-group-item-action" data-toggle="list"
                            href="#orders-info">Order History</a>
                        <a class="list-group-item list-group-item-action" data-toggle="list"
                            href="#">Complaints</a>
                        <a class="list-group-item list-group-item-action" data-toggle="list"
                            href="#inquiry-info">Inquiries</a>
                        <a class="btn btn-primary"
                            href="Logout">Log Out</a>
                        <a class="btn btn-primary" style="margin-top:20px;"
                            href="index.jsp">Home Page</a>
                        <%if((session.getAttribute("Admin"))!=null){ %>
                        <a class="btn btn-primary" style="margin-top:20px;"
                            href="AdminUI.jsp">Admin DashBoard</a>
                        <%} %>
                    </div>
                </div>
                
                
                
                
                

                
                
                
                
                
                <div class="col-md-9">
                    <div class="tab-content">
                    
                    
                    
                                     
                    
                    
                        <div class="tab-pane fade" id="account-general">
              <!-- Form to update the user general information -->          
            <form action="http://localhost:8080/JAVAWebApplication/UpdateUserProfile" method="post" enctype="multipart/form-data">
            <input type="hidden" value="<%=session.getAttribute("id") %>" name="userID">
                  <div class="card-body media align-items-center">
                                <div class="media-body ml-4">
                                <div class="customer-photo">
                                    <img src="<%=request.getAttribute("profileImage")%>" alt="profileImage" height="200px" width="200px"/>
                                    </div>
                             <input type="file" name="profileImage">
                                </div>
                            </div>
                            <hr class="border-light m-0">
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" value="<%=session.getAttribute("name") %>"  name="userName">
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Phone number</label>
                                    <input type="tel" class="form-control" value="<%=session.getAttribute("phoneNo") %>" name="phoneNo">
                                </div>
                               <div class="form-group">
                                    <label class="form-label">Address</label><br>
                                    <textarea rows="5" cols="40" name="userAddress"><%=session.getAttribute("address") %></textarea>
                                </div>
            <input type="submit" value="Submit" class="btn btn-primary">
            <input type="reset" class="btn btn-default" value="Reset">
                            </div>
                           </form> 
                        </div>
                        
         <!-- Form for the email update -->
                  <div class="tab-pane fade" id="account-change-Email">
              <form method="post" action="http://localhost:8080/JAVAWebApplication/UpdateUserEmail">
              <input type="hidden" value="<%=session.getAttribute("id") %>" name="userID1">
                            <div class="card-body pb-2">
                                <div class="form-group">
                                    <label class="form-label">Current Email</label>
                                    <input type="email" class="form-control" value="<%=session.getAttribute("Email_Address")%>">
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Enter new email</label>
                                    <input type="email" class="form-control" name="user_Email">
                                </div>
                            </div>
			<input type="submit" value="Submit" class="btn btn-primary" style="margin-right: 20px; margin-top: 20px;">
			<input type="reset" class="btn btn-default" value="Reset" style="margin-right: 20px;">
              </form>
                        </div>
                        
        <!-- Inquiry List -->
                        <div class="tab-pane fade" id="inquiry-info" style="margin-top:10px;">
    <div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2 style="margin-left:50px;"><b>Inquiries</b></h2>
						</div>
						<div class="col-xs-6" style="margin-left:600px; margin-bottom:60px;">
							<a href="<c:url value='UserInquiryList'/>?userID=<%=session.getAttribute("id") %>#inquiry-info" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>List All Inquiries</span></a>
					        <br><br><a href="contact.jsp" class="btn btn-success" style="float:left;"><i class="material-icons">&#xE147;</i> <span>More Questions?</span></a>								
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Question</th>
							<th>Answer</th>
							<th>Action</th>
						</tr>
					</thead>
			<tbody>
        <c:forEach var="ListInquiry" items="${ListInquiry}">
        <c:set var="InquiryID" value="${ListInquiry.getContactID()}"/>
        <c:set var="InquiryUserID" value="${ListInquiry.getUserID()}"/>
        <c:set var="CustomerName" value="${ListInquiry.getName()}"/>
        <c:set var="CustomerEmail" value="${ListInquiry.getEmail()}"/>
        <c:set var="CustomerInquiry" value="${ListInquiry.getInquery()}"/>
        <c:set var="Answer" value="${ListInquiry.getAnswer()}"/>
        
            <tr>
                <td>${ListInquiry.getInquery()}</td>
                <td>${ListInquiry.getAnswer()}</td>
                
         <c:url value="http://localhost:8080/JAVAWebApplication/DeleteUserSideInquiry" var="InquiryDelete">
         	<c:param name="id" value="${InquiryID}"/>
         	<c:param name="CustomerName" value="${CustomerName}"/>
         	<c:param name="CustomerEmail" value="${CustomerEmail}"/>
         	<c:param name="CustomerQuestion" value="${CustomerInquiry}"/>
         	<c:param name="Answer" value="${Answer}"/>
         </c:url>
                <td>
                <a href="${InquiryDelete}" >Delete</a>
            	</td>
			</tr>
	</c:forEach>
			</tbody>
				</table>
			</div>
		</div>        
    </div>
                        </div>
                        
                       
 <div class="tab-pane fade" id="orders-info" style="margin-top:10px;">
    <div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2 style="margin-left:50px;"><b>Orders</b></h2>
						</div>
						<div class="col-xs-6" style="margin-left:600px; margin-bottom:60px;">
							<a href="<c:url value='http://localhost:8080/JAVAWebApplication/ListOrderHistory1'/>?userID=<%=session.getAttribute("id") %>#inquiry-info" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>List All Orders</span></a>
					        <br><br><a href="contact.jsp" class="btn btn-success" style="float:left;"><i class="material-icons">&#xE147;</i> <span>More Questions?</span></a>								
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Customer name</th>
							<th>Payment Type</th>
							<th>Total</th>
							<th>Transaction Date</th>
							<th>Order Details</th>
							<th>Actions</th>
						</tr>
					</thead>
			<tbody>
        <c:forEach var="ListOrder" items="${ListOrder}">
        
            <tr>
                <td>${ListOrder.getCustomerName()}</td>
                <td>${ListOrder.getPaymment_type()}</td>
                <td>${ListOrder.getTotal_Price()}</td>
                <td>${ListOrder.getTransaction_Date()}</td>
                <td>${ListOrder.getOrder_Details()}</td>
                
         <c:url value="#" var="Complaint">
         
         </c:url>
                <td>
                <a href="${Complaint}" >Complaint</a>
                <a href="${Delete}" >Delete</a>
            	</td>
			</tr>
	</c:forEach>
			</tbody>
				</table>
			</div>
		</div>        
    </div>
      </div>
                        
                        
                        
            <div class="tab-pane fade active show" id="account-info">
              <!-- Display account information-->          
            <form action="#" method="post" enctype="multipart/form-data">
            <input type="hidden" value="<%=session.getAttribute("id") %>" name="userID">
                  <div class="card-body media align-items-center">
                                <div class="media-body ml-4">
                                <div class="customer-photo">
                                    <img src="<%=request.getAttribute("profileImage")%>" alt="profileImage" height="200px" width="200px"/>
                                    </div>
                                </div>
                            </div>
                            <hr class="border-light m-0">
                            <div class="card-body">
                                <div class="form-group">
                                    <label class="form-label">Name</label>
                                    <input type="text" class="form-control" value="<%=session.getAttribute("name") %>"  name="userName" readonly>
                                </div>
                                <div class="form-group">
                                    <label class="form-label">Phone number</label>
                                    <input type="tel" class="form-control" value="<%=session.getAttribute("phoneNo") %>" name="phoneNo" readonly>
                                </div>
                               <div class="form-group">
                                    <label class="form-label">Address</label><br>
                                    <textarea rows="5" cols="40" name="userAddress" readonly><%=session.getAttribute("address") %></textarea>
                                </div>
                            </div>
                           </form> 
                           
                        </div>    
                        
                       
                       
                        
                        
                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
    </script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
let update=document.getElementById("update").value;
if(update=="success"){
	swal("Profile Updated successfully","Nice","success");
}else if (update=="error"){
	swal("error in updating profile","Try again","error");
}

</script>


<script type="text/javascript">

let update1=document.getElementById("update_1").value;
if(update1=="success"){
	swal("Entry successfully deleted","","success");
}else if (update1=="error"){
	swal("Delete was not successfull","Try again","error");
}

</script>

<script type="text/javascript">
let present=document.getElementById("present").value;
if(present=="error"){
	swal("Email already in use","Please use a different email","error");
}else if(present=="success"){
	swal("Success","Email changed successfully","success");
}

</script>

<script type="text/javascript">
let phone=document.getElementById("phone").value;
if(phone=="error"){
	swal("Phone number is already present","Please use a different phone number","error");
}
</script>
</body>

</html>