<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2019
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Search product</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="wrap-container">
        <h1>Search product</h1>
        <a href="/product"><button class="button back">Back to product list</button></a><br>
        <form action="/product?action=search&id=${requestScope['product'].getId()}" method="post">
            <table class="form" cellpadding="0" cellspacing="0">
                <tr>
                    <td><input type="text" name="name" placeholder="Enter product name"></td>
                    <td><button type="submit" class="button search">Search</button></td>
                </tr>
            </table>
        </form>
        <c:if test="${requestScope['message']!=null}">
            <span class="message success">${requestScope['message']}</span><br>
        </c:if>
    </div>
</body>
</html>
