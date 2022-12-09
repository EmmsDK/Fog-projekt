<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>DealInfo</title>
    </head>
    <body>

    <h1>Tak for din bestilling!</h1>

    <br>
    <h2>Du kan se din ordre her:</h2>    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/myOrders.jsp">Mine
        Ordre</a>


    </body>
</t:pagetemplate>
</html>
