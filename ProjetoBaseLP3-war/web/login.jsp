<%-- 
    Document   : login
    Created on : 16/02/2016, 08:17:36
    Author     : 41404671
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set scope="session" var="menu" value="login"></c:set>
        <%@include file="topMenu.jsp" %>
        <h1>Login!</h1>
        <c:if test="${errormsg != null && !''.equals(errormsg)}">
        <p class="msg">${errormsg}</p>
        </c:if>
        <c:set scope="session" var="errormsg" value=""></c:set>
        <form method="POST" action="home">
            <p><input text="text" name="username" placeholder="username" value="${cookie.usernameCookie.value}"/></p>
            <p><input type="password" name="password" placeholder="password" value="${cookie.passwordCookie.value}"/></p>
            <p><input type="checkbox" name="checkSave" checked="checked"/> Salvar usuário e senha</p>
            <p><input type="submit" value="Login"/></p>
            <input type="hidden" name="command" value="User"/>
            <input type="hidden" name="action" value="login"/>
        </form>
    </body>
</html>
