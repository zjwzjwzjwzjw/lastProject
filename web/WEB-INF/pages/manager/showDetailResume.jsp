<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/15
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px" cellspacing="0">
    <tr>
        <td colspan="4" style="text-align: center">简历</td>
    </tr>
    <tr>
        <td>真实姓名</td>
        <td>${requestScope.computerResumes.tname}</td>
        <td>性别</td>
        <td>${requestScope.computerResumes.gender}</td>
    </tr>
    <tr>
        <td>年龄</td>
        <td>${requestScope.computerResumes.age}</td>
        <td>学历</td>
        <td>${requestScope.computerResumes.education}</td>
    </tr>
    <tr>
        <td>联系方式</td>
        <td>${requestScope.computerResumes.tel}</td>
        <td>EMAIL</td>
        <td>${requestScope.computerResumes.email}</td>
    </tr>
    <tr>
        <td>应聘职位</td>
        <td>${requestScope.computerResumes.dept},${requestScope.computerResumes.job}</td>
        <td>政治面貌</td>
        <td>${requestScope.computerResumes.policitalStatus}</td>
    </tr>
    <tr>
        <td>上份工作</td>
        <td>${requestScope.resume.beforeJob}</td>
        <td>工作经验</td>
        <td>${requestScope.resume.workExperience}</td>
    </tr>
    <tr>
        <td>期望薪资</td>
        <td>${requestScope.resume.salary}
        <td>兴趣爱好</td>
        <td>${requestScope.resume.favorite}</td>
    </tr>
    <tr>
        <td colspan="2">
            <button>面试</button>
        </td>
        <td colspan="2" style="text-align: center">
            <button>
                <a href="/man/showComputerResumes" style="text-underline: none">返回</a>
            </button>
        </td>
    </tr>
</table>
</body>
</html>
