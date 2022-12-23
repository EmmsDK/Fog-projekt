<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>DealInfo</title>
    </head>
    <body>

    <h1>Tak for din bestilling!</h1>
    ${sessionScope.svg}
    <br>
    <h2>Du kan se din ordre her:</h2>
    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/ordersservlet">Mine Ordre</a>

    <h2>Stykliste: </h2>
    <table class="table table-striped">
    <c:forEach var="item" items="${sessionScope.billOfMaterials}">
        <tr>
            <td>
                Type: ${item.type}<br>
                Description: ${item.description}<br>
                <c:if test="${item.length!=0}">
                Length: ${item.length}<br>
                </c:if>
                Quantity: ${item.quantity}<br>
            </td>
        </tr>
    </c:forEach>
    </table>
    </body>
</t:pagetemplate>
</html>
