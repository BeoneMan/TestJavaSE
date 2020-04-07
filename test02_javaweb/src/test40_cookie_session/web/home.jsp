<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/1
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>改造cookie案例</title>
</head>
<body>
    <%
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Boolean flag = false;
        if (cookies.length > 0 && cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastime".equals(name)) {
                    flag = true;
                    cookie.setValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")));
                    cookie.setMaxAge(60 * 60 * 12);
                    response.addCookie(cookie);
                    response.getWriter().write("欢迎回来，你上次登录的时间为" + cookie.getValue());
                    break;
                }
            }
        }
        //证明首次登录
        if (cookies.length == 0 || cookies == null || flag == false) {
            Cookie lastimeCookie = new Cookie("lastime",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss")));
            lastimeCookie.setMaxAge(60 * 60 * 12);
            response.addCookie(lastimeCookie);
            response.getWriter().write("您好，欢迎您首次访问");
        }
    %>
</body>
</html>
