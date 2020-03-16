package cn.artisan323.service;

import cn.artisan323.dao.GoodsMapper;
import cn.artisan323.domain.Goods;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    private Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public ResponseUtil saveGoodsImg(RequestUtil requestUtil) {
        logger.info("进入保存商品图片");
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            Goods goods = (Goods) requestUtil.getValueFormData("goods");
            logger.info("保存的goods {}", goods);
            goodsMapper.insertSelective(goods);
            responseUtil.setSuccess(true);
            responseUtil.setMessage("保存商品图片成功");
        }catch (Exception e){
            responseUtil.setSuccess(false);
            responseUtil.setMessage("保存商品图片失败");
            e.printStackTrace();
        }
        return responseUtil;
    }

    @Override
    public ResponseUtil getGoods(RequestUtil requestUtil) {
        logger.info("进入查找商品图片");
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        Map<String, Object> map = new HashMap<>(2);
        try {
            Integer belongId = (Integer) requestUtil.getValueFormData("usrCde");
            Integer index = (Integer) requestUtil.getValueFormData("index");
            map.put("belongId", belongId);
            map.put("index", index);
            Goods goods = goodsMapper.selectByUsrCde(map);
            logger.info("查询参数{}", map.toString());
            if (goods == null){
                String path = "/Users/wannengqingnian/MyCode/MarketingSystem/mms-web/src/main/webapp/pic/index/remen"+ index +".jpg";
                responseUtil.setMessage("查找商品图片成功");
                responseUtil.setSuccess(true);
                responseUtil.putValueToData("goodsPath", path);
            }else {
                responseUtil.setMessage("查找商品图片成功");
                responseUtil.setSuccess(true);
                responseUtil.putValueToData("goodsPath", goods.getGdPath());
            }
        }catch (Exception e){
            responseUtil.setMessage("查找商品图片失败");
            responseUtil.setSuccess(false);
            e.printStackTrace();
        }
        return responseUtil;
    }
}
