<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>UserById</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>IsActive</th>
        <th>IsAdult</th>
        <th>Pocket</th>
    </tr>
    <c:forEach items="${user}" var="user" >
    <tr>
        <td>user.id</td>
        <td>user.name</td>
        <td>user.isActive</td>
        <td>user.isAdult</td>
        <td>user.money</td>

    </tr>
</table>
<table border="1" cellpadding="5">
    <tr>
        <th>Id</th>
        <th>ProductName</th>
        <th>Amount</th>
        <th>Price</th>
    </tr>
    </c:forEach>
    <c:forEach items="${orders}" var="user" >
        <tr>
            <td>user.id</td>
            <td>user.productName</td>
            <td>user.amount</td>
            <td>user.price</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
