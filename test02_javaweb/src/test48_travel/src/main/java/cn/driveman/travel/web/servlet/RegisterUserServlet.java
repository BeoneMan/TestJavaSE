package cn.driveman.travel.web.servlet;

import cn.driveman.travel.domain.ResultInfo;
import cn.driveman.travel.domain.User;
import cn.driveman.travel.service.IUserService;
import cn.driveman.travel.service.impl.UserServiceImpl;
import cn.driveman.travel.util.MailUtils;
import cn.driveman.travel.util.UuidUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
@SuppressWarnings("all")
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        //校验验证码是否正确
        String checkParam = request.getParameter("check");
        String checkcode_server = String.valueOf(request.getSession().getAttribute("CHECKCODE_SERVER"));
        ObjectMapper objectMapper = new ObjectMapper();
        ResultInfo info = new ResultInfo();
        if(StringUtils.isEmpty(checkParam)||(!checkcode_server.equals(checkParam))){
            info.setErrorMsg("验证码错误");
            info.setFlag(false);
            response.getWriter().write( objectMapper.writeValueAsString(info));
            return;
        }
        try {
            //封装数据
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,parameterMap);
            System.out.println("user=>"+user);
            //验证用户是否存在
            User userByName = userService.findUserByName(user.getUsername());
            if(userByName!=null){
                info.setErrorMsg("用户名已存在");
                info.setFlag(false);
                response.getWriter().write( objectMapper.writeValueAsString(info));
                return;
            }
            //注册用户
            String uuid = UuidUtil.getUuid();
            user.setCode(uuid);
            user.setStatus("N");
            if(userService.save(user)>0){
                info.setFlag(true);
                String text="<a href=http://localhost:8080/travel/activeUserServlet?code="+uuid+">点击激活账号</a>";
                MailUtils.sendMail(user.getEmail(),text,"测试激活邮件");
            }else{
                info.setErrorMsg("用户名注册失败,请重试");
                info.setFlag(false);
            }
            response.getWriter().write(objectMapper.writeValueAsString(info));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
