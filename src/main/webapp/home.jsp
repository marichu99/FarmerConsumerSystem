<%


      <!-- check the type of user accessing this page  -->
      UserType userType = request.getParameter("userType");


%>

<!DOCTYPE html>
<html>
    <head lang="en">
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- CSS -->
    <link rel="stylesheet" href="dash.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"> 

    <title>Admin Dashboard Panel</title>
    </head>
    <body>
        <div class="navlets">

            <!-- the div below is for the Sidebar Container -->

            <nav class="navContainer">
                <div class="logoName">
                    <span class="logo_name">Ukulima Bora</span>
                </div>
                <form method="post">
                <div class="menu-items">
                    <ul class="nav-links">
                        <li><a href="#">
                            <img src="icons/home.jpg" class="icon"/>
                            <span class="link-name" onclick="window.location.href='dashboard.php'">Dashboard</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/chart-line.jpg" class="icon"/>
                            <span class="link-name" onclick="showPage('reports')">Reports</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/adjust-circle.jpg" class="icon" />
                            <span class="link-name" onclick="showPage('admin')" >Add Admin</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/user-circle.jpg"class="icon"/>
                            <span class="link-name" onclick="showPage('users')">Users</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/plane-fly.jpg"class="icon" />
                            <span class="link-name" onclick="showPage('produce')">Produce</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/plane-arrival.jpg" class="icon" />
                            <span class="link-name" onclick="showPage('approvals')">Approvals</span><span class="approvals"> <% echo $rowsApprovals%></span>
                        </a></li>
                        
                    </ul>

                    <ul>
                        <li><a href="adminLogout.php">
                            <img src="icons/signout.jpg" class="icon" />
                            <span class="link-name">Log out</span>
                        </a></li>
                    </ul>
                </div>
                </form>
            </nav>

            
            <!-- the div below is for the main content -->

            <div class="dashboard">
                <!-- div for the top level stuff -->
                <div class ="top">
                    <div class="search-box">
                    <img src="icons/user-circle.jpg"class="icon"/>
                    <span><% %></span>
                    </div>
                </div>
                <!-- div for the header content -->
                
                <!-- div for sign up to users -->
                <div class="main" id="main"> 

                    <form action="adminSign.php" method="POST">
                        <div class="row">
                            <div class="col">
                                <h3 class="title">ADD A NEW ADMIN USER</h3>
                                <div class="user">
                                    <label>First Name:</label>
                                    <input type="text" placeholder="Enter First Name" name="fname" required/>
                                </div>
                                <div class="user">
                                    <label>Last Name:</label>
                                    <input type="text" placeholder="Enter Last Name" name="lname" required/>
                                </div>
                                <div class="user">
                                    <label>User Name:</label>
                                    <input type="text" placeholder="Enter Last Name" name="uname" required/>
                                </div>
                                <div class="user">
                                    <label>Email:</label>
                                    <input type="email" placeholder="enter your email address" name="email" required/>
                                </div>
                                <div class="user">
                                    <label>Password:</label>
                                    <input type="password" placeholder="enter your password" name="password" required/>
                                </div>
                                <div class="user">
                                    <label>Confirm Password:</label>
                                    <input type="password" placeholder="Confirm your password" name="password" required/>
                                </div>
                            </div>
                            <div class="col">
                                <p id="firstSignValid"></p>
                                <p id="specialCharacter"></p>
                                <p id="lastSignValid"></p>
                                <p id="emailSignValid"></p>
                                <p id="passwordSignValid"></p>
                                <p id="passReValid"></p>     
                            </div>
                        </div>
                        <input type="submit" value="SUBMIT DETAILS" class="submit">
                    </form>        
                 </div>

                <!-- the section below is for pdfviewing purposes -->
                <div class="mainPDF" id="mainPDF">      
       
                    <div class="pdfShow">
                        <embed src="compliance/" type="application/pdf" height="400" width="450">
                        <embed src="identity/>" type="application/pdf" height="400" width="450">
                    </div>           
                    <div class="approve">
                        <button class="approveUser" onclick="window.location.href='approve.php?approve=Yes&seller='">APPROVE USER</a></button>
                        <button class="rejectUser" onclick="window.location.href='approve.php?approve=No&seller='">REJECT USER</button>
                    </div>         

                    <!-- <input type="submit" value="SUBMIT DETAILS" class="submit"> -->
                </div>

                <!-- div for users -->
                <section class="farm_produce" id="allUsers">        
                    <h3 id="userHead">Featured Farm Products</h3>
                    <% if($all==true){
                        echo "All users";
                    }else{
                        echo $numResult." results found";
                    }%>
                    <div class="prod_row" id="users">
                        

                        <!-- all products -->
                        
                        <%
                            $iterations=0;
                            if(isset($resultsAll) and $all==true){
                                if($numResult>0){
                                while($iterations<$numResult){
                            
                        %>
                        
                        <div class="prod_item">
                            
                            <img src='profiles/' class="image_prod"/><br/>
                            <span class="prodName">Name: <% echo $arr_results[$iterations]["FirstName"]; echo $arr_results[$iterations]["LastName"];%></span><br/>
                            <span class="prodName">User Name: <% echo $arr_results[$iterations]["userName"]; %></span><br/>
                            <form method="post" action="">
                            <div className="fpRating">
                                <input type="button" class="prodBuy" name="getDetails" value="DELETE USER" onclick="window.location.href='delete.php?user='"/>
                            </div>
                            </form>
                        </div>
                        <%
                            $iterations=$iterations+1;
                                }
                            }
                        }                     
                        
                        %>
                    </div>
                
                </section>    
                <!-- div for products -->
                <section class="farm_produce" id="farms">        
                    <h3>Featured Farm Products</h3>
                    <% if($all==true){
                        echo "All produce";
                    }else{
                        echo $numResult." results found";
                    }%>
                    <div class="prod_row" id="farm_produces">
                        <!-- all products -->
                        
                        <%
                            $iterations=0;
                            if(isset($resultsAll) and $all==true){
                                if($numResult>0){
                                while($iterations<$numResult){
                            
                        %>
                        
                        <div class="prod_item">
                            
                            <img src='prodIMG/<% echo $arr_results[$iterations]["prodIMGDir"];%>' class="image_prod"/><br/>
                            <span class="prodName"><% echo $arr_results[$iterations]["productName"];%></span><br/>
                            <span class="prodLocation"><% echo $arr_results[$iterations]["productLocation"]; %></span><br/>
                            <span class="prodPrice"><% echo $arr_results[$iterations]["productPrice"]."Per Kilogram";%></span><br/>
                            <% $prodID=$arr_results[$iterations]["productID"];%>                            
                        </div>
                        <%
                            $iterations=$iterations+1;
                                }
                            }
                        }                     
                        
                        %>
                </div>
                
            </section>         
                <!-- div for approvals -->
                <section class="farm_produce" id="approvalSect">       

                    <h3 id="userHead">Request for Sell Approval</h3>
                    <% if($all==true){
                        echo "All prospective sellers";
                        echo "<br/>";
                        echo $numResult. " approval requests"; 
                    }else{
                        echo $numResult." results found";
                    }%>
                    <div class="prod_row" id="usersApproval">
                        

                        <!-- all products -->
                        
                        <%
                            $iterations=0;
                            if(isset($resultsAll) and $all==true){
                                if($numResult>0){
                                while($iterations<$numResult){
                            
                        %>
                        
                        <div class="prod_item">
                            <span><% print_r($rows);%></span>
                            <img src='profiles/<% echo $arr_results[$iterations]["imgDIR"];%>' class="image_prod"/><br/>
                            <span class="prodName">User Name: <% echo $arr_results[$iterations]["farmerName"]; %></span><br/>
                            
                                <% 
                                    $farmername=$arr_results[$iterations]['farmerName'];
                                    
                                %>
                            <div className="fpRating">
                                
                                <button class="prodBuy" onclick="showPage('pdfView','<% echo $farmername%>')">VIEW DETAILS</button>
                                
                            </div>
                            
                        </div>
                        <%
                            $iterations=$iterations+1;
                                }
                            }
                        }                     
                        
                        %>
                    </div>
                
                </section>
                    
                    <%

                            if(isset($_SESSION["Username"])){
                                // $buttonclicked="None";
                            if($buttonclicked == "None"){
                                echo "
                                    <script type='text/javascript'>
                                    var admin=document.querySelector('.farm_produce');
                                    var farms=document.getElementById('farms');
                                    var approvalSect=document.getElementById('approvalSect');
                                    var produce=document.getElementById('farm_produces');
                                    var mainPDF=document.getElementById('mainPDF');
                                    mainPDF.style.display='none';
                                    farms.style.display='none';
                                    produce.style.display='none';
                                    admin.style.display='none';
                                    approvalSect.style.display='none';
                                    </script>            
                                    ";
                                include("dashmain.php ");
                            }else if($buttonclicked == "admin"){
                                // echo $buttonclicked;
                                echo "
                                    <script type='text/javascript'>
                                    var admin=document.getElementById('main');
                                    var mainPDF=document.getElementById('mainPDF');
                                    mainPDF.style.display='none';
                                    admin.style.display='flex';
                                    
                                    </script>            
                                    ";
                            }else if($buttonclicked == "users"){
                                // echo $buttonclicked;
                                echo "
                                    <script type='text/javascript'>
                                    var users=document.getElementById('users');
                                    var heading=document.getElementById('userHead');
                                    var farms=document.getElementById('farms');
                                    var approvals=document.getElementById('approvalSect');
                                    var mainPDF=document.getElementById('mainPDF');
                                    mainPDF.style.display='none';
                                    approvals.style.display='none';
                                    heading.textContent='User List';
                                    users.style.display='flex';
                                    farms.style.display='none';
                                    </script>            
                                    ";
                            }else if($buttonclicked == "produce"){
                                // echo $buttonclicked;
                                echo "
                                    <script type='text/javascript'>
                                    var produce=document.getElementById('farm_produces');
                                    var heading=document.getElementById('userHead');
                                    var farm_produce=document.getElementById('allUsers');
                                    var approvals=document.getElementById('approvalSect');
                                    var mainPDF=document.getElementById('mainPDF');
                                    mainPDF.style.display='none';
                                    approvals.style.display='none';
                                    farm_produce.style.display='none';
                                    heading.textContent='';
                                    produce.style.display='flex';
                                    </script>            
                                    ";
                            }else if($buttonclicked == "approvals"){
                                // echo $buttonclicked;
                                echo "
                                    <script type='text/javascript'>
                                    var approvals=document.getElementById('usersApproval');
                                    var heading=document.getElementById('userHead');
                                    var farm_produce=document.getElementById('allUsers');
                                    var farms =document.getElementById('farms');
                                    var mainPDF=document.getElementById('mainPDF');
                                    mainPDF.style.display='none';
                                    farms.style.display='none';
                                    farm_produce.style.display='none';
                                    heading.textContent='';
                                    approvals.style.display='flex';
                                    </script>            
                                    ";
                            }else if($buttonclicked == "pdfView"){
                                // echo $buttonclicked;
                                echo "
                                    <script type='text/javascript'>
                                    var approvals=document.getElementById('usersApproval');
                                    var mainPDF=document.getElementById('mainPDF');
                                    var heading=document.getElementById('userHead');
                                    var approvalsLarge=document.getElementById('approvalSect');
                                    var farm_produce=document.getElementById('allUsers');
                                    var farms =document.getElementById('farms');
                                    farms.style.display='none';
                                    farm_produce.style.display='none';
                                    approvalsLarge.style.display='none';
                                    heading.textContent='';
                                    approvals.style.display='none';
                                    mainPDF.style.display='flex';
                                    </script>            
                                    ";
                            } else if($buttonclicked == "reports"){
                                echo "
                                    <script type='text/javascript'>
                                    var admin=document.querySelector('.farm_produce');
                                    var farms=document.getElementById('farms');
                                    var approvalSect=document.getElementById('approvalSect');
                                    var produce=document.getElementById('farm_produces');
                                    var mainPDF=document.getElementById('mainPDF');
                                    mainPDF.style.display='none';
                                    farms.style.display='none';
                                    produce.style.display='none';
                                    admin.style.display='none';
                                    approvalSect.style.display='none';
                                    </script>            
                                    ";
                                <!-- include("adminReports.php "); -->
                            }
                                
                            }
                        %>
             </div>
        </div>
        
        <script type="text/javascript">
            // get the div elements
            // the function below is used to route to different pages according to their different url parameters
            function showPage(type,name="") {   
                console.log(type)   
                if(type === "admin"){
                    window.location.href='dashboard.php?mode=admin';                
                }else if(type === "users"){
                    window.location.href='dashboard.php?mode=users';
                }else if(type === "produce"){
                    window.location.href='dashboard.php?mode=produce';
                }else if(type === "approvals"){
                    window.location.href='dashboard.php?mode=approvals';
                }else if(type === "pdfView"){
                    window.location.href='dashboard.php?mode=pdfView&name='+name;
                }else if(type === "reports"){
                    window.location.href='dashboard.php?mode=reports';
                }
            }
            function rejectApprove(type,person){
                console.log(type,person)
                
            }
            function hey() {
                console.log(hey)
            }
            
           
        </script>
    </body>
</html>