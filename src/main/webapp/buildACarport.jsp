<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<html>
<t:pagetemplate>
    <head>
        <title>Title</title>
    </head>
    <body>

    <form action="buildacarport" method="post">
        Længde:<br>
        <select name="længde" id="længde">
            <option value="1">Vælg venligst en længde</option>
            <option value="2">300 cm</option>
            <option value="3">310 cm</option>
            <option value="4">320 cm</option>
            <option value="5">330 cm</option>
            <option value="6">340 cm</option>
            <option value="7">350 cm</option>
            <option value="8">360 cm</option>
            <option value="9">370 cm</option>
            <option value="10">380 cm</option>
            <option value="11">390 cm</option>
            <option value="12">400 cm</option>
            <option value="13">410 cm</option>
            <option value="14">420 cm</option>
        </select>
        <br><br>

        Bredde:<br>
        <select name="bredde">
            <option value="1">Vælg venligst en bredde</option>
            <option value="2">180 cm</option>
            <option value="3">190 cm</option>
            <option value="4">200 cm</option>
            <option value="5">210 cm</option>
            <option value="6">220 cm</option>
            <option value="7">230 cm</option>
            <option value="8">240 cm</option>
            <option value="9">250 cm</option>
            <option value="10">260 cm</option>
        </select>
        <br><br>

        redskabsrum:<br>
        <select name="redskabsrum">
            <option value="1">Vælg venligst et redskabsrum</option>
            <option value="2">Ja</option>
            <option value="3">Nej</option>
        </select>
        <br><br>

        <button name="addToCart">Add To Cart</button>
    </form>

    </body>
</t:pagetemplate>
</html>
