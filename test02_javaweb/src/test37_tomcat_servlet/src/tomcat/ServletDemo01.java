package tomcat;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo01 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化...");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig:"+getServletConfig());
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet...");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo"+getServletInfo());
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("被销毁了...");
    }
}
