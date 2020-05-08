package cn.driveman.travel.web.filter;


import cn.driveman.travel.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    // 不拦截的资源类型
    private static String[] ignoreTypes;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String ignoreTypes = filterConfig.getInitParameter("ignoreTypes");
        if(ignoreTypes != null && !ignoreTypes.trim().equals("")){
            this.ignoreTypes = ignoreTypes.split(",");
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.ignoreTypes);
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());


        boolean isIgnoreType = false;
        if(ignoreTypes != null){
            for (int i = 0; i < ignoreTypes.length; i++) {
                if (url.endsWith("." + ignoreTypes[i])) {
                    isIgnoreType = true;
                    break;
                }
            }
        }

        if(url.indexOf("/login.jsp") > -1||url.indexOf("/loginServlet") > -1||url.indexOf("/checkCode") > -1||isIgnoreType==true){
            System.out.println(url+"这是登录入口或者静态资源，放行");
            chain.doFilter(request, response);
        }else{
            User user = (User)request.getSession().getAttribute("user");
            if(user==null){
                    response.sendRedirect(contextPath+"/login.jsp");
            }
          else{
                String name = user.getName();
                System.out.println("用户名:"+name);
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
