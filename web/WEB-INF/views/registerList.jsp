<%--
  Created by IntelliJ IDEA.
  User: life95
  Date: 2020/3/18
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册页面</title>
</head>
<script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
<body>

<br><br><br><br><br><br><br><br><br><br>

<div align="center">
    用户名:<input id="userName" name="userName"><br>
    <br>
    密  码:<input id="password" name="password"><br>
    <br>
    确认密码:<input id="password1" name="password1"><br>
    <br>
    <button onclick="registerData()">确认注册</button>
</div>
</body>
<script type="text/javascript">
    function registerData() {
        var userName=$("#userName").val();
        var password=$("#password").val();
        var password1=$("#password1").val();

        if (password!=password1){
            alert("两次密码输入不一致！请检查后重新注册");
            return;
        }
        var params = {
            userName:userName,
            password:password
        };
        var url = '/login/registerData';
        jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            url: url,
            data: params,
            dataType: 'json',
            success: function (data) {
                 // alert("成功啦");
                 var code=data.code;
                 if (code=="0000"){
                     alert("注册成功！")
                     location.href="/login/page";
                 } else if(code=="0002"){
                     alert("注册提示："+data.msg);
                 }else {
                     alert("未知异常！");
                 }

            },
            error: function (data) {
                alert("失败啦");
            }
        });
    }
</script>
</html>
