<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="images/ramen78.png"/>
<meta charset="UTF-8">
<title>MenuItemSelectionPage</title>
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
            #center {
                margin-top: 70px;
                margin-bottom: 30px;
                text-align: center;
                
            }

            .option {
                text-align: center;
                padding: 5px;
                border-radius: 20px;
                margin: 2px;
                  

            }
            .option:hover{
                 background-color:#d0d2d6;
                transform: scale(1.1);
                box-shadow: 12px 15px 20px  black;
                border-radius: 5px;
                  
            }

            .option button {
                display: flex;
                justify-content: space-between;
                align-items: center;
                gap: 5px;
                border-radius: 5px;
                width: 400px;
                height: 70px; 
                margin: 0px 40px 20px 0px;  
                padding: 10px;
                border-width: 0px;  
                cursor: pointer;    
                background-color:#d0d2d6;   
                 
                 
            }

            .option img {
             width: 40px;
             height: 40px;
             border-radius:70px;
            }

            .container-option {
                text-align: center;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 50vh;
                margin-bottom: 100px;
                
            }

          
            
            .container-option button:active {
                background-color: #888888;
            }

            .container-left{
                margin-right: 10px;
            }

            .container-right {
                margin-left: 10px;
            }

        </style>
</head>
<body>

    <header>
        <jsp:include page="header2.jsp" />
    </header>
    <br>
    <br>
    <br>
    <br>
    <center><h1>Select Your Option Please</h1></center>
    <br>
    <br>
    <br>
    <br>
    <br>
        <div class="container-option" >
        <img src="images/ramen78.png" height="400px" width="400px">
            <div class="container-left">
                <div class="option">
                    <a href="http://localhost:8080/JAVAWebApplication/ListAllAppetisers" style="text-decoration:none"><button>Appetisers<img src="MenuItemImages/food.png" alt="Image-Arrow"></button></a>
                </div>
                <div class="option">
                <a href="http://localhost:8080/JAVAWebApplication/ListMenuItemsInHomePage" style="text-decoration:none"><button>Main Course<img src="MenuItemImages/food.png"  alt="Image-Arrow"></button></a>
                </div>
                <div class="option">
                <a href="http://localhost:8080/JAVAWebApplication/DessertsInHomePage" style="text-decoration:none"><button>Desserts<img src="MenuItemImages/food.png"  alt="Image-Arrow"></button></a>
                </div>
                <div class="option">
                <a href="http://localhost:8080/JAVAWebApplication/DrinksInHomePage" style="text-decoration:none"><button>Drinks<img src="MenuItemImages/food.png"  alt="Image-Arrow"></button></a>
                </div>
            </div>
          </div>  
    <footer>
        <jsp:include page="footer.jsp" />
    </footer>
</body>
</html>