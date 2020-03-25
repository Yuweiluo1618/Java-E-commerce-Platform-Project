<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">Main</a><span
				class="crumb-step">&gt;</span><span class="crumb-name">User</span>
		</div>
	</div>
	<div class="search-wrap">
		<div class="search-content">
			<form action="/E-commerceShop/manage/admin_douserselect" method="get">
				<table class="search-tab">
					<tr>
						<!--  th width="120">选择分类:</th>
						<td><select name="search-sort" id="">
								<option value="">全部</option>
								<option value="19">精品界面</option>
								<option value="20">推荐界面</option>
						</select></td-->
						<th width="70">Search:</th>
						<td><input class="common-text" placeholder="Keyword"
							name="keywords" value="${param.keywords}" id="" type="text"></td>
						<td><input class="btn btn-primary btn2" name="sub" value="Search"
							type="submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="result-wrap">
		<form action="/E-commerceShop/manage/admin_douserdel" id="myform" method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="admin_useradd.jsp"><i class="icon-font"></i>New User</a>
					<a id="batchDel" href="javascript:delmore('Are you sure you want to delete this?','myform')"> <i class="icon-font"></i>Delete All</a>
					<!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th class="tc" width="5%"><input class="allChoose" name="" onclick ="selall(this)" type="checkbox"></th>
						<th>ID</th>
						<th>Name</th>
						<th>Sex</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Update</th>

					</tr>
					<c:forEach var = "u" items = "${userlist}">
					<tr>
						<td class="tc"><input name="id[]" value="${u.USER_ID}" type="checkbox"></td>
						<td>${u.USER_ID}</td>
						<td>${u.USER_NAME}</td>
						<td>${u.USER_SEX == 'T'?'Male':'Female'}</td>
						<td>${u.USER_EMAIL}</td>
						<td>${u.USER_MOBILE}</td>
						
						<td>
							<a class="link-update" href="admin_touserupdate?id=${u.USER_ID}&cpage=${cpage}">Revise</a>
						    
						    <c:if test = "${u.USER_STATUS == 1}">
						    	<a class="link-del" href="javascript:Delete('Are you sure to deleter [${u.USER_NAME}] User?','/E-commerceShop/manage/admin_douserdel?id=${u.USER_ID}&cpage=${cpage}')">Del</a>
						    </c:if>
						</td>
					</tr>
				</c:forEach>
				<script>
					 function Delete(mess, url){
						 if(confirm(mess)){
							 location.href = url;
						 }
						}
					 
					 function selall(o){
						 var a = document.getElementsByName("id[]");
						 for(var i = 0; i < a.length; i++){
							 a[i].checked = o.checked;
						 }
					 }
					 
					 function delmore(mess, formname){
						 if(confirm(mess)){
							 var form = document.getElementById(formname);
							 form.submit();
						 }
					 }
					 
				</script>
				</table>
				<div class="list-page">
					Total Record: ${tsum}
					Current Page: ${cpage}/${tpage} 
					<a href="admin_douserselect?cp=1${searchParams}">First Page</a>
					<a href="admin_douserselect?cp=${cpage-1 < 1 ? 1:cpage-1}${searchParams}">Previous</a>
					<a href="admin_douserselect?cp=${cpage+1 > tpage ? tpage:cpage+1}${searchParams}">Next</a>
					<a href="admin_douserselect?cp=${tpage}${searchParams}">Last Page</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>