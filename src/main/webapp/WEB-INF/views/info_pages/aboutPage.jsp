<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.04.2021
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<c:choose>
    <c:when test="${id_user_role == '1'}">
        <jsp:include page="../common/nav_menu_admin.jsp"></jsp:include>
    </c:when>
    <c:when test="${id_user_role == '2'}">
        <jsp:include page="../common/nav_menu_user.jsp"></jsp:include>
    </c:when>
</c:choose>

<div class="col-sm-2 empty-col">

</div>

<div class="col-sm-8 content-col">
    <form class="btn_form">
        <h2>About page</h2>
        <h4>Let me speak from my heart about this awesome application. It's blablabla and blablabla. Bla blabla
            blablabla.
            Go blablabla yourself and go on normal pages!</h4>
    </form>
</div>

<div class="col-sm-2 empty-col">

</div>


<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>