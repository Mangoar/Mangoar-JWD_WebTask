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
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="Controller?command=getcards&idaccount=0&balance=0">Cards</a>
                </li>
                <li class="nav-item ">
                    <span>Hello, ${pageContext.findAttribute("login")}</span>
                </li>
            </ul>
        </div>
    </div>
    <!-- Navbar content -->
</nav>

