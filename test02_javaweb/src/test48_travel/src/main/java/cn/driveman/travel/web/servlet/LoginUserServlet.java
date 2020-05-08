package cn.driveman.travel.web.servlet;

import cn.driveman.travel.domain.ResultInfo;
import cn.driveman.travel.domain.User;
import cn.driveman.travel.service.IUserService;
import cn.driveman.travel.service.impl.UserServiceImpl;
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

@WebServlet("/loginUserServlet")
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultInfo info = new ResultInfo();
            //校验验证码
            String code = request.getParameter("check");
            if(StringUtils.isEmpty(code)){
                info.setFlag(false);
                info.setErrorMsg("验证码不能为空");
                ObjectMapper mapper = new ObjectMapper();
                response.setContentType("application/json;charset=utf-8");
                mapper.writeValue(response.getOutputStream(),info);
                return;
            }

            String checkcode_server =String.valueOf( request.getSession().getAttribute("CHECKCODE_SERVER"));
            if(!code.equals(checkcode_server)){
                info.setFlag(false);
                info.setErrorMsg("验证码错误");
                ObjectMapper mapper = new ObjectMapper();
                response.setContentType("application/json;charset=utf-8");
                mapper.writeValue(response.getOutputStream(),info);
                return;
            }
            //校验用户名与密码
            IUserService userService = new UserServiceImpl();
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,parameterMap);
            String username = user.getUsername();
            String password = user.getPassword();

            if(StringUtils.isEmpty(username)&&StringUtils.isEmpty(password)){
                info.setFlag(false);
                info.setErrorMsg("用户名或密码不能为空");
            }else{
                User u = userService.findUserByUsernameAndPassword(username, password);

                if(u==null){
                    info.setFlag(false);
                    info.setErrorMsg("此用户还没注册");
                }
                if(u!=null&&u.getStatus().equals("N")){
                    info.setFlag(false);
                    info.setErrorMsg("此用户还没激活");
                }
                if(u!=null && "Y".equals(u.getStatus())){
                    //登录成功
                    info.setFlag(true);
                    info.setData(u);
                    request.getSession().setAttribute("user",u);
                }
            }
            //响应数据
            ObjectMapper mapper = new ObjectMapper();
            response.setContentType("application/json;charset=utf-8");
            mapper.writeValue(response.getOutputStream(),info);

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
