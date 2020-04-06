package cn.artisan323.dao;

import cn.artisan323.domain.Goods;

import java.util.Map;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer fanCde);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer fanCde);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    Goods selectByUsrCde(Map<String, Object> map);

    Object selectByIndex(int i);
}