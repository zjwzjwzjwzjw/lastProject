<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/11
  Time: 19:43
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
            $("form").submit(function(){
                var passwordB=$("#passwordB").val()//旧密码
                var passwordA=$("#passwordA").val()//输入的旧密码
                var password=$("#password").val()//新密码
                var passwordC=$("#passwordC").val()
                if(passwordB!=passwordA){
                    $("#alarm").text("密码不正确");
                    return false;
                }
                if(passwordC!=password){
                    $("#alarm").text("两次密码不一致");
                    return false;
                }
            })
        })
    </script>
</head>
<body>
<form action="/registAccount">
    <input type="hidden"  id="id" name="id" value="${sessionScope.user.id}">
    <input type="hidden"  id="utype" value="${sessionScope.user.utype}">
    <input type="hidden" id="passwordB" value="${sessionScope.user.password}">
    <input type="text" name="accName" id="iname" value="${sessionScope.user.accName}"><br>
    <input type="password" id="passwordA"><br>
    <input type="password" id="password" name="password" value="${sessionScope.user.password}"><br>
    <input type="password" id="passwordC" value="${sessionScope.user.password}"><br>
    <input type="submit" value="提交" >
    <span id="alarm"></span>
    <button><a href="/login?accName=${sessionScope.user.accName}&password=${sessionScope.user.password}" style="text-underline: none">返回</a></button>
</form>
</body>
</html>
