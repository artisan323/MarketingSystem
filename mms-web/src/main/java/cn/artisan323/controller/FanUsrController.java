package cn.artisan323.controller;

import cn.artisan323.domain.FanUsr;
import cn.artisan323.domain.Usr;
import cn.artisan323.service.FanUsrService;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 粉丝注册登陆
 * @author wannengqingnian
 */
@Controller
@RequestMapping("/fanUsr")
public class FanUsrController {

    private Logger logger = LoggerFactory.getLogger(FanUsrController.class);

    @Autowired
    FanUsrService fanUsrServiceImpl;

    @RequestMapping(value = "/fanLogin", method = RequestMethod.POST)
    public String fanLogin(HttpServletRequest request, String username, String psw){
        //创建请求工具类
        RequestUtil requestUtil = RequestUtil.getRequestUtil();
        requestUtil.putValueToData("userName", username);
        requestUtil.putValueToData("userPassword", psw);
        //返回接口工具类
        ResponseUtil responseUtil;
        responseUtil = fanUsrServiceImpl.checkLogin(requestUtil);
        if (responseUtil.isSuccess()){
            HttpSession session = request.getSession();
            FanUsr usr = (FanUsr) responseUtil.getValueFormData("usr");
            session.setAttribute("fanUsr", usr);
            return "forward:/index.jsp";
        }else {
            return "forward:/fanlogin.jsp";
        }
    }

    /**
     * 用户注册
     * @param fanUsr
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(FanUsr fanUsr){

        //创建请求工具类
        RequestUtil requestUtil = RequestUtil.getRequestUtil();
        requestUtil.putValueToData("fanUsr", fanUsr);

        ResponseUtil responseUtil = fanUsrServiceImpl.register(requestUtil);

        if (responseUtil.isSuccess()){
            return "forward:/fanlogin.jsp";
        }else {
            return "forward:/fansignup.jsp";
        }
    }

    @RequestMapping("/getFan")
    @ResponseBody
    public String getFan(Model model, HttpServletRequest request){
        try {
            List<FanUsr> fanUsrs = fanUsrServiceImpl.selectAll();
            logger.info("fanusrs = {}", fanUsrs);
            model.addAttribute("fanUsrs", fanUsrs);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "forward:/management.jsp";
    }

}
