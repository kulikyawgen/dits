<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.model.Topic" %>
<%@ page import="org.springframework.data.domain.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String title = "DITS";%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title><%=title%>
    </title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

<div class="container">
    <div>
        <a href="<c:url value="/logout"/>">Log out</a>
    </div>
    <div class="row m-5">
        <div class="col text-center">
            <h1 class="text-primary"><%=title%>
            </h1>
        </div>
    </div>
    <div class="row m-2 align-items-center">
        <div class="col-sm-12 col-md-5">
            <img src="https://lh4.googleusercontent.com/hiq9rrHzKdGFT2fRNKUO39NHMnLOXNWmlh_LSj-Tq-Mu36hPgcL1mjKUbgY3Hs65EZIwcxHHkB0ZIU5LWaLiLIupl3wsJZLxWz_ceFRhNiS4iqCw4rs8OOZDGSkfxzTlJmz-WAupOVsy7pwNow"
                 class="img-fluid"
                 alt="logo">
        </div>
        <div class="col-sm-12 col-md-7 pl-4">
                <h2>You've chosen the test:</h2>
                <h3>Topic: ${topic.name}</h3>
                <h3>Test: ${test.name}</h3>
                <p>About: ${test.description}</p>
                <button onclick="myFunction(${test.testId})" style="text-align: center">Let's start</button>
        </div>
    </div>
</div>
</body>
<script>
function myFunction(id) {
    var url = "http://localhost:8081/dits_war/user/passing/"+id;
    location.href=url;
}
</script>
</html>