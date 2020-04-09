package jstl;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 	1. if:相当于java代码的if语句
 * 		1. 属性：
 *             * test 必须属性，接受boolean表达式
 *                 * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
 *                 * 一般情况下，test属性值会结合el表达式一起使用
 *    		 2. 注意：
 *        		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签
 * 	2. choose:相当于java代码的switch语句
 * 		1. 使用choose标签声明         			相当于switch声明
 *         2. 使用when标签做判断         			相当于case
 *         3. 使用otherwise标签做其他情况的声明    	相当于default
 *
 * 	3. foreach:相当于java代码的for语句
 */
@WebServlet("/jstlDemo01")
public class JstlDemo01 extends HttpServlet {
    @Override
    @SuppressWarnings("all")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = Arrays.asList(new User("小一", 18), new User("小二", 22), new User("小三", 23));
        Map<String,User> map=new HashMap<>();
        map.put("user1",new User("map1",21));
        map.put("user2",new User("map2",22));
        map.put("user3",new User("map3",23));
        req.setAttribute("userList",userList);
        req.setAttribute("map",map);
        req.getRequestDispatcher("/jsp07.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
