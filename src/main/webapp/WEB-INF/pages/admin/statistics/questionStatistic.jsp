<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous">
    <title><spring:message code="questionStatistics"/>>
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
    <div class="row m-5">
        <div class="col text-center">
            <h1 class="text-primary"><spring:message code="questionStatistics"/>
            </h1>
        </div>
    </div>
    <div class="row m-2 align-items-center">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col"><spring:message code="questionName"/></th>
                <th scope="col"><spring:message code="finishedTimes"/></th>
                <th scope="col"><spring:message code="percentageOfCorrectAnswers"/></th>
            </tr>
            </thead>
            <c:forEach items="${statistics}" var="stat">
                <tr>
                    <th> ${stat.name} </th>
                    <th> ${stat.countCompleted} </th>
                    <th> ${stat.percent} </th>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="text-align:center">
        <a href="<c:url value="/admin/statistic"/>" class="btn btn-primary text-light"><spring:message code="back"/> </a>
    </div>
</div>
</body>
</html>