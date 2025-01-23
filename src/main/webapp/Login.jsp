<%--
  Created by IntelliJ IDEA.
  User: nadun
  Date: 1/23/2025
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
  <link rel="stylesheet" type="text/css" href="CSS/styles/Login/style.css">
  <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/a81368914c.js"></script>
</head>
<body>
<img class="wave" src="images/wave.png">
<div class="container">
  <div class="img">
    <img src="images/bg.svg">
  </div>
  <div class="login-content">
    <form action="Login.jsp">
      <img src="images/avatar.svg">
      <h2 class="title">Welcome</h2>
      <div class="input-div one">
        <div class="i">
          <i class="fas fa-user"></i>
        </div>
        <div class="div">
          <h5>Username</h5>
          <input type="text" class="input">
        </div>
      </div>
      <div class="input-div pass">
        <div class="i">
          <i class="fas fa-lock"></i>
        </div>
        <div class="div">
          <h5>Password</h5>
          <input type="password" class="input">
        </div>
      </div>
      <input type="submit" class="btn" value="Login">
      <a href="#">Don't have an account?</a>
    </form>
  </div>
</div>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
