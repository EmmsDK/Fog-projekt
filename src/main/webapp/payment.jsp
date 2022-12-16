<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>Betalings Side</title>
    </head>
    <body>

    <p>Denne side er hvor du betaler for din carport. </p>

    <button formaction="payment" name="total_price" value="${requestScope.totalprice}">
        ${requestScope.totalprice}
    </button>

    <a href="myOrders.jsp">Se dine order her</a>

    <p>Byg din carport!</p>



    </body>
</t:pagetemplate>
</html>
