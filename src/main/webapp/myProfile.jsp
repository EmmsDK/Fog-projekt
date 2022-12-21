<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>Min Profil</title>
    </head>
    <body>

    <p>Dit Brugernavn er: ${sessionScope.user.username} </p>
    ${sessionScope.user.user_id}

    <a href="myOrders.jsp">Se dine order her</a>

    <p>Byg din carport!</p>



    </body>
</t:pagetemplate>
</html>
