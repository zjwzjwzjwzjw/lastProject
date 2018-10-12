<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/12
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/">
    <script src="js/jquery-1.7.2.js"></script>
</head>
<body>
<input type="hidden" id="id" value="${requestScope.user.id}">
<input type="hidden" id="name" value="${requestScope.user.accName}">
</body>
</html>
