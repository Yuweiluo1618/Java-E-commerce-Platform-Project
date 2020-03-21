<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
 	<script src = "js/jquery-1.12.4.min.js"></script>
    <script src = "js/calendar.js"></script>
    <script src= "js/function.js"></script>
    <style >
    	.reg P .error{
    		display:inline-block;
    		border: 1px solid #ff855a;
    		background-color: #ffe8e0;
    		height: 25px;
    		line-height:25px;
    		padding:0px 20px;
    		margin-left:20px;
    		
    	}
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit = "return checkForm(this)"><h1><a href="/E-commerceShop/reg.jsp"><img src="img/temp/UBC.png"></a></h1>
        <h1 style="padding:0px;margin:0px;font-size:30px;background:#3344AA;text-align:center;line-height:60px;color:#FFFFFF">User Registration</h1>
        <p><input type="text" name="username" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="username"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="realname"><span></span></p>
        <p><input type="text" name="password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="password"><span></span></p>
        <p><input type="text" name="repassword" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="retype password"><span></span></p>
        <p>
        <input type="radio" style = "width:15px;height:15px" name="sex" value="T" checked = "checked"> Male 
        <input type="radio" style = "width:15px;height:15px" name="sex" value="T" checked = "checked"> Female
        </p>
        <p><input type="text" name="birthday" value="" onfocus = "c.show(this)" placeholder="birthday"></p>
        <p><input type="text" name="email" value="" placeholder="email"></p>
        <p><input type="text" name="mobile" value="" placeholder="cell-phone"></p>
        <p><input type="text" name="address" value="" placeholder="address"></p>
        <p><input class="code" type="text" name="verycode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="verify code"><img height ="30" src="getcode" alt="not clear?" onclick="change(this)"><span></span></p></p>
        <p><input type="submit" name="" value="submit"></p>
        <p class="txtL txt"><a href="#">
      
        </a></p>
        <p><a href="#"><span></span>Already Has Account?</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>