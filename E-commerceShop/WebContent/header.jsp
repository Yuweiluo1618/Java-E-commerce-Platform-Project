<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src=""/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            <c:if test = "${isLogin != 1}">
            	<a href="login.jsp" id="login">login</a>
            	<a href="reg.jsp" id="reg">register</a>
            </c:if>
             <c:if test = "${isLogin == 1}">
            		<b>Hello:</b> <a href="login.jsp" id="login">${name.USER_NAME}</a>
            </c:if>
             <c:if test = "${isAdminLogin == 1}">
            		<a href="/E-commerceShop/manage/admin_index.jsp" id="login">System</a>
            </c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="Java"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1"><img
                        src="img/ewm.png"/></a>
                  <c:if test = "${isLogin == 1}">       
                        <a href="cart.html"><img src="img/gwc.png"/></a>
                  </c:if>  
                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">Main</a></li>
            <c:forEach var = "f" items = "${flist}">
            	<li><a href="selectproductlist?fid=${f.CATE_ID}">${f.CATE_NAME }</a>
                	<div class="sList2">
                    	<div class="clearfix">
                    		<c:forEach var = "c" items ="${clist}">
                    			<c:if test ="${f.CATE_ID  == c.CATE_PARENT_ID}">
                    				<a href="selectproductlist?cid=${c.CATE_ID}">${c.CATE_NAME }</a>
                    			</c:if>
                    			
                    		</c:forEach>
                    		
                    	</div>
                	</div>
            	</li>
            </c:forEach>
        </ul>
    </div>
 </div>