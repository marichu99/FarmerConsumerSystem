* {
    border: 0;
    padding: 0;
    margin: 0;
    text-decoration: none;
    color: black;
    box-sizing: border-box;
    font-family: 'Open Sans', sans-serif;
    list-style: none
}

body {
    height: 100%;
    background-color: #5ab8db;
   
}

.modal-cont {
    position: fixed;
    height: 100%;
    width: 100%;
    background-color: rgba(0, 0, 0, 0.47);
    top: 0;
    left: 0;
     overflow: auto
   
    
}

.modal-box{
    width: 80%;
    margin: 30px auto;
    background-color: white;
    position: relative;
    text-align: ;
    padding:
}

.modal-box .close {
    position: absolute;
    right: 16px;
    top: 5px;
    font-size: 25px;
    font-weight: bolder;  
    cursor: pointer
}
.modal-box .close:hover, .modal-box .close:focus{
    color: #c6c6c6
}
.modal-box img{
    width: 30%;
    border-radius: 50%;
    display: block;
    margin:auto;
    padding: 14px;
    margin-bottom: 30px;
    min-width: 150px;
    max-width: 230px
}
input[type=text], input[type=password]{
    width: 100%;
    border: 1px solid #d0d0d0;
    display: block;
    padding: 8px;
    margin: 5px 0;
    margin-bottom: 10px;
    
}
.modal-box .login-button {
    padding: 10px;
    font-size: 15px;
    display: block;
    width: 100%;
    color: white;
    background-color: #29a6d4;
    margin: 16px 0;
    
}
input[type = checkbox] {
    margin-right: 2px;
    vertical-align: baseline; /*no effect for baseline*/
}


.close-forgot{
    background-color: 
}

.modal-box label, .modal-box .login-button, .modal-box input{
    width: 95%;
    display: block;
    margin: 10px auto
    
}

.modal-box .login-button{
    margin-top: 16px;
    cursor: pointer
}
input[type=checkbox]{
    display: inline-block;
    width: auto;
    margin-left: 16px
}
.modal-box .close-forgot {
    background-color: #d8d8d8;
    width: 100%;
    padding: 30px 2.5%;
    
}
.modal-box .cancel{
    background-color: #c44f4f;
    padding: 10px 15px;
    font-size: 15px;
    color: white;
    cursor: pointer
}
.modal-box span{
    float: right
}
.modal-box a{
    color: #1483be;
    font-weight: 500;
    text-decoration: underline
}


.modal-cont{display: none}
.modal-box {
    animation-name: zoom;
    animation-duration: .7s;
    animation-fill-mode: forwards;
    animation-timing-function: ease;
    border: 1px solid #b7b7b7;
    border-radius: 4px;
    box-shadow: 1px 1px 8px rgba(35, 120, 204, 0.8)
    
}
@keyframes zoom {
    from{transform: scale(0);}
    to{transform: scale(1);}
}
.login{
    padding: 10px 25px;
    font-size: 20px;
    color: white;
    background-color: rgb(113, 113, 113);
    cursor: pointer
}
h1, .login {
    margin: auto;
    text-align: center;
    display: block;
    margin-top: 20px;
    
}


<body>
    <h1>Modal Login Form</h1>
    <button id="test" class="login">Login</button>
    <h1>Modal Login Form</h1>
    <div class="modal-cont">
        <div class="modal-box">
            <span class="close">&times;</span>
            <form action="" class="login-box">
              <h1> Login Page </h1>
                <label for="">Username</label>
                <input type="text" class="name" required>
                <label for="">Password</label>
                <input type="password" class="password" required>
              <button class="login-button">Login</button>
                <div class="close-forgot">
                    <button class="cancel">Cancel</button>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
    var closeBut = document.getElementsByClassName('close')[0],
        modal = document.getElementsByClassName('modal-cont')[0],
        cancelBut = document.getElementsByClassName('cancel')[0],
        loginBut = document.getElementsByClassName('login')[0];
        
    //close
    function x () {
        modal.style.display = "none";
    }
    closeBut.onclick = x;
    cancelBut.onclick = x;

    loginBut.onclick = function () {
        modal.style.display = "block";
    }

    window.onclick = function (e) {
        if (e.target.className === 'modal-cont'){
            e.target.style.display = 'none';
        }
    }
</script>
