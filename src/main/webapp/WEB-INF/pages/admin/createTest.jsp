<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <div class="row m-2">
                <div class="col-sm-12">
                    <form action="/admin/createTest" method="post">
                        <p>
                            <select name="topicId">
                                <c:forEach items="${topics}" var="topic">
                                    <option value="${topic.topicId}"> ${topic.name}</option>
                                </c:forEach>
                            </select>
                           <%-- <input type="text" required list="topics" placeholder="choose topic" name="topic">
                            <datalist id="topics">
                                <c:forEach items="${topics}" var="topic">
                                    <option value="${topic.name}"/>
                                </c:forEach>
                            </datalist>--%>
                        </p>

                        <p>
                            <input type="text" required list="tests" placeholder="input a new tests name" name="name">
                            <datalist id="tests">
                                <c:forEach items="${tests}" var="test">
                                    <option value="${test.name}"/>
                                </c:forEach>
                            </datalist>
                        </p>
                        <p><textarea placeholder="<spring:message code="description"/>"
                                     name="description"></textarea></p>
                        <button type="submit" class="btn btn-primary text-light"><spring:message
                                code="create"/></button>
                    </form>
                </div>
            </div>
            <div class="col-sm-12">
                <a href="<c:url value="/admin"/>" class="btn btn-primary text-light"><spring:message code="back"/> </a>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>