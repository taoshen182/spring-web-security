<%--
  Created by IntelliJ IDEA.
  User: xx
  Date: 2017/4/26
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>security 首页</title>
</head>
    <body style="align-content: center">
        <p>
            <h2>认证通过，HL主页</h2>
            <h5><a href="/user/logout">退出登录</a></h5>
        </p>

        <table>
            <tr>
                <td width="80px">序号</td>
                <td width="200px">一级菜单</td>
                <td width="700px">二级菜单</td>
            </tr>
            <c:forEach var="menu1" items="${menuList}" varStatus="status1">
                <tr>
                    <td width="80px">${status1.index+1}</td>
                    <td width="200px"><a href="${pageContext.request.contextPath}${menu1.menuRescStr}">${menu1.menuName}</a></td>
                    <td width="700px">
                        <c:forEach var="menu2" items="${menu1.children}" varStatus="status2">
                            <a href="${pageContext.request.contextPath}${menu2.menuRescStr}">${menu2.menuName}</a>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
