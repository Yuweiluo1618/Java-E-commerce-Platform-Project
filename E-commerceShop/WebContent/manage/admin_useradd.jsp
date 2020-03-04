<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">Main</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">User</a><span class="crumb-step">&gt;</span><span>New User</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/E-commerceShop/manage/admin_douseradd" method="post" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>UserName:</th>
                                <td>
                                    <input class="common-text required" id="title" name="userName" size="50" value="" type="text">
                                </td>
                            </tr>
                             
                             <tr>
                                <th><i class="require-red">*</i>RealName:</th>
                                <td>
                                    <input class="common-text required" id="title" name="Name" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>Password:</th>
                                <td>
                                    <input class="common-text required" id="title" name="passWord" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>Re-password:</th>
                                <td>
                                    <input class="common-text required" id="title" name="Repassword" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th>Gender:</th>
                                <td>
                                    <input type = "radio" name = "sex" value = "T" checked ="checked"> Male
                                    <input type = "radio" name = "sex" value = "F"> Female
                                </td>
                            </tr>
                            
                            <tr>
                                <th>Birthday:</th>
                                <td>
                                    <input class="common-text required" id="title" name="birthday" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>E-mail:</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>Cell-Phone:</th>
                                <td>
                                    <input class="common-text required" id="title" name="mobile" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>Address:</th>
                                <td>
                                    <input class="common-text required" id="title" name="address" size="50" value="" type="text">
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