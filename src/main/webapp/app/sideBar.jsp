    <!-- the div below is for the Sidebar Container -->

    <nav class="navContainer">
        <div class="logoName">
            <span class="logo_name">Ukulima Bora</span>
        </div>
        <% 
                if(session.getAttribute("userType") == "Admin"){
        %>
            <h3>Admin Dashboard Panel</h3>
        <% 
                }else if(session.getAttribute("userType") =="User"){
        %>
            <h3>User Dashboard Panel</h3>
        <% 
                }
        %>
        <form method="post">
        <div class="menu-items">
            <%  if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("user")){%>
            <ul class="nav-links">
                <li><a href="#">
                <img src="icons/home.jpg" class="icon"/>
                    <span class="link-name" onclick="window.location.href='./home'">Dashboard</span>
                </a></li>
                <li><a href="#">
                <img src="icons/user-circle.jpg"class="icon"/>
                    <span class="link-name" onclick="window.location.href='./produce?type=product&mode=mine'">My Products</span>
                </a></li>
                <li><a href="#">
                <img src="icons/user-circle.jpg"class="icon"/>
                    <span class="link-name" onclick="window.location.href='./produce?type=product&mode=all'">All Products</span>
                </a></li>
                <li><a href="#">
                <img src="icons/angle-double-down.jpg"class="icon"/>
                    <span class="link-name" onclick="window.location.href='./sell'">Sell</span>
                </a></li>
                <li><a href="#">
                <img src="icons/plane-arrival.jpg" class="icon" />
                    <span class="link-name" onclick="window.location.href='./cart'">Cart Items</span><span class="approvals"> <%=0%></span>
                </a></li>
                            
            </ul>
            <% }else  if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("admin")){%>
            <ul class="nav-links">
                        <li><a href="#">
                            <img src="icons/home.jpg" class="icon"/>
                            <span class="link-name" onclick="window.location.href='./home'">Dashboard</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/chart-line.jpg" class="icon"/>
                            <span class="link-name" onclick="window.location.href='./reports'">Reports</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/adjust-circle.jpg" class="icon" />
                            <span class="link-name" onclick="window.location.href='./admin'" >User</span>
                        </a></li>
                        <li><a href="#">
                            <img src="icons/plane-fly.jpg"class="icon" />
                            <span class="link-name" onclick="window.location.href='./produce'">Produce</span>
                        </a></li>                        
            </ul>
            <% }%>

            <ul>
                <li><a href="./logout">
                <img src="icons/signout.jpg" class="icon" />
                    <span class="link-name">Log out</span>
                </a></li>
            </ul>
        </div>
        </form>
    </nav>