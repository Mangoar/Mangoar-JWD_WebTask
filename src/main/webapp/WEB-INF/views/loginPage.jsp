<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.03.2021
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-2 empty-col">

        </div>

        <div class="col-sm-8 content-col">
            <form class="btn_form" method="POST" action="Controller">
                <c:if test="${message == 'REGISTER_SUCCESS'}">
                <p>
                    <span style="color: green; ">You successfully registered!</span>
                <p>
                    </c:if>
                <input type="hidden" name="command" value="login" />
                <fieldset>
                    <!-- Form Name -->
                    <legend>Enter your credentials</legend>

                    <c:if test="${message_fail_log_in == 'FAIL_LOG_IN'}">
                    <p>
                        <span style="color: red; ">Invalid log in data or your user is blocked!</span>
                        <span style="color: red; ">If you sure with your log in data - contact admin!</span>
                    <p>
                        </c:if>
                    <div class="form-group">
                        <label class="control-label" for="textinput">Login</label>
                        <div >
                            <input id="textinput" name="UserLogin" type="text" placeholder="User login" class="form-control input-md" required="">
                            <span class="help-block">Enter your login here</span>
                        </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                        <label class="control-label" for="passwordinput">Password</label>
                        <div >
                            <input id="passwordinput" name="UserPassword" type="password" placeholder="User password" class="form-control input-md" required="">
                            <span class="help-block">Enter your password here</span>
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <div>
                            <input type="submit" value="Login"/>
                        </div>
                    </div>

                    <a href="Controller?command=gotoregisterpage">Not registered yet?</a>

                </fieldset>

            </form>
        </div>

        <div class="col-sm-2 empty-col">

        </div>
    </div>
</div>

<jsp:include page="common/footer.jsp"></jsp:include>

</body>
</html>
