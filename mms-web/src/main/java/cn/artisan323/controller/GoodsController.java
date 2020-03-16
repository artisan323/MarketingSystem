package cn.artisan323.controller;

import cn.artisan323.domain.Goods;
import cn.artisan323.domain.Poster;
import cn.artisan323.domain.Usr;
import cn.artisan323.service.GoodsService;
import cn.artisan323.util.DateUtils;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * 商品相关
 * @author wannengqingnian
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    private Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsServiceImpl;

    @RequestMapping("/uploadGoods")
    @ResponseBody
    public ResponseUtil uploadGoods(MultipartFile upGoodsImg, Integer index, HttpSession session){
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        //创建请求工具
        RequestUtil requestUtil = RequestUtil.getRequestUtil();
        logger.info("进入商品图片上传。。。");
        try {
            Usr usr = (Usr) session.getAttribute("usr");
            Integer usrCde = usr.getUsrCde();
            Goods goods = new Goods();
            goods.setBelongId(usrCde);
            goods.setCreateTime(DateUtils.getCurrentFormatDateLong14());
            goods.setGdIndex(index);
            String upfileName = upGoodsImg.getOriginalFilename();
            String suffix = upfileName.substring(upfileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            goods.setGdPath("/Users/wannengqingnian/Documents/test/upImg/" + uuid + suffix);
            FileUtils.copyInputStreamToFile(upGoodsImg.getInputStream(), new File(goods.getGdPath()));
            logger.info("保存本地成功 goods{}", goods.toString());
            requestUtil.putValueToData("goods", goods);
            responseUtil = goodsServiceImpl.saveGoodsImg(requestUtil);
            if (responseUtil.isSuccess() == true){
                logger.info("商品信息保存成功");
            }else {
                logger.info("商品信息保存失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseUtil;
    }

    @RequestMapping("/getGoods")
    public void getGoods(Integer index, HttpServletResponse response, HttpSession session){
        //创建请求工具
        RequestUtil requestUtil = RequestUtil.getRequestUtil();
        ResponseUtil responseUtil = null;
        String goodsPath;
        Goods goods = null;
        try {
            Usr usr = (Usr) session.getAttribute("usr");
            if (usr == null){
                requestUtil.putValueToData("index", index);
                responseUtil = goodsServiceImpl.getGoods(requestUtil);
                goodsPath = (String) responseUtil.getValueFormData("goodsPath");
            }else {
                String usrCde = usr.getUsrIdNo();
                //创建请求工具
                requestUtil = RequestUtil.getRequestUtil();
                requestUtil.putValueToData("usrCde", usrCde);
                requestUtil.putValueToData("index", index);
                responseUtil = goodsServiceImpl.getGoods(requestUtil);
                goodsPath = (String) responseUtil.getValueFormData("goodsPath");
            }
            FileInputStream pic = new FileInputStream(goodsPath);
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
            logger.info("获取商品图失败"+e.getMessage());
        }
    }

    @RequestMapping("/getGoodsInfo")
    public ResponseUtil getGoodsInfo(Integer index, HttpServletResponse response, HttpSession session){
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            Usr usr = (Usr) session.getAttribute("usr");
            if (usr == null){
                switch (index){
                    case 1:
                        responseUtil.setMessage("FILL");
                }
            }else {

            }

        } catch (Exception e){
            e.printStackTrace();
            logger.info("获取海报失败"+e.getMessage());
        }
        return responseUtil;
    }
}
