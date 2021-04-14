<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.04.2021
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Admin menu</a>
        <div id="navbarColor02" class="collapse navbar-collapse">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="Controller?command=getprofileinfo">My profile</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" aria-current="page" href="Controller?command=getusers">Users</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" aria-current="page" href="Controller?command=getcards">Cards</a>--%>
<%--                </li>--%>
                <li class="nav-item ">
                    <span>Hello, ${pageContext.findAttribute("login")}</span>
                    <a href="Controller?command=logout">Log Out</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- Navbar content -->
</nav>

<%--<nav class="navbar navbar-expand-lg navbar-light bg-light">--%>
<%--    <a class="navbar-brand" href="#">Navbar w/ text</a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--        <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>
<%--    <div class="collapse navbar-collapse" id="navbarText">--%>
<%--        <ul class="navbar-nav mr-auto">--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link" href="Controller?command=gotouserspage">Users<span class="sr-only">(current)</span></a>--%>
<%--            </li>--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link" href="Controller?command=gotoaccountpage">Accounts<span class="sr-only">(current)</span></a>--%>
<%--            </li>--%>

<%--            <li class="nav-item active">--%>
<%--                <span>Hello, ${pageContext.findAttribute("login")}</span>--%>
<%--                <a href="Controller?command=logout">Log Out</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--        <span class="navbar-text">--%>
<%--      Navbar text with an inline element--%>
<%--    </span>--%>
<%--    </div>--%>
<%--</nav>--%>
