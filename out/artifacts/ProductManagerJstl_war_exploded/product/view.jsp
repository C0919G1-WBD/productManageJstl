<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2019
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Product Detail</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="wrap-container">
    <h1>Product detail</h1>
    <a href="/product"><button class="button back">Back to product list</button></a><br>
    <table class="form" cellpadding="0" cellspacing="0">
        <tr>
            <td>Name: </td>
            <td><input type="text" name="name" value="${requestScope['product'].getName()}" readonly></td>
        </tr>
        <tr>
            <td>Price: </td>
            <td><input type="number" name="price" value="${requestScope['product'].getPrice()}" readonly></td>
        </tr>
        <tr>
            <td>Description: </td>
            <td><input type="text" name="description" value="${requestScope['product'].getDescription()}" readonly></td>
        </tr>
    </table>
</div>
</body>
</html>
