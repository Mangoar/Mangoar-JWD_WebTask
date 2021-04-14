<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.04.2021
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar w/ text</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="Controller?command=getprofileinfo">My profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Controller?command=getpayments">My payments</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Controller?command=getaccounts">My accounts</a>
            </li>

            <li class="nav-item active">
                <span>Hello, ${pageContext.findAttribute("login")}</span>
                <a href="Controller?command=logout">Log Out</a>
            </li>
        </ul>
        <span class="navbar-text">
      Navbar text with an inline element
    </span>
    </div>
</nav>
