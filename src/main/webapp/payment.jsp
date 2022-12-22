<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <head>
        <title>Betalings Side</title>
    </head>
    <body>

    <p>Denne side er hvor du betaler for din carport. </p><br><br>
    <h1>DU SKAL BETALE: <br> ${sessionScope.price} danska crowners</h1>
    <style>
        img {
        display: block;
        margin-left: auto;
        margin-right: auto;
    }
    </style>

    <img src="${pageContext.request.contextPath}/images/newCardInfo.png" width="1180" style="width:50%" alt="CardInfo">

    <a href="dealInfo.jsp">
        <img src="${pageContext.request.contextPath}/images/paynow.png" width="348" style="width: 50%" alt="payNow"/>
    </a>


    </body>
</t:pagetemplate>
</html>
