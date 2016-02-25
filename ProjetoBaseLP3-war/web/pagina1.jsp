<%-- 
    Document   : pagina1
    Created on : 16/02/2016, 08:16:09
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
        <c:if test="${username == null}">
            <c:set scope="session" var="errormsg" value="Acesso restrito! Faça login para continuar."></c:set>
            <c:redirect url="login.jsp"> </c:redirect>
        </c:if>
        
        <c:set scope="session" var="menu" value="pagina1"></c:set>
        <%@include file="topMenu.jsp"%>
        <h1>Pagina Um!</h1>
    </body>
</html>
