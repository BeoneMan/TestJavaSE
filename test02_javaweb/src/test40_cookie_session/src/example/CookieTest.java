package example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  案例：记住上一次访问时间
 * 	1. 需求：
 * 		1. 访问一个Servlet，如果是第一次访问，则提示：您好，欢迎您首次访问。
 * 		2. 如果不是第一次访问，则提示：欢迎回来，您上次访问时间为:显示时间字符串
 *
 * 	2. 分析：
 * 		1. 可以采用Cookie来完成
 * 		2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 * 			1. 有：不是第一次访问
 * 				1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 * 				2. 写回Cookie：lastTime=2018年6月10日11:50:01
 * 			2. 没有：是第一次访问
 * 				1. 响应数据：您好，欢迎您首次访问
 * 				2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */
@WebServlet("/example/cookietest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        Boolean flag = false;
        if (cookies.length > 0 && cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastime".equals(name)) {
                    flag = true;
                    cookie.setValue(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")));
                    cookie.setMaxAge(60 * 60 * 12);
                    resp.addCookie(cookie);
                    resp.getWriter().write("欢迎回来，你上次登录的时间为" + cookie.getValue());
                    break;
                }
            }
        }
        //证明首次登录
        if (cookies.length == 0 || cookies == null || flag == false) {
            Cookie lastimeCookie = new Cookie("lastime",LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss")));
            lastimeCookie.setMaxAge(60 * 60 * 12);
            resp.addCookie(lastimeCookie);
            resp.getWriter().write("您好，欢迎您首次访问");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
