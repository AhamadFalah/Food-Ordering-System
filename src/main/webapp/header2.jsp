<% 
Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>

<!DOCTYPE html>
 <html lang="en">
     <head>
         <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
           <title></title>
             <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> <!-- Add your custom CSS --> 
             <style>
               body { 
                font-family: 'Open Sans', sans-serif;
                    background-color: #F5F5F5; 
                    color: #333; 
               
                 } 
                .jumbotron{ 
                    background-image: url('your-introduction-image.jpg'); 
                    background-size: cover;
                    color: #FFF; 
                } 
                .cta-button { 
                    background-color: #FF5722;
                     color: #FFF;
                 } 
                     .menu-item img { 
                    max-width: 100%; 
                     border-radius: 5px; 
                }
                 h2, p, 
                 .card-title, 
                 .card-text,
                .navbar-brand, 
                .nav-link {
                     color: #333; 
                    } 
                .card {
                     background-color: #FFF; 
                     } 
                 #our-story {
                     background-image: url('your-story-image.jpg') no-repeat;
                    background-size: cover;
                    background-position: left;
                    color: #FFF; 
                    padding: 20px; 
                    } 
                     .social-icons {
                         font-size: 24px;
                          margin-right: 10px; 
                          color: #333; 
                        }
                .site-logo {
                    max-height: 40px; 
                    margin-right: 10px; 
                    float: left;
                     } 
                .vidd{
                     width: 1200px; 
                     }
                .cardour {
                     background-color: #dfdfdf;                  
                     }
                     
                     .header-image{
                     background-image: url("images/banner.png");
                    background-position: center;
                    -webkit-background-size: cover;
                    background-size: cover;
                    position: absolute;
                     height: 70%;
  					  width: 100%;
  					  z-index: -1;
					}		

					.header-content{
          			  color: #fff;
   					  text-shadow: 0px 0px 1px black;
                      text-align: center;
                      padding-top: 250px;
                      padding-bottom: 250px;
}
.box{
    margin: 30px;
    float: left;
}
.h1box{
    color:rgb(0, 0, 0);
    float: left;
    -webkit-text-stroke:1px rgb(100, 100, 100);
}
.h3box{
    color:#000000;
    float: left;
    
    -webkit-text-stroke:1px rgb(100, 100, 100);
    }
 
  .topnv {
  background-color: white;
  position: fixed;
  width: 100%;
  overflow: hidden;
  box-shadow: 0px 5px 10px 0px #aaa;
  height: 65px;
  z-index:1;
  
  
  
}

/* Style the links inside the navigation bar */
.topnv a {
    font-weight: bold;
   font-size: 18px;
  float: right;
  color: #676666;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  
}

/* Change the color of links on hover */
.topnv a:hover {
    background-color: #f4f2f2;
  text-decoration: none;
  color:rgb(66, 154, 117);
}  
.log{
 position :fixed;
 z-index:2;
 margin-left:50px;
}

                                       
      </style>         
                </head> 

                    <body>  
   <img alt="images/logo9.png" src="images/logo9.png" class="log" width=230px height=230px >
  	<div class ="topnv">
	  <% if (loggedIn != null && loggedIn) { %>
    <a href="Logout">Logout</a>
    <a href="userProfilePage.jsp">Profile</a>
    <a href="ShoppingCart.jsp">Cart</a>
     <% } else { %>
                  <a href="Login.jsp">Login</a>
    <% } %>
    <a href="contact.jsp">Contact</a>
    <a href="#testimonials">Testimonial</a>
    <a href="MenuItemSelection.jsp">Menu</a>
    <a href="AboutUs.jsp">About</a>
     <a href="index.jsp">Home</a>
 </div>
 
 <div>