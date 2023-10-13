
<html>
    <head>
        <style>
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
                width: 60px;
                height: 60px;
             border-radius:60px;
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
        <script>
            document.write(Date());
            function getPage(url) {
                window.location.href = url;
            }
        </script>
    </head>
    <body>
    <center><img src="images/logo9.png" width="500px" height="500px"></center>
        <div>
            <h1 id="center"><b>SYSTEM DASHBOARD<b></h1>
            <h1 id="center"><b><%=session.getAttribute("name")%><b></h1>
        </div>
        <div class="container-option">
            <div class="container-left">
                <div class="option">
                    <a href="ManageMenuItemCRUD.jsp" style="text-decoration:none"><button>Manage Menu Items<img src="Images/arrow.jpg" alt="Image-Arrow"></button></a>
                </div>
                <div class="option">
                <a href="CRUD/display.php" style="text-decoration:none"><button>Manage User Profiles <img src="Images/arrow.jpg" alt="Image-Arrow"></button></a>
                </div>
                <div class="option">
                <a href="CRUD/DisplayPackage.php" style="text-decoration:none"><button>Manage Complaints<img src="Images/arrow.jpg" alt="Image-Arrow"></button></a>
                </div>
            </div>

            <div class="container-right">
                <div class="option">
                <a href="CRUD/CRUD_RESERVATION.php" style="text-decoration:none"><button>Manage Payments<img src="Images/arrow.jpg" alt="Image-Arrow"></button></a>
                </div>
                <div class="option">
                <a href="ManageInquiryCRUD.jsp" style="text-decoration:none"><button>Manage Inquiries<img src="Images/arrow.jpg" alt="Image-Arrow"></button></a>
                </div>
                <div class="option">
                <a href="Logout" style="text-decoration:none"><button>Log out<img src="Images/arrow.jpg" alt="Image-Arrow"></button></a>
                </div>
            </div>
    </body>

</html>