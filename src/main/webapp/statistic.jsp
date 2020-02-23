<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Museum</title>
    </head>

    <body>
        <h2>Statistic by Technique</h2>
            <pre>Count of Exhibit  |  Name of Technique</pre>
        <c:forEach items="${list}" var="item">
            <pre>        ${item[0]}              ${item[1]}</pre>
        </c:forEach>
    </body>
</html>