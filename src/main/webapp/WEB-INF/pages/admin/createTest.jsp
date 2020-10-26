<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Test</title>
</head>
<body>
kyky create test
<form action="/admin/createTest" method="post">
    <p>
        <input type="text" required list="topics" placeholder="choose topic" id="topic" name="topic">
        <datalist id="topics" name="nameTopic">
            <c:forEach items="${topics}" var="topic">
                <option value="${topic.name}"/>
            </c:forEach>
        </datalist>
    </p>

    <p>
        <input type="text" required list="tests" placeholder="input a new tests name" id="nameTest" name="nameTest">
        <datalist id="tests" >
            <c:forEach items="${tests}" var="test">
                <option value="${test.name}"/>
            </c:forEach>
        </datalist>
    </p>
    <p><textarea name="descriptionTest"></textarea></p>
    <
<%--    <p>--%>
<%--        <input type="text" required list="questions" multiple placeholder="question name" id="question" name="questions">--%>
<%--        <datalist id="questions">--%>
<%--            <c:forEach items="${questions}" var="question">--%>
<%--                <option value="${question.description}"--%>
<%--            </c:forEach>--%>
<%--        </datalist>--%>
<%--    </p>--%>
    <input type="submit" value="save"> <br>
</form>
</body>
</html>