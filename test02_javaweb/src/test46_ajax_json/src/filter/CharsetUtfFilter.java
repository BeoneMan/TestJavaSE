package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ContentTypeFilter")
public class CharsetUtfFilter implements Filter {

    // 不拦截的资源类型
    private static String[] ignoreTypes;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String ignoreTypes = config.getInitParameter("ignoreTypes");
        if(ignoreTypes != null && !ignoreTypes.trim().equals("")){
            this.ignoreTypes = ignoreTypes.split(",");
        }
    }

}
