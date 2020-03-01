package cn.artisan323.service;

import cn.artisan323.dao.UsrMapper;
import cn.artisan323.domain.Usr;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsrServiceImpl implements UsrService {

    @Autowired
    UsrMapper usrMapper;

    private Logger logger = LoggerFactory.getLogger(UsrServiceImpl.class);

    @Override
    public ResponseUtil checkLogin(RequestUtil requestUtil) {

        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();

        String usrLoginName = (String) requestUtil.getValueFormData("userName");
        String usrPassword = (String) requestUtil.getValueFormData("userPassword");

        Usr usr = usrMapper.selectByLoginName(usrLoginName);

        logger.info("usr = {}", usr);

        if (usr == null){
            responseUtil.setSuccess(false);
        }else if (usr.getUsrPassword().equals(usrPassword)){
            responseUtil.setSuccess(true);
            responseUtil.putValueToData("usr", usr);
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
            Usr usr = (Usr) requestUtil.getValueFormData("usr");
            logger.info("usr = {}", usr);

            int i = usrMapper.insertSelective(usr);
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
}
