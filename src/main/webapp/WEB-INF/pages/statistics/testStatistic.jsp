<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>statistic by tests</title>
</head>
<body>
<table border="1">
    <tbody>
    <tr>
        <th> Test name</th>
        <th> Finished</th>
        <th> % true</th>
    </tr>
    </tbody>
    <tbody>
    <c:forEach items="${testStat}" var="stat">
    <tr>
        <th>${stat.name} </th>
        <th>${stat.countCompleted} </th>
        <th>${stat.percent} </th>
    </tr>
    </c:forEach>
    </tbody>
</table>
</form>
</body>
</html>