package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
     2. 快速入门：
         * 使用步骤：
         1. 创建Cookie对象，绑定数据
         * new Cookie(String name, String value)
         2. 发送Cookie对象
         * response.addCookie(Cookie cookie)
         3. 获取Cookie，拿到数据
         * Cookie[]  request.getCookies()

 */
@WebServlet("/cookie/CookieDemo01")
public class CookieDemo01  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("JSESSION","USER");
        cookie.setMaxAge(5*60);
        //同一个tomcat中多个web项目共享cookie
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
