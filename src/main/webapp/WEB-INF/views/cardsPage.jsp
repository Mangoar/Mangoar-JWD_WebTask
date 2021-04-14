<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.03.2021
  Time: 1:45
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
            <c:if test="${id_user_role == '2'}">
                <ul class="nav nav-pills">
                    <li class="active"><a data-toggle="pill" href="#tab1">Your cards</a></li>
                    <li><a data-toggle="pill" href="#tab2">Register new card</a></li>
                </ul>

                <div class="tab-content">
                    <div id="tab1" class="tab-pane fade in active">
                        <form class="btn_form">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th scope="col">Card Number</th>
                                    <th scope="col">CVV Code</th>
                                    <th scope="col">Valid Date</th>
                                    <th scope="col">Payment</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="n" items="${cards}">
                                    <form action="Controller" method="post">
                                        <tr>
                                            <td><c:out value="${n.number}"/></td>
                                            <td><c:out value="${n.cvv_code}"/></td>
                                            <td><c:out value="${n.valid_date}"/></td>
                                            <td>
                                                <input type="hidden" name="command" value="gotonewpaymentpage"/>
                                                <input type="hidden" name="idaccount" value="${id_account}"/>
                                                <input type="hidden" name="balancecard" value="${balance}"/>
                                                <input type="hidden" name="idcard" value="${n.id}"/>
                                                <input type="hidden" name="numbercard" value="${n.number}"/>
                                                <input type="submit" name="submit" value="MAKE NEW PAYMENT"/>
                                            </td>
                                        </tr>
                                    </form>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                    <div id="tab2" class="tab-pane fade">
                        <form class="btn_form" action="Controller" method="post">
                            <h2>Register new card</h2>
                            <h4>Here you can register new card for chosen account
                            </h4>
                            <div>
                                <input type="hidden" name="command" value="addnewcard"/>
                                <input type="hidden" name="balance" value="${balance}"/>
                                <input type="hidden" name="idaccount" value="${id_account}"/>
                                <input type="submit" name="submit" value="REGISTER NEW CARD"/>
                            </div>
                        </form>
                    </div>
                </div>
            </c:if>


            <c:if test="${id_user_role == '1'}">
                <form class="btn_form">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Account ID</th>
                            <th scope="col">Card Number</th>
                            <th scope="col">Valid Date</th>
                            <th scope="col">Extended Date</th>
                            <th scope="col">Save Data</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="n" items="${cards}">
                        <form action="Controller" method="post">
                            <tr>
                                <td><c:out value="${n.id_account}"/></td>
                                <td><c:out value="${n.number}"/></td>
                                <td><c:out value="${n.valid_date}"/></td>
                                <td>
                                    <input type="date" name="new_valid_date" value=""/>
                                </td>
                                <td>
                                    <input type="hidden" name="command" value="extendcardvaliddate"/>
                                    <input type="hidden" name="idcard" value="${n.id}"/>
                                    <input type="submit" name="submit" value="SAVE"/>
                                </td>
                            </tr>
                        </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
            </c:if>


        </div>

        <div class="col-sm-2 empty-col">

        </div>
    </div>
</div>


<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
