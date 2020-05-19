package controller;

import mapper.LoginDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        LoginDao loginDao=new LoginDao();
        User user = new User ();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        if (loginDao.login(user)!=null) {
            req.setAttribute("user",user);
            req.getRequestDispatcher("/success").forward(req,resp);
        }else {
            req.getRequestDispatcher("/fail").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }


}

//测试案例
class Test{
    public static void main(String[] args) {
        LoginDao loginDao=new LoginDao();
        User user = new User ();
        user.setUsername("lisi");
        user.setPassword("lisi");
        if (loginDao.login(user)!=null) {
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
    }
}
