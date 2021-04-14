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

${pageContext.findAttribute("user")}

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

                <input type="hidden" name="command" value="updateuserinfo" />
                <fieldset>
                    <p style="color: red;">${errorString}</p>
                    <!-- Form Name -->
                    <legend>User info:</legend>

                    <input type="file"
                           id="avatar" name="avatar"
                           accept="image/png, image/jpeg">
                    <!-- Password input-->
                    <div class="form-group">
                        <label class="control-label" for="passwordinput">Password</label>
                        <div>
                            <input id="passwordinput" name="NewUserPassword" type="text" value="${user.password}" class="form-control input-md" required="" value="${user.password}">
                            <c:if test="${message_password == 'INCORRECT_PASSWORD'}">
                            <p>
                                <span style="color: red; ">Invalid password</span>
                            <p>
                                </c:if>
                        </div>
                    </div>

                    <div class="form-group ">
                        <label class="control-label" for="fullnameinput">UserFullname</label>
                        <div >
                            <input id="fullnameinput" name="NewUserFullname" type="text" value="${user.fullname}" class="form-control input-md" required="" value="${user.fullname}">
                            <c:if test="${message_fullname == 'INCORRECT_FULLNAME'}">
                            <p>
                                <span style="color: red; ">Invalid fullname</span>
                            <p>
                                </c:if>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="userpassportinput">UserPassport</label>
                        <div >
                            <input id="userpassportinput" name="NewUserPassport" type="text" value="${user.passport}" class="form-control input-md" required="" value="${user.passport}">
                            <span class="help-block">Enter your passport here</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="useremailinput">UserEmail</label>
                        <div >
                            <input id="useremailinput" name="NewUserEmail" type="text" value="${user.email}" class="form-control input-md" required="" value="${user.email}">
                            <c:if test="${message_email == 'INCORRECT_EMAIL'}">
                            <p>
                                <span style="color: red; ">Invalid email</span>
                            <p>
                                </c:if>
                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <div >
                            <input type="submit" value="Udpate data"/>
                            <%--                    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Sign in</button>--%>
                        </div>
                    </div>

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