<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<div class="CreateUser">
    <form method="post" action="/admin/createUser" modelAttribute="user">
        <table>
            First Name:<input type="text" name="firstName"/> <br>
            First Name:<input type="text" name="lastName"/> <br>
            Login: <input type="text" name="login"/> <br>
            Password: <input type="password" name="password"/> <br>
            Role: <br>
        <%--    <c:forEach var="role" items="${allRoles}">
                <input type="checkbox" name="roles" value="${role.name}"> ${role.name} <br>
            </c:forEach> <br>--%>
            <input type="submit" value="save"/>
        </table>
    </form>

</div>
</body>
</html>