<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>statistic by question</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th> Question name</th>
        <th> finished count</th>
        <th> % true</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${statistics}" var="stat">
        <tr>
            <th> ${stat.name} </th>
            <th> ${stat.countCompleted} </th>
            <th> ${stat.percent} </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/goHome">
    <input type="submit" value="Home page">
</form>
</body>
</html>