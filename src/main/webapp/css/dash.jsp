<style>

    body{
        min-height: 100vh;
        background-color: aliceblue;
        display:flex;
        flex-direction: row;
    }
    .navlets{
        display: flex;
        flex-direction: row;
        position: relative;
        top: 0;
        left: 0;
        height: 100%;
        width: 100%;
    }
    .nav{
        display: flex;
        flex-direction: column;
        width: 250px;
        border-right: 1px solid grey;
        transition: 1.5s;
    }
    .navClose{
        width: 75px;    
    }
    .logoName{
        padding: 10px;
        margin: 10px;
        margin-left: 45px;
        margin-bottom: 5px;
        justify-content: center;
    }
    .logo_name{   
        font-family: sans-serif;
        font-size: 25px;
        font-weight: bolder;
        left: 20px;
    }
    .menu-items{
        top: 60px;
        /* background-color: rgb(253, 180, 180); */
        border-radius: 20px;
        height: calc(100vh - 75px);
        margin: 5px;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }

    .menu-items ul li a{
        text-decoration: none;
    }
    .menu-items ul li{
        list-style: none;
        padding: 10px;
        margin: 10px;
    }

    .menu-items ul li a:hover .link-name,
    .menu-items ul li a:hover .icon{
        color: grey;
    }
    .approvals{
        padding: 5px 10px;
        border-radius: 20px;
        background-color: brown;
        color: whitesmoke;
        font-weight: bold;
        font-size: large;
        text-align: center;
        text-transform: uppercase;
    }
    .link-name{
        font-family: sans-serif;
        font-size: large;
        color: black;
        font-weight: bold;
        outline: none;
        border: none;
        background: none;
    }
    .icon{
        font-size: 15px;
        min-width: 29px;
        height: 25px;
        color: grey;
        cursor: pointer;
    }
    .dashboard{
        height: 100vh;
        /* background-color: blanchedalmond; */
        width: 70%;
        margin: 15px;
    }
    .dashboard .top{
        display: flex;
        justify-content: space-between;
        padding: 10px 14px;
    }
    .search-box{
        margin-top: 30px;
        height: 35px;
        border: 1px solid;
        border-radius: 5px;
        padding: 8px 14px;
    }
    .input-box{
        outline: none;
        position: relative;    
        height: 28px;
        border: none;
        background-color: aliceblue;
        text-align: center;
    }
    .top{
        height: 50px;
    }
    .acc-details{
        
        height: 100px;
        width: 200px;
        background-color: rgb(250, 229, 229);
        border-radius: 15px;
        transition: transform .5s;
        display: flex;
        flex-direction: column;

    }
    .acc-details:hover{
        transform: scale(1.1);
        box-shadow: 1px solid grey;
    }
    .header-deets{
        display: flex;
        flex-direction:row;
        justify-content: space-between;
        margin-left: 100px;
        margin-right: 100px;
        margin-top: 50px;
    }
    .header-deets .acc-span-deets{
        position: relative;
        top: 1px;

        padding:  3px;
        margin: 8px;
        margin-top: 10px;
        font-family: sans-serif;
        font-size: large;
        font-weight: 10px;
    }
    .recentContainer{
        display: flex;
        justify-content: space-between;
        align-items: center;
        flex-direction: row;
        margin: 25px;
        padding: 10px 15px;
    }
    .recentTitle{
        font-weight: bold;
        font-size: large;
        font-family: serif;
    }
    .recent{
        display: flex;
        flex-direction: column;
    }
    .recenData{
        padding: 8px;
        font-size: 15px;
    }
    .sectionDeets{
        display: flex;
        justify-content: space-between;
    }
    .sectionDeets h3{
        background-color: rgb(192, 192, 253);
        color: white;
        padding: 14px;
        width: 150px;
        border-radius: 15px;
        margin: 15px;
    }
    .sectionDeets select{
        position: relative;
        height: 5vh;
        top: 30px;
    }
    .myTable{
        width: 100%;
    }
    tr:nth-child(even) {background-color: #f2f2f2;}

    .myTable th, td {
        border-bottom: 1px solid #ddd;
    }
    .myTable .key{
        border-radius: 12px;
        background-color: rgb(243, 121, 121);
    }
    .navContainer{
        width: 20%;
        background-color:rgb(210 210 233);
        margin-right:50px;
    }



    /* CSS FOR THE ADMIN FORM */

    .main{
        display: none;
        justify-content: center;
        align-items: center;
        background: linear-gradient( rgba(88, 88, 88, 0.2),rgba(182, 180, 180, 0.4));
        min-height: 100vh;
        padding-top: 20px;
        padding-bottom: 10px;
    }
    form .row{
        display: flex;
        flex-wrap: wrap;
        gap: 15px;
    }
    .main form .row .col{
        flex: 1 1 250px;
    }
    .main form .row .col .title{
        font-size: 20px;
        color: black;
        text-transform: uppercase;
    }
    .main form .row .col .user{
        margin: 10px 0;
        display: flex;
        flex-direction: column;
        padding: 5px 12px;
    }
    .main form .row .col .user label{
        margin-bottom: 5px;
    }
    .main form .row .col .user input{
        width: 100%;
        border: 1px solid grey;
        padding: 10px 15px;
        font-size: 15px;
        text-transform: none;
        border-radius: 10px;
    }
    .main form .row .col .user input:focus{
        border: 1px solid black;
    }
    .main form .row .col .flex{
        display: flex;
        justify-content: space-between;
    }
    .main form .submit{
        width: 100%;
        font-size: 17px;
        color: white;
        cursor: pointer;
        background-color: rgb(99, 87, 87);
        border-radius: 10px;
        height: 34px;
        font-family: 'Times New Roman', Times, serif;
        text-transform: uppercase;
        transition: transform .5s;
    }
    .main form .submit:hover{
        background-color: rgb(36, 35, 35);
        transform: scale(0.9);
    }
    .mainApproval{
        display: none;
        justify-content: center;
        align-items: center;
        background: linear-gradient( rgba(88, 88, 88, 0.2),rgba(182, 180, 180, 0.4));
        height: 80%;
        width: 90%;
        padding-top: 20px;
        padding-bottom: 10px;
    }



    /* CSS FOR THE USERS DIV */

    .farm_produce{
        width: 70%;
        padding-top: 10px;
        text-align: center;
        margin: 10px;
    }
    .users{
        width: 60%;
        padding-top: 10px;
        text-align: center;
        margin: auto;
        display:flex;
    }
    .prod_row{
        margin-top: 5%;
        display: flex;
        justify-content: space-between;
        padding-bottom: 0;
        flex-wrap: wrap;
    }
    .prod_item{
        display:flex;
        flex-direction:column;
        flex: 1;
        gap: 10px;
        padding: 0;
        margin: 10px;
        text-align: start;
        transition: transform .5s;
    }
    .prod_item:hover{
        transform: scale(1.1);
    }
    .image_prod{
        width: 200px;
        height: 150px;
        border-radius: 20px;
    }
    .productName{
        font-weight: bold;
        font-size: 20px;
    }
    .productDescription{
        font-weight: 300;
        font-size: 15px;
        font-size: small;
    }
    .price{
        font-weight: bold;
        font-size: 15px;
        color: dark-blue;
    }
    .farm_produce h1{
        font-size: 50px;
        font-weight: bold;
        font-style: normal;
        /* padding: 25px;
        padding-bottom: 0; */
    }

    /* style the sold and bought texts from the REPORTS page */
    .acc-detailsReport{
        margin-left: 50px;
        margin-right: 50px;
        height: 70px;
        width: 200px;
        background-color: rgb(250, 229, 229);
        border-radius: 15px;
        transition: transform .5s;
        display: flex;
    }
    .typeLabel{
        align-items: center;
        margin: 5px;
        padding: 5px 5px;
        text-transform: uppercase;
        padding-top: 12px;
    }
    /* style the parameters report divs */
    .paramsReports{
        padding-top: 30px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        margin-left: 50px;
        margin-right: 50px;
    }
    .param{
        display: flex;
    }
    .priceController{
        display: flex;
        flex-direction: column;
    }
    .button { 
        background-color: #04AA6D; /* Green */
        border-radius: 10px;
        color: white;
        padding: 10px 15px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
    }
    /* code for the export button */
    .export{
        background-color: rgb(156, 245, 156);
        color: black;
        transition: transform .5s;
        padding: 10px;
        margin-left: 100px;
        border-radius: 12px;
        font-weight: bold;
    }
    .export:hover{
        transform: scale(1.1);
        background-color: rgb(19, 131, 19);
        color: white;
        cursor:pointer
    }
    .export .icon{
        top: 0;
        left: 0;
        right: 0;
        margin: 0;
    }

    /* code for the most loyal customer field */
    .loyalCustomer{
        padding-top: 50px;
        margin-left: 30PX;
    }

    /* parameters for different products reports */
    .exportForm{
        display: flex;
        flex-direction: row;
    }
    .productCategory{
        width: 70%;
        padding: 10px 5px;
        margin: 10px;
    }
    /* parameters for the sales reports */
    .salesExport{
        display: none;
        flex-direction: row;
    }
    .paramLabel{
        padding: 15px;   
    }
    .inputPrice{
        width: 150px;
        height: 30px;
        border-radius: 13px;
        margin-right: 10px;
        margin-left: 10px;
    }

    /* div for showing pdfs and images */
    .pdfShow{
        display: flex;    
        flex-wrap: wrap;
        margin: 10px 15px;
    }
    .mainPDF{
        display: flex;
        flex-direction: column;
        margin: 10px 15px;
    }
    /* button for approving and rejecting users */
    .approveUser{
        color: aliceblue;
        background-color: rgb(62, 248, 62);
        height: 30px;
        padding: 5px 10px;
        margin: 8px;
        border-radius: 10px;
        transition: transform .5s;
    }
    .approveUser:hover{
        transform: scale(1.1);    
        background-color: green;
    }
    .rejectUser{
        color: aliceblue;
        background-color: rgb(252, 105, 105);
        height: 30px;
        padding: 5px 10px;
        border-radius: 10px;
        transition: transform .5s;
    }
    .rejectUser:hover{
        transform: scale(1.1);    
        background-color: red;
    }
    .main{
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient( rgba(88, 88, 88, 0.2),rgba(182, 180, 180, 0.4));
        min-height: 100vh;
        padding-top: 20px;
        padding-bottom: 10px;
    }
    .main form{
        background-color: white;
        border-radius: 20px;
        padding: 20px;
        width: 500px;
    }
    .main form .row{
        display: flex;
        flex-wrap: wrap;
        gap: 15px;
    }
    .main form .row .col{
        flex: 1 1 250px;
    }
    .main form .row .col .title{
        font-size: 20px;
        color: black;
        text-transform: uppercase;
    }
    .main form .row .col .user{
        margin: 10px 0;
        display: flex;
        flex-direction: column;
        padding: 5px 12px;
    }
    .main form .row .col .user label{
        margin-bottom: 5px;
    }
    .main form .row .col .user input{
        width: 100%;
        border: 1px solid grey;
        padding: 10px 15px;
        font-size: 15px;
        text-transform: none;
        border-radius: 10px;
    }
    .main form .row .col .user input:focus{
        border: 1px solid black;
    }
    .main form .row .col .flex{
        display: flex;
        justify-content: space-between;
    }
    .main form .submit{
        width: 100%;
        font-size: 17px;
        color: white;
        cursor: pointer;
        background-color: rgb(99, 87, 87);
        border-radius: 10px;
        height: 34px;
        font-family: 'Times New Roman', Times, serif;
        text-transform: uppercase;
        transition: transform .5s;
    }
    .main form .submit:hover{
        background-color: rgb(36, 35, 35);
        transform: scale(0.9);
    }
    input.message{
        height: 80px;    
    }

    /* The Modal (background) */
    .modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    }

    /* Modal Content */
    .modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 33%;
    }

    /* The Close Button */
    .close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
    }

    .close:hover,
    .close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
    }


    /* page responsiveness */
    @media only screen and (max-width :600px){
        /* css for the sidebar */
        .link-name{
            font-size: smaller;
        }
        .icon{
            font-size: 34px;
        }
        /* css for the landing dashboard page */
        .header-deets{
            margin-right: 5px;
            margin-left: 5px;
        }
        .acc-detailsReport{
            margin-right: 5px;
            margin-left: 5px;
        }
        .acc-details{
            width: 120px;
        }
        .myTable{
            width: 60%;
        }
        .paramLabel{
            padding: 2px;
        }
        .paramsReports{
            margin-left: 2px;
            justify-content: space-between;
        }
        .export{
            margin-left: 30px;
        }
        select{
            width: 20px;
        }
        .inputPrice{
            width: 50px;
        }
        .loyalCustomer{
            padding-top: 2px;
        }
        .recentContainer{
            margin: 5px;
            padding: 2px 5px;
        }
        .image_prod{
            width: 112px;
            height: 100px;
        }
        

    }
</style>