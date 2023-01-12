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

        <p>
            Fra denne side kan du blive omdirigeret til Rediger Materiale og Ordrer ved at trykke på nedstående knapper. <br>
            På Rediger Materiale siden, kan du ændre navnet og prisen på materialerne fra databasen. <br>
            På Ordrer siden, kan du se, redigere og slette kundeordrer der ligger inde på databasen. <br>
            Yderligere, kan du blive opdirigeret til Tilføj Materiale. På Tilføj Materiale siden, <br>
            kan du tilføje nye materialer til databasen.
        </p>

        <br>
        <form action="materialList.jsp">
            <button>Rediger Materiale</button>
        </form>
        <form action="orders.jsp">
            <button>Ordrer</button>
        </form>
        <form action="addMaterial.jsp">
            <button>Tilføj Materiale</button>
        </form>

    </jsp:body>

</t:pagetemplate>
</html>