<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<html>
<t:pagetemplate>
    <head>
        <title>Alle Ordre:</title>
    </head>
    <body>

    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Liste af ordre:</th>
        </tr>
        </thead>
        <c:if test="${sessionScope.ordersList != null}">
            <c:forEach var="item" items="${sessionScope.ordersList}">
                <tr>
                    <td>
                        Bruger ID: ${item.user_id}<br>
                        Længde: ${item.length}
                        Bredde: ${item.width}
                        Total Pris: ${item.total_price}<br>
                        Oprettet: ${item.created}<br>
                        Ordre ID: ${item.getOrder_id()}<br>
                    </td>
                    <td>
                        <form action="removeorder" method="get">
                            <button name="order_id" value="${item.getOrder_id()}">Fjern ordre</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>


    <br>
    <form action="admin.jsp">
        <button name="tilbageTilAdmin">Tilbage til Admin Siden</button>
    </form>

    </body>
</t:pagetemplate>
</html>
