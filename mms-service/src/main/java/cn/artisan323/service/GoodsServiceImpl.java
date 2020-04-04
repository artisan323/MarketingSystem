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

    @Override
    public ResponseUtil getGoodsInfo() {
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            responseUtil.putValueToData("good1", (goodsMapper.selectByIndex(1) == null) ? "null":goodsMapper.selectByIndex(1));
            responseUtil.putValueToData("good2", (goodsMapper.selectByIndex(2) == null) ? "null":goodsMapper.selectByIndex(2));
            responseUtil.putValueToData("good3", (goodsMapper.selectByIndex(3) == null) ? "null":goodsMapper.selectByIndex(3));
            responseUtil.putValueToData("good4", (goodsMapper.selectByIndex(4) == null) ? "null":goodsMapper.selectByIndex(4));
            responseUtil.setSuccess(true);
            responseUtil.setMessage("查找商品信息成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseUtil;
    }


}
