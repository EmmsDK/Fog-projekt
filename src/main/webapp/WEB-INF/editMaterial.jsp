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

    <form method="post">
        <h3>Edit Material name</h3>
        <input style="width:200px" type="text" name="type" value="${requestScope.material.type}"/>
        <input style="width:200px" type="text" name="length" value="${requestScope.material.length}"/>
        <input style="width:200px" type="text" name="type_id" value="${requestScope.material.type_id}"/>
        <input style="width:200px" type="text" name="description" value="${requestScope.material.description}"/>
        <button formaction="updatematerial" name="item_id" value="${requestScope.material.material_id}">
            Update material
        </button>
    </form>

    </body>
</t:pagetemplate>
</html>
