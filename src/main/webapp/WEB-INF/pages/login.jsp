<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Form - Modal</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900|Material+Icons'>
  <style>
    <%@include file="../css/style.css"%>
  </style>
</head>

<body>
  
<!-- Form-->
<div class="form">
  <div class="form-toggle"></div>
  <div class="form-panel one">
    <div class="form-header">
      <h1>Account Login</h1>
    </div>
    <div class="form-content">
      <form method="post" action="<c:url value="/login"/>">
        <c:if test="${error!=null}">
          <div><p style="color:red"><c:out value="Incorrect login or password"/></p></div>
        </c:if>
        <div class="form-group">
          <label for="username">Username</label>
          <input type="text" id="username" name="username" required="required"/>
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" id="password" name="password" required="required"/>
        </div>
        <div class="form-group">
          <button type="submit">Log In</button>
        </div>
      </form>
    </div>
  </div>
  <div class="form-panel two">
    <div class="form-header">
      <h1>Register Account</h1>
    </div>
    <div class="form-content">
      <form method="post" action="<c:url value="/registration"/> ">
        <div class="form-group">
          <label for="username2">Username</label>
          <input type="text" id="username2" name="username" required="required"/>
        </div>
        <div class="form-group">
          <label for="password2">Password</label>
          <input type="password" id="password2" name="password" required="required"/>
        </div>
        <div class="form-group">
          <label for="cpassword2">Confirm Password</label>
          <input type="password" id="cpassword2" name="cpassword" required="required"/>
        </div>
        <div class="form-group">
          <label for="first-name">First name</label>
          <input type="text" id="first-name" name="first-name" required="required"/>
        </div>
        <div class="form-group">
          <label for="last-name">Last name</label>
          <input type="text" id="last-name" name="last-name" required="required"/>
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" id="email" name="email" required="required"/>
        </div>
        <div class="form-group">
          <button onclick="registr()">Register</button>
        </div>
      </form>
    </div>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://codepen.io/andytran/pen/vLmRVp.js'></script>
    <script>
      <%@include file="../js/index.js"%>
    </script>

<script>
<%--  TODO functional for registration--%>
  function registr() {

    if($('#password2').val()===$('#cpassword2').val()){
      var newUser={
        "id" : 0,
        "firstName" : $('#first-name').val(),
        "lastName" : $('#last-name').val(),
        "login" : $('#username2').val(),
        "password" : $('#password2').val(),
        "email" : $('#email').val(),
      }
      $.ajax({
        type:"POST",
        url:"http://localhost:8081/dits_war/registration/",
        data:JSON.stringify(newUser),
        contentType:"application/json",
        success:function (data){
          if(data===""){
            alert("User already exist")
          }else{
            console.log(data)
            alert("User has been added")
          }
        },
        error:function (e) {
          console.log(e)
        }
      })
    }else {
      alert("Password doesn't equal cpassword");
    }
  }
</script>
</body>
</html>
