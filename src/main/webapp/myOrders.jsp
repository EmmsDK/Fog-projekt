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
        <form action="ordersservlet" method="get">
            <c:forEach var="item" items="${sessionScope.usersOrders}">
                <tr>
                    <td>
                        Bruger ID: ${item.user_id}<br>
                        Bredde: ${item.width}<br>
                        Længde: ${item.length}<br>
                        Total Pris: ${item.total_price}<br>
                        Oprettet: ${item.created}<br>
                    </td>
                </tr>
            </c:forEach>
        </form>
    </table>
    </body>
</t:pagetemplate>
</html>
