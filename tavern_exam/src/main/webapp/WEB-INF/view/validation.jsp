<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 15.01.21
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation to buy </title>
</head>
<body>
<form:form method="post" modelAttribute="validationAttribute" action="valid">
    <table>
        <tr>
            <td>UserId:</td>
            <td><form:input path="UserId" /></td>
        </tr>
        <tr>
            <td>DrinkId:</td>
            <td><form:input path="DrinkId" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
<table border="1" cellpadding="5">
    <tr>
        <th>UserId</th>
        <th>ProductId</th>
        <th>Price</th>
        <th>Validation</th>
    </tr>
    <c:forEach items="${valid}" var = "validation">
        <tr>
            <td>validation.userId</td>
            <td>validation.drinkId</td>
            <td>validation.price</td>
            <td>validation.canOrder</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
