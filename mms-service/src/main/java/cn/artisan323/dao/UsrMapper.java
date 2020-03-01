package cn.artisan323.dao;

import cn.artisan323.domain.Usr;

public interface UsrMapper {
    int deleteByPrimaryKey(Integer usrCde);

    int insert(Usr record);

    int insertSelective(Usr record);

    Usr selectByPrimaryKey(Integer usrCde);

    int updateByPrimaryKeySelective(Usr record);

    int updateByPrimaryKey(Usr record);
}