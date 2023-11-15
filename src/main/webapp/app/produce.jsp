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
                        <div class="imgDiv">
                            <img src='../images/corn.jpg' class="image_prod"/><br/>
                        </div>                      
                        <div class="deetsDiv">
                            <span class="prodName"><%=product.getProductName()%></span><br/>
                            <span class="prodLocation"><%= product.getProductDescription()%></span><br/>
                            <span class="prodPrice"><%=product.getPrice()%></span><br/>
                            <div class="innerButtons">
                                <button class='buttonRemove' onclick="window.location.href='../produce?type=product&productID=<%= product.getProductId()%>&mode=remove'">Remove</button>
                                <button class="buttonEdit" onclick="openForm(<%= product.getProductId()%>)">Edit</button>
                                <button class='button' onclick="window.location.href='../cart?mode=add&productId=<%= product.getProductId()%>'">Buy</button>
                            </div>
                        </div>                        
                    </div>
                <%
                }
                %>    
                 <!-- A button to open the popup form -->
                <!-- The form -->
                <div class="form-popup" id="myForm">
                <form action="../produce" class="form-container" method="POST">
                    <h2>Edit Details</h2>
                    <input type="hidden" id="hiddenId"  name="productId">
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
        </section> 
    </div>    
</body>
<script type="text/javascript">
        function openForm(productId) {
            document.getElementById("myForm").style.display = "flex";
            document.getElementById("hiddenId").value = productId;
        }

        function closeForm() {
            document.getElementById("myForm").style.display = "none";
        } 
</script>
</html>
    
