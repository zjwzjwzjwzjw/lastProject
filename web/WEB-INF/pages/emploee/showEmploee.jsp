<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/13
  Time: 15:47
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
<form>
    <table>
        <tr>
            <td colspan="4" style="text-align: center">个人信息</td>
        </tr>
        <tr>
            <td>姓名</td>
            <td>${requestScope.emploee.ename}</td>
            <td>性别</td>
            <td>${requestScope.emploee.egender}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>${requestScope.emploee.eage}</td>
            <td>学历</td>
            <td>${requestScope.emploee.eeducation}</td>
        </tr>
        <tr>
            <td>联系电话</td>
            <td>${requestScope.emploee.etel}</td>
            <td>邮箱</td>
            <td>${requestScope.emploee.eemail}</td>
        </tr>
        <tr>
            <td>部门职位</td>
            <td>${requestScope.emploee.edept}&nbsp;${requestScope.emploee.ejob}</td>
            <td>政治面貌</td>
            <td>${requestScope.emploee.epolicitalStatus}</td>
        </tr>
        <tr>
            <td>入职时间</td>
            <td>${requestScope.emploee.ebegintime}</td>
            <td>爱好</td>
            <td>${requestScope.emploee.efavorite}</td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">保存</td>
            <td colspan="2" style="text-align: center"><a href="/login?accName=${sessionScope.user.accName}&password=${sessionScope.user.password}" style="text-underline: none">返回</a></td>
        </tr>
    </table>
</form>
</body>
</html>
