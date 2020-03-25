<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <title>BackStage Management System</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/E-commerceShop/manage/admin_index.jsp" class="navbar-brand">Backstage Management</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/E-commerceShop/manage/admin_index.jsp">Main</a></li>
                <li><a href="/E-commerceShop/index.jsp" target="_blank">Web Main</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">Administrator:${name.USER_NAME}</a></li>
                <li><a href="#">Change Password</a></li>
                <li><a href="/E-commerceShop/manage/admin_logout">Quit</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>Menu</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>Manipulation</a>
                    <ul class="sub-menu">
                        <li><a href="/E-commerceShop/manage/admin_douserselect"><i class="icon-font">&#xe008;</i>User</a></li>
                        <li><a href="admin_cate.jsp"><i class="icon-font">&#xe005;</i>Category</a></li>
                        <li><a href="admin_product.jsp"><i class="icon-font">&#xe006;</i>Book</a></li>
                        <li><a href="admin_order.jsp"><i class="icon-font">&#xe004;</i>Order</a></li>
                        <li><a href="admin_message.jsp"><i class="icon-font">&#xe012;</i>Feedback</a></li>
                        <li><a href="admin_news.jsp"><i class="icon-font">&#xe052;</i>News</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>System</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe017;</i>Setup</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe037;</i>Data Clean</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe046;</i>Data Backup</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>Data Restore</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
 