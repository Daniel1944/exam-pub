<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 13.01.21
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<div align="center">
    <h1>Command list</h1>
    <p>1) /users
        Vraci vsechny objekty User(id, name, isActive, isAdult, Pocket)
    </p>
    <p>2) /users/{id}
        Vraci User s danym id a jeho objednavky (id, name, isActive, isAdult, Pocket, Order(id, productName, price, isForAdult))
    </p>
    <p>3) /drink-menu
        Vraci napojovy listek, drinky maji tyto atributy (id, productName, price, isForAdult)
    </p>
    <p>4) /buy
        Validace zdali je uživatel plnoletý a zdali má dostatek financí v peněžence(userId, productId, price)
    </p>
    <p>5) /summary/all
        Vraci vsechny objednavky daneho produktu/drinku pro vsechny drinky a jejich celkovy soucet (product, amount, unitPrice, summaryPrice) <br>
          /summary/product
        Vraci vsechny objednavky daneho drinku pro kazdy drink (userId, amount, price)<br>
          /summary/user
        Vraci vsechny objednavky daneho uzivatele pro vsechny uzivatele (sserId, product, price)
    </p>
</div>
</body>
</html>
