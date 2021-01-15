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
    <title>Summary/User</title>
</head>
<body>
<table border="1" cellpadding="5">
    <tr>
        <th>UserId</th>
        <th>Product</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${summaryUser}" var = "sumU">
        <tr>
            <td>sumU.userId</td>
            <td>sumU.product</td>
            <td>sumU.price</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
