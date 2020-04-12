package cn.artisan323.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    private Logger logger = LoggerFactory.getLogger(JumpController.class);

    @RequestMapping("jump")
    public String jump(String page){
        logger.info("页面跳转 = {}", page);
        return "forward:/" + page + ".jsp";
    }

}
