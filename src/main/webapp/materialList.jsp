<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<html>
<t:pagetemplate>
    <head>
        <title>Materiale Liste</title>
    </head>
    <body>

    <h1>Materiale liste</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Liste af Materiale:</th>
        </tr>
        </thead>
        <form action="editmaterial" method="post">
            <c:forEach var="item" items="${sessionScope.materialList}">
            <tr>
                <td>
                    Materiale ID: ${item.material_id}<br>
                    Type: ${item.type} <br>
                    Pris: ${item.price}
                <td align="right">
                    <br>
                    <button name="material_id" id="material_id" value="${item.material_id}">
                        Rediger
                    </button>
                </td>
                </c:forEach>
        </form>
    </table>
    <br><br>
    <br>
    <form action="admin.jsp">
        <button name="tilbageTilAdmin">Tilbage til Admin Siden</button>
    </form>
    </body>
</t:pagetemplate>
</html>
