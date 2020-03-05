<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.html">Main</a><span
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
							name="keywords" value="" id="" type="text"></td>
						<td><input class="btn btn-primary btn2" name="sub" value="Search"
							type="submit"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="result-wrap">
		<form name="myform" id="myform" method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="admin_useradd.jsp"><i class="icon-font"></i>New User</a>
					<a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
					<a id="updateOrd" href="javascript:void(0)"><i
						class="icon-font"></i>更新排序</a>
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="100%">
					<tr>
						<th class="tc" width="5%"><input class="allChoose" name=""
							type="checkbox"></th>
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
							<a class="link-update" href="#">Revise</a>
						    <a class="link-del" href="#">Del</a>
						</td>
					</tr>
				</c:forEach>
				</table>
				<div class="list-page">
					Total Record: ${tsum}
					Current Page: ${cpage}/${tpage} 
					<a href="admin_douserselect?cp=1">First Page</a>
					<a href="admin_douserselect?cp=${cpage-1 < 1 ? 1:cpage-1 }">Previous</a>
					<a href="admin_douserselect?cp=${cpage+1 > tpage ? tpage:cpage+1}">Next</a>
					<a href="admin_douserselect?cp=${tpage}">Last Page</a>
				</div>
			</div>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>