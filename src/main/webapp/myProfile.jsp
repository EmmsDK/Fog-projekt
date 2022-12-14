<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>My Profile</title>
    </head>
    <body>

    <h1>Min Profil</h1>

    <p>Dit Brugernavn er: ${sessionScope.user.username} </p>

    <a href="myOrders.jsp">Se dine order her</a>

    <p>Byg din carport!</p>



    </body>
</t:pagetemplate>
</html>
