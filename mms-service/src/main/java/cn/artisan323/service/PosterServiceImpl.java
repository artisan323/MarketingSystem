package cn.artisan323.service;

import cn.artisan323.dao.PosterMapper;
import cn.artisan323.domain.Poster;
import cn.artisan323.domain.Usr;
import cn.artisan323.util.PosterUtil;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;

/**
 * 海报相关
 * @author wannengqingnian
 */
@Service
public class PosterServiceImpl implements PosterService {

    private Logger logger = LoggerFactory.getLogger(PosterServiceImpl.class);

    @Autowired
    private PosterMapper posterMapper;

    @Override
    public ResponseUtil createPoster(RequestUtil requestUtil) {
        //创建返回工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            //拿到请求参数
            Poster poster = (Poster) requestUtil.getValueFormData("poster");
            posterMapper.insertSelective(poster);

            logger.info("生成海报开始...");
            PosterUtil.drawPoster(poster);
            logger.info("生成海报结束，海报保存路径 : {}", poster.getPosterFullPath());
            responseUtil.setSuccess(true);
            responseUtil.setMessage("生成海报成功");
        }catch (Exception e){
            logger.error("生成海报失败： {}", e.getMessage());
            responseUtil.setSuccess(false);
            responseUtil.setMessage("生成海报失败");
        }

        return responseUtil;
    }
}
