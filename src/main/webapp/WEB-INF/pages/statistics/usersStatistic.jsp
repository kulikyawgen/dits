<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>statistic</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th> Login </th>
        <th> Test name </th>
        <th> Finished </th>
        <th> % true</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <td> ${user.login}</td>
    </c:forEach>
    </tbody>
</table>
<form action="/goHome">
    <input type="submit" value="Home page">
</form>
</body>
</html>