package cn.driveman.travel.web.servlet;

import cn.driveman.travel.vo.ResultInfo;
import cn.driveman.travel.entity.User;
import cn.driveman.travel.service.IUserService;
import cn.driveman.travel.service.impl.UserServiceImpl;
import cn.driveman.travel.util.MailUtils;
import cn.driveman.travel.util.UuidUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    IUserService userService = new UserServiceImpl();
    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //校验验证码是否正确
        String checkParam = request.getParameter("check");
        String checkcode_server = String.valueOf(request.getSession().getAttribute("CHECKCODE_SERVER"));
        ObjectMapper objectMapper = new ObjectMapper();
        ResultInfo info = new ResultInfo();
        if(StringUtils.isEmpty(checkParam)||(!checkcode_server.equalsIgnoreCase(checkParam))){
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
                String text="<a href=http://localhost:8080/travel/user/active?code="+uuid+">点击激活账号</a>";
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
    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    //退出
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        response.sendRedirect("../index.html");
    }
    //激活
    public void active(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        String code = request.getParameter("code");
        Boolean flag = userService.activeUser(code);
        String msg;
        if(flag){
            msg = "激活成功，请<a href='../login.html'>登录</a>";
        }else{
            msg = "激活失败，请联系管理员";
        }
        response.getWriter().write(msg);
    }
    //查询单个对象
    public void findUser(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        User user =(User) request.getSession().getAttribute("user");
        ResultInfo info = new ResultInfo();
        if(user!=null){
            info.setFlag(true);
            info.setData(user);
        }else{
            info.setFlag(false);
            info.setErrorMsg("未登录用户");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(),info);

    }




}
