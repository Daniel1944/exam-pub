<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 15.01.21
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
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
    <c:forEach items="${users}" var = "usersList">
    <tr>
        <td>usersList.index</td>
        <td>usersList.name</td>
        <td>usersList.isActive</td>
        <td>usersList.isAdult</td>
        <td>usersList.money</td>

    </tr>
    </c:forEach>
</table>
</body>
</html>
