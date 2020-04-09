<%--* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面--%>
<%--* isErrorPage：标识当前也是是否是错误页面。--%>
<%--* true：是，可以使用内置对象exception--%>
<%--* false：否。默认值。不可以使用内置对象exception--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="jsp02.jsp" %>
<%--include	： 页面包含的。导入页面的资源文件--%>
<%--* <%@include file="top.jsp"%>--%>
<%@include file="jsp03.jsp"%>

<%--taglib	： 导入资源--%>
<%--* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--* prefix：前缀，自定义的--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% int i =1/0; %>
</body>
</html>
