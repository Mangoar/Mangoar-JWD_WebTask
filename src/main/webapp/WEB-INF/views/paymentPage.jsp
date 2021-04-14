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
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/MyDateTag.tld" %>
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

${pageContext.findAttribute("id_user_role")}

<jsp:include page="common/nav_menu_user.jsp"></jsp:include>

<div class="container-fluid">

    <div class="row">

        <div class="col-sm-2 empty-col">

        </div>

        <div class="col-sm-8 content-col">
            <tag:MyDateTag/>


            <ul class="nav nav-pills">
                <li class="active"><a data-toggle="pill" href="#tab1">Last payments</a></li>
                <li><a data-toggle="pill" href="#tab2">Payment reports</a></li>
            </ul>

            <div class="tab-content">
                <div id="tab1" class="tab-pane fade in active">
                    <form class="btn_form">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th scope="col">Payment date</th>
                                <th scope="col">Payment type</th>
                                <th scope="col">Sum</th>
                                <th scope="col">Destination</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="n" items="${payments}">
                                <tr>
                                    <td><c:out value="${n.payment_date}"/></td>
                                    <td><c:out value="${n.id_type}"/></td>
                                    <td><c:out value="${n.sum}"/></td>
                                    <td><c:out value="${n.destination}"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
                <div id="tab2" class="tab-pane fade">
                    <form class="btn_form">
                        <div>
                            <h2>Payment reports</h2>
                            <h4>Here you can generate payment report
                                (one of three types - for alltime, for current month, for current week).
                                Click one of buttons below.
                            </h4>
                            <form action="${pageContext.request.contextPath}/DownloadServlet" method="post">
                                <div>
                                    <input type="hidden" name="report" value="week"/>
                                    <input type="submit" name="submit" value="CURRENT WEEK PAYMENTS REPORT"/>
                                </div>
                            </form>
                            <form action="${pageContext.request.contextPath}/DownloadServlet" method="post">
                                <div>
                                    <input type="hidden" name="report" value="month"/>
                                    <input type="submit" name="submit" value="CURRENT MONTH PAYMENTS REPORT"/>
                                </div>
                            </form>
                            <form action="${pageContext.request.contextPath}/DownloadServlet" method="post">
                                <div>
                                    <input type="hidden" name="report" value="year"/>
                                    <input type="submit" name="submit" value="CURRENT YEAR PAYMENTS REPORT"/>
                                </div>
                            </form>
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
