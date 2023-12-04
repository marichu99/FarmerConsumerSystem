<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="css/farmer.css" rel="stylesheet">
  <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
</head>

<body>
  <div class="marichu">

    <div class="loginContainer">
      <div class="button-box">
        <div id="buttonz"></div>

        <button class="toggle-btn" onclick="login()">Login</button>
        <button class="toggle-btn"><a href="./sign">Sign Up</a></button>
      </div>

      <form action="./login" method="POST" id="login" class="login-input-group">
        <div class="loginDiv">
          <jsp:useBean id="LoginForm" class="com.servlet.app.bean.LoginForm" scope="page" />
          <label class="form-label">Enter your Email:</label>
          <div class="input-detail">
            <input id="email" placeholder="<jsp:getProperty name='LoginForm' property='usernamePLaceholder' />"
              type="email" name="email" class="input-box" onkeyup="checkFormValidation(event)"><br>
          </div>
          <label class="form-label">Enter your Password:</label>
          <div class="input-detail">
            <input id="password" placeholder="Enter your password" name="password" class="input-box"
              onchange="checkFormValidation(event)" onkeyup="checkFormValidation(event)" type="password"><br><i
              class="uil uil-eye" id="openPass" onclick="hidePass('password','pass')"></i><i class="uil uil-eye-slash"
              onclick="showPass('password','pass')" id="eyeClosedPass"></i>
          </div>
          <div class="input-detailLast">
            <div class="label">
              <label for="" class="form-label">Select the type of user </label><br />
            </div>
            <div class="lablContent">
              <label for="user">User: </label>
              <input type="radio" name="usertype" value="USER" />
              <label for="admin">Admin: </label>
              <input type="radio" name="usertype" value="ADMIN"/>
            </div>
          </div>
          <input type="submit" id="submit" class="btn-submit"><br>
          <p onclick="window.location.href='forgotPass.php'" class="forgotPass">Forgot Password</p>

        </div>
      </form>


    </div>
  </div>
  <script src="./js/login.js" type="text/javascript"></script>

</body>

</html>