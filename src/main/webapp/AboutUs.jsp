<% 
Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>
<!DOCTYPE html>
 <html lang="en">
     <head>
         <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
           <title>About us</title>
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
                     background-image: url("images/Banner2.jpg");
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
    color:white;
    float: left;
    -webkit-text-stroke:1px rgb(100, 100, 100);
}
.h3box{
    color:white;
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
    <a href="#about">About</a>
     <a href="index.jsp">Home</a>
 </div>
  
 
          
                            
                              <div class="header-image">
                              </div>
                              <div class="col-md-12 header-content">                                                                                                                                                   
                                       <div class="box">
                                            <h1 class="h1box" >Welcome to Uzumaki</h1> <br><br><br>
                                            <h2 class="h3box">Experience the Authentic Flavors of Ramen</h2><br><br>
                                       <a style="float: left;" href="MenuItemSelection.jsp" class="btn btn-primary cta-button">Order Now</a>
                                    </div>
                              </div>
                           
                               
                                       
                         <section id="introduction" class="container mt-5">
                            <div class="cardour"></div>
                             <h2>Introduction</h2>
                              <p>Welcome to uzumaki, your destination for a delightful ramen experience. We take pride in offering you an exquisite selection of traditional and modern ramen dishes. With a commitment to quality and taste, we invite you to savor the authentic flavors of Japan.</p>
                               <p>Our ramen is made with the finest ingredients and crafted with care. We're passionate about delivering an unforgettable culinary experience to our guests.</p>
                            </section>
                        </section>
                        <br><br><br>
                        <center>
                            <video class="vidd" autoplay loop  controls>
                                <source src="Video/ramenvideo2.webm" type="video/mp4">
                            </video>
                        </center>
                                <br><br>
                             <section id="our-story" class="container mt-5">
                                 <div class="row">
                                
                                       <center> <h2>Our Story</h2></center> 
                                         <div class="cardour" >  
                                            <image src="images/aboutus.png"  class="image" style=" width: 800px ; float: right; margin: 30px;">  </image>   
                                          
                                           <p  style="margin: 30px">Our journey began in the heart of Tokyo, where our founder, a passionate ramen connoisseur, decided to bring the rich culinary heritage of ramen to the world. With meticulous attention to detail and a dedication to perfecting each broth and ingredient, we've crafted a menu that tells a story of tradition, innovation, and love for ramen.</p>
                                            <p style="margin: 30px">Over the years, we've continued to innovate while staying true to our roots. We're proud to share our passion for ramen with you and invite you to be part of our story.</p> 
                                        </div> 
                                </div>
                            </section>   
                            <br><br>
                            
                             <section id="popular-item" class="menu container mt-5"> 
                               <h2>Popular Items</h2>
                               <div class="row">
                                <div class="col-lg-4"> 
                                    <div class="card"> 
                                        <img src="images/MisoRamen.png" class="card-img-top" alt="Ramen 1 Image"> 
                                        <div class="card-body">
                                         <h3 class="card-title">Miso Ramen</h3> 
                                            <p class="card-text">Coming from the Sapporo region of Hokkaido, miso ramen takes its name from its main ingredient. This broth is strong and savory and has an opaque appearance. There's lots of different varieties of miso paste too.</p> 
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-4">
                                    <div class="card"> 
                                        <img src="images/ShoyuRamen.png" class="card-img-top" alt="Ramen 2 Image"> 
                                        <div class="card-body">
                                             <h3 class="card-title">Shoyu Ramen</h3>
                                              <p class="card-text">Shoyu means soy sauce in Japanese and this style of noodle dish was actually the first type of ramen and is still going strong. There’s lots of different varieties of shoyu ramen but the taste is normally salty and tangy.</p>
                                         </div> 
                                    </div> 
                                </div>

                                <div class="col-lg-4">
                                    <div class="card"> 
                                        <img src="images/ShioRamen.png" class="card-img-top" alt="Ramen 3 Image"> 
                                        <div class="card-body">
                                             <h3 class="card-title">Shio Ramen </h3>
                                              <p class="card-text">Shio means salt and this style of ramen tends to be light and transparent. It’s often made by boiling down chicken bones and flavored with seafood based products like dried sardines, dashi stock, and bonito flakes.</p>
                                         </div> 
                                    </div> 
                                </div>
                                </div>
                                </section>
                                
											<br><br><br>
		
					<footer>
                		<jsp:include page="footer.jsp" />
  					</footer>

</body>
</html>                        
                                       
