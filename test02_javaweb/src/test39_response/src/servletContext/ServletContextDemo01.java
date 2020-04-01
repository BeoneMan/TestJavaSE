package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 获取MIME类型：
 * 		* MIME类型:在互联网通信过程中定义的一种文件数据类型
 * 			* 格式： 大类型/小类型   text/html		image/jpeg
 *
 * 		* 获取：String getMimeType(String file)
 * 	2. 域对象：共享数据
 * 		1. setAttribute(String name,Object value)
 * 		2. getAttribute(String name)
 * 		3. removeAttribute(String name)
 *
 * 		* ServletContext对象范围：所有用户所有请求的数据
 */
@WebServlet("/servletContext/ServletContextDemo01")
public class ServletContextDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = req.getServletContext();
        System.out.println(servletContext==servletContext1);
        System.out.println(servletContext);
        System.out.println("--------");
        servletContext.setAttribute("servletContext","你还在");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
