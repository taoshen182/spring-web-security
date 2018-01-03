<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
    <body>
        <form name="loginForm" method="post" action="/login/check">
            <label>用户名：</label>
            <input type="text" name="username" value="hl" width="288px" height="30px">

            <label>密码：</label>
            <input type="text" name="password" value="" width="288px" height="30px">

            <label>Remember ME:</label>
            <input type="checkbox" name="rememberMe" checked="checked"/>

            <button type="submit">提交</button>
        </form>
        <a href="/login/check">已记住密码，直接登录</a>
    </body>
</html>
