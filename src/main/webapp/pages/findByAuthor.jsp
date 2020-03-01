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
<div id="findByAuthor" align="center">
    <br>
    <form id="findExByAuthor" method="get" action="">
        <label>Enter the author: </label>
        <input type="text" name="authorName" required placeholder="Author name"/>
        <input type="text" name="authorSurname" required placeholder="Author surname">
        <input type="submit" class="btn btn-dark" value="Find"/>
    </form>
    <br>
</div>
<c:if test="${not empty name and not empty surname}">
<div class="card border-dark mb-3 pb-3" style="max-width: 20rem; margin: 15px auto auto;">
    <div class="card-header">Exhibits by Author - ${name} ${surname}</div>
    <div class="card-body text-dark">
        <p class="card-text">
            <c:if test="${empty exhibitList && name != null && surname != null}">
        <p style="color: red;">No exhibits by author - ${name} ${surname}</p>
        </c:if>
        <c:if test="${not empty exhibitList}">
            <ul>
                <c:forEach var="exhibit" items="${exhibitList}">
                    <li>
                        <c:out value="${exhibit.name}"/>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
        </p>
    </div>
</div>
</c:if>
<div id="footer">
    <jsp:include page="../parts/footer.jsp"/>
</div>
</body>
</html>
