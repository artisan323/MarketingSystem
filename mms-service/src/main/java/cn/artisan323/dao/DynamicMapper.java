package cn.artisan323.dao;

import cn.artisan323.domain.Dynamic;

import java.util.List;

public interface DynamicMapper {
    int deleteByPrimaryKey(Integer dyCde);

    int insert(Dynamic record);

    int insertSelective(Dynamic record);

    Dynamic selectByPrimaryKey(Integer dyCde);

    int updateByPrimaryKeySelective(Dynamic record);

    int updateByPrimaryKey(Dynamic record);

    List<Dynamic> selectAll();
}