<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.03.2021
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style><%@include file="/WEB-INF/css/parts-css/header.css"%></style>
<div class="header">
    <a href="Controller?command=gotomainpage" class="logo">WebAppPayments</a>
    <div class="header-right">
        <a href="Controller?command=gotomainpage">Home</a>
        <a href="Controller?command=gotocontactspage">Contact</a>
        <a href="Controller?command=gotoaboutpage">About</a>
        <c:if test="${id_user_role == null}">
        <a href="Controller?command=gotologinpage">Log In / Registration</a>
        </c:if>
        <c:if test="${id_user_role == '1'}">
            <a href="Controller?command=logout">Log Out</a>
        </c:if>
        <c:if test="${id_user_role == '2'}">
            <a href="Controller?command=logout">Log Out</a>
        </c:if>
    </div>
</div>