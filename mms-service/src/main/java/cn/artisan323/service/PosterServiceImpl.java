package cn.artisan323.service;

import cn.artisan323.dao.ActivityMapper;
import cn.artisan323.dao.PosterMapper;
import cn.artisan323.domain.Activity;
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
import java.util.List;

/**
 * 海报相关
 * @author wannengqingnian
 */
@Service
public class PosterServiceImpl implements PosterService {

    private Logger logger = LoggerFactory.getLogger(PosterServiceImpl.class);

    @Autowired
    private PosterMapper posterMapper;

    @Autowired
    private ActivityMapper activityMapper;

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

    @Override
    public ResponseUtil getPoster(RequestUtil requestUtil){
        //创建返回工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            //拿到请求参数
            Integer usrCde = (Integer) requestUtil.getValueFormData("usrCde");
            if (usrCde == null){
                List<Poster> posters =posterMapper.selectByTime();
                if (posters.size() <= 0){
                    logger.info("还没有创建过一次海报");
                    responseUtil.putValueToData("posterPath", "/Users/wannengqingnian/MyCode/MarketingSystem/mms-web/src/main/webapp/pic/index/cheat.png");
                }else {
                    responseUtil.putValueToData("posterPath", posters.get(0).getPosterFullPath());
                }
            }else {
                List<Poster> posters = posterMapper.selectPosterByUsrId(usrCde);
                if (posters.size() <= 0){
                    logger.error("还未创建海报");
                }else {
                    responseUtil.putValueToData("posterPath", posters.get(0).getPosterFullPath());
                }
            }
            responseUtil.setSuccess(true);
            responseUtil.setMessage("查询最近一次海报");
        }catch (Exception e){
            logger.error("查找海报失败： {}", e.getMessage());
            responseUtil.setSuccess(false);
            responseUtil.setMessage("查找海报失败");
        }
        return responseUtil;
    }

    @Override
    public void setActivity(Activity activity) {
        activityMapper.insertSelective(activity);
    }

    @Override
    public ResponseUtil getActivity() {
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        responseUtil.setSuccess(true);
        responseUtil.putValueToData("activity",activityMapper.selectByCreateTime());
        return responseUtil;
    }
}
