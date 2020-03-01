package cn.artisan323.service;

import cn.artisan323.util.RequestUtil;
import cn.artisan323.util.ResponseUtil;

public interface UsrService {
    ResponseUtil checkLogin(RequestUtil requestUtil);

    ResponseUtil register(RequestUtil requestUtil);
}
