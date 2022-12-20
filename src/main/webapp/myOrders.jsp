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

    <c:forEach var="item" items="${sessionScope.list.ordersList}">
        Test:
        ${item.order_id}
        ${item.width}
        ${item.length}
        ${item.total_price}
        ${item.created}
        <br>
    </c:forEach>

    </body>
</t:pagetemplate>
</html>
