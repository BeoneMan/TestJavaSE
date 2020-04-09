package el;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * ${域名称.键名}：从指定域中获取指定键的值
 * 				* 域名称：
 * 					1. pageScope		--> pageContext
 * 					2. requestScope 	--> request
 * 					3. sessionScope 	--> session
 * 					4. applicationScope --> application（ServletContext）
 * 				* 举例：在request域中存储了name=张三
 * 				* 获取：${requestScope.name}
 */
@WebServlet("/elDemo01")
public class ElDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = Arrays.asList(new User("小一", 18), new User("小二", 22), new User("小三", 23));
        Map<String,User> map=new HashMap<>();
        map.put("user1",new User("map1",21));
        map.put("user2",new User("map2",22));
        map.put("user3",new User("map3",23));
        req.setAttribute("name","张三");
        req.setAttribute("userList",userList);
        req.setAttribute("map",map);
        HttpSession session = req.getSession();
        session.setAttribute("name","李四");
        req.getServletContext().setAttribute("name","王五");
        req.getRequestDispatcher("/jsp06.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
