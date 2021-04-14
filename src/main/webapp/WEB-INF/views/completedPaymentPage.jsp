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

${pageContext.findAttribute("id_user_role")}

<jsp:include page="common/nav_menu_user.jsp"></jsp:include>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-2 empty-col">

        </div>

        <div class="col-sm-8 content-col">
            <form class="btn_form">

                <h2>Congratulations! Your payment is completed!</h2>
                <h4>The payment will appear in your payment list shortly. So you can check it on Payments
                    page, make another payment from the same card or Download the check of this payment.</h4>
            </form>
            <form class="btn_form" action="Controller" method="post">
                <div>
                    <form action="Controller" method="post">
                        <div>
                            <input type="hidden" name="command" value="getpayments"/>
                            <input type="submit" name="submit" value="GO TO PAYMENTS PAGE"/>
                        </div>
                    </form>
                    <form action="${pageContext.request.contextPath}/DownloadServlet" method="post">
                        <div>
                            <input type="hidden" name="report" value="now"/>
                            <input type="submit" name="submit" value="DOWNLOAD PAYMENT CHECK"/>
                        </div>
                    </form>
                </div>
            </form>

        </div>

        <div class="col-sm-2 empty-col">

        </div>
    </div>
</div>


<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
