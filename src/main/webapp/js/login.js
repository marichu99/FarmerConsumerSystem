

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

// FUNCTIONS FOR THE ADD TO CART PAGE
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
    console.log("The quantities are ",quantityGlobal)

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
    