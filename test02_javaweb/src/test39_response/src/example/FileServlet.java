package example;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/example/fileServlet")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码
        req.setCharacterEncoding("utf-8");
        String filename = req.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        //读取文件进内存
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(servletContext.getRealPath("img/") + filename));
        //获取文件类型
        String mimeType = servletContext.getMimeType(filename);
        //设置响应头
        //设置响应头类型
        resp.setHeader("content-type", mimeType);
            /* 中文文件问题
                    * 解决思路：
                1. 获取客户端使用的浏览器版本信息
                2. 根据不同的版本信息，设置filename的编码方式不同*/
        String agent = req.getHeader("User-Agent");
        String name = DownLoadUtils.getFileName(agent, filename);

        //设置响应头打开方式
        resp.setHeader("content-disposition", "attachment;filename=" + name);

        //将输入流的数据写出输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = bis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }

        bis.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
