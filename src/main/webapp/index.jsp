<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <p>Log venligst på systemet først</p>
        <p>Derefter kan du shoppe løs</p>
        <p>Det kan du gøre her: <a href="login.jsp">Login</a></p>
        <br>
        <p>Hvis du ikke har en bruger</p>
        <p>Så opret dig venligst her: <a href="createUser.jsp"></a></p>

    </jsp:body>

</t:pagetemplate>