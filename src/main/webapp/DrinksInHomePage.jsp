<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>

<% 
Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

   <!-- custom js file link  -->
   <script src="JS/menu_script.js" defer></script>
   
<style>
   @import url('https://fonts.googleapis.com/css2?family=Nunito:wght@200;300;400;500;600&display=swap');

*{
   font-family: 'Nunito', sans-serif;
   margin:0; padding:0;
   box-sizing: border-box;
   outline: none; border:none;
   text-decoration: none;
   transition: all .2s linear;
   text-transform: capitalize;
}


html{
   font-size: 62.5%;
   overflow-x: hidden;
}


body{
   font-size: 62.5%;
   background: #eee;
}

.container{
   max-width: 1200px;
   margin:0 auto;
   padding:3rem 2rem;
}

.container .title{
   font-size: 3.5rem;
   color:#444;
   margin-bottom: 3rem;
   text-transform: uppercase;
   text-align: center;
}

.container .products-container{
   display: grid;
   grid-template-columns: repeat(auto-fit, minmax(30rem, 1fr));
   gap:2rem;
}

.container .products-container .product{
   text-align: center;
   padding:3rem 2rem;
   background: #fff;
   box-shadow: 0 .5rem 1rem rgba(0,0,0,.1);
   outline: .1rem solid #ccc;
   outline-offset: -1.5rem;
   cursor: pointer;
}

.container .products-container .product:hover{
   outline: .2rem solid #222;
   outline-offset: 0;
}

.container .products-container .product img{
   height: 25rem;
}

.container .products-container .product:hover img{
   transform: scale(.9);
}

.container .products-container .product h3{
   padding:.5rem 0;
   font-size: 2rem;
   color:#444;
}

.container .products-container .product:hover h3{
   color:#27ae60;
}

.container .products-container .product .price{
   font-size: 2rem;
   color:#444;
}

.products-preview{
   position: fixed;
   top:0; left:0;
   min-height: 100vh;
   width: 100%;
   background: rgba(0,0,0,.8);
   display: none;
   align-items: center;
   justify-content: center;
}

.products-preview .preview{
   display: none;
   padding:2rem;
   text-align: center;
   background: #fff;
   position: relative;
   margin:2rem;
   width: 40rem;
}

.products-preview .preview.active{
   display: inline-block;
}

.products-preview .preview img{
   height: 30rem;
}

.products-preview .preview .fa-times{
   position: absolute;
   top:1rem; right:1.5rem;
   cursor: pointer;
   color:#444;
   font-size: 4rem;
}

.products-preview .preview .fa-times:hover{
   transform: rotate(90deg);
}

.products-preview .preview h3{
   color:#444;
   padding:.5rem 0;
   font-size: 2.5rem;
}

.products-preview .preview .stars{
   padding:1rem 0;
   font-size: 1.7rem;
}

.products-preview .preview .stars i{
   color:#27ae60;
}

.products-preview .preview .stars span{
   color:#999;
}

.products-preview .preview p{
   line-height: 1.5;
   padding:1rem 0;
   font-size: 1.6rem;
   color:#777;
}

.products-preview .preview .price{
   padding:1rem 0;
   font-size: 2.5rem;
   color:#27ae60;
}

.products-preview .preview .buttons{
   display: flex;
   gap:1.5rem;
   flex-wrap: wrap;
   margin-top: 1rem;
}

.products-preview .preview .buttons a{
   flex:1 1 16rem;
   padding:1rem;
   font-size: 1.8rem;
   color:#444;
   border:.1rem solid #444;
}

.products-preview .preview .buttons a.cart{
   background: #444;
   color:#fff;
}

.products-preview .preview .buttons a.cart:hover{
   background: #111;
}

.products-preview .preview .buttons a.buy:hover{
   background: #444;
   color:#fff;
}


@media (max-width:991px){

   html{
      font-size: 55%;
   }

}

@media (max-width:768px){

   .products-preview .preview img{
      height: 25rem;
   }

}

@media (max-width:450px){

   html{
      font-size: 50%;
   }

}
</style>

</head>
<body>
<input type="hidden" id="search" value="<%=request.getAttribute("search")%>">
<input type="hidden" id="update" value="<%=request.getAttribute("update")%>">
<input type="hidden" id="present" value="<%=request.getAttribute("present")%>">
<% String userID = (String) session.getAttribute("id"); %>
<div class="Origianl_header" style="font-size:1.5rem;">

    <header style="font-size:1.5rem;">
        <jsp:include page="header.jsp" />
    </header>

</div>
    
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
<br>
<div class="buttons" style="font-size:1.5rem;">
<a href="http://localhost:8080/JAVAWebApplication/DrinksInHomePage" class="btn btn-primary" style="margin-left:1000px;">List Drinks</a>
<a href="MenuItemSelection.jsp" class="btn btn-primary" style="margin-right:200px;">Go back</a>

<div class="MenuItems1">
</div>

<div style="margin-left:1000px;">
<form action="http://localhost:8080/JAVAWebApplication/SearchDrink" method="get">
<input type="text" placeholder="Search" style="margin-bottom:5px;" name="search" required><br><br>
<input type="submit" value="Search" class="btn btn-primary">
</form>
</div>

<div class="container" >
   <h3 class="title" style="magin-top:20px;"> Drinks  </h3>
   <div class="products-container">
<c:forEach var="MenuItem" items="${listMenuItems}">
        <c:set var="MenuItemID" value="${MenuItem.getMenuItemID()}"/>
        <c:set var="MenuItemCategory" value="${MenuItem.getMenuItemCategory()}"/>
        <c:set var="MenuItemName" value="${MenuItem.getMenuItemName()}"/>
        <c:set var="MenuItemPrice" value="${MenuItem.getMenuItemPrice()}"/>
        <c:set var="MenuItemUploadPath" value="${MenuItem.getMenuItemImageUrl()}"/>
        
        
        
      <div class="product" data-name="p-${MenuItem.getMenuItemID()}">
         <img src="${MenuItem.getMenuItemImageUrl()}" alt="" height="300px" width="300px">
         <h3>${MenuItem.getMenuItemName()}</h3>
         <div class="price">${MenuItem.getMenuItemPrice()}</div>
      </div>     
</c:forEach>
      </div> 
</div>

<div class="products-preview">

<c:forEach var="MenuItem" items="${listMenuItems}">
        <c:set var="MenuItemID" value="${MenuItem.getMenuItemID()}"/>
        <c:set var="MenuItemCategory" value="${MenuItem.getMenuItemCategory()}"/>
        <c:set var="MenuItemName" value="${MenuItem.getMenuItemName()}"/>
        <c:set var="MenuItemPrice" value="${MenuItem.getMenuItemPrice()}"/>
        <c:set var="MenuItemUploadPath" value="${MenuItem.getMenuItemImageUrl()}"/>
        
		<c:url value="http://localhost:8080/JAVAWebApplication/AddDrinksToShoppingCart" var="AddDrinksToShoppingCart">
         	<c:param name="UserID" value="<%=userID%>"/>
         	<c:param name="id" value="${MenuItemID}"/>
         	<c:param name="MenuItemCategory" value="${MenuItemCategory}"/>
         	<c:param name="MenuItemName" value="${MenuItemName}"/>
         	<c:param name="MenuItemPrice" value="${MenuItemPrice}"/>
         </c:url>
         
         <c:url value="Payment.jsp" var="directPayment">
         	<c:param name="UserID" value="<%=userID%>"/>
         	<c:param name="id" value="${MenuItemID}"/>
         	<c:param name="MenuItemCategory" value="${MenuItemCategory}"/>
         	<c:param name="ItemList" value="${MenuItemName} 1 ${MenuItemPrice}"/>
         	<c:param name="total" value="${MenuItemPrice}"/>
         </c:url>
         
   <div class="preview " data-target="p-${MenuItem.getMenuItemID()}">
      <i class="fas fa-times"></i>
         <img src="${MenuItem.getMenuItemImageUrl()}" alt="" height="300px" width="300px">
      <h3>${MenuItem.getMenuItemName()}</h3>
      <div class="price">${MenuItem.getMenuItemPrice()}</div>
      <div class="buttons">
      
        <% if (loggedIn != null && loggedIn) { %>
        <a href="${AddDrinksToShoppingCart}" class="cart">add to cart</a>
        <a href="${directPayment}" class="buy">buy now</a>
              <% } else { %>
         <a href="Login.jsp" class="cart">add to cart</a>
         <a href="Login.jsp" class="buy">buy now</a>
              <% } %>
         
      </div>
   </div>
</c:forEach>
</div>
</div>
    <br>
    <br>
    <footer style="font-size:1.5rem;">
        <jsp:include page="footer.jsp" />
    </footer>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
let search=document.getElementById("search").value;
if(search=="error"){
	swal("Sorry no such item is present","Try again","error");
}
</script>

<script type="text/javascript">
let update=document.getElementById("update").value;
if(update=="success"){
	swal("Item Added Successfully To The Cart","","success");
}
</script>

<script type="text/javascript">
let present=document.getElementById("present").value;
if(present=="success"){
	swal("Item Present In The Cart","","error");
}
</script>

</body>
</html>