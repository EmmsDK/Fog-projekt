<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>Portfolio</title>
    </head>
    <body>

    <h1>Portfolio</h1>

    <p>Admin portfolio</p>

    <c:forEach var="item" items="${sessionScope.materialList}">
        Test: ${item.type}: <br>
        Test: ${item.description}
        Test: ${item.length}
        Test: ${item.type_id}
        <br><br>
    </c:forEach>



    </body>
</t:pagetemplate>
</html>
