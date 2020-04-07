package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/example/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        String newCheckCode = checkCode.toLowerCase();
        //session域中的checkCode
        String realCheckCode = String.valueOf(req.getSession().getAttribute("checkCode"));
        if(realCheckCode.equals(newCheckCode)){
            if(("张三".equals(username))&&("driven".equals(password))){
                req.setAttribute("user",username);
                req.getRequestDispatcher("/success.jsp").forward(req,resp);
            }else{
                req.setAttribute("msg","用户名或者密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("msg","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
