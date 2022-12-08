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
        Længde
        <select name="længde" id="længde">

            <option value="1">Almond (7kr)</option>
            <option value="2">Chocolate (5kr)</option>
            <option value="3">Nutmeg (6kr)</option>
            <option value="4">Pistacio (6kr)</option>
            <option value="5">Vanilla (5kr)</option>
        </select>
        Bredde
        <select name="bredde">
            <option value="1">Blue Cheese (9kr)</option>
            <option value="2">Blueberry (5kr)</option>
            <option value="3">Chocolate (5kr)</option>
            <option value="4">Crispy (6kr)</option>
            <option value="5">Lemon (8kr)</option>
            <option value="6">Orange (8kr)</option>
            <option value="7">Rasberry (5kr)</option>
            <option value="8">Rum/Raisin (7kr)</option>
            <option value="9">Strawberry (6kr)</option>
        </select>
        Type
        <select name="type carport">
            <option value="1">Enkeltcarport</option>
            <option value="2">Dobbeltcarport</option>

        </select>
        Redskabsrums
        <select name="redskabsrum">
            <option value="1">Ja</option>
            <option value="2">Nej</option>

        </select>
        <button name="addToCart">Add To Cart</button>
    </form>

    </body>
</t:pagetemplate>
</html>
