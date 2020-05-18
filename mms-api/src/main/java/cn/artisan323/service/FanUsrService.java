package cn.artisan323.service;

import cn.artisan323.domain.FanUsr;
import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;

import java.util.List;

public interface FanUsrService {

    ResponseUtil checkLogin(RequestUtil requestUtil);

    ResponseUtil register(RequestUtil requestUtil);

    List<FanUsr> selectAll();
}
