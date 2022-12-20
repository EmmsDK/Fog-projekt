<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<html>
<t:pagetemplate>
<jsp:attribute name="header">
Admin Side
</jsp:attribute>

    <jsp:body>

        <!--
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
        --!>
        
        <p>
            Fra denne side kan du blive omdirigeret til Rediger Materiale og Portfolio ved at trykke på nedstående knapper. <br>
            På Rediger Materiale siden, kan du ændre navnet og prisen på materialerne fra databasen. På Portfolio siden, <br>
            kan du se, redigere og slette kundeordrer der ligger inde på databasen.
        </p>

        <br>
        <form action="editOrders.jsp">
            <button name="editmaterial">Rediger Materiale</button>
        </form>
        <form action="portfolio.jsp">
            <button name="portfolio">Portfolio</button>
        </form>
        <br>
        <a href="addMaterial.jsp">Tilføj Materiale</a>

    </jsp:body>

</t:pagetemplate>
</html>