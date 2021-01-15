<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form action="valid" method="post" modelAttribute="user">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td>Telephone:</td>
            <td><form:input path="telephone" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
