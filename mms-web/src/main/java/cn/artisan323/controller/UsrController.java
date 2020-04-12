package cn.artisan323.controller;


import cn.artisan323.domain.Usr;
import cn.artisan323.service.UsrService;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登陆
 * @author wannengqingnian
 */
@Controller
@RequestMapping("/usr")
public class UsrController {

    @Autowired
    private UsrService usrServiceImpl;

    private Logger logger = LoggerFactory.getLogger(UsrController.class);

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

        if (responseUtil.isSuccess()){
            HttpSession session = request.getSession();
            Usr usr = (Usr) responseUtil.getValueFormData("usr");
            session.setAttribute("usr", usr);
            return "forward:/index.jsp";
        }else {
            return "forward:/login.jsp";
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

        if (responseUtil.isSuccess()){
            return "redirect:/login.jsp";
        }else {
            return "redirect:/signup.jsp";
        }
    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/getUsr", method = RequestMethod.GET)
    @ResponseBody
    public ResponseUtil getUsr(HttpServletRequest request, HttpSession session){
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            Usr usr = (Usr) session.getAttribute("usr");
            if (usr != null){
                logger.info("session中保存的对象为 = {}", usr.toString());
                responseUtil.putValueToData("usr", usr);
                responseUtil.setSuccess(true);
            }else {
                responseUtil.setSuccess(false);
                responseUtil.setMessage("没有用户登录");
            }
        }catch (Exception e){
            e.printStackTrace();
            responseUtil.setSuccess(false);
            responseUtil.setMessage("后端出现异常");
        }
        return responseUtil;
    }



}
