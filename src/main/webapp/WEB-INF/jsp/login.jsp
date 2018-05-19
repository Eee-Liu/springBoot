<%--
  Created by IntelliJ IDEA.
  User: LJ0000275
  Date: 2018/5/15
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <title>登录</title>
</head>
<body>
<script type="text/javascript">
    $(function(){
        $('#submit').click(function () {
            var result = new Object();
            result.account = $('#account').val();
            result.pwd = $('#pwd').val();
            var jsonData = JSON.stringify(result);
            var option = {
                url: '/auth/login.do',
                dataType: 'json',
                type: 'POST',
//                data: {
//                    "account": $('#account').val(),
//                    "pwd": $('#pwd').val()
//                },
                data:jsonData,
                success: function (data) {
                    window.location.href = "http://127.0.0.1:8080/index";
                }
            };
            proxyAjax(option);
        })
    });
</script>
this is spring boot jsp page<br>
帐号:<input type="text" size="30" id="account"/>
<div><br></div>
密码:<input type="password" size="30" id="pwd"/>
<div><br></div>
<input type="submit" size="30" value="登录" id="submit"/>
</body>
</html>
