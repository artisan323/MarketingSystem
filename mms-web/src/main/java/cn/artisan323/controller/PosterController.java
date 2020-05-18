package cn.artisan323.controller;

import cn.artisan323.domain.Activity;
import cn.artisan323.domain.Poster;
import cn.artisan323.domain.Usr;
import cn.artisan323.service.PosterService;
import cn.artisan323.util.DateUtils;
import cn.artisan323.util.HttpUtil;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import java.util.HashMap;
import java.util.Map;
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
            poster.setCreateTime(DateUtils.getCurrentFormatDateShort10());
            //保存文件所属者
//            Usr usr = (Usr) session.getAttribute("usr");
//            poster.setBelongUsrId(usr.getUsrCde());

            //保存文件到本地
            FileUtils.copyInputStreamToFile(uploadPoster.getInputStream(), new File(poster.getUpImgFullPath()));
            logger.info("接收到上传的图片，先存入本地，然后保存入库，保存对象poster = {}", poster.toString());

//            logger.info("测试上传图床开始");
//            String url = "http://129.28.173.126:8088/clientupimg/";
//            Map<String, String> requestParams = new HashMap<>(2);
//            requestParams.put("email", "artisan323@163.com");
//            requestParams.put("pass", "123456");
//            String result = HttpUtil.requestOCRForHttp(url, requestParams, poster.getUpImgFullPath());
//            logger.info("测试上传图床结束  返回数据：{}", result);
//            JSONObject jsonResult = JSON.parseObject(result);
//            String code = jsonResult.getString("code");
//            String msg = jsonResult.getString("msg");
//            JSONArray data = jsonResult.getJSONArray("data");
//            JSONObject da = data.getJSONObject(0);
//            String str = da.getString("Imgurl");
//            logger.info(str);
//            if (str == null || "".equals(str)){
//                logger.info("图床不可用");
//            }else {
//                poster.setFigureBed(str);
//            }
            //创建请求工具
            RequestUtil requestUtil = RequestUtil.getRequestUtil();
            requestUtil.putValueToData("poster", poster);
            //调用生成图片
            responseUtil = posterServiceImpl.createPoster(requestUtil);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("创建图片失败");
        }
        return "redirect:/index.jsp";
    }

    @RequestMapping("/getPoster")
    public void getPoster(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        //创建请求工具
        RequestUtil requestUtil = RequestUtil.getRequestUtil();
        ResponseUtil responseUtil;
        String posterPath;
        Poster poster = null;
        try {
            Usr usr = (Usr) session.getAttribute("usr");
            if (usr == null){
                responseUtil = posterServiceImpl.getPoster(requestUtil);
                posterPath = (String) responseUtil.getValueFormData("posterPath");
            }else {
                String usrCde = usr.getUsrIdNo();
                requestUtil.putValueToData("usrCde", usrCde);
                responseUtil = posterServiceImpl.getPoster(requestUtil);
                posterPath = (String) responseUtil.getValueFormData("posterPath");
            }
            //这里只是为了测试，所以把文件地址写死了
            FileInputStream pic = new FileInputStream(posterPath);
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
        } catch (Exception e){
            e.printStackTrace();
            logger.info("获取海报失败"+e.getMessage());
        }
    }

    @RequestMapping("/activity")
    @ResponseBody
    public String activity(String context){
        try {
            logger.info("活动文案 = {}", context);
            Activity activity = new Activity();
            activity.setName("活动");
            activity.setDesc(context);
            activity.setStartTime(DateUtils.getCurrentFormatDateShort10());
            posterServiceImpl.setActivity(activity);
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
        return "true";
    }

    @RequestMapping("/getActivity")
    @ResponseBody
    public String getActivity(){
        try {
            ResponseUtil responseUtil = posterServiceImpl.getActivity();
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
        return "true";
    }

}
