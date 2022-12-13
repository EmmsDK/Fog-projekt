<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<html>
<t:pagetemplate>
<jsp:attribute name="header">
Admin Side
</jsp:attribute>

    <jsp:body>

        <h1>Welcome to the Admin Page</h1>

        <a href="editOrders.jsp">Edit order</a>
        <a href="portfolio.jsp">Portfilio</a>


    </jsp:body>

</t:pagetemplate>
</html>