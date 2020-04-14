package controller;

import service.IUserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {

    private IUserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (parameterMap.size() > 0) {
            String[] uids = parameterMap.get("uid");
            if (uids.length > 0) {
                for (String uid : uids) {
                    service.deleteUserById(Integer.valueOf(uid));
                }
            }
        }
        resp.sendRedirect(req.getContextPath()+"/listServlet");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
