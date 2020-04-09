
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<html>
<head>
    <title>域中获取值</title>
</head>
<body>
    从reques域中获取：${requestScope.name};<br>
    从reques域中获取：${requestScope.get("name")};<br>
    从最小域中获取：${name};<br>
    从session域中获取：${sessionScope.name};<br>
    从servletContext域中获取：${applicationScope.name};<br>
    从servletContext域中获取：${pageContext.servletContext.getAttribute("name")};<br>
<%--    List集合：${域名称.键名[索引]}--%>
    从reques域中获取：${userList[1].name};<br>
<%--    Map集合：--%>
<%--    * ${域名称.键名.key名称}--%>
<%--    * ${域名称.键名["key名称"]}--%>
    从reques域中获取：${map.user2.name};<br>

    动态获取虚拟目录:${pageContext.request.contextPath}
</body>
</html>
