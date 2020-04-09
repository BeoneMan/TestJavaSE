package example.controller;

import example.entity.User;
import example.service.IUserService;
import example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {

    private IUserService service = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        service.addUser(new User(name,sex,Integer.parseInt(age),address,qq,email));
        req.getRequestDispatcher("/listServlet").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
