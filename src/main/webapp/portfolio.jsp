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

    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Lise af ordre:</th>
        </tr>
        </thead>
        <c:if test="${sessionScope.ordersList != null}">
            <c:forEach var="item" items="${sessionScope.ordersList}">
                <tr>
                    <td>
                        User ID: ${item.user_id}<br>
                        Længde: ${item.length}
                        Bredde: ${item.width}
                        Total Pris: ${item.total_price}<br>
                        Oprettet: ${item.created}<br>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>


    </body>
</t:pagetemplate>
</html>
