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
        <div class="main">        
            <form action="./produce" enctype="multipart/form-data" method="POST" >
                <div class="row">
                    <div class="col">
                        <h3 class="title">Product Details</h3>                        <a href="customerDash.php">Dashboard</a>
        
                        <div class="user">
                            <label>Product Name</label>
                            <input type="text" placeholder="E.g. Names..." name="prodName"/>
                        </div>
                        <div class="user">
                            <label>Product Description:</label>
                            <input type="text-area" placeholder="Please type in a description" name="prodDescription"/>
                        </div>
                        <div class="user">
                            <label>Select Image:</label>
                            <input type="file"  value="Select an Image" name="prodImg"/>
                        </div>
                        <div class="user">
                            <label>Product Price Per Kilo:</label>
                            <input type="number" placeholder="Enter Price per product" name="prodPrice"/>
                        </div>
                        <div class="flex">
                            <div class="user">
                                <label>Country:</label>
                                <input type="text" placeholder="Kenya" name="prodCountry"/>
                            </div>
                            <div class="user">
                                <label>Product Location:</label>
                                <input type="text" placeholder="E.g. New York" name="prodLocation"/>
                            </div>
                            <div class="user">
                                <label>Product Quantity (Kilos):</label>
                                <input type="number" placeholder="E.g. 20..." name="prodQuantity"/>
                            </div>
                </div>
                <input type="submit" value="Submit" class="submit" name="submit"/>
            </form>
        </div>
    </div>    
</body>
</html>
