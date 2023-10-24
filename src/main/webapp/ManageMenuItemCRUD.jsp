<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.JavaWebApplication.Beans.MenuItem" %>
<%@ page import="java.util.List" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<% Boolean conditionMet = (Boolean) request.getAttribute("conditionMet"); %>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" type="image/png" href="images/ramen78.png"/>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ManageMenuItemCRUD</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.table-responsive {
        margin: 30px 0;
    }
	.table-wrapper {
		min-width: 1000px;
        background: #fff;
        padding: 20px 25px;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {        
		padding-bottom: 15px;
		background: #435d7d;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn-group {
		float: right;
	}
	.table-title .btn {
		color: #fff;
		float: right;
		font-size: 13px;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
		outline: none !important;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }    
	/* Custom checkbox */
	.custom-checkbox {
		position: relative;
	}
	.custom-checkbox input[type="checkbox"] {    
		opacity: 0;
		position: absolute;
		margin: 5px 0 0 3px;
		z-index: 9;
	}
	.custom-checkbox label:before{
		width: 18px;
		height: 18px;
	}
	.custom-checkbox label:before {
		content: '';
		margin-right: 10px;
		display: inline-block;
		vertical-align: text-top;
		background: white;
		border: 1px solid #bbb;
		border-radius: 2px;
		box-sizing: border-box;
		z-index: 2;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		content: '';
		position: absolute;
		left: 6px;
		top: 3px;
		width: 6px;
		height: 11px;
		border: solid #000;
		border-width: 0 3px 3px 0;
		transform: inherit;
		z-index: 3;
		transform: rotateZ(45deg);
	}
	.custom-checkbox input[type="checkbox"]:checked + label:before {
		border-color: #03A9F4;
		background: #03A9F4;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		border-color: #fff;
	}
	.custom-checkbox input[type="checkbox"]:disabled + label:before {
		color: #b8b8b8;
		cursor: auto;
		box-shadow: none;
		background: #ddd;
	}
	/* Modal styles */
	.modal .modal-dialog {
		max-width: 400px;
	}
	.modal .modal-header, .modal .modal-body, .modal .modal-footer {
		padding: 20px 30px;
	}
	.modal .modal-content {
		border-radius: 3px;
	}
	.modal .modal-footer {
		background: #ecf0f1;
		border-radius: 0 0 3px 3px;
	}
    .modal .modal-title {
        display: inline-block;
    }
	.modal .form-control {
		border-radius: 2px;
		box-shadow: none;
		border-color: #dddddd;
	}
	.modal textarea.form-control {
		resize: vertical;
	}
	.modal .btn {
		border-radius: 2px;
		min-width: 100px;
	}	
	.modal form label {
		font-weight: normal;
	}	
</style>
<script>
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
</script>
</head>
<!--  <% if (conditionMet!=null) { %>
    <table>
        <tr>
            <th>Item ID</th>
            <th>Category</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <% List<MenuItem> menuItems = (List<MenuItem>) request.getAttribute("listMenuItems"); %>
        <% for (MenuItem menuItem : menuItems) { %>
            <tr>
                <td><%= menuItem.getMenuItemID() %></td>
                <td><%= menuItem.getMenuItemCategory() %></td>
                <td><%= menuItem.getMenuItemName() %></td>
                <td><%= menuItem.getMenuItemPrice() %></td>
            </tr>
        <% } %>
    </table>
<% } else { %>
    <p>The condition is not met, so this content is not displayed.</p>
<% } %>-->
	<input type="hidden" id="OrderExcel" value="<%=request.getAttribute("FileODownload")%>">
	<input type="hidden" id="status1" value="<%=request.getAttribute("status1")%>">
    <div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>Manage <b>Menu Items</b></h2>
						</div>
						<div class="col-xs-6">
							<a href="http://localhost:8080/JAVAWebApplication/CreateExcelForMenuItems" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Create Excel for Menu Items</span></a>
							<a href="http://localhost:8080/JAVAWebApplication/NewMenuItem.jsp" data-toggle="modal" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Add New Menu Item</span></a>
							<a href="http://localhost:8080/JAVAWebApplication/ListMenuItems" class="btn btn-success" style="margin-top:10px;"><i class="material-icons">&#xE147;</i> <span>List Menu Items</span></a>	
							<a href="AdminUI.jsp" class="btn btn-danger" style="margin-top:10px;"><i class="material-icons">&#xE15C;</i> <span>Go Back</span></a>						
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Menu Item Category</th>
							<th>Menu Item Name</th>
							<th>Price</th>
							<th>Image</th>
							<th>Actions</th>
						</tr>
					</thead>
			<tbody>
        <c:forEach var="MenuItem" items="${listMenuItems}">
        <c:set var="MenuItemID" value="${MenuItem.getMenuItemID()}"/>
        <c:set var="MenuItemCategory" value="${MenuItem.getMenuItemCategory()}"/>
        <c:set var="MenuItemName" value="${MenuItem.getMenuItemName()}"/>
        <c:set var="MenuItemPrice" value="${MenuItem.getMenuItemPrice()}"/>
        <c:set var="MenuItemUploadPath" value="${MenuItem.getMenuItemImageUrl()}"/>
            <tr>
                <td>${MenuItem.getMenuItemID()}</td>
                <td>${MenuItem.getMenuItemCategory()}</td>
                <td>${MenuItem.getMenuItemName()}</td>
                <td>${MenuItem.getMenuItemPrice()}</td>
                <td><img src="${MenuItem.getMenuItemImageUrl()}" height="150px" width="150px"/></td>
         <c:url value="UpdateMenuItem.jsp" var="itemupdate">
         	<c:param name="id" value="${MenuItemID}"/>
         	<c:param name="MenuItemCategory" value="${MenuItemCategory}"/>
         	<c:param name="MenuItemName" value="${MenuItemName}"/>
         	<c:param name="MenuItemPrice" value="${MenuItemPrice}"/>
         </c:url>
         <c:url value="DeleteMenuItem.jsp" var="itemDelete">
         	<c:param name="id" value="${MenuItemID}"/>
         	<c:param name="MenuItemCategory" value="${MenuItemCategory}"/>
         	<c:param name="MenuItemName" value="${MenuItemName}"/>
         	<c:param name="MenuItemPrice" value="${MenuItemPrice}"/>
         </c:url>
        <c:url value="uploadMenuItemImage.jsp" var="uploadMenuPicture">
         	<c:param name="id" value="${MenuItemID}"/>
         	<c:param name="uploadPath" value="${MenuItemUploadPath}"/>
         	<c:param name="MenuItemName" value="${MenuItemName}"/>
         </c:url>
                <td><a href="${itemupdate}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                <a href="${uploadMenuPicture}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Upload Picture">&#xE254;</i></a>
                <a href="${itemDelete}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                
            	</td>
			</tr>
	</c:forEach>
			</tbody>
				</table>
			</div>
		</div>        
    </div>
	<!-- Delete Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Menu Item</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning"><small>This action cannot be undone.</small></p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">	
<script type="text/javascript">
let status1=document.getElementById("status1").value;
if(status1=="success"){
	swal("Data insertion successfully","Food item added successfully","success");
}
else if(status1=="error"){
	swal("Adding food item failed","Try again","error");
}
</script>

<script type="text/javascript">
let OrderExcel=document.getElementById("OrderExcel").value;
if(OrderExcel=="success"){
	swal("Excel File Successfully Created","","success");
}
else if(status1=="error"){
	swal("Delete failed","Try again","error");
}
</script>
</body>
</html>