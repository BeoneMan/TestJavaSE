package controller;

import entity.PageBean;
import entity.User;
import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@WebServlet("/findByUserPageServlet")
public class FindByUserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Map<String, String[]> parameterMap = req.getParameterMap();
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");

        if(currentPage==null||"".equals(currentPage)){
            currentPage="1";

        }
        if(rows==null||"".equals(rows)){
            rows="2";
        }
        IUserService service = new UserServiceImpl();
        PageBean<User> pb =service.findByUserPage(currentPage,rows,parameterMap);
        req.setAttribute("pb",pb);
        req.setAttribute("parameterMap",parameterMap);//将查询条件存入request域中
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
