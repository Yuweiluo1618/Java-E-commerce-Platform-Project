<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">
	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="index.jsp">Main</a><span class="crumb-step">&gt;</span><span class="crumb-name">Book</span>
		</div>
	</div>
	<div class="result-wrap">
		<form action="/E-commerceShop/manage/admin_douserdel" id="myform" method="post">
			<div class="result-title">
				<div class="result-list">
					<a href="/E-commerceShop/manage/admin_toproductadd"><i class="icon-font"></i>Add Book</a>
					
					<!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a> -->
				</div>
			</div>
			<div class="result-content">
				<table class="result-tab" width="40%">
					<tr>
						<th>ID</th>
						<th>Category Name</th>
						<th>Manipulation</th>

					</tr>
					<c:forEach var = "cate" items = "${cateList}">
					   <c:if test = "${cate.CATE_PARENT_ID == 0}">
								<tr>
									<td>${cate.CATE_ID}</td>
									<td>${cate.CATE_NAME}</td>
									<td><a href = "admin_tocateupdate?id=${cate.CATE_ID}">Modify</a> <a href = "javascript:catedel(${cate.CATE_ID})">Delete</a></td>
								</tr>
							<c:forEach var = "zcate" items = "${cateList}">
								<c:if test = "${zcate.CATE_PARENT_ID == cate.CATE_ID}">
								<tr>
									<td>${zcate.CATE_ID}</td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${zcate.CATE_NAME}</td>
									<td><a href = "admin_tocateupdate?id=${zcate.CATE_ID}">Modify</a> <a href = "javascript:catedel(${zcate.CATE_ID})">Delete</a></td>
								</tr>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
				
				<script>
					 function catedel(id){
						 if(confirm("Are you sure to delete the category?")){
							 location.href = "admin_docatedel?id="+id;
						 }
						}		 
				</script>
				</table>
			</div>
		</form>
	</div>
</div>
<!--/main-->
</div>
</body>
</html>