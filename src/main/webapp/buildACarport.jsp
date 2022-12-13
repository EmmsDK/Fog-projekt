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
        <br><br>

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

        </select>
        Redskabsrum
        <select name="shed" id="shed">
            <option value="1">Ja</option>
            <option value="0">Nej</option>

        <button name="buildACarport">Byg carport</button>
        <c:if test="${sessionScope.svg!=null}">
            <button name="SvgServlet" formaction="svg" formmethod="get">Se din nuværende carport</button>
        </c:if>
    </form>

    </body>
</t:pagetemplate>
</html>
