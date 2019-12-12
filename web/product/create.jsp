<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2019
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Create product</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="wrap-container">
        <h1>Create new product</h1>
        <a href="/product"><button class="button back">Back to product list</button></a><br>
        <c:if test="${requestScope['message']!=null}">
            <span class="message success">${requestScope['message']}</span><br>
        </c:if>
        <form action="/product?action=add" method="post">
            <table class="form" cellpadding="0" cellspacing="0">
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" placeholder="Enter product name"></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="number" name="price" placeholder="Enter product price"></td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td><input type="text" name="description" placeholder="Enter product description"></td>
                </tr>
            </table>
            <input type="submit" class="button add" value="Create product">
        </form>
    </div>
</body>
</html>
