<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Main</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">User</a><span class="crumb-step">&gt;</span><span>New User</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/E-commerceShop/manage/admin_dousercate" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>Parent Category:</th>
                                <td>
                                    <select class="common-text required"  name="parentId">
                                    <option value = "0" selected = "selected">Main Category</option>
                                    <c:forEach var = "cate" items = "${catelist}">
                                    	<c:if test ="${cate.CATE_PARENT_ID == 0}" >
                                    	<option value = "${cate.CATE_ID}">${cate.CATE_NAME}</option>
                                    	</c:if>
                                    </c:forEach>
                                    </select>
                                </td>
                            </tr>
                             
                             <tr>
                                <th><i class="require-red">*</i>Category Name:</th>
                                <td>
                                    <input class="common-text required" id="title" name="className" size="50" value="" type="text">
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