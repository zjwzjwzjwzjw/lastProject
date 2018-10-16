<%--  Created by IntelliJ IDEA.
  User: user
  Date: 2018/10/12
  Time: 22:33
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/">
    <script src="js/jquery-1.7.2.js"></script>
    <script>
        $(function(){
            $("table:last").hide();
            var itype=$("#itype").val();
            if(itype==0){
                $("#type").text("已过期")
            }
            if(itype==1){
                $("#type").text("通知面试")
            }
            if(itype==2){
                $("#type").text("预约面试")
            }
            if(itype==3){
                $("#type").text("录取")
            }
            if(itype==4){
                $("#type").text("未录取")
            }
            $("#detail").click(function(){
                $("#show").text("已查看")
                $("table:last").show();
                var iid=$("#iid").val();
                var url="/updateInterview"
                var args={"iid":iid}
                $.post(url,args,function(data){

                })
            })
            $("#goInterview").click(function() {
                var itype = $("#type").text();
                if (itype == "已过期") {
                    alert("面试已过期")
                }
                if(itype == "预约面试") {
                    alert("已预约面试")
                }
                if(itype == "通知面试"){
                    var flag = confirm("是否确认预约面试")
                    if (flag) {
                        var iid = $("#iid").val();
                        var url = "/updateInterview"
                        var args = {"iid": iid}
                        $.post(url, args, function (data) {
                            $("#show").text("已查看")
                            $("#type").text("预约面试")
                            alert("预约成功,请按时去面试,祝您好运")
                        })
                    }
                }
            })
        })
    </script>
</head>
<body>
<input type="hidden" id="id" value="${sessionScope.user.id}">
<input type="hidden" id="name" value="${sessionScope.user.accName}">
<input type="hidden" id="iid" value="${requestScope.interview.iid}">
<input type="hidden" id="itype" value="${requestScope.interview.itype}">
<form>
    <table border="2px" cellspacing="0">
        <tr>
            <td colspan="6" style="text-align: center">面试信息</td>
        </tr>
        <tr>
            <td>投递时间</td>
            <td>是否查看</td>
            <td>面试时间</td>
            <td>是否去面试</td>
            <td>是否录取</td>
            <td>查看详情</td>
            <td>返回</td>
        </tr>
        <tr>
            <td>
                <f:formatDate value="${requestScope.interview.time}" pattern="yyyy-MM-dd"/>
            </td>
            <td id="show">
                <c:if test="${requestScope.interview.iutype==0}" >未查看</c:if>
                <c:if test="${requestScope.interview.iutype==1}" >已查看</c:if>
            </td>
            <td>
                <f:formatDate value="${requestScope.interview.iinterviewtime}" pattern="yyyy-MM-dd"/>
            </td>
            <td id="goInterview">去面试</td>
            <td id="type"></td>
            <td id="detail">查看详情</td>
            <td><a href="/login?accName=${sessionScope.user.accName}&password=${sessionScope.user.password}">返回</a></td>
        </tr>
    </table>
    <table border="2px" cellspacing="0">
        <tr>
            <td colspan="4" style="text-align: center">简历</td>
        </tr>
        <tr>
            <td>真实姓名</td>
            <td>${requestScope.interview.tname}</td>
            <td>性别</td>
            <td>${requestScope.interview.gender}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>${requestScope.interview.age}</td>
            <td>学历</td>
            <td>${requestScope.interview.education}</td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td>${requestScope.interview.tel}</td>
            <td>EMAIL</td>
            <td>${requestScope.interview.email}</td>
        </tr>
        <tr>
            <td>应聘职位</td>
            <td>${requestScope.interview.dept}&nbsp;${requestScope.interview.job}
            </td>
            <td>政治面貌</td>
            <td>
                ${requestScope.interview.policitalStatus}
            </td>
        </tr>
        <tr>
            <td>上份工作</td>
            <td>${requestScope.interview.beforeJob}</td>
            <td>工作经验</td>
            <td>${requestScope.interview.workExperience}</td>
        </tr>
        <tr>
            <td>期望薪资</td>
            <td>${requestScope.interview.workExperience}</td>
            <td>兴趣爱好</td>
            <td>${requestScope.interview.favorite}</td>
        </tr>
    </table>
</form>
</body>
</html>
