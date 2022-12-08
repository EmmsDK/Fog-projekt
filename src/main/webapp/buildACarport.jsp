<%--
  Created by IntelliJ IDEA.
  User: Johan
  Date: 08/12/2022
  Time: 09.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="addtocart" method="post">
    længde
    <select name="længde"  id="længde" >

        <option value="1">Almond (7kr)</option>
        <option value="2">Chocolate (5kr)</option>
        <option value="3">Nutmeg (6kr)</option>
        <option value="4">Pistacio (6kr)</option>
        <option value="5">Vanilla (5kr)</option>
     </select>
    bredde
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
    type
    <select name="type carport">
        <option value="1">Enkeltcarport</option>
        <option value="2">Dobbeltcarport</option>

    </select>
    redskabsrums
    <select name="redskabsrum">
        <option value="1">Ja</option>
        <option value="2">Nej</option>

    </select>
    <button name="addToCart">Add To Cart</button>
</form>

</body>
</html>
