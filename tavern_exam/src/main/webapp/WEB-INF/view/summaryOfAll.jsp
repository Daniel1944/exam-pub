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
    <title>Summary/All</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>Product</th>
        <th>Amount</th>
        <th>UnitPrice</th>
        <th>SummaryPrice</th>
    </tr>
    <c:forEach items="${summaryAll}" var = "sumA">
        <tr>
            <td>sumA.productName</td>
            <td>sumA.summaryAmount</td>
            <td>sumA.price</td>
            <td>sumA.summaryPrice</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
