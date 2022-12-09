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

            <option value="1">300</option>
            <option value="2">310</option>
            <option value="3">320</option>
            <option value="4">330</option>
            <option value="5">340</option>
            <option value="6">350</option>
            <option value="7">360</option>
            <option value="8">370</option>
            <option value="9">380</option>
            <option value="10">390</option>
            <option value="11">400</option>
            <option value="12">410</option>
            <option value="13">420</option>


        </select>
        Bredde
        <select name="bredde">
            <option value="1">180 cm</option>
            <option value="2">190</option>
            <option value="3">200</option>
            <option value="4">210</option>
            <option value="5">220</option>
            <option value="6">230</option>
            <option value="7">240 (5kr)</option>
            <option value="8">250</option>
            <option value="9">260</option>
        </select>
        Type
        <select name="type carport">
            <option value="1">Enkeltcarport</option>
            <option value="2">Dobbeltcarport</option>

        </select>
        redskabsrum
        <select name="redskabsrum">
            <option value="1">Ja</option>
            <option value="2">Nej</option>

        </select>
        <button name="addToCart">Add To Cart</button>
    </form>

    </body>
</t:pagetemplate>
</html>
