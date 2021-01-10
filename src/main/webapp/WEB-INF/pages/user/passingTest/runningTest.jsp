<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.model.Topic" %>
<%@ page import="org.springframework.data.domain.Page" %>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Question" %>
<%@ page import="com.model.Test" %>
<%@ page import="com.model.Answer" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
            <h2>${test.description}</h2>
            <h4>${question.description}</h4>
            <c:forEach items="${question.answers}" var="answer">
                <input type="checkbox" id="${answer.answerId}" value="${answer.description}">
                <label>${answer.description}</label>
                <br>
            </c:forEach>
            <button onclick="myFunction(${sessionScope.passingTest.testId})">Next question</button>
        </div>
    </div>
</div>
</body>

<script>

    function myFunction(id) {
        var answers = ['${question.questionId}'];
        <c:forEach items="${question.answers}" var="answerJs">
        var checkBox= $('#${answerJs.answerId}');
        if(checkBox[0].checked==true){
            answers.push(checkBox.val());
        }
        </c:forEach>
        var url = "http://localhost:8081/dits_war/user/passing/"+id;
        $.ajax({
            type:"POST",
            url:"http://localhost:8081/dits_war/user/statistic/",
            data:JSON.stringify(answers),
            contentType:"application/json",
            success:function (data){
               console.log(data)
                location.href=url;
            },
            error:function (e) {
                console.log(e)
                location.href=url;
            }
        })




    }
</script>
</html>