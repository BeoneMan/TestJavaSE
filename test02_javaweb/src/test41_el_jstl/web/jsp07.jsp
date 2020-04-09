
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>
    <c:if test="${empty userList}" >
        userList为空
    </c:if>
    <c:if test="${not empty userList}" >
        <c:forEach items="${userList}"  var="user"  step="1" varStatus="s">
           ${s.index} : ${user.name}<br>
        </c:forEach>
    </c:if>
    <% int money=100; %>
<c:choose>
    <c:when test="${pageScope.money<0}">
        太惨了
    </c:when>
    <c:when test="${pageScope.money>100}">
        真富有
    </c:when>
    <c:otherwise>
        太难了
    </c:otherwise>
</c:choose>
</body>
</html>
