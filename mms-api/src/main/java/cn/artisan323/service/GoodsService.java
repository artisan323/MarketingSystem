package cn.artisan323.service;

import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;

public interface GoodsService {

    ResponseUtil saveGoodsImg(RequestUtil requestUtil);

    ResponseUtil getGoods(RequestUtil requestUtil);
}
