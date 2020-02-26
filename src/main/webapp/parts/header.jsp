<%--
  Created by IntelliJ IDEA.
  User: 38067
  Date: 26.02.2020
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/find.jsp">Find<span class="sr-only">Find</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                       aria-haspopup="true" aria-expanded="false">Statistic</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">Exhibits</a>
                        <a class="dropdown-item" href="#">Excursion</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <div class="btn-group dropright">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">
                                Exhibits
                            </button>
                            <div class="dropdown-menu">
                                <a class="nav-link" href="${pageContext.request.contextPath}/stat">By Technique<span
                                        class="sr-only">Technique</span></a>
                                <a class="nav-link" href="#">By Material<span class="sr-only">Material</span></a>
                            </div>
                        </div>
                        <a class="dropdown-item" href="#">By</a>
                        <a class="dropdown-item" href="#">By Material</a>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Find</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Excursion</a>
                </li>
            </ul>
            <span class="navbar-text">Test</span>
        </div>
    </nav>
</header>
