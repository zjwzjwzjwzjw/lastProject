<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/11
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/">
</head>
<body>
<c:if test="${requestScope.user.utype==2}">
    <a href="">消息提醒</a>
    <a href="/showResume?id=${requestScope.user.id}">查看简历</a>
    <a href="/editAccount?id=${requestScope.user.id}">修改账户信息</a>
    <a href="">退出</a>
</c:if>
<c:if test="${requestScope.user.utype==0}">
    success
</c:if>
</body>
</html>
