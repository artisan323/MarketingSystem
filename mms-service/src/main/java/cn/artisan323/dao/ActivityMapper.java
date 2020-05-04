package cn.artisan323.dao;

import cn.artisan323.domain.Activity;

public interface ActivityMapper {
    int deleteByPrimaryKey(Integer aCde);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer aCde);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

    Activity selectByCreateTime();
}