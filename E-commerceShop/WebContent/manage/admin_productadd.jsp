<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Main</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/E-commerceShop/manage/admin_productselect">Book</a><span class="crumb-step">&gt;</span><span>New Book</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/E-commerceShop/manage/admin_doproductcate" method="post" enctype ="multipart/form-data" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                          
                           <tr>
                                <th><i class="require-red">*</i>Book Name:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productName" size="50" value="" type="text">
                                </td>
                            </tr>
                           
                            <tr>
                                <th><i class="require-red">*</i>Book Category:</th>
                                <td>
                                    <select class="common-text required"  name="parentId">
                                
                                    <c:forEach var = "f" items = "${flist}">
                                    	<option value = "${f.CATE_ID}" disabled = "disabled">|-${f.CATE_NAME}</option>
                                    	  <c:forEach var = "c" items = "${clist}">
                                    	  	<c:if test="${c.CATE_PARENT_ID == f.CATE_ID }">
                                    	  		<option value = "${f.CATE_ID}-${c.CATE_ID}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.CATE_NAME}</option>
                                    	  	</c:if>
                                    	  </c:forEach>
                                    </c:forEach>
                                    </select>
                                </td>
                            </tr>
                             
                             <tr>
                                <th><i class="require-red">*</i>Book Picture:</th>
                                <td>
                                    <input class="common-text required" id="title" name="phtot" size="50" value="" type="file">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>Book Price:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productPrice" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>Book Description:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productDesc" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>Book stock:</th>
                                <td>
                                    <input class="common-text required" id="title" name="productStock" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="Submit" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="Return" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>