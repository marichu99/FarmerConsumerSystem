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
    <jsp:include page="sideBar.jsp" />
    <div class="navDeets">
        <section class="farm_produce" id="approvalSect">                                            
            <div class="prod_row" id="usersApproval">
                <div class="main" id="main"> 
                    <form>
    
                        <div class="row">
                            <div class="col">
                                <h3 class="title" onclick="window.location.href='productDetail.php'"> YOUR APPROVAL STATUS IS: </h3>
    
    
                                <div class="detailsApproved">
                                    <h3 class="mode"><img src="icons/check.svg" class="icons" id="checked" />Approved</h3>
                                </div>
                                <div class="detailsApproved">
                                    <span>Dear @ </span><br/>
                                    <p>Your details have been approved and you can <a href="sell.php">sell</a> on the platform.</p>
                                </div>
    
                                <div class="detailsApproved">
                                    <h3 class="modeNot"><img src="icons/times.svg" class="icons" id="checked" /></i>REJECTED</h3>
                                </div>
                                <div class="detailsApproved">
                                    <span>Dear @ </span><br/>
                                    <p>Your request for seller approval has been rejected by the admin. If you wish to appeal kindly reach out to them @ ukulimabora44@gmail.com</p>
                                </div>
    
                                <p>You can request for a seller's approval at the <a href="sell.php">sell</a> on the platform.</p>
                            </div>                                                
    
                        </div>      
                    </form>      
                </div>
            </div>                
    
    </section>
    </div>    
</body>
</html>     
