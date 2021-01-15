<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 15.01.21
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Summary/Product</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>UserId</th>
        <th>Amount</th>
        <th>Price</th>

    </tr>
    <c:forEach items="${summaryProduct}" var = "sumP" varStatus="status">
        <tr>
            <td>sumP.userId</td>
            <td>sumP.amount</td>
            <td>sumP.price</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
