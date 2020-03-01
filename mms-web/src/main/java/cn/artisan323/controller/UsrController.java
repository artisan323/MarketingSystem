package cn.artisan323.controller;


import cn.artisan323.domain.Usr;
import cn.artisan323.service.UsrService;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户管理类
 * @author wannengqingnian
 */
@Controller
@RequestMapping("/usr")
public class UsrController {

    @Autowired
    private UsrService usrServiceImpl;


    /**
     * 用户登陆
     * @param username
     * @param psw
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, String username, String psw){
        //创建请求工具类
        RequestUtil requestUtil = RequestUtil.getRequestUtil();
        requestUtil.putValueToData("userName", username);
        requestUtil.putValueToData("userPassword", psw);

        //返回接口工具类
        ResponseUtil responseUtil;

        responseUtil = usrServiceImpl.checkLogin(requestUtil);

        if (responseUtil.isSuccess() == true){
            HttpSession session = request.getSession();
            Usr usr = (Usr) responseUtil.getValueFormData("usr");
            session.setAttribute("usr", usr);
            return "redirect:/management.jsp";
        }else {
            return "redirect:/login.jsp";
        }
    }

    /**
     * 用户注册
     * @param usr
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Usr usr){

        //创建请求工具类
        RequestUtil requestUtil = RequestUtil.getRequestUtil();
        requestUtil.putValueToData("usr", usr);

        ResponseUtil responseUtil = usrServiceImpl.register(requestUtil);

        if (responseUtil.isSuccess() == true){
            return "redirect:/login.jsp";
        }else {
            return "redirect:/signup.jsp";
        }
    }


}
