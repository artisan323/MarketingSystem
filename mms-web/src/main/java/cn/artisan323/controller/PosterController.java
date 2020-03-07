package cn.artisan323.controller;

import cn.artisan323.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/poster")
public class PosterController {

    private Logger logger = LoggerFactory.getLogger(PosterController.class);

    @ResponseBody
    @RequestMapping("/uploadPoster")
    public ResponseUtil uploadPoster(MultipartFile uploadPoster, String slogan){
        //创建返回工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();

        //调用生成图片

        return null;
    }

}
