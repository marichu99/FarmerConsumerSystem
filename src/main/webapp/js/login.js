

// functions to check Form Validation
var truly_valid= true;


// inputotp and systemgenerated otp
var inputOtp;
var outGenerated;
// OTP validation
var optElement=document.getElementById("inputedOtp");
optElement.setAttribute("type","text");
optElement.required=true;
// email field validation
var email = document.getElementById("email");
email.setAttribute("type","email");
email.required=true;
// the password field validation
var password = document.getElementById("password")
password.setAttribute("type","password");
password.required=true;


// the JS form 
function formValidation(){
    // LOGIN FORM
var email = document.getElementById("email")
console.log(email.value)
var emailValidation=document.getElementById("emailValidation")
if (email.value.length < 5){
  emailValidation.textContent="Please enter an email address"
  emailValidation.style.color= "red"
  truly_valid= false;
}
var password = document.getElementById("password")
console.log(password.value)
var passwordValidation= document.getElementById("passwordValidation")
if(password.value.length < 5){
  passwordValidation.textContent="Please enter a password"
  passwordValidation.style.color="red"
  truly_valid=false;
}
if(truly_valid === true){
  // check otp sent by users

  var inputOtp=document.getElementById("inputedOtp").value;
  var submit=document.getElementById("submit");
  console.log(parseInt(inputOtp));
  inputOtp=parseInt(inputOtp);
  console.log(otpGenerated);
  if(inputOtp!==otpGenerated){
    alert("The OTP does not match!");
    window.location.href='login.php';
  }else{
    submit.disabled=false;
  }
}


// SIGN UP DATA
// email Sign Up Text Box
var emailSign= document.getElementById("emailSign");
console.log(emailSign.value)
var emailSignValid= document.getElementById("emailSignValid");
if (emailSign.value.length < 5){
    emailSignValid.textContent="Please enter an email address"
    emailSignValid.style.color= "red"
    truly_valid= false;
  }
// password Sign Up TextBox
var passwordSign = document.getElementById("passwordSign")
console.log(passwordSign.value)
// store all special characters in a variable
var special = /^[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]*$/
var contAlphaNumeric= special.test(passwordSign.value)
var passwordSignValid= document.getElementById("passwordSignValid")
if(passwordSign.value.length < 5){
  passwordSignValid.textContent="Please enter a password"
  passwordSignValid.style.color="red"
  truly_valid=false;
// check for special characters
}else if(passwordSign.value > 5 && contAlphaNumeric !== true){
    var specialCharacter= document.getElementById("specialCharacter")
    specialCharacter.textContent="Please place speacial characters in your password"
    specialCharacter.style.color="red";
}
// confirm password and password
// get the confirm password object
var c_password = document.getElementById("passwordRe")
console.log(c_password.value)
var contains = passwordSign.value.localeCompare(c_password.value)
console.log(contains)
if(contains!==0 || c_password.value.length<5){
    passReValid.textContent="Passwords do not match"
    passReValid.style.color="red";
}
// first name textbox
var firstSign= document.getElementById("firstSign");
console.log(firstSign.value)
var firstSignValid= document.getElementById("firstSignValid");
if (firstSign.value.length < 5){
    firstSignValid.textContent="Please enter a first name"
    firstSignValid.style.color= "red"
    truly_valid= false;
  }
  var lastSign= document.getElementById("lastSign");
  console.log(lastSign.value)
  var lastSignValid= document.getElementById("lastSignValid");
  if (lastSign.value.length < 5){
    lastSignValid.textContent="Please enter a last name"
    lastSignValid.style.color= "red"
    truly_valid= false;
    }
}
document.getElementById("emailValidation")
var logDiv= document.querySelector("#loginDiv")
logDiv.addEventListener("keyup",(e)=>{
  document.getElementById("emailValidation").textContent=""
})
// functions to remove error messages when users type in their passwords
function checkFormValidation(e){
  if (e.target.value.length > 0){
    if (e.target.id === "email"){
      document.getElementById("emailValidation").textContent=""
    }else if(e.target.id === "emailSign"){
        document.getElementById("emailSignValid").textContent=""
    }else if(e.target.id === "passwordSign"){
        document.getElementById("passwordSignValid").textContent=""
        // remove the special characters error message 
        document.getElementById("specialCharacter").textContent=""
    }else if(e.target.id === "passwordRe"){
        // remove the the confirm password error message
        document.getElementById("passReValid").textContent=""
    }else if(e.target.id === "firstSign"){
        document.getElementById("firstSignValid").textContent=""
    }else if(e.target.id === "lastSign"){
        document.getElementById("lastSignValid").textContent=""
    }
  }
  if(e.target.value.length >0){
    if (e.target.id === "password"){
      document.getElementById("passwordValidation").textContent=""
    }
  }
}

function signRedirect(){
  window.location.href="http://localhost/PROJO/Sign.php"
}

// functions to show and hide the passwords
function showPass(type,place){
  console.log(type);
  if(place === "pass"){
    // get the password element
    var pass = document.getElementById(type);
    // change its type into text
    pass.type="text";
    var icon= document.getElementById("eyeClosedPass");
    // hide the slashed eye icon
    icon.style.display="none";
    var open=document.getElementById("openPass");
    // display the open eye icon
    open.style.display="flex";
  }else if(place === "passConfirm"){
    var pass = document.getElementById(type);
    pass.type="text";
    var icon= document.getElementById("eyeClosedPassConfirm");
    icon.style.display="none";
    var open=document.getElementById("openPassConfirm");
    open.style.display="flex";
  }
}

// a function to hide the password
function hidePass(type,place){
  console.log(type);
  if(place === "pass"){
    // get the password element
    var pass = document.getElementById(type);
    // change its type into password
    pass.type="password";
    var icon= document.getElementById("eyeClosedPass");
    // show the slashed eye icon
    icon.style.display="flex";
    var open=document.getElementById("openPass");
    // display the open eye icon
    open.style.display="none";
  }else if(place === "passConfirm"){
    var pass = document.getElementById(type);
    pass.type="password";
    var icon= document.getElementById("eyeClosedPassConfirm");
    icon.style.display="flex";
    var open=document.getElementById("openPassConfirm");
    open.style.display="none";
  }
}

// function to send otp when the email has been keyed in
function sendOTP(id){   
  console.log(id)
  
  hiddenEmail=document.getElementById(id);


  console.log("The hidden email",hiddenEmail.value);
  var randNo=Math.ceil(Math.random()*123456);
  console.log("The otp is",randNo);

  otpGenerated=randNo;
  // instantiate XHR
  var xhttp= new XMLHttpRequest();
  xhttp.onreadystatechange=function(){
    if(this.readyState===4 && this.status===200){
      console.log(this.responseText);
      console.log("email value",hiddenEmail.value);
    }
  }
  xhttp.open("POST","sendEmail.php",true);
  xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  xhttp.send("otp="+randNo+"&emails="+hiddenEmail.value);
}
// check otp sent and the one keyed in by the user
function checkOtp(e){
  
  var inputOtp=parseInt(e.target.value);
  console.log("input otp",inputOtp)
  console.log(inputOtp.toString().length,otpGenerated.toString().length)
  if(inputOtp.toString().length>otpGenerated.toString().length){
      if(inputOtp!==otpGenerated){
          alert("The otp does not match");
          window.location.href="login.php";
      }
  }
}
    