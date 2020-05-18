package cn.artisan323.dao;

import cn.artisan323.domain.FanUsr;
import cn.artisan323.domain.Usr;

import java.util.List;

public interface FanUsrMapper {
    int deleteByPrimaryKey(Integer fanCde);

    int insert(FanUsr record);

    int insertSelective(FanUsr record);

    FanUsr selectByPrimaryKey(Integer fanCde);

    int updateByPrimaryKeySelective(FanUsr record);

    int updateByPrimaryKey(FanUsr record);

    FanUsr selectByFanName(String usrLoginName);

    List<FanUsr> selectAll();
}