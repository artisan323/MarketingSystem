package cn.artisan323.dao;

import cn.artisan323.domain.FanUsr;

public interface FanUsrMapper {
    int deleteByPrimaryKey(Integer fanCde);

    int insert(FanUsr record);

    int insertSelective(FanUsr record);

    FanUsr selectByPrimaryKey(Integer fanCde);

    int updateByPrimaryKeySelective(FanUsr record);

    int updateByPrimaryKey(FanUsr record);
}