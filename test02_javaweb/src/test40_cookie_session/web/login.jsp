<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script>
   window.onload=function () {
       var pathName=window.document.location.pathname;
       document.getElementById("img").onclick = function () {
           this.src = "${pageContext.servletContext.contextPath}/example/checkCodeServlet?time=" +<%= System.currentTimeMillis() %>;
       }

   }
</script>
<head>
    <title>登录界面</title>
</head>
<body>

        提示：${msg}
        <form  action="${pageContext.servletContext.contextPath}/example/loginServlet" method="post">
            账号： <input type="text" name="username"><br>
            密码：<input type="password" name="password"><br>
            验证码：<input type="text" name="checkCode"><img id="img" src="${pageContext.servletContext.contextPath}/example/checkCodeServlet"><br>
            <input type="submit" value="提交">
        </form>

</body>
</html>
