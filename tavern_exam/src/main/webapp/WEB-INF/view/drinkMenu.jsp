<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 15.01.21
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drink-menu</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>Id</th>
        <th>ProductName</th>
        <th>Price</th>
        <th>IsForAdult</th>
    </tr>
    <c:forEach items="${drinkMenu}" var = "drinkL">
        <tr>
            <td>drinkL.id</td>
            <td>drinkL.productName</td>
            <td>drinkL.price</td>
            <td>drinkL.isForAdult</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
