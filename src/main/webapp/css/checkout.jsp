<style>
    *{
    font-family:'Times New Roman', Times, serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    outline: none;
    border: none;
    text-transform: capitalize;
    transition: all .2s linear;
}
.main{
    display: flex;
    justify-content: center;
    align-items: flex-start;
    background: linear-gradient( rgba(88, 88, 88, 0.2),rgba(182, 180, 180, 0.4));
    min-height: 100vh;
    padding-top: 20px;
    padding-bottom: 10px;
}
.main form{
    background-color: white;
    border-radius: 20px;
    padding: 20px;
    width: 90%;
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
    width: 90%;
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
.profileHeader{
    width:90%;
    height:200px;
    display:flex;
    justify-content:space-between;
    align-items: center;
    gap: 10px;
    border-radius:10px;
    background-color:rgb(238, 237, 237);
}
i{
    font-size: larger;
    margin: 20px;
}
.userImage{
    display: flex;
    flex-direction: column;
}
.userDetails{
    padding: 10px 14px;
    margin: 15px;
}
.profilePic {
    margin: 15px;
    height: 120px;
}
.profilePic img{
    height: 100%;
    width: 100%;
    object-fit: contain;
}
.details{
    display: flex;
    flex-direction: row;
    gap: 150px;
    padding-top: 20px;

}
.detailsApproved{
    display: flex;
    justify-content: center;
    padding-top: 20px;
    flex-direction: column;
}
 {box-sizing: border-box;}
<%-- chekout css --%>
.recentContainer {
    margin-left: 40px;
    padding: 10px 15px;
    margin-right: 100px;
}

.recentTitle {
    font-weight: bold;
    font-size: large;
    font-family: serif;
}

.recent {
    display: flex;
    flex-direction: column;
}

.recenData {
    padding: 8px;
    font-size: 15px;
}

.myTable {
    width: 100%;
}

.myTable td {
    text-align: center;
    padding: 5px 15px;
}

.myTable th {
    text-align: center;
    padding: 8px 15px;
    background-color: rgb(252, 152, 152);
}

.image_prod {
    width: 200px;
    height: 150px;
    border-radius: 20px;
}

.numQuantity {
    width: 150px;
    height: 34px;
    border-radius: 10px;
    padding: 8px 14px;
}

.myTable i {
    color: red;
    font-size: 30px;
    text-transform: uppercase;
    transition: transform .5s;
    cursor: pointer;
}

.myTable i:hover {
    transform: scale(1.1);
}

.Container {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
}

.checkout {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    border-radius: 10px;
    background-color: bisque;
    height: 200px;
    margin: 15px;
    padding: 8px 10px;
}

.submit {
    width: 100%;
    font-size: 17px;
    color: white;
    cursor: pointer;
    background-color: rgb(99, 87, 87);
    border-radius: 10px;
    text-align: center;
    height: 34px;
    font-family: 'Times New Roman', Times, serif;
    text-transform: uppercase;
    transition: transform .5s;
}

.submit:hover {
    background-color: rgb(36, 35, 35);
    transform: scale(0.9);
}

#errText {
    position: relative;
}

.priceText {
    font-size: 30px;
    font-weight: 700;
    color: rgb(12, 95, 12);
    text-align: center;
    text-transform: uppercase;
    padding: 15px;
}

@media only screen and (max-width: 700px) {
    .myTable {
        width: 30%;
    }

    .image_prod {
        width: 142px;
        height: 130px;
    }

    .numQuantity {
        width: 90px;
    }

    .recentContainer {
        margin-left: 3px;
    }
}


/* Button used to open the contact form - fixed at the bottom of the page */


/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: relative;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}
.navDeets{
    width:80%;
}
.prodDetails{
    width:25%;
    display:flex;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}
.buttonRemove{
    background-color: red;
    border-radius: 10px;
    color: white;
    padding: 10px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    }
.buttonEdit{
    background-color: green;
    border-radius: 10px;
    color: white;
    padding: 10px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
} 
.mode{
    background-color: azure;
    padding-right: 20px;
    font-size: larger;
    font-weight: 50px;
    color: green;
}
.mode #checked{
    font-size: 30px;
    font-weight: 50px;
    color: green;
    background-color: rgb(173, 170, 170);
    border-radius: 25px;
}
.mainContent{
    display: flex;
    flex-direction: column;
}
.innerButtons{
    display:flex;
    flex-direction:row;
    justify-content:space-evenly;
    margin-right:100px;
}
@media only screen and(max-width:600px){
    .profileHeader{
        flex-direction: column;
        width: 70%;
    }
}
</style>