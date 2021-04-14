<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.03.2021
  Time: 1:46
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

<jsp:include page="common/nav_menu_admin.jsp"></jsp:include>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-2 empty-col">

        </div>

        <div class="col-sm-8 content-col">
            <form class="btn_form" action="Controller" method="post">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Login</th>
                        <th scope="col">Fullname</th>
                        <th scope="col">BD</th>
                        <th scope="col">Email</th>
                        <th scope="col">Blocked</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="n" items="${users}">
                        <form action="Controller" method="post">
                            <tr>
                                <td><c:out value="${n.login}"/></td>
                                <td><c:out value="${n.fullname}"/></td>
                                <td><c:out value="${n.birthdate}"/></td>
                                <td><c:out value="${n.email}"/></td>
                                <td>
                                    <c:if test="${n.blocked == '1'}">
                                        <input type="hidden" name="command" value="unblockuser"/>
                                        <input type="hidden" name="iduser" value="${n.id}"/>
                                        <input type="submit" name="submit" value="UNBAN"/>
                                    </c:if>
                                    <c:if test="${n.blocked != '1'}">
                                        <input type="hidden" name="command" value="blockuser"/>
                                        <input type="hidden" name="iduser" value="${n.id}"/>
                                        <input type="submit" name="submit" value="BAN"/>
                                    </c:if>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>

            </form>

        </div>

        <div class="col-sm-2 empty-col">

        </div>
    </div>
</div>


<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
