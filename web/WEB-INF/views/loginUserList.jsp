<%--
  Created by IntelliJ IDEA.
  User: life95
  Date: 2020/3/20
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<script type="text/javascript" src="/static/jquery-2.1.3.min.js"></script>
<body>
<br><br><br><br><br><br><br><br><br><br><br>
<div align="center">
    用户名：<input id="userName" name="userName" type=""><br>
    <br>
    密  码：<input id="password" name="password" type=""><br>
    <br>
    <button onclick="pageData()">登陆</button>
</div>
</body>
<script type="text/javascript">
    function pageData() {
        var userName=$("#userName").val();
        var password=$("#password").val();
        var params = {
            userName:userName,
            password:password
        };
        var url = '/login/pageData';
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
                    alert("登陆成功！")
                    location.href="/tick/list";
                } else if(code=="0001"){
                    alert("登陆提示："+data.msg);
                }else if(code=="0002"){
                    alert("登陆提示："+data.msg);
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
