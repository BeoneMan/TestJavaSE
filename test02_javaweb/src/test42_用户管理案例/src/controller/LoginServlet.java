package controller;

import entity.User;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService service=new UserServiceImpl();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String userName = req.getParameter("user");
        String password = req.getParameter("password");
        String verifycode = req.getParameter("verifycode");
        if(userName==null||userName.length()==0||password==null||password.length()==0||verifycode==null||verifycode.length()==0){
            req.setAttribute("msg","用户名或密码或验证码不能为空！！！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        //转换成统一小写
        String newCheckCode = verifycode.toLowerCase();

        //获取session中验证码
        String checkcodeServer = String.valueOf(req.getSession().getAttribute("CHECKCODE_SERVER"));
        if(verifycode .equals(checkcodeServer)){
            User user = service.findUserByName(userName);
            if(user!=null&&user.getPassword().equals(password)){
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                String jSessionId = session.getId();
                Cookie cookie = new Cookie("JSESSIONID",jSessionId);
                cookie.setMaxAge(60*60*24);
                resp.addCookie(cookie);
                resp.sendRedirect(req.getContextPath()+"/listServlet");
            }else {
                req.setAttribute("msg","用户名或者密码错误！！！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("msg","验证码错误！！！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
