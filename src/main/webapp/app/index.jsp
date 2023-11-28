
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
        <div class="form-popup" id="myForm">
            <form action="./produce" class="form-container" method="POST">
                <h2>Edit Details</h2>
                <input type="hidden" id="hiddenId" name="productId">
                <input type="hidden" value="update" name="product">
                <label for="email"><b>Product Name</b></label>
                <input type="text" placeholder="Enter product name" name="productName" required>
                <label for="psw"><b>Product Description</b></label>
                <input type="text" placeholder="Enter product description" name="productDescription" required>
                <label for="email"><b>Product Quantity</b></label>
                <input type="number" placeholder="Enter desired quantity" name="prodQuantity" required>
                <label for="psw"><b>Price</b></label>
                <input type="number" placeholder="Enter desired price per Quantity" name="price" required>
                <button type="submit" class="btn">Edit</button>
                <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
            </form>
        </div>
    </div>
                            
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