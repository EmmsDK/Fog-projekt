<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>myOrder</title>
    </head>
    <body>

    <h1>Mine Ordre</h1>

    <c:forEach var="material" items="${sessionScope.BillOfMaterials}">
        ${material.idWood}: <br>
        ${material.idScrew}
        ${material.idRoofTile}
        ${material.idFitting}
        ${material.idCarportPrice}<br>
        <br>
    </c:forEach>


    </body>
</t:pagetemplate>
</html>
