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

<jsp:include page="common/nav_menu_user.jsp"></jsp:include>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-2 empty-col">

        </div>

        <div class="col-sm-8 content-col">
            <ul class="nav nav-pills">
                <li class="active"><a data-toggle="pill" href="#tab1">Your accounts</a></li>
                <li><a data-toggle="pill" href="#tab2">Register new account</a></li>
            </ul>

            <div class="tab-content">
                <div id="tab1" class="tab-pane fade in active">
                    <form class="btn_form">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Acc_number</th>
                                <th scope="col">Balance</th>
                                <th scope="col">Id_currency</th>
                                <th scope="col">GoToCards</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="n" items="${accounts}">
                                <form action="Controller" method="post">
                                    <tr>
                                        <td><c:out value="${n.id}"/></td>
                                        <td><c:out value="${n.acc_number}"/></td>
                                        <td><c:out value="${n.balance}"/></td>
                                        <td><c:out value="${n.id_currency}"/></td>
                                        <td>
                                            <input type="hidden" name="command" value="getcards"/>
                                            <input type="hidden" name="balance" value="${n.balance}"/>
                                            <input type="hidden" name="idaccount" value="${n.id}"/>
                                            <input type="submit" name="submit" value="CHOOSE CARD"/>
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
                        <h2>Create new account</h2>
                        <h4>Here you can create new account of chosen currency!</h4>
                        ${n.id_user}

                        <div class="form-group">
                            <label class="control-label" for="textinput">Currency</label>
                            <div >
                                <select id="textinput" name="IdCurrency">
                                    <option value="1">BYN</option>
                                    <option value="2">USD</option>
                                    <option value="3">EUR</option>
                                </select>
                                <span class="help-block">Choose your new account's currency here</span>
                            </div>
                        </div>

                        <div>
                            <input type="hidden" name="command" value="addnewaccount"/>
                            <input type="submit" name="submit" value="REGISTER NEW ACCOUNT"/>
                        </div>
                    </form>
                </div>
            </div>

        </div>

        <div class="col-sm-2 empty-col">

        </div>
    </div>
</div>


<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
