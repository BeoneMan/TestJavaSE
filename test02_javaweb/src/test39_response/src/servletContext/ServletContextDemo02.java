package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContext/ServletContextDemo02")
public class ServletContextDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        String file = "a.jpg";
        String mimeType = servletContext.getMimeType(file);
        System.out.println(mimeType);
        System.out.println("--------");
        String s = String.valueOf(servletContext.getAttribute("servletContext"));
        System.out.println(s);
        servletContext.removeAttribute("servletContext");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
