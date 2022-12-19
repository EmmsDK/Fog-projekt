<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>editOrders</title>
    </head>
    <body>

    <form action="editmaterial" method="post">
        <h3>Edit Material</h3>
        Material Type:
        <input style="width:200px" type="text" name="updatedType" id=""/> <br>
        Material Length:
        <input style="width:200px" type="number" name="length" value="${requestScope.material.length}"/><br>
        Material Description:
        <input style="width:200px" type="text" name="description" value="${requestScope.material.description}"/><br>
        <br>
        <button formaction="editmaterial" name="item_id" value="${requestScope.material.material_id}">
            Update material
        </button>
    </form>

    </body>
</t:pagetemplate>
</html>
