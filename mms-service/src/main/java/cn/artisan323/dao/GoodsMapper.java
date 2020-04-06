package cn.artisan323.dao;

import cn.artisan323.domain.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer fanCde);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer fanCde);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}