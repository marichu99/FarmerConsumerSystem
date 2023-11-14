<%@ page import="com.servlet.app.model.entity.Product" %>
<%@ page import="com.servlet.database.Database" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../css/dash.jsp" ></jsp:include>
    <jsp:include page="../css/checkout.jsp" ></jsp:include>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"> 
    <title>Document</title>
</head>
<body>
    <jsp:include page="./sideBar.jsp" />
    <div class="navDeets">
        <section class="farm_produce" id="farms">        
            <h3>Featured Farm Products</h3>
        
            <div class="prod_row" id="farm_produces">
                <!-- all products -->
                <%   
                Database dbInstance = Database.getDbInstance();     
                for (Product product : dbInstance.getProducts()){     
                %>    
                    <div class="prod_item">                            
                        <img src='./images/corn.jpg' class="image_prod"/><br/>
                        <span class="prodName"><%=product.getProductName()%></span><br/>
                        <span class="prodLocation"><%= product.getProductDescription()%></span><br/>
                        <span class="prodPrice"><% product.getPrice();%></span><br/>
                        <div class="innerButtons">
                            <button class='button'>Remove</button>
                            <button class="open-button" onclick="openForm()">Edit</button>
                        </div>
                    </div>
                <%
                }
                %>    
                 <!-- A button to open the popup form -->
                <

                <!-- The form -->
                <div class="form-popup" id="myForm">
                <form action="../produce" class="form-container" method="POST">
                    <h1>Login</h1>

                    <label for="email"><b>Product Name</b></label>
                    <input type="text" placeholder="Enter product name" name="prodname" required>

                    <label for="psw"><b>Product Description</b></label>
                    <input type="text" placeholder="Enter product description" name="prodescription" required>

                    <label for="email"><b>Product Quantity</b></label>
                    <input type="text" placeholder="Enter desired quantity" name="prodQuantity" required>

                    <label for="psw"><b>Price</b></label>
                    <input type="text" placeholder="Enter desired price per Quantity" name="prodprice" required>

                    <button type="submit" class="btn">Login</button>
                    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
                </form>
                </div>             
            </div>    
        </section> 
    </div>    
</body>
<script type="text/javascript">
        function openForm() {
            document.getElementById("myForm").style.display = "block";
        }

        function closeForm() {
            document.getElementById("myForm").style.display = "none";
        } 
</script>
</html>
    
