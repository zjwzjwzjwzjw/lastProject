<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/15
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/">
    <script src="js/jquery-1.7.2.js"></script>
    <script>
        $(function(){
            $(".detail").click(function(){
                var crid=$(this).parent().parent().children()[0].innerHTML
                window.location.href="/man/showDetailResumes?crid="+crid
            })
            $(".del").click(function(){
                var crid=$(this).parent().parent().children()[0].innerHTML
                var flag=confirm("确认删除吗?")
                if(flag){
                    $.post("",{"crid":crid},function(data){
                    })
                    $(this).parent().parent().remove()
                }
            })
        })
    </script>
</head>
<body>
<table>
    <tr>
        <td>序号</td>
        <td>应聘者名字</td>
        <td>投递时间</td>
        <td>简历状态</td>
        <td>面试状态</td>
        <td>操作</td>
        <c:forEach items="${requestScope.computerResumes}" var="cresume">
            <tr class="tab">
                <td>${cresumes.crid}</td>
                <td>${cresumes.tname}</td>
                <td>${cresumes.time}</td>
                <td>${cresumes.crtype}</td>
                <td>${cresumes.cstype}</td>
                <td><button class="detail">查看</button><button class="del">删除</button></td>
            </tr>
        </c:forEach>
    </tr>
</table>
</body>
</html>
