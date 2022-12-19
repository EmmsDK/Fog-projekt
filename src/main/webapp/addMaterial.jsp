<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        Add Material
    </jsp:attribute>
    <jsp:body>

        <form action="addmaterial" method="post">
                <%--@declare id="type"--%>
                <%--@declare id="description"--%>
                <%--@declare id="length"--%>
                <%--@declare id="type_id"--%>
                <%--@declare id="price"--%>
            <label for="type">Type: </label>
            <input type="text" id="newType" name="type"/>
            <br>
            <label for="description">Description: </label>
            <input type="text" id="newDescription" name="description"/>
            <br>
            <label for="length">Length: </label>
            <input type="number" id="newLength" name="length"/>
            <br>
            <label for="type_id">Type ID: </label>
            <input type="number" id="newTypeID" name="type_id"/>
            <br>
            <label for="price">price: </label>
            <input type="number" id="newPrice" name="price"/>
            <br>
            <input type="submit" value="Add Material"/>
        </form>

    </jsp:body>
</t:pagetemplate>

