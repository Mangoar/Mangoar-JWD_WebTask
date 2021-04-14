<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.03.2021
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style>
    <%@include file="/WEB-INF/css/parts-css/footer.css" %>
</style>
<div class="footer-dark">
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-3 item">
                    <h3>About</h3>
                    <ul>
                        <li><a href="Controller?command=gotoaboutpage">Information</a></li>
                        <li><a href="Controller?command=gotocontactspage">Contacts</a></li>
                    </ul>
                </div>
                <div class="col-sm-6 col-md-3 item">
                    <div class="col item social">
                        <a href="https://www.facebook.com/mangoar"><i class="fa fa-facebook"></i></a>
                        <a href="javascript:void(0);" onclick="alert('Skype: arteman1996');"><i class="fa fa-skype"></i></a>
                        <a href="https://www.linkedin.com/in/artsiom-homan-a13040174/"><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
                <div class="col-md-6 item text">
                    <h3>WebAppPayments</h3>
                    <p>WebAppPayments - is a web application, that provides possibility to make easy payments for our
                        clients and make it comfortable.</p>
                </div>

            </div>
            <p class="copyright">WebAppPayments © 2021</p>
        </div>
    </footer>
</div>
