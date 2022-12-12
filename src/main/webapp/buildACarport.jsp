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
            <option>Vælg venligst en længde</option>
            <option value="300">300 cm</option>
            <option value="310">310 cm</option>
            <option value="320">320 cm</option>
            <option value="330">330 cm</option>
            <option value="340">340 cm</option>
            <option value="350">350 cm</option>
            <option value="360">360 cm</option>
            <option value="370">370 cm</option>
            <option value="380">380 cm</option>
            <option value="390">390 cm</option>
            <option value="400">400 cm</option>
            <option value="410">410 cm</option>
            <option value="420">420 cm</option>
        </select>
        <br><br>

        Bredde<br>
        <select name="width" id="width">
            <option>Vælg venligst en bredde</option>
            <option value="300">300 cm</option>
            <option value="600">600 cm</option>
        </select>

        <br><br>
        Redskabsrum<br>
        <select name="redskabsrum">
            <option>Vælg venligst redskabsrum</option>
            <option value="1">Ja</option>
            <option value="2">Nej</option>
        </select>
        <br><br>

        <button name="buildACarport">Byg carport</button>
        <c:if test="${sessionScope.svg!=null}">
            <button name="SvgServlet" formaction="svg" formmethod="get">Se din nuværende carport</button>
        </c:if>
    </form>

    </body>
</t:pagetemplate>
</html>
