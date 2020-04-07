package session;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 2. 客户端不关闭，服务器关闭后，两次获取的session是同一个吗？
 * 		* 不是同一个，但是要确保数据不丢失。tomcat自动完成以下工作
 * 			* session的钝化：
 * 				* 在服务器正常关闭之前，将session对象系列化到硬盘上
 * 			* session的活化：
 * 				* 在服务器启动后，将session文件转化为内存中的session对象即可。
 */
@WebServlet("/session/sessionDemo03")
public class SessionDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
