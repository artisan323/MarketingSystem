package cn.artisan323.service;

import cn.artisan323.dao.FanUsrMapper;
import cn.artisan323.domain.FanUsr;
import cn.artisan323.domain.Usr;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FanUsrServiceImpl implements FanUsrService{

    @Autowired
    FanUsrMapper fanUsrMapper;

    private Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);

    @Override
    public ResponseUtil checkLogin(RequestUtil requestUtil) {
        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        String fanName = (String) requestUtil.getValueFormData("userName");
        String fanPassword = (String) requestUtil.getValueFormData("userPassword");
        FanUsr fanUsr = fanUsrMapper.selectByFanName(fanName);
        logger.info("fanUsr = {}", fanUsr);
        if (fanUsr == null){
            responseUtil.setSuccess(false);
        }else if (fanUsr.getFanPassword().equals(fanPassword)){
            responseUtil.setSuccess(true);
            responseUtil.putValueToData("usr", fanUsr);
        }else {
            responseUtil.setSuccess(false);
        }
        return responseUtil;
    }

    @Override
    public ResponseUtil register(RequestUtil requestUtil) {
        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();

        try {
            FanUsr fanUsr = (FanUsr) requestUtil.getValueFormData("fanUsr");
            logger.info("fanUsr = {}", fanUsr);

            int i = fanUsrMapper.insertSelective(fanUsr);
            if (i == 1){
                responseUtil.setSuccess(true);
            }else {
                responseUtil.setSuccess(false);
            }
        }catch (Exception e){
            e.printStackTrace();
            responseUtil.setSuccess(false);
        }
        return responseUtil;
    }

    @Override
    public List<FanUsr> selectAll() {
        return fanUsrMapper.selectAll();
    }
}
