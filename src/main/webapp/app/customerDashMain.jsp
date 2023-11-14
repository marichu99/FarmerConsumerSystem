<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="navDeets">
        <div class="header-deets">
            <div class="acc-details">
                <span class="acc-span-deets">Sold:</span>
                <span class="acc-span-deets">KSHS 3000</span>
            </div> 
            <div class="acc-details">
                <span class="acc-span-deets">Bought:</span>
                <span class="acc-span-deets">KSHS 5000</span>
            </div>
            <div class="acc-details">
                <span class="acc-span-deets">Totals:</span>
                <span class="acc-span-deets">KSHS -2000</span>
            </div>
        </div>
        <div class="sectionDeets">
            <h3>Recent Activity</h3>
                <select class="logFilters" onchange="getFeature(this,'logsUser')">
                    <option>Choose   </option>
                    <option>Login</option>
                    <option>Log Out</option>
                    <option>Sell</option>
                    <option>Buy</option>
                    <option>Seller Approval</option>
                    <option>Password Change</option>
                </select>
            <h3 class="export" onclick="window.location.href='export.php?logReport=user&username=<?php echo $userName;?>'">Export Report</h3>
            
        </div>
            <table class="myTable">
                    <tr class="key">
                        <th>Log ID</th>
                        <th>User Name</th>
                        <th>Email</th>
                        <th>Action</th>
                        <th>TimeStamp</th>
                        <th>IP Address</th>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                
                    
            </table>  
    </div>  
</body>
</html>
    

