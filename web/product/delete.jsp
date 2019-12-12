<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2019
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="wrap-container">
    <h1>Delete product ${requestScope['product'].getName()}</h1>
    <form action="/product?action=delete&id=${requestScope['product'].getId()}" method="post">
        <table class="form" cellspacing="0" cellpadding="0">
            <tr>
                <td><button type="submit" class="button add">Yes</button></td>
                <td><a href="/product"><button type="button" class="button add">No</button></a></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
