<%--
  Created by IntelliJ IDEA.
  User: javac
  Date: 10/13/2020
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Welcome user!</h1>

<button onclick="location='/test'">Add user</button>
<button onclick="location='/test'">Add test</button>
<% if (request.getAttribute("role").equals("Admin")){

out.println("<p>Some text</p>");
}
%>
<button onclick="location='/test'">Add topic</button>
<button onclick="location='/test'">Start test</button>

</body>
</html>
