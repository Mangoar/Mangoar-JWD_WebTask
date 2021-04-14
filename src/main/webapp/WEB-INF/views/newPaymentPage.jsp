<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.04.2021
  Time: 14:19
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
                    <li class="active"><a data-toggle="pill" href="#tab1">New payment</a></li>
                    <li><a data-toggle="pill" href="#tab2">New refill</a></li>
                </ul>

                <div class="tab-content">
                    <div id="tab1" class="tab-pane fade in active">
                        <form class="btn_form" method="POST" action="Controller">

                            <input type="hidden" name="command" value="addnewpayment" />
                            <fieldset>
                                <p style="color: red;">${errorString}</p>
                                <!-- Form Name -->
                                <legend>Enter payments data:</legend>

                                <!-- Text input-->
                                <div class="form-group">
                                    <label class="control-label" for="outcomecard">From what card</label>
                                    <div>
                                        <input type="hidden" name="id_payment_type" value="2"/>
                                        <input type="hidden" name="id_account" value="${id_account}"/>
                                        <input type="hidden" name="id_card" value="${id_card}"/>
                                        <input id="outcomecard" name="OutcomeCard" type="text" value="${number_card}" class="form-control input-md" disabled>
                                        <span class="help-block">Number of your card</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="currentbalance">Current balance</label>
                                    <div >
                                        <input id="currentbalance" name="CurrentBalance" type="text" value="${balance_card}" class="form-control input-md" disabled>
                                        <span class="help-block">Current balance of your card</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="paymentvalue">Payment value</label>
                                    <div >
                                        <input id="paymentvalue" name="PaymentValue" type="text" placeholder="Payment value" class="form-control input-md" >
                                        <span class="help-block">Value of payment</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="destination">Destination</label>
                                    <div >
                                        <input id="destination" name="Destination" type="text" placeholder="Destination" class="form-control input-md" >
                                        <span class="help-block">Number of your card</span>
                                    </div>
                                </div>

                                <!-- Button -->
                                <div class="form-group">
                                    <div>
                                        <input type="submit" value="Proceed payment"/>
                                    </div>
                                </div>

                            </fieldset>

                        </form>
                    </div>
                    <div id="tab2" class="tab-pane fade">
                        <form class="btn_form" method="POST" action="Controller">

                            <input type="hidden" name="command" value="addnewpayment" />
                            <fieldset>
                                <p style="color: red;">${errorString}</p>
                                <!-- Form Name -->
                                <legend>Enter transfer's data</legend>

                                <div class="form-group">
                                    <label class="control-label" for="incomecard">From what card</label>
                                    <div >
                                        <input type="hidden" name="id_payment_type" value="1"/>
                                        <input type="hidden" name="id_account" value="${id_account}"/>
                                        <input type="hidden" name="id_card" value="${id_card}"/>
                                        <input type="hidden" name="CurrentBalance" value="${balance_card}"/>
                                        <input type="hidden" name="Destination" value="income"/>
                                        <input id="incomecard" name="IncomeCard" type="text" value="${number_card}" class="form-control input-md" disabled>
                                        <span class="help-block">Number of your card</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="incomevalue">Payment value</label>
                                    <div >
                                        <input id="incomevalue" name="PaymentValue" type="text" placeholder="Payment value" class="form-control input-md" >
                                        <span class="help-block">Value of payment</span>
                                    </div>
                                </div>

                                <!-- Button -->
                                <div class="form-group">
                                    <div>
                                        <input type="submit" value="Proceed transfer"/>
                                    </div>
                                </div>

                            </fieldset>

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
