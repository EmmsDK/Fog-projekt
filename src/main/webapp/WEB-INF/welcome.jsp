<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Shopping Page
    </jsp:attribute>

    <jsp:body>

        <h1>Welcome to the Shopping Page</h1>

        <form action="addtocart" method="post">
            <select name="bottom">
                <option value="1">Almond (7kr)</option>
                <option value="2">Chocolate (5kr)</option>
                <option value="3">Nutmeg (6kr)</option>
                <option value="4">Pistacio (6kr)</option>
                <option value="5">Vanilla (5kr)</option>
            </select>

            <select name="topping">
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

            <select name="quantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>

            <button name="addToCart">Add To Cart</button>
        </form>
        <form action="checkout" method="post">
            <button name="checkout">Checkout</button>
        </form>
        <h2> Antal linjer i kurven: ${requestScope.cartsize}</h2>

        <h2>Indhold i kurv:</h2>
        <c:forEach var="item" items="${sessionScope.cart.cupcakeList}">
            topping: ${item.toppingVar} bund: ${item.bottomVar} QUANT: ${item.quantity}
            <br>

        </c:forEach>

        <h2>pris: i kr ${sessionScope.totalPris}</h2>
        <h2>testpris i kr ${sessionScope.testpris}</h2>


    </jsp:body>

</t:pagetemplate>