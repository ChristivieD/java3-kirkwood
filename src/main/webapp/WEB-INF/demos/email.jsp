<%--
  Created by IntelliJ IDEA.
  User: lised
  Date: 1/24/2024
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${success}">
    <p>Email sent</p>
</c:if>
<form action="${appURL}/email" method="post">
    <input type="text" name="email">
    <input type="text" name="message">
</form>

</body>
</html>
