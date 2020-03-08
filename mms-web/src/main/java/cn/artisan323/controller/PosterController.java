package cn.artisan323.controller;

import cn.artisan323.domain.Poster;
import cn.artisan323.domain.Usr;
import cn.artisan323.service.PosterService;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/poster")
public class PosterController {

    private Logger logger = LoggerFactory.getLogger(PosterController.class);

    @Autowired
    private PosterService posterServiceImpl;

    @RequestMapping("/uploadPoster")
    public String uploadPoster(MultipartFile uploadPoster, String slogan, HttpSession session){
        logger.info("进入生成海报控制器");
        //创建返回工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();

        try {
            Poster poster = new Poster();
            //获得文件名称
            String upfileName = uploadPoster.getOriginalFilename();
            poster.setUpImgName(upfileName);
            //设置文件保存路径
            poster.setSlogen(slogan);
            String upPath = "/Users/wannengqingnian/Documents/test/upImg/";
            String posterUrl = "/Users/wannengqingnian/Documents/test/createImg/";
            String suffix = upfileName.substring(upfileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            poster.setSuffix(suffix);
            poster.setPosterFullPath(posterUrl + uuid + suffix);
            poster.setUpImgFullPath(upPath + uuid + suffix);
            //保存文件所属者
            Usr usr = (Usr) session.getAttribute("usr");
            poster.setBelongUsrId(usr.getUsrCde());

            //保存文件到本地
            FileUtils.copyInputStreamToFile(uploadPoster.getInputStream(), new File(poster.getUpImgFullPath()));
            logger.info("接收到上传的图片，先存入本地，然后保存入库，保存对象poster = {}", poster.toString());

            //创建请求工具
            RequestUtil requestUtil = RequestUtil.getRequestUtil();
            requestUtil.putValueToData("poster", poster);
            //调用生成图片
            responseUtil = posterServiceImpl.createPoster(requestUtil);
        }catch (Exception e){
            logger.error("创建图片失败");
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("/getPoster")
    public void getPoster(HttpServletRequest request, HttpServletResponse response){
        try {
            //这里只是为了测试，所以把文件地址写死了
            FileInputStream pic = new FileInputStream("/Users/wannengqingnian/Documents/test/createImg/40864e8c-96bf-4fa3-a148-2aa7a45ef595.png");
            int i = pic.available();
            byte[] date = new byte[i];
            pic.read(date);
            pic.close();
            //这里要有这个设置，否则会报错
            response.setContentType("img/*");
            response.setCharacterEncoding("utf-8");
            ServletOutputStream out=response.getOutputStream();
            out.write(date);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
