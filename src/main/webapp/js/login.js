

// functions to check Form Validation
var truly_valid = true;


// inputotp and systemgenerated otp
var inputOtp;
var outGenerated;
// OTP validation
var optElement = document.getElementById("inputedOtp");
optElement.setAttribute("type", "text");
optElement.required = true;
// email field validation
var email = document.getElementById("email");
email.setAttribute("type", "email");
email.required = true;
// the password field validation
var password = document.getElementById("password")
password.setAttribute("type", "password");
password.required = true;


// the JS form 
function formValidation() {
  // LOGIN FORM
  var email = document.getElementById("email")
  console.log(email.value)
  var emailValidation = document.getElementById("emailValidation")
  if (email.value.length < 5) {
    emailValidation.textContent = "Please enter an email address"
    emailValidation.style.color = "red"
    truly_valid = false;
  }
  var password = document.getElementById("password")
  console.log(password.value)
  var passwordValidation = document.getElementById("passwordValidation")
  if (password.value.length < 5) {
    passwordValidation.textContent = "Please enter a password"
    passwordValidation.style.color = "red"
    truly_valid = false;
  }
  if (truly_valid === true) {
    // check otp sent by users

    var inputOtp = document.getElementById("inputedOtp").value;
    var submit = document.getElementById("submit");
    console.log(parseInt(inputOtp));
    inputOtp = parseInt(inputOtp);
    console.log(otpGenerated);
    if (inputOtp !== otpGenerated) {
      alert("The OTP does not match!");
      window.location.href = 'login.php';
    } else {
      submit.disabled = false;
    }
  }


  // SIGN UP DATA
  // email Sign Up Text Box
  var emailSign = document.getElementById("emailSign");
  console.log(emailSign.value)
  var emailSignValid = document.getElementById("emailSignValid");
  if (emailSign.value.length < 5) {
    emailSignValid.textContent = "Please enter an email address"
    emailSignValid.style.color = "red"
    truly_valid = false;
  }
  // password Sign Up TextBox
  var passwordSign = document.getElementById("passwordSign")
  console.log(passwordSign.value)
  // store all special characters in a variable
  var special = /^[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]*$/
  var contAlphaNumeric = special.test(passwordSign.value)
  var passwordSignValid = document.getElementById("passwordSignValid")
  if (passwordSign.value.length < 5) {
    passwordSignValid.textContent = "Please enter a password"
    passwordSignValid.style.color = "red"
    truly_valid = false;
    // check for special characters
  } else if (passwordSign.value > 5 && contAlphaNumeric !== true) {
    var specialCharacter = document.getElementById("specialCharacter")
    specialCharacter.textContent = "Please place speacial characters in your password"
    specialCharacter.style.color = "red";
  }
  // confirm password and password
  // get the confirm password object
  var c_password = document.getElementById("passwordRe")
  console.log(c_password.value)
  var contains = passwordSign.value.localeCompare(c_password.value)
  console.log(contains)
  if (contains !== 0 || c_password.value.length < 5) {
    passReValid.textContent = "Passwords do not match"
    passReValid.style.color = "red";
  }
  // first name textbox
  var firstSign = document.getElementById("firstSign");
  console.log(firstSign.value)
  var firstSignValid = document.getElementById("firstSignValid");
  if (firstSign.value.length < 5) {
    firstSignValid.textContent = "Please enter a first name"
    firstSignValid.style.color = "red"
    truly_valid = false;
  }
  var lastSign = document.getElementById("lastSign");
  console.log(lastSign.value)
  var lastSignValid = document.getElementById("lastSignValid");
  if (lastSign.value.length < 5) {
    lastSignValid.textContent = "Please enter a last name"
    lastSignValid.style.color = "red"
    truly_valid = false;
  }
}
document.getElementById("emailValidation")
var logDiv = document.querySelector("#loginDiv")
logDiv.addEventListener("keyup", (e) => {
  document.getElementById("emailValidation").textContent = ""
})
// functions to remove error messages when users type in their passwords
function checkFormValidation(e) {
  if (e.target.value.length > 0) {
    if (e.target.id === "email") {
      document.getElementById("emailValidation").textContent = ""
    } else if (e.target.id === "emailSign") {
      document.getElementById("emailSignValid").textContent = ""
    } else if (e.target.id === "passwordSign") {
      document.getElementById("passwordSignValid").textContent = ""
      // remove the special characters error message 
      document.getElementById("specialCharacter").textContent = ""
    } else if (e.target.id === "passwordRe") {
      // remove the the confirm password error message
      document.getElementById("passReValid").textContent = ""
    } else if (e.target.id === "firstSign") {
      document.getElementById("firstSignValid").textContent = ""
    } else if (e.target.id === "lastSign") {
      document.getElementById("lastSignValid").textContent = ""
    }
  }
  if (e.target.value.length > 0) {
    if (e.target.id === "password") {
      document.getElementById("passwordValidation").textContent = ""
    }
  }
}


// functions to show and hide the passwords
function showPass(type, place) {
  console.log(type);
  if (place === "pass") {
    // get the password element
    var pass = document.getElementById(type);
    // change its type into text
    pass.type = "text";
    var icon = document.getElementById("eyeClosedPass");
    // hide the slashed eye icon
    icon.style.display = "none";
    var open = document.getElementById("openPass");
    // display the open eye icon
    open.style.display = "flex";
  } else if (place === "passConfirm") {
    var pass = document.getElementById(type);
    pass.type = "text";
    var icon = document.getElementById("eyeClosedPassConfirm");
    icon.style.display = "none";
    var open = document.getElementById("openPassConfirm");
    open.style.display = "flex";
  }
}

// edit forms
function openForm(productId) {
  document.getElementById("myForm").style.display = "flex";
  document.getElementById("hiddenId").value = productId;
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}


// a function to hide the password
function hidePass(type, place) {
  console.log(type);
  if (place === "pass") {
    // get the password element
    var pass = document.getElementById(type);
    // change its type into password
    pass.type = "password";
    var icon = document.getElementById("eyeClosedPass");
    // show the slashed eye icon
    icon.style.display = "flex";
    var open = document.getElementById("openPass");
    // display the open eye icon
    open.style.display = "none";
  } else if (place === "passConfirm") {
    var pass = document.getElementById(type);
    pass.type = "password";
    var icon = document.getElementById("eyeClosedPassConfirm");
    icon.style.display = "flex";
    var open = document.getElementById("openPassConfirm");
    open.style.display = "none";
  }
}

// function to send otp when the email has been keyed in
function sendOTP(id) {
  console.log(id)

  hiddenEmail = document.getElementById(id);


  console.log("The hidden email", hiddenEmail.value);
  var randNo = Math.ceil(Math.random() * 123456);
  console.log("The otp is", randNo);

  otpGenerated = randNo;
  // instantiate XHR
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
      console.log(this.responseText);
      console.log("email value", hiddenEmail.value);
    }
  }
  xhttp.open("POST", "sendEmail.php", true);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send("otp=" + randNo + "&emails=" + hiddenEmail.value);
}
// check otp sent and the one keyed in by the user
function checkOtp(e) {

  var inputOtp = parseInt(e.target.value);
  console.log("input otp", inputOtp)
  console.log(inputOtp.toString().length, otpGenerated.toString().length)
  if (inputOtp.toString().length > otpGenerated.toString().length) {
    if (inputOtp !== otpGenerated) {
      alert("The otp does not match");
      window.location.href = "login.php";
    }
  }
}

function closeModal() {
  // Get the modal
  var modal = document.getElementById("myModal");

  modal.style.display = "none";
}

// function makePayment() {
//   var url = "https://tinypesa.com/api/v1/express/initialize";
//   // "amount=50&msisdn=0700034834&account_no=200"
//   fetch(url, {
//     body: "amount=50&msisdn=0700034834",
//     headers: {
//       Apikey: "gxpesDG7o1L",
//       "Content-Type": "application/x-www-form-urlencoded",
//     },
//     method: "POST",
//   }).then(response=>{
//     return response.json()
//   }).then(data=>{
//     console.log("The response data is",data)
//   }).catch(err=>{
//     console.log("The error is",err)
//   });
// }

function makePayment(endPoint) {

  // get the total Number of $iterations
  var totalIterations = document.getElementById("numIterations");
  totalIterations = totalIterations.value;
  totalIterations = parseInt(totalIterations);

  // get the price and phone number
  var phoneNumber = document.getElementById("phoneNumber").value;
  var amount = document.querySelector(".finalPrice").textContent;
  console.log("the price is ", amount);
  console.log("the phoneNumber is ", phoneNumber);

  for (var i = 0; i < totalIterations; i++) {
    // get the product ID and numQuantity for each product
    var productID = document.getElementById("hiddenProductID" + i);
    productID = parseInt(productID.value);

    var numQuantity = document.getElementById("hiddenUpdatedQuantity" + i);
    numQuantity = parseInt(numQuantity.value)

    // update
    updatedQuantity(productID, numQuantity);
  }

  // persist payment info
  updatePaymentData(amount)

  // append this data to the endpoint
  endPoint = endPoint + "?amount=" + amount + "&phoneNumber=" + phoneNumber;

  console.log("The latest endpoint is");
  console.log(endPoint);
  // for basic auth on our local api
  const username = 'mabera@gmail.com';
  const password = 'mabera';
  // Encode the credentials in Base64 format
  const base64Credentials = btoa(`${username}:${password}`);
  fetch(endPoint, {
    method: "GET",
    headers: {
      "Authorization": `Basic ${base64Credentials}`,
      "Content-type": "application/json"
    },
    mode: "cors"
  }).then(response => {
    if (!response.ok) {
      console.log("The response has an error of ", response.status)
    } else {
      return response.json()
    }
  }).then(data => {
    console.log("The json data obtained successfully is ", data)
  }).catch(err => {
    console.error("The error obtained was", err)
  })
}

function openModal(type, i) {
  // Get the modal
  var modal = document.getElementById("myModal");

  var form = document.querySelector(".form-popup");

  console.log("The value of i is ", i)
  if (type == "checkout") {
    var finalTotal = document.getElementById("hiddenFinalPrice").value;

    var finalPrice = document.querySelector(".finalPrice");
    finalPrice.textContent = finalTotal;
  } else if (i != null) {
    var hiddenIdTable = document.getElementById("hiddenIdTable" + i).value;

    // set the id in the popup form
    document.getElementById("hiddenId").value = hiddenIdTable;
  }

  console.log("The modal has been found");


  // When the user clicks on the button, open the modal
  modal.style.display = "block";
  form.style.display = "flex";

}

async function uploadFile() {
  let formData = new FormData();
  formData.append("file", imageName.files[0]);
  await fetch("uploadFile", {
    method: "POST",
    body: formData
  });

}
async function exportReport(endpoint) {
  const username = 'mabera@gmail.com';
  const password = 'mabera';
  console.log("The endpoint is", endpoint)
  // Encode the credentials in Base64 format
  const base64Credentials = btoa(`${username}:${password}`);

  await fetch(endpoint, {
    method: "GET",
    headers: {
      "Authorization": `Basic ${base64Credentials}`,
      "Content-type": "application/json"
    }
  }).then(response => {
    if (!response.ok) {
      throw new Error(`Network response was not ok, status: ${response.status}`);
    }
    return response.json();
  })
    .then(data => {
      // Create a Blob from the array buffer
      const wb = convertJsonToExcel(data);
      // Create a link and trigger download
      const wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: false, type: 'binary' });
      const blob = new Blob([s2ab(wbout)], { type: 'application/octet-stream' });
      const url = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.download = 'output.xlsx';
      document.body.appendChild(link);
      link.click();

      // Clean up
      document.body.removeChild(link);
      window.URL.revokeObjectURL(url);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}
// Utility function to convert string to ArrayBuffer
function s2ab(s) {
  const buf = new ArrayBuffer(s.length);
  const view = new Uint8Array(buf);
  for (let i = 0; i !== s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
  return buf;
}
function convertJsonToExcel(jsonData) {


  // Convert JSON data to a worksheet
  const ws = XLSX.utils.json_to_sheet(jsonData);

  // Extract headers from the worksheet
  const headers = [];
  for (const key in jsonData[0]) {
    if (jsonData[0].hasOwnProperty(key)) {
      headers.push(key);
    }
  }

  // Move the headers to the first row
  XLSX.utils.sheet_add_aoa(ws, [headers], { origin: 'A1' });

  // Save the worksheet to a workbook
  const wb = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

  // return the workbook as an Excel file
  return wb;
}

// search functionality
function search(event, location) {

  updateUrlParams(null, null, event.value, null)
}

// get product by category
function getFeature(selectedObj, category) {

  updateUrlParams(null, category, null, selectedObj.value);
}

// function to update the URL parameters
function updateUrlParams(type, category, search, value) {
  // Get the current URL
  var currentUrl = window.location.href;

  // Create a URL object to easily manipulate the URL components
  var url = new URL(currentUrl);

  // Check if the URL has "type" parameter
  if (url.searchParams.has('type') && type != null) {
    url.searchParams.set('type', type);
  } else {
    // If "type" parameter is not present, add it
    if (type != null) {
      url.searchParams.append('type', type);
    }

  }

  // Check if the URL has "category" parameter
  if (url.searchParams.has('category') && category != null) {
    url.searchParams.set('category', category);
  } else {
    // If "type" parameter is not present, add it
    if (category != null) {
      url.searchParams.append('category', category);
    }
  }

  // Check if the URL has "search" parameter
  if (url.searchParams.has('search') && search != null) {
    url.searchParams.set('search', search);
  } else {
    // If "search" parameter is not present, add it
    if (search != null) {
      url.searchParams.append('search', search);
    }
  }

  // Check if the URL has "value" parameter
  if (url.searchParams.has('value') && value != null) {
    url.searchParams.set('value', value);
  } else {
    // If "value" parameter is not present, add it
    if (value != null) {
      url.searchParams.append('value', value);
    }
  }

  // Update the current URL with the modified URL
  window.history.replaceState(null, null, url.toString());

  // Log or use the updated URL as needed
  console.log("Updated URL:", url.toString());
  window.location.href = url.toString();
}


function calculatePrice(e, id) {
  // FUNCTIONS FOR THE ADD TO CART PAGE
  // initiate a boolean value to check whether the user has changed some fields
  var changed = false;
  // initaite the form Element
  var form = document.getElementById("form");

  var totalSumGlobal = 0;

  var cartIDGlobal = new Array();

  var quantityGlobal = new Array();

  var pricesGlobal = new Array();

  let newPrices = new Array();

  // get the total Number of $iterations
  var totalIterations = document.getElementById("numIterations");
  totalIterations = totalIterations.value;
  totalIterations = parseInt(totalIterations);
  // update the cart banner
  document.querySelector(".approvals").textContent = totalIterations;
  for (var i = 0; i < totalIterations; i++) {

    var thisPrices = document.getElementById("totalPricePerProductH" + i);
    var thisPrice = thisPrices.value;
    thisPrice = parseInt(thisPrice);

    var totalQuant = document.getElementById("totalQuantity" + i);
    totalQuant = totalQuant.textContent;
    totalQuant = parseInt(totalQuant);

    var prodQuant = document.getElementById("numQuantity" + i);
    prodQuant = parseInt(prodQuant.value);

    if (prodQuant > totalQuant) {
      // make the proceed to checkout button null
      document.getElementById("myBtn").disabled = true;
    } else {
      document.getElementById("myBtn").disabled = false;
      // calculate the updated Quantity
      var updatedQuantity = totalQuant - prodQuant;
      document.getElementById("hiddenUpdatedQuantity" + i).value = updatedQuantity;
    }

    pricesGlobal.push(thisPrice);
    quantityGlobal.push(totalQuant);
  }
  // initiate the array storing the new user input values 


  // change the status to be true
  changed = true;

  // all errors to removed when a user types
  var errText = document.getElementById("errText" + id);
  errText.textContent = "";

  // get the element of the input quantity
  var prodQuantity = e.target.value;
  // change it to int for mathematical operation
  prodQuantity = parseInt(prodQuantity);


  // get the totalQuantity
  var totalQuant = document.getElementById("totalQuantity" + id);
  totalQuantity = totalQuant.textContent;
  totalQuantity = totalQuantity.match(/\d/g);
  totalQuantity = totalQuantity.join("");
  totalQuantity = parseInt(totalQuantity);
  console.log(totalQuantity, prodQuantity);

  // get the new quantity and append it to the array 
  var updatedQuantity = totalQuantity - prodQuantity;
  var newQuantity = new Array();
  newQuantity.push(updatedQuantity);


  var price = document.getElementById("hiddenQuantity" + id);
  price = parseInt(price.value);

  var priceShow = price * prodQuantity;

  document.getElementById("totalPricePerProduct" + id).textContent = priceShow;

  pricesGlobal[id] = priceShow;

  var totalSum = 0;
  for (var i = 0; i < totalIterations; i++) {
    var pricePerProduct = document.getElementById("totalPricePerProduct" + i);
    pricePerProduct = pricePerProduct.textContent;
    pricePerProduct = parseInt(pricePerProduct);
    totalSum = totalSum + pricePerProduct;
  }
  // instantiate the overall price
  var overall = document.querySelector(".priceText");
  // make the other price null
  document.getElementById("hiddenFinalPrice").value = totalSum;
  overall.textContent = totalSum + " Kshs";



  if (prodQuantity < totalQuantity || prodQuantity == totalQuantity) {

    newPrices.push(priceShow);





    // for loop to display the price 
    var totalSum = 0;
    var prePrice = priceShow;
    for (var i = 0; i < totalIterations; i++) {



      var totalQuant = document.getElementById("totalQuantity" + i);

      var thisPrices = document.getElementById("totalPricePerProductH" + i);
      thisPrice = thisPrices.value;
      thisPrice = parseInt(thisPrice);


      // if the iteration is the same index as the changed price, modify the priceGlobal to effect this
      if (i === id) {
        // reconcile the prices
        var thisPrice = prePrice;
        // console.log(`the price at ${i} after change is `,thisPrice);
        thisPrices.textContent = thisPrice + " Kshs";
        quantityGlobal[i] = prodQuantity;

      }

      totalSum = totalSum + thisPrice;

    }


    totalSumGlobal = totalSum;



  } else {
    var prodQuant = document.getElementById("numQuantity" + id);
    prodQuant.textContent = ""
    var errText = document.getElementById("errText" + id);
    errText.textContent = "Please enter a quantity lower than the total";
    errText.style.color = "red";
  }
}

// function to persist payment data to the DB
function updatePaymentData(price) {

  const addOrUpdateEndpoint = "http://localhost:8080/farmer-system-app/rest/malipo/add?value=" + price + "";

  const username = 'mabera@gmail.com';
  const password = 'mabera';

  // Encode the credentials in Base64 format
  const base64Credentials = btoa(`${username}:${password}`);

  fetch(addOrUpdateEndpoint, {
    method: "GET",
    headers: {
      "Authorization": `Basic ${base64Credentials}`,
      "Content-type": "application/json"
    }
  }).then(response => {
    return response.json()
  }).then(data => {
    console.log(data)
  }).catch(err => {
    console.error(err);
  })

}

// function to update the quantities of bought goods
function updatedQuantity(productID, numQuantity) {

  const addOrUpdateEndpoint = "http://localhost:8080/farmer-system-app/rest/home/add?category=" + productID + "&value=" + numQuantity + "";

  const username = 'mabera@gmail.com';
  const password = 'mabera';

  // Encode the credentials in Base64 format
  const base64Credentials = btoa(`${username}:${password}`);

  fetch(addOrUpdateEndpoint, {
    method: "GET",
    headers: {
      "Authorization": `Basic ${base64Credentials}`,
      "Content-type": "application/json"
    }
  }).then(response => {
    return response.json()
  }).then(data => {
    console.log(data)
  }).catch(err => {
    console.error(err);
  })

}

