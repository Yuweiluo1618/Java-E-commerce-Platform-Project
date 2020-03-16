<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="#" method="post"><h1><a href="/E-commerceShop/reg.jsp"><img src="img/temp/UBC.png"></a></h1>
        <h1 style="padding:0px;margin:0px;font-size:30px;background:#3344AA;text-align:center;line-height:60px;color:#FFFFFF">User Registration</h1>
        <p><input type="text" name="username" value="" placeholder="username"><span></span></p>
        <p><input type="text" name="name" value="" placeholder="realname"><span></span></p>
        <p><input type="text" name="password" value="" placeholder="password"><span></span></p>
        <p><input type="text" name="repassword" value="" placeholder="retype password"><span></span></p>
        <p>
        <input type="radio" style = "width:15px;height:15px" name="sex" value="T" checked = "checked"> Male 
        <input type="radio" style = "width:15px;height:15px" name="sex" value="T" checked = "checked"> Female
        </p>
        <p><input type="text" name="birthday" value="" placeholder="birthday"></p>
        <p><input type="text" name="email" value="" placeholder="email"></p>
        <p><input type="text" name="mobile" value="" placeholder="cell-phone"></p>
        <p><input type="text" name="address" value="" placeholder="address"></p>
        <p><input class="code" type="text" name="verycode" value="" placeholder="verify code"><img
                src="img/temp/code.jpg"></p>
        <p><input type="submit" name="" value="submit"></p>
        <p class="txtL txt"><a href="#">
      
        </a></p>
        <p><a href="#"><span></span>Already Has Account?</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>