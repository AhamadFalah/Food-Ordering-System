<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, intial-scale=1.0">
<title>Testimonial HTML</title>
<!--Stylesheet--------------------------->
<link rel="stylesheet" href=""/>
<style>
a{
    text-decoration: none;
}
#testimonials{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    width:100%;
}
.testimonial-heading{
    letter-spacing: 1px;
    margin: 30px 0px;
    padding: 10px 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.testimonial-heading h1{
    font-size: 2.2rem;
    font-weight: 500;
    background-color: #202020;
    color: #ffffff;
    padding: 10px 20px;
}
.testimonial-heading span{
    font-size: 1.3rem;
    color: #252525;
    margin-bottom: 10px;
    letter-spacing: 2px;
    text-transform: uppercase;
}
.testimonial-box-container{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    width:100%;
}
.testimonial-box{
    width:500px;
    box-shadow: 2px 2px 30px rgba(0,0,0,0.1);
    background-color: #ffffff;
    padding: 20px;
    margin: 15px;
    cursor: pointer;
}
.profile-img{
    width:50px;
    height: 50px;
    border-radius: 50%;
    overflow: hidden;
    margin-right: 10px;
}
.profile-img img{
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: center;
}
.profile{
    display: flex;
    align-items: center;
}
.name-user{
    display: flex;
    flex-direction: column;
}
.name-user strong{
    color: #3d3d3d;
    font-size: 1.1rem;
    letter-spacing: 0.5px;
}
.name-user span{
    color: #979797;
    font-size: 0.8rem;
}
.reviews{
    color: #f9d71c;
}
.box-top{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}
.client-comment p{
    font-size: 0.9rem;
    color: #4b4b4b;
}
.testimonial-box:hover{
    transform: translateY(-10px);
    transition: all ease 0.3s;
}
 
@media(max-width:1060px){
    .testimonial-box{
        width:45%;
        padding: 10px;
    }
}
@media(max-width:790px){
    .testimonial-box{
        width:100%;
    }
    .testimonial-heading h1{
        font-size: 1.4rem;
    }
}
@media(max-width:340px){
    .box-top{
        flex-wrap: wrap;
        margin-bottom: 10px;
    }
    .reviews{
        margin-top: 10px;
    }
}
::selection{
    color: #ffffff;
    background-color: #252525;
}
</style>
<!--Fav-icon------------------------------>
<link rel="shortcut icon" href="images/fav-icon.png"/>
<!--poppins-font-family------------------->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
<!--using-Font-Awesome-------------------->
<script src="https://kit.fontawesome.com/c8e4d183c2.js" crossorigin="anonymous"></script>
</head>
<body>

    <header>
        <jsp:include page="header2.jsp" />
    </header>
    <!--Testimonials------------------->
    <section id="testimonials">
        <!--heading--->
        <div class="testimonial-heading">
<h1 style="margin-top:50px;"><a href="http://localhost:8080/JAVAWebApplication/ListAllCustomerReviewsForReviewPage" style="text-decoration: none; color: white;">Our Customers</a></h1>

        </div>
        <!--testimonials-box-container------>
        <div class="testimonial-box-container">
        
        <c:forEach var="ReviewList" items="${ReviewList}">
        <c:set var="customerID" value="${ReviewList.getCustomer_id()}" />
        <c:set var="OrderID" value="${ReviewList.getOrder_id()}"/>
        <c:set var="rating" value="${ReviewList.getRating()}"/>
        <c:set var="review" value="${ReviewList.getReview()}"/>
        <c:if test="${ReviewList.getRating() > 2}">
            <div class="testimonial-box">
                <!--top------------------------->
                <div class="box-top">
                    <!--profile----->
                    <div class="profile">
                        <!--img---->
                        <div class="profile-img">
                            <img src="${ReviewList.getProfileImage()}" />
                        </div>
                        <!--name-and-username-->
                        <div class="name-user">
                            <strong>${ReviewList.getName()}</strong>
                        </div>
                    </div>
                    <div class="reviews">
                    <c:choose>
                    	<c:when test="${ReviewList.getRating()==3}">
                    	<i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                        <i class="far fa-star"></i>
                    	</c:when>
                    	<c:when test="${ReviewList.getRating()==4}">
                    	<i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                    	</c:when>
                    	<c:when test="${ReviewList.getRating()==5}">
                    	<i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    	</c:when>
                    </c:choose>
  
                    </div>
                </div>
                <div class="client-comment">
                    <p>${ReviewList.getReview()}</p>
                </div>
            </div>
            </c:if>
            </c:forEach>
		</div>
    </section>
</body>
     <footer style="margin-top:500px;">
        <jsp:include page="footer.jsp" />
    </footer>
</html>