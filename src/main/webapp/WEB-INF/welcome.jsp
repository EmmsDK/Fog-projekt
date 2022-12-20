<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Shopping Page
    </jsp:attribute>

    <jsp:body>

        <h1>Velkommen!</h1>

        <a class="navbar-brand" href="buildACarport.jsp">
            <img src="${pageContext.request.contextPath}/images/Build-A-Carport.png" width="350px;" class="img-fluid"/>
        </a>

        <a class="navbar-brand" href="myOrders.jsp">
            <img src="${pageContext.request.contextPath}/images/Orders.png" width="350px;" class="img-fluid"/>
        </a>

        <a class="navbar-brand" href="myProfile.jsp">
            <img src="${pageContext.request.contextPath}/images/Profile.png" width="350px;" class="img-fluid"/>
        </a>

    </jsp:body>

</t:pagetemplate>