<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<html>
<t:pagetemplate>
    <head>
        <title>editOrders</title>
    </head>
    <body>

    <h1>Edit Orders</h1>

    <form method="post">
        <h3>Edit material</h3>
        <input style="width:300px" type="text" name="name" value="${requestScope.material.type}"/>
        <button formaction="updatematerial" name="material_id" value="${requestScope.material.type_id}">
            Update material
        </button>
    </form>

    </body>
</t:pagetemplate>
</html>
