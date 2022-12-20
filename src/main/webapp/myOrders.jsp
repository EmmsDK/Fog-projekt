<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>Dine Ordre</title>
    </head>
    <body>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Dine Ordre:</th>
        </tr>
        </thead>
        <c:forEach var="item" items="${sessionScope.list}">
            <tr>
                <td>
                    Bruger ID: ${item.user_id}<br>
                    Længde: ${item.width}
                    Bredde: ${item.width}
                    Total Pris: ${item.total_price}<br>
                    Oprettet: ${item.created}<br>
                </td>
            </tr>
        </c:forEach>

    </table>

    <c:forEach var="item" items="${sessionScope.list}">
        Test:
        ${item.user_id}
        ${item.width}
        ${item.length}
        ${item.total_price}
        ${item.created}
        <br>
    </c:forEach>

    </body>
</t:pagetemplate>
</html>
