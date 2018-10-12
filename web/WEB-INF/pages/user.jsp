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
    <script src="js/jquery-1.7.2.js"></script>
    <script>
        $(function(){
            var data=checkmessage();
            if(data=="3"){
                interview()
            }
            $("#exit").click(function(){
                var flag=confirm("确认退出吗?")
                if(!flag){
                    return false;
                }
            })
            $("#message").click(function(){
                var data=checkmessage()
                if(data==""){
                    alert("您还没有写简历")
                }
                if(data=="1"){
                    alert("部门主管还没来得及查看您的简历,请耐心等候哦")
                }
                if(data=="2"){
                    alert("您的简历已被查看,请耐心等候通知哦")
                }
                if(data=="3"){
                    interview()
                }
                return false
            })
        })
        function checkmessage(){
            var args={"id":id}
            var url="/sendResume"
            $.post(url,args,function(data){
               return data
            })
        }
        function interview(){
            var name=$("#name").val();
            var flag=confirm("您可以去面试了");
            if(flag){
                window.location.href="/showInterview?id="+id+"&accName="+name;
            }
        }
    </script>
</head>
<body>
<input type="hidden" id="id" value="${requestScope.user.id}">
<input type="hidden" id="name" value="${requestScope.user.accName}">
<c:if test="${requestScope.user.utype==2}">
    <a href="#" id="message">消息提醒</a>
    <span id="alarm"></span>
    <a href="/showResume?id=${requestScope.user.id}">查看简历</a>
    <a href="/editAccount?id=${requestScope.user.id}">修改账户信息</a>
    <a href="/main.jsp" id="exit">退出</a>
</c:if>
<c:if test="${requestScope.user.utype==1}">
    <a href="">基本信息</a>
    <a href="">我的考勤</a>
    <a href="">我的奖惩</a>
    <a href="">部门职位</a>
    <a href="">我的薪资</a>
    <a href="">修改密码</a>
    <a href="">其他</a>
    <a href="">退出</a>
</c:if>
<c:if test="${requestScope.user.utype==0}">
    <a href="">应聘管理</a>
    <a href="">部门职位</a>
    <a href="">培训管理</a>
    <a href="">员工管理</a>
    <a href="">奖惩管理</a>
    <a href="">薪资管理</a>
    <a href="">退出</a>
</c:if>
</body>
</html>
