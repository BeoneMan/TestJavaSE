package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取文件的真实(服务器)路径
 * 		1. 方法：String getRealPath(String path)
 * 			 String b = context.getRealPath("/b.txt");//web目录下资源访问
 * 	         System.out.println(b);
 *
 * 	        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下的资源访问
 * 	        System.out.println(c);
 *
 * 	        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
 * 	        System.out.println(a);
 */
@WebServlet("/servletContext/ServletContextDemo03")
public class ServletContextDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        //获取src下的文件
        String realPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath);
        //获取web下的文件
        String realPath2 = servletContext.getRealPath("b.txt");
        System.out.println(realPath2);
        //获取web/WEB-INF下的文件
        String realPath3 = servletContext.getRealPath("/WEB-INF/c.txt");
        System.out.println(realPath3);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
