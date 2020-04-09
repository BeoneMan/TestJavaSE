
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<html>
<%--1. 算数运算符： + - * /(div) %(mod)--%>
<%--2. 比较运算符： > < >= <= == !=--%>
<%--3. 逻辑运算符： &&(and) ||(or) !(not)--%>
<%--4. 空运算符： empty--%>
<%--* 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0--%>
<%--* ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0--%>
<%--* ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0--%>

<head>
    <title>运算</title>
</head>
<body>
    算数运算符:${1+1}<br>                    <!-- 2 -->
    比较运算符:${1==2}<br>                   <!-- false -->
    逻辑运算符:${1==1&&1>0}<br>              <!-- true -->
    空运算符:${empty requestScope}<br>       <!-- true -->
</body>
</html>
