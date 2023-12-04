
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        ${requestScope.content}
        <!-- include the customerDash nav -->
    </div>
        <script src="./js/login.js" type="text/javascript"></script>        
        <script type="text/javascript">
            function openForm(productId) {
                document.getElementById("myForm").style.display = "flex";
                document.getElementById("hiddenId").value = productId;
            }

            function closeForm() {
                document.getElementById("myForm").style.display = "none";
            }

            // get the div elements
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