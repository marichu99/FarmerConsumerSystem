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

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
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
    justify-content:space-between;
}
@media only screen and(max-width:600px){
    .profileHeader{
        flex-direction: column;
        width: 70%;
    }
}
</style>