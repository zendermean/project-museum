<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find Exhibits by Worker</title>
    <jsp:include page="../parts/head.jsp"/>
</head>
<div id="header">
    <jsp:include page="../parts/header.jsp"/>
</div>
<body>
<div align="center">
    <br>
    <form id="findByWorkerName" method="get" action="">
        <label>Worker name</label>
        <input type="text" name="workerName" required placeholder="Worker name"/>
        <input type="submit" value="Find"/>
    </form>
    <br>
</div>
<div class="card border-dark mb-3 pb-3" style="max-width: 20rem; margin: 15px auto auto;">
    <div class="card-header">Exhibits by worker name - ${name}</div>
    <div class="card-body text-dark">
        <p class="card-text">
            <c:if test="${not empty exhibitList}">
        <ul>
            <c:forEach var="exhibit" items="${exhibitList}">
                <li>
                    <c:out value="${exhibit.name}"/>
                </li>
            </c:forEach>
        </ul>
        </c:if>
        <c:if test="${empty exhibitList && name != null}">
            <p style="color: red;">No exhibits by worker name - ${name}</p>
        </c:if>
        </p>
    </div>
</div>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>