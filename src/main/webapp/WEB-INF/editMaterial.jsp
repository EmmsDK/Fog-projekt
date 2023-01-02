<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>Edit Material</title>
    </head>
    <body>

    <form action="updatematerial" method="post">
        <h3>Rediger materiale ${sessionScope.material.material_id}</h3>
        Type:
        <label for="updatedType"></label><input style="width:200px" type="text" name="type" id="updatedType"/> <br>
        Længde:
        <label for="updatedLength"></label><input style="width:200px" type="number" name="length" id="updatedLength"/><br>
        Beskrivelse:
        <label for="updatedDescription"></label><input style="width:200px" type="text" name="description" id="updatedDescription"/><br>
        <br>
        Pris:
        <label for="updatedPrice"></label><input style="width:200px" type="text" name="price" id="updatedPrice"/><br>
        <input type="hidden" name="material_id" value="${sessionScope.material.material_id}"/>
        <br>
        <button>
            Opdater materiale
        </button>
    </form>

    </body>
</t:pagetemplate>
</html>
