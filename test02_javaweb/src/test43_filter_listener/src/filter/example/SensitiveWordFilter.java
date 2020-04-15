package filter.example;

import javax.servlet.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class SensitiveWordFilter implements Filter {
    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        BufferedReader bufferedReader = null;
        try {
            //获取文件真实路径
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("WEB-INF/敏感词汇.txt");
            InputStreamReader isr = new InputStreamReader(new FileInputStream(realPath),"utf-8");
            bufferedReader = new BufferedReader(isr);

            String resultLine;
            while ((resultLine = bufferedReader.readLine()) != null) {
                list.add(resultLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Class<ServletRequest> servletRequestClass = (Class<ServletRequest>) servletRequest.getClass();

        ServletRequest proxyServletRequest = (ServletRequest) Proxy.newProxyInstance(servletRequestClass.getClassLoader(), servletRequestClass.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(servletRequest, args);
                    if (list.size() > 0) {
                        for (String s : list) {
                            if (value.contains(s)) {
                                value = value.replaceAll(s, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest, args);
            }
        });
        filterChain.doFilter(proxyServletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
