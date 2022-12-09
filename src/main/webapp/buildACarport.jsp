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
        <select name="length" id="length">
            <option value="300">300</option>
            <option value="310">310</option>
            <option value="320">320</option>
            <option value="330">330</option>
            <option value="340">340</option>
            <option value="350">350</option>
            <option value="360">360</option>
            <option value="370">370</option>
            <option value="380">380</option>
            <option value="390">390</option>
            <option value="400">400</option>
            <option value="410">410</option>
            <option value="420">420</option>
        </select>
        Bredde
        <select name="bredde">
            <option value="1">180 cm</option>
            <option value="2">190</option>
            <option value="3">200</option>
            <option value="4">210</option>
            <option value="5">220</option>
            <option value="6">230</option>
            <option value="7">240</option>
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
        <button name="buildACarport">Se carport</button>
    </form>

    </body>
</t:pagetemplate>
</html>
