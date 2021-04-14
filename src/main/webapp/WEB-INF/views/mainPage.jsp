<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.03.2021
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>

<c:choose>
    <c:when test="${id_user_role == '1'}">
        <jsp:include page="common/nav_menu_admin.jsp"></jsp:include>
    </c:when>
    <c:when test="${id_user_role == '2'}">
        <jsp:include page="common/nav_menu_user.jsp"></jsp:include>
    </c:when>
</c:choose>
<div class="container-fluid">

    <div class="row">

        <div class="col-sm-2 empty-col">

        </div>

        <div class="col-sm-8 content-col">
            <form class="btn_form">
                <h2>Welcome!</h2>
                <h4>This is an app that blablablabla. To start work - register first and login to system.
                If you are already registered - go to login page and start working!</h4>
            </form>

        </div>

        <div class="col-sm-2 empty-col">

        </div>
    </div>
</div>


<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
