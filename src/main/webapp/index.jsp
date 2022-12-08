<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen til Fog's skræddersyede carporte side
    </jsp:attribute>

    <jsp:attribute name="footer">
         Velkommen til Fog's skræddersyede carporte side
    </jsp:attribute>

    <jsp:body>
        <p>For at benytte hjemmesiden, skal du venligst login:</p>
        <a href="login.jsp"> Login</a>
        <br>
        <p>Hvis du ikke har en bruger, kan du oprette en bruger her:</p>
        <a href="createUser.jsp">Opret bruger</a>

    </jsp:body>

</t:pagetemplate>