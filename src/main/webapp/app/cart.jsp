

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <jsp:include page="../css/dash.jsp" ></jsp:include>
    <jsp:include page="../css/checkout.jsp" ></jsp:include>
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css"> 
</head>
<body>
    <jsp:include page="./sideBar.jsp"/>
    <div class="navDeets">
    <div class="Container">
        <div class="recentContainer">
            <table class="myTable">
                    <tr>
                        <th>Product</th>
                        <th>Product Quantity</th>
                        <th>Product Price</th>
                        <th>Total Price</th>
                    </tr>
                    <% 

                        if(isset($res)){
                            while($iterations<$numResult){
                    %>
                    <tr id="<% echo $iterations;%>">
                    
                        <td><img src='prodIMG/<% echo $arr_results[$iterations]["imgDIR"];%>' class="image_prod"/><br/><% echo $arr_results[$iterations]["productName"]%></td>
                        
                        <td id="prodQuantity"><p id="errText<% echo $iterations;%>"></p><input type="number" placeholder="Choose Quantity" name="numQuantity" class="numQuantity" id="numQuantity<% echo $iterations;%>" onkeyup="calculatePrice(event,<% echo $iterations;%>)" />/ <span  id="totalQuantity<% echo $iterations;%>"><% echo $arr_results[$iterations]["Quantity"]. "Kg"%></span></td>
                        <td><% echo $arr_results[$iterations]["Price"] ." Kshs"%></td>
                        
                        <input type="hidden" name="hiddenQuantity" id="hiddenQuantity<% echo $iterations%>" name="hiddenQuantity<% echo $iterations%>" value="<% echo $arr_results[$iterations]["Price"]  %>"/>
                        <td id="comPrice<% echo $iterations%>"><% echo $arr_results[$iterations]["Price"]*$arr_results[$iterations]["Quantity"] ."Kshs"%></td>
                        <% $sumTotal= $arr_results[$iterations]["Price"]*$arr_results[$iterations]["Quantity"]%>
                        <!-- update the product details array for each iteration -->
                        <% 
                            $imgDIR=$arr_results[$iterations]["imgDIR"];
                            // get the cartID for this item
                            $sqlGetCartId="select * from usercart where imgDIR='$imgDIR'";
                            $queryGetCartId=mysqli_query($conn,$sqlGetCartId) or die(mysqli_error($conn));
                            $res=mysqli_fetch_assoc($queryGetCartId);
                            $cartID=$res["cartID"];

                            echo '<input type="hidden" name="cartedID'.$iterations.'" id="cartedID'.$iterations.'" value='.$cartID.'/>';                            
                        %>
                        <td><i class="uil uil-trash-alt" onclick="window.location.href='delete.php?prodID=<% echo $arr_results[$iterations]['ProductID'];%>&userID=<% echo $arr_results[$iterations]['userID']; %>'"></i></td>
                    </tr>
                  
                    <% 
                            $sum = $sum+$sumTotal;
                            $iterations=$iterations+1;
                            }
                        }   
                    %>                    
            </table>
        </div>
        <div class="checkout">
            <h3 class="checkOutHeader">The Total Comprehensive Price is:</h3>
            <!-- set the total number if iterations in a hidden field -->
            <input type="hidden" value="<% echo $iterations;%>" id="numIterations"/>
            <span class="priceText"><% echo $sum ." Kshs";%></span>
            <input class="submit" name="submit" value="proceed to checkout" onclick="submitDetails()"/>
        </div>
    </div>
    </div>


</body>
<script type="text/javascript">
    // initiate a boolean value to check whether the user has changed some fields
    var changed=false;
    // initaite the form Element
    var form=document.getElementById("form");   
    
    var totalSumGlobal=0;
     
    var cartIDGlobal= new Array();

    var quantityGlobal= new Array();

    var pricesGlobal= new Array();

    // get the total Number of $iterations
    var totalIterations=document.getElementById("numIterations");
    totalIterations=totalIterations.value;
    totalIterations=totalIterations.match(/\d/g);
    totalIterations=totalIterations.join("");
    totalIterations=parseInt(totalIterations)

    for(var i=0;i<totalIterations;i++){
        var thisPrices=document.getElementById("comPrice"+i);
        thisPrice=thisPrices.textContent;                
        thisPrice=parseInt(thisPrice);
        var totalQuant=document.getElementById("totalQuantity"+i);
        totalQuant=totalQuant.textContent;
        totalQuant=totalQuant.match(/\d/g);
        totalQuant=totalQuant.join("");
        totalQuant=parseInt(totalQuant);
        
        pricesGlobal.push(thisPrice);
        quantityGlobal.push(totalQuant);
    }

    function calculatePrice(e,id) {
        // initiate the array storing the new user input values 
        var newQuantity=new Array();
        var cartIDs= new Array();
        var newPrices=new Array();

        // change the status to be true
        changed=true;

        // all errors to removed when a user types
        var errText=document.getElementById("errText"+id);
        errText.textContent="";

        // get the element of the input quantity
        var prodQuantity=e.target.value;
        // change it to int for mathematical operation
        prodQuantity=parseInt(prodQuantity);


        // get the totalQuantity
        var totalQuant=document.getElementById("totalQuantity"+id);
        totalQuantity=totalQuant.textContent;
        totalQuantity=totalQuantity.match(/\d/g);
        totalQuantity=totalQuantity.join("");
        totalQuantity=parseInt(totalQuantity);
        console.log(totalQuantity,prodQuantity);

        // get the new quantity and append it to the array 
        var updatedQuantity=totalQuantity-prodQuantity;
        newQuantity.push(updatedQuantity);        

        if(prodQuantity<totalQuantity || prodQuantity==totalQuantity){                    
            // get the price per quantity from the hidden input field
            var price=document.getElementById("hiddenQuantity"+id)
            price=parseInt(price.value);
            // get the element that shows the total price
            var totalPrice=document.getElementById("comPrice"+id);
            totalPrice=totalPrice.textContent;
            totalPrice=totalPrice.match(/\d/g);
            totalPrice=totalPrice.join("");
            totalPrice=parseInt(totalPrice)
            
            // calculate the totalprice using the price the user has just put in        
            var priceShow=price*prodQuantity;

            newPrices.push(priceShow);           
            
           
            // instantiate the overall price
            var overall=document.querySelector(".priceText");
            

            // for loop to display the price 
            var totalSum=0;
            var prePrice=priceShow;
            for(var i=0;i<totalIterations;i++){

                var thisPrices=document.getElementById("comPrice"+i);
                thisPrice=thisPrices.textContent;                
                thisPrice=parseInt(thisPrice);
                console.log(pricesGlobal);
                
                // if the iteration is the same index as the changed price, modify the priceGlobal to effect this
                if(i === id){  
                    // reconcile the prices
                    var thisPrice=prePrice;     
                    // console.log(`the price at ${i} after change is `,thisPrice);
                    thisPrices.textContent=thisPrice+" Kshs";    
                    pricesGlobal[i]=thisPrice;   
                    quantityGlobal[i]=prodQuantity;
                    
                }  
                //  get the cart IDS for every carted ClipboardItem
                var thisCartID=document.getElementById("cartedID"+i);          
                thisCartID=thisCartID.value;
                thisCartID=parseInt(thisCartID);
                cartIDs.push(thisCartID);


                 totalSum=totalSum+thisPrice;   
                                       
            }
                cartIDGlobal=cartIDs;
                console.log("Global Prices",newPrices);
                console.log(quantityGlobal);
                overall.textContent=totalSum+" Kshs";
                totalSumGlobal=totalSum;
           
           

        }else{
            var prodQuant=document.getElementById("numQuantity"+id);
            prodQuant.textContent=""
            var errText=document.getElementById("errText"+id);
            errText.textContent="Please enter a quantity lower than the total";
            errText.style.color="red";
        }
    }
        // if user has not changed any values send the form with the default values
        function submitDetails(){                  
        
            if(changed === false){
                var defaulPrices=new Array();
                var cartIDs=new Array();
                var totalIterations=document.getElementById("numIterations");
                var newQuantity=new Array();
                var totalSum=0;
                totalIterations=totalIterations.value;
                totalIterations=parseInt(totalIterations)
                for(var i=0;i<totalIterations;i++){
                    var thisPrices=document.getElementById("comPrice"+i);
                    var totalQuant=document.getElementById("totalQuantity"+i);
                    totalQuant=totalQuant.textContent;
                    totalQuant=totalQuant.match(/\d/g);
                    totalQuant=totalQuant.join("");
                    totalQuant=parseInt(totalQuant);
                    thisPrice=thisPrices.textContent;
                    thisPrice=parseInt(thisPrice);
                    
                    defaulPrices.push(thisPrice);

                    var thisCartID=document.getElementById("cartedID"+i);          
                    thisCartID=thisCartID.value;
                    thisCartID=parseInt(thisCartID);
                    cartIDs.push(thisCartID);
                    newQuantity.push(totalQuant);


                    var totalSum=totalSum+thisPrice;   
                    console.log("The total sum is",totalSum);   
                    console.log("The default prices",defaulPrices)                                    
                }
                window.location.href="pay.php?cartIDs="+cartIDs+"&productQuants="+newQuantity+"&totals="+totalSum+"&newPrices="+defaulPrices                
            }else{
                
                window.location.href="pay.php?cartIDs="+cartIDGlobal+"&productQuants="+quantityGlobal+"&totals="+totalSumGlobal+"&newPrices="+pricesGlobal;                 
            }
     }


</script>
</html>