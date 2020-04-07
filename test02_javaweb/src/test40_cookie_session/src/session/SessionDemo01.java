package session;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 1. 当客户端关闭后，服务器不关闭，两次获取session是否为同一个？
 * 		* 默认情况下。不是。
 * 		* 如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
 * 			 Cookie c = new Cookie("JSESSIONID",session.getId());
 * 	         c.setMaxAge(60*60);
 * 	         response.addCookie(c);
 */
@WebServlet("/session/sessionDemo01")
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = new User("小三", "123");
        session.setAttribute("user",u);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
