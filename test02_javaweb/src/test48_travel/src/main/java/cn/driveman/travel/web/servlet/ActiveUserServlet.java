package cn.driveman.travel.web.servlet;

import cn.driveman.travel.service.IUserService;
import cn.driveman.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        String code = request.getParameter("code");
        Boolean flag = userService.activeUser(code);
        String msg;
        if(flag){
            msg = "激活成功，请<a href='login.html'>登录</a>";
        }else{
            msg = "激活失败，请联系管理员";
        }
        response.getWriter().write(msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
