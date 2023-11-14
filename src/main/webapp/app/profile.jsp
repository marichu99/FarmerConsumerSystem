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
        <!-- div for users -->
    <section class="farm_produce" id="allUsers">       
        
        <div class="prod_row" id="users">
            <div class="main" id="main"> 
            <form action="profileUpload.php" enctype="multipart/form-data" method="POST" >
                    <div class="row">
                        <div class="col">
                            <h3 class="title" onclick="window.location.href='productDetail.php'">Please Provide us with more details <%=session.getAttribute("email") %></h3>
                            <div class="profileHeader">
                                <div class="userDetails">
                                    <h2></h2>
                                    <p></p>
                                    
                                </div>
                                <div class="userImage">
                                    <!-- check whether the user has uploaded the photos -->

                                    <div class="profilePic">
                                        <img src="./images/profile.jpg" alt="" id="pic">
                                    </div>

                                    <!-- else -->
                                    <div class="profilePic">
                                        <img src="images/profile.jpg" alt="" id="pic">
                                    </div>
                                    <input type="file" id="upload" accept="Image/*" onchange="readURL(this)" value="Select an Image" name="userIMG"/>

                                </div>
                            </div>
                            <div class="details">
                                <div>
                                    <div class="user">
                                        <label>Change your Password</label>
                                        <input type="password" placeholder="Enter your password" name="password" id="password"/>
                                    </div>
                                    <div class="user">
                                        <label>Confirm your Password</label>
                                        <input type="password" placeholder="Confirm your Password" name="passwordRe" id="passwordRE"/>
                                    </div>
                                    
                                    <div class="flex">
                                        <div class="user">
                                        <input type="submit" value="SUBMIT CHANGES" class="submit" name="submit">
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <div class="user">
                                        <label id="passError"></label>
                                    </div>
                                    <div class="user">
                                        <label id="passConfirm"></label>
                                    </div>
                                    <div class="flex">
                                        <div class="user">
                                        <input type="submit" value="DELETE ACCOUNT" class="submit" name="delete" id="delete">
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </div>
                                
                    </div>

            </form>
            </div>
        </div>    
    </section>
    </div>    
</body>
</html>
    
     
