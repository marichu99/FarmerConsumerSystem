<%-- <%
            // Check if the user is a normal user
            if (session.getAttribute("userType") != null && session.getAttribute("userType").equals("user")) {
                // Include the main page content
                RequestDispatcher dispatcher = request.getRequestDispatcher("./sideBar.jsp");
                // this will include the sidebar
                dispatcher.include(request, response);
                
                // Get the value of the "pageDest" request parameter
                String pageDest = request.getParameter("page");

                // Include pages based on the "pageDest" parameter
                if (pageDest != null) {
                    if (pageDest.equals("account")) {
                        dispatcher = request.getRequestDispatcher("./profile.jsp");
                    } else if (pageDest.equals("approval")) {
                        dispatcher = request.getRequestDispatcher("./approvals.jsp");
                    } else if (pageDest.equals("produce")) {
                        dispatcher = request.getRequestDispatcher("./produce.jsp");
                    } else if (pageDest.equals("sell")) {
                        dispatcher = request.getRequestDispatcher("./sell.jsp");
                    } else if (pageDest.equals("reports")) {
                        dispatcher = request.getRequestDispatcher("./reports.jsp");
                    } else if (pageDest.equals("cart")) {
                        dispatcher = request.getRequestDispatcher("./cart.jsp");
                    } else if (pageDest.equals("track")) {
                        dispatcher = request.getRequestDispatcher("./track.jsp");
                    }

                    if (dispatcher != null) {
                        // this will include the content from the various routes
                            // out.println("<div class='navDeets'>");
                            // dispatcher.include(request, response);
                            // out.println("</div>");
                    }
                }else if(dispatcher!= null){                        
                    // dispatcher=request.getRequestDispatcher("./customerDashMain.jsp");
                    // dispatcher.include(request, response);
                }
                
            }else if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("admin")){
                // Include the main page content
                RequestDispatcher dispatcher = request.getRequestDispatcher("./customerDashMain.jsp");
                // this will include the sidebar
                // dispatcher.include(request, response);

                
                // Get the value of the "pageDest" request parameter
                String pageDest = request.getParameter("page");

                // Include pages based on the "pageDest" parameter
                if (pageDest != null) {
                    if (pageDest.equals("reports")) {
                        dispatcher = request.getRequestDispatcher("./reports.jsp");
                    } else if (pageDest.equals("admin")) {
                        dispatcher = request.getRequestDispatcher("./admin.jsp");
                    } else if (pageDest.equals("produce")) {
                        dispatcher = request.getRequestDispatcher("./produce.jsp");
                    } else if (pageDest.equals("users")) {
                        dispatcher = request.getRequestDispatcher("./users.jsp");
                    } else if (pageDest.equals("approvals")) {
                        dispatcher = request.getRequestDispatcher("./approvals.jsp");
                    } 

                }else if(dispatcher!= null){                        
                    dispatcher=request.getRequestDispatcher("./customerDashMain.jsp");
                    
                }
            }            
        %> --%>
<!DOCTYPE html>
<html>
    <head lang="en">
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- CSS -->
    <jsp:include page="../css/dash.jsp" ></jsp:include>
    <jsp:include page="../css/checkout.jsp" ></jsp:include>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"> 
    </head>
    <body>
    <jsp:include page="./sideBar.jsp" />

    <div class="navDeets">
    <jsp:include page="./customerDashMain.jsp" />
    <!-- include the customerDash nav -->

    </div>
        

            
            <!-- the div below is for the main content -->                
            
            <!-- div for the header content -->
            
            <!-- div for sign up to users -->

                
            <!-- div for products -->
                    
            <!-- div for approvals -->
            
            <!-- div for ?PurchaseApprovals? -->
            <%-- there is not gonna be any need for purchase approvals as the payment integration will automatically handle this --%>
                            
        <script type="text/javascript">
            // get the div elements
           
            function showPage(type) {      
                if(type .equals= "approvals"){
                    window.location.href='customerDash.php?mode=approvals';                
                }else if(type .equals= "profile"){
                    window.location.href='customerDash.php?mode=profile';
                }else if(type .equals= "produce"){
                    window.location.href='customerDash.php?mode=produce';
                }else if(type .equals= "reports"){
                    window.location.href='customerDash.php?mode=reports';
                }else if(type .equals= "PurchaseApprovals"){
                    window.location.href='customerDash.php?mode=PurchaseApprovals';
                }
                
            }
            function rejectApprove(type,person){
                console.log(type,person)
                
            }
            function toggleSidebar(){
                console.log(window.innerWidth);
                // this funtion will only work on smaller devices using the code below
                if(window.innerWidth <=600){
                    // get the sidebar class id
                    var sidebar=document.querySelector(".navContainer");
                    sidebar.style.display="none";
                }
1           }           
        </script>
    </body>
</html>