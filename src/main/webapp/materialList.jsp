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
        <c:forEach var="item" items="${sessionScope.materialList}">
            <tr>
                <td>
                    Materiale ID: ${item.material_id}<br>
                    Type: ${item.type}<br>
                    Pris: ${item.price}
                </td>
            </tr>
        </c:forEach>
    </table>
    <br><br>

    <form action="editmaterial" method="post">
        <h3>Rediger Materiale</h3>

        <label>
            <input style="width:300px" type="number" name="material_id" id="material_id"/>
        </label>
        <button>Opdater materiale</button>
    </form>
    <br>
    <form action="admin.jsp">
        <button name="tilbageTilAdmin">Tilbage til Admin Siden</button>
    </form>
    </body>
</t:pagetemplate>
</html>