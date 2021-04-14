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

    <h2>Dear users!</h2>
    <h5>If you have any question about registration, using or any others related to our application - feel free to
        contact us via the form below!</h5>

    <form class="btn_form" method="POST" action="SendEmail">

        <!-- TODO отправка письма на майл админа -->

        <input type="hidden" name="command" value="#"/>
        <fieldset>
            <legend>Enter your message and click "Send" button</legend>

            <c:if test="${message_send == 'MESSAGE_SEND'}">
            <p>
                <span style="color: green; ">Message send</span>
            <p>
                </c:if>
                    <c:if test="${message_email == 'INCORRECT_EMAIL'}">
            <p>
                <span style="color: red; ">Invalid email</span>
            <p>
                </c:if>
            <div class="form-group">
                <label class="control-label" for="textusername">Your Name</label>
                <div>
                    <input id="textusername" name="UserName" class="form-control input-md">
                    <span class="help-block">Enter your message here</span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label" for="textmail">Your Mail</label>
                <div>
                    <input id="textmail" name="UserEmail" class="form-control input-md">
                    <span class="help-block">Enter your message here</span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label" for="textsubject">Message Subject</label>
                <div>
                    <input id="textsubject" name="MailSubject" class="form-control input-md">
                    <span class="help-block">Enter your message here</span>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label" for="textmessage">Message Text</label>
                <div>
                    <textarea id="textmessage" name="MailMessage" class="form-control input-md"></textarea>
                    <span class="help-block">Enter your message here</span>
                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <div>
                    <input type="submit" value="Send message"/>
                </div>
            </div>


        </fieldset>

    </form>

</div>

<div class="col-sm-2 empty-col">

</div>


<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
