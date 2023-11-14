<%@ page import="com.servlet.utils.Calculator" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="with=device-with, initial scale=1.0">
        <title> Farmer Consumer Linkage Management System </title>
    </head>
    <!-- <link rel="stylesheet" href="styles.css"> -->
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.1/css/fontawesome.min.css">
    <body>
        <div class="banner">
           
          <nav>
            <div class="navbar" id="navbar">
                <span><i class="uil uil-user-circle"></i>Welcome</span>
                <div class="navlinks" id="navLinks">                
                    <i class="fa fa-times" onclick="hideMenu()" id="times"></i>
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="./login">Login</a></li>
                    <li><a href="./sign">Sign Up</a></li>
                    <li><a href="contact.php">Contact Us</a></li>
                    <li><a href="about.html">About Us</a></li>
                </ul>                                                
                </div>
            </div>
        </nav>
            <div class="content">
                <h1>BUY AND SELL FARM PRODUCE</h1>
                <P>Buy or Sell Farm produce in the click of a button</P>
                <div>
                    
                    <input type="submit" class="button" onclick="window.location.href='buy.php'" value="BUY" name="buy"/>
                    <input type="submit" class="button" onclick="window.location.href='sell.php'" value="SELL" name="sell"/>
                    
                    
                </div>
            </div>
            
        </div>
     
        <section class="farm_produce">
            <h1>Featured Farm Products</h1>
            <div class="prod_row">
                <div class="prod_item">
                    <img src="images/white_maize.jfif" class="image_prod"/>
                    <span class="prodName">White Maize</span>
                    <span class="prodLocation">Uasin Gishu</span>                    
                </div>
                <div class="prod_item">
                    <img src="images/Yellow-beans.jpeg" class="image_prod"/>
                    <span class="prodName">White Maize</span>
                    <span class="prodLocation">Uasin Gishu</span>                    
                </div>
                <div class="prod_item">
                    <img src="images/white_wheat" class="image_prod"/>
                    <span class="prodName">White Maize</span>
                    <span class="prodLocation">Uasin Gishu</span>                    
                </div>
                <div class="prod_item">
                    <img src="images/white_wheat" class="image_prod"/>
                    <span class="prodName">White Maize</span>
                    <span class="prodLocation">Uasin Gishu</span>                    
                </div>
            </div>
            <h2>Search by Location</h2>
            <div class="prod_row">
                <div class="prod_item">
                    <img src="images/uasin_gishu.jpg" class="image_prod"/>
                    <span class="prodName">White Maize</span>
                    <span class="prodLocation">Uasin Gishu</span>                    
                </div>
                <div class="prod_item">
                    <img src="images/barley.jpg" class="image_prod"/>
                    <span class="prodName">Barley</span>
                    <span class="prodLocation">Uasin Gishu</span>                    
                </div>
                <div class="prod_item">
                    <img src="images/rice.jfif" class="image_prod"/>
                    <span class="prodName">Rice</span>
                    <span class="prodLocation">Ahero</span>                    
                </div>
                <div class="prod_item">
                    <img src="images/tomato.jpg" class="image_prod"/>
                    <span class="prodName">Tomato GreenHouse</span>
                    <span class="prodLocation">Tharaka Nithi</span>                    
                </div>
            </div>
            
        
        </section>
        <div class="foot">
          <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="footer-col-1">
                        <h3>Ukulima Bora</h3>
                        <p>Your online stop for all things art and decor</p>
                    </div>
                    <div class="footer-col-2">
                        <p>If you have any questions or comments, please contact us via email or phone</p>
                            <br>
                            <p>Email:email@example.com<br>
                            Phone:<br>+254 746 343590
                        </p>
                    </div>
                </div>
                <hr>
                    <p class="copyright">Copyright 2023 - Art Gallery</p>
            </div>
        </div>
        </div>
        <script src="js/login.js" type="text/javascript"></script>
        <!-- Javascript for toggling the menu -->
        <script type="module">
            var navbar = document.getElementById("navbar")
            var navlinks= document.getElementById("navLinks")
            function hideMenu(){
                navlinks.style.right="-200px"
            }
            function showMenu(){
                navlinks.style.right="0"
            }
           
        </script>
       
    </body>
</html>