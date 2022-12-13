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
        Længde<br>
        <select name="length" id="length">
            <option value="240">240</option>
            <option value="270">270</option>
            <option value="300">300</option>
            <option value="330">330</option>
            <option value="360">360</option>
            <option value="390">390</option>
            <option value="450">450</option>
            <option value="480">480</option>
            <option value="510">510</option>
            <option value="540">540</option>
            <option value="570">570</option>
            <option value="600">600</option>
            <option value="630">630</option>
            <option value="660">660</option>
            <option value="690">690</option>
            <option value="720">720</option>
        </select>
        <br>

        Bredde<br>
        <select name="width" id="width">
            <option value="240">240</option>
            <option value="270">270</option>
            <option value="300">300</option>
            <option value="330">330</option>
            <option value="360">360</option>
            <option value="390">390</option>
            <option value="420">420</option>
            <option value="450">450</option>
            <option value="480">480</option>
            <option value="510">510</option>
            <option value="540">540</option>
            <option value="570">570</option>
            <option value="600">600</option>
        </select>
        <br>
        Redskabsrum<br>
        <select name="shed" id="shed">
            <option value="1">Ja</option>
            <option value="0">Nej</option>
        </select>
            <br>
            Redskabsrum længde<br>
            <select name="shedLength" id="shedLength">
                <option value="150">150</option>
                <option value="180">180</option>
                <option value="210">210</option>
                <option value="240">240</option>
                <option value="270">270</option>
                <option value="300">300</option>
                <option value="330">330</option>
                <option value="360">360</option>
                <option value="390">390</option>
                <option value="450">450</option>
                <option value="480">480</option>
                <option value="510">510</option>
                <option value="540">540</option>
                <option value="570">570</option>
                <option value="600">600</option>
                <option value="630">630</option>
                <option value="660">660</option>
                <option value="690">690</option>

            </select>
            <br>
            Redskabsrum bredde<br>
            <select name="shedWidth" id="shedWidth">
                <option value="210">210</option>
                <option value="240">240</option>
                <option value="270">270</option>
                <option value="300">300</option>
                <option value="330">330</option>
                <option value="360">360</option>
                <option value="390">390</option>
                <option value="450">450</option>
                <option value="480">480</option>
                <option value="510">510</option>
                <option value="540">540</option>
                <option value="570">570</option>
                <option value="600">600</option>
                <option value="630">630</option>
                <option value="660">660</option>
                <option value="690">690</option>
                <option value="720">720</option>
            </select>
        <br><br>
        <button name="buildACarport">Byg carport</button>
        <br>
        <c:if test="${sessionScope.svg!=null}">
            <button name="SvgServlet" formaction="svg" formmethod="get">Se din nuværende carport</button>
        </c:if>
    </form>

    </body>
</t:pagetemplate>
</html>
