<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">
	<div class="crumb-wrap">
		<div class="crumb-list">
			<i class="icon-font"></i><a href="admin_index.jsp">Main</a><span class="crumb-step">&gt;</span><span class="crumb-name">Book</span>
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
				<table class="result-tab" width="80%">
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Manipulation</th>

					</tr>
					<c:forEach var = "p" items = "${plist}">
						<tr>
							<td>${p.PRODUCT_ID}</td>
							<td>
								<img src = "../images/product/${p.PRODUCT_FILENAME }" width = "80" height = "80">
								${p.PRODUCT_NAME }
							</td>
							<td>
								<a href = ""> Modify</a>
								<a href = ""> Delete</a>
							</td>
						</tr>
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