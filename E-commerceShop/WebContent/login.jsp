<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="login" method="post"><h1><a href="login.jsp"><img src="img/temp/UBC.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>Do not login at public computer</div>
        <p><input type="text" name="userName" value="" placeholder="username"></p>
        <p><input type="text" name="passWord" value="" placeholder="password"></p>
        <p><input type="submit" name="" value="login"></p>
        <p class="txt"><a class="" href="reg.html">register</a><a href="forget.html">forget password？</a></p></form>
</div>
</body>
</html>