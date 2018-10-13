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
            var diff="aaa";
            var id=$("#id").val()
            var args={"id":id,"diff":diff}
            var url="/sendResume"
            $.post(url,args,function(data){
                if(data=="3"){
                    var name=$("#name").val();
                    var flag=confirm("您可以去面试了,是否去查看面试信息")
                    if(flag){
                        window.location.href="/showInterview?id="+id+"&accName="+name;
                    }
                }
            })
            $("#exit").click(function(){
                var flag=confirm("确认退出吗?")
                if(!flag){
                    return false;
                }
            })
        })
        function checkmessage(){
            var diff="aaa";
            var id=$("#id").val()
            var args={"id":id,"diff":diff}
            var url="/sendResume"
            $.post(url,args,function(data){
                if(data==""){
                    alert("您还没有写简历")
                }
                if(data=="0"){
                    alert("您的简历还未发布")
                }
                if(data=="1"){
                    alert("部门主管还没来得及查看您的简历,请耐心等候哦")
                }
                if(data=="2"){
                    alert("您的简历已被查看,请耐心等候通知哦")
                }
                if(data=="3"){
                    var name=$("#name").val();
                    window.location.href="/showInterview?id="+id+"&accName="+name;
                }
            })
        }
    </script>
</head>
<body>
<input type="hidden" id="id" value="${sessionScope.user.id}">
<input type="hidden" id="name" value="${sessionScope.user.accName}">
<c:if test="${sessionScope.user.utype==2}">
    <a href="/showInterview?id=${sessionScope.user.id}&accName=${sessionScope.user.accName}">消息提醒</a>
    <span id="alarm"></span>
    <a href="/showResume?id=${sessionScope.user.id}">查看简历</a>
    <a href="/editAccount">修改账户信息</a>
    <a href="/main.jsp" id="exit">退出</a>
</c:if>
<c:if test="${sessionScope.user.utype==1}">
    <a href="/emp/showEmp?id=${sessionScope.user.id}">基本信息</a>
    <a href="">我的考勤</a>
    <a href="">我的奖惩</a>
    <a href="">部门职位</a>
    <a href="">我的薪资</a>
    <a href="">修改密码</a>
    <a href="">其他</a>
    <a href="">退出</a>
</c:if>
<c:if test="${sessionScope.user.utype==0}">
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
