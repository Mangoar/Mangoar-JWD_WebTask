<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.03.2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fi">
<head>
    <title>Title</title>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'/>
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
            <form class="btn_form" method="post" action="Controller">

                <input type="hidden" name="command" value="registernewuser"/>
                <fieldset>
                    <!-- Form Name -->
                    <legend>Register new user - enter user's credentials:</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="control-label" for="textinput">Login</label>
                        <div>
                            <input id="textinput" name="UserLogin" type="text" placeholder="User login"
                                   class="form-control input-md" required="">
                            <c:if test="${message_login == 'INCORRECT_LOGIN'}">
                            <p>
                                <span style="color: red; ">Invalid login</span>
                            <p>
                                </c:if>
                        </div>

                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                        <label class="control-label" for="passwordinput">Password</label>
                        <div>
                            <input id="passwordinput" name="UserPassword" type="password" placeholder="User password"
                                   class="form-control input-md" required="">
                            <c:if test="${message_password == 'INCORRECT_PASSWORD'}">
                            <p>
                                <span style="color: red; ">Invalid password</span>
                            <p>
                                </c:if>
                        </div>

                    </div>

                    <div class="form-group ">
                        <label class="control-label" for="userphoto">UserPhoto</label>
                        <div>
                            <input type="file"
                                   id="userphoto" name="userphoto"
                                   accept="image/png, image/jpeg">
                            <span class="help-block">Enter your login here</span>
                        </div>
                    </div>

                    <div class="form-group ">
                        <label class="control-label" for="textinput">UserFullname</label>
                        <div>
                            <input name="UserFullname" type="text" placeholder="UserFullname"
                                   class="form-control input-md" required="">
                            <c:if test="${message_fullname == 'INCORRECT_FULLNAME'}">
                            <p>
                                <span style="color: red; ">Invalid fullname</span>
                            <p>
                                </c:if>
                        </div>

                    </div>

                    <div class="form-group">
                        <label class="control-label" for="textinput">UserBirthdate</label>
                        <div>
                            <input name="UserBirthdate" type="date" placeholder="UserBirthdate"
                                   class="form-control input-md" required="">
                            <c:if test="${message_birthdate == 'INCORRECT_BIRTHDATE'}">
                            <p>
                                <span style="color: red; ">Invalid birthdate</span>
                            <p>
                                </c:if>
                        </div>

                    </div>

                    <div class="form-group">
                        <label class="control-label" for="textinput">UserPassport</label>
                        <div>
                            <input name="UserPassport" type="text" placeholder="UserPassport"
                                   class="form-control input-md" required="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="textinput">UserEmail</label>
                        <div>
                            <input name="UserEmail" type="text" placeholder="UserEmail" class="form-control input-md"
                                   required="">
                            <c:if test="${message_email == 'INCORRECT_EMAIL'}">
                            <p>
                                <span style="color: red; ">Invalid email</span>
                            <p>
                                </c:if>
                        </div>

                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <div>
                            <input type="submit" value="Register"/>
                        </div>
                    </div>

                    <p style="color:red;">Fields marked with * must be filled!</p>
                    <a href="Controller?command=gotologinpage">Log in</a>
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
