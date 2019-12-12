<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2019
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Product list</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="wrap-container">
        <h1>Product list</h1>
        <p>
            <a href="/product?action=add"><button class="button add">Create new product</button></a>
            <a href="/product?action=search"><button class="button add">Find your product</button></a>
        </p>
        <table class="productList" cellspacing="0" cellpadding="0">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${requestScope['products']}" var="product">
                <tr>
                    <td>${product.getId()}</td>
                    <td><a href="/product?action=view&id=${product.getId()}">${product.getName()}</a></td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getDescription()}</td>
                    <td><a href="/product?action=edit&id=${product.getId()}"><button class="button edit">Edit</button></a></td>
                    <td><a href="/product?action=delete&id=${product.getId()}"><button class="button delete">Delete</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
