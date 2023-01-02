<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Create User
    </jsp:attribute>

    <jsp:body>

        <h3>Opret ny bruger her:</h3>

        <form action="createuser" method="post">
            <%--@declare id="password"--%><%--@declare id="username"--%>
            <label for="username">Brugernavn: </label>
            <label for="newUsername"></label><input type="text" id="newUsername" name="username"/>
            <label for="password">Kodeord: </label>
            <label for="newPassword"></label><input type="password" id="newPassword" name="password"/>
            <input type="submit" value="Create User"/>

        </form>

    </jsp:body>
</t:pagetemplate>