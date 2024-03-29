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
    <h1>
        Mål til carport i cm:
    </h1>
    <form action="buildacarport" method="post">
        Længde<br>
        <label for="length"></label><select name="length" id="length">
            <option value="240">240</option>
            <option value="270">270</option>
            <option value="300">300</option>
            <option value="330">330</option>
            <option value="360">360</option>
            <option value="420">420</option>
            <option value="450">450</option>
            <option value="480">480</option>
            <option value="510">510</option>
            <option value="540">540</option>
            <option value="570">570</option>
            <option value="600">600</option>
            <option value="660">660</option>
            <option value="720">720</option>
        </select>
        <br>

        Bredde<br>
        <label for="width"></label><select name="width" id="width">
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
        <label for="shed"></label><select name="shed" id="shed">
            <option value="1">Ja</option>
            <option value="0">Nej</option>
        </select>
            <br>
            Redskabsrum længde<br>
        <label for="shedLength"></label><select name="shedLength" id="shedLength">
                <option value="105">105</option>
                <option value="120">120</option>
                <option value="135">135</option>
                <option value="150">150</option>
                <option value="165">165</option>
                <option value="180">180</option>
                <option value="195">195</option>
                <option value="210">210</option>
                <option value="225">225</option>
                <option value="240">240</option>
                <option value="255">255</option>
                <option value="270">270</option>
                <option value="285">285</option>
                <option value="300">300</option>
                <option value="315">315</option>
                <option value="330">330</option>
                <option value="345">345</option>

            </select>
            <br>
            Redskabsrum bredde<br>
        <label for="shedWidth"></label><select name="shedWidth" id="shedWidth">
                <option value="210">210</option>
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
                <option value="630">630</option>
                <option value="660">660</option>
                <option value="690">690</option>
                <option value="720">720</option>
            </select>
        <br><br>
        <button name="buildACarport">Byg carport</button>
        <c:if test="${sessionScope.svg!=null}">
            <c:if test="${sessionScope.svg.getShedLength()>=sessionScope.svg.getWidth()/2-15}">
                ${sessionScope.svg.setShedLength(sessionScope.svg.getWidth()/2-15)}
            </c:if>
            <c:if test="${sessionScope.svg.getShedWidth()>sessionScope.svg.getHeight()}">
            ${sessionScope.svg.setShedWidth(sessionScope.svg.getHeight())}
            </c:if>
                <br><br>
            <button name="PaymentServlet" formaction="paymentservlet" formmethod="post">Bestil carport</button>


        </c:if>


    </form>

    </body>
</t:pagetemplate>
</html>
