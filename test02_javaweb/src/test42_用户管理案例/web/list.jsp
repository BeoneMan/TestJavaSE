<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload=function () {
            document.getElementById("delSelected").onclick=function () {
                if(confirm("确定要删除此信息吗?")){
                    var flag= false;
                    var elementsByName = document.getElementsByName("uid");
                    for (var i =0;i<elementsByName.length;i++){
                        if(elementsByName[i].checked){
                            flag=true;
                            break;
                        }
                    }
                    if(flag){
                          document.getElementById("form").submit();
                    }
                }
            }

            var selectAll = document.getElementById("selectAll");
            selectAll.onclick=function () {
                var uid = document.getElementsByName("uid");
                if(selectAll.checked){
                    for (var i =0;i<uid.length;i++){
                        uid[i].checked=true;
                    }
                }else{
                    for (var i =0;i<uid.length;i++){
                        uid[i].checked=false;
                    }
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">${user.name}用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/findByUserPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="name" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3" name="address">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" id="exampleInputEmail2"  name="email">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="selectAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

        <c:forEach items="${pb.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox"  name="uid" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/selectUpdateByIdServlet?id=${user.id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/deleteServlet?id=${user.id}">删除</a></td>
            </tr>

        </c:forEach>


        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage==1}" >
                    <li>
                        <a href="${pageContext.request.contextPath}/findByUserPageServlet?currentPage=${1}&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}" aria-label="Previous">
                            <span aria-hidden="true" >&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage!=1}" >
                    <li>
                        <a href="${pageContext.request.contextPath}/findByUserPageServlet?currentPage=${pb.currentPage-1}&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>


                <c:forEach begin="1" end="${pb.totalPage}" var="i" >


                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findByUserPageServlet?currentPage=${i}&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findByUserPageServlet?currentPage=${i}&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>
                <c:if test="${pb.currentPage==pb.totalPage}" >
                    <li>
                        <a href="${pageContext.request.contextPath}/findByUserPageServlet?currentPage=${pb.totalPage}&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage!=pb.totalPage}" >
                    <li>
                        <a href="${pageContext.request.contextPath}/findByUserPageServlet?currentPage=${pb.currentPage+1}&name=${parameterMap.name[0]}&address=${parameterMap.address[0]}&email=${parameterMap.email[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>


                <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>

            </ul>
        </nav>


    </div>


</div>


</body>
</html>
