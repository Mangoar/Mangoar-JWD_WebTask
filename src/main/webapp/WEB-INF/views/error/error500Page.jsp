<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.04.2021
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>

<% response.setStatus(500); %>
<html>
<head>
    <title>Title</title>

    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<div class="col-sm-2 empty-col">
    navigation column
</div>

<div class="col-sm-8 content-col">
    <button onclick="history.back()">Back to Previous Page</button>

    </br>

    <h3>Error 500 occurred - your request came with mistake, try later or contact administrator!</h3>
</div>

<div class="col-sm-2 empty-col">
    navigation column
</div>


<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
