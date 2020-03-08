package cn.artisan323.dao;

import cn.artisan323.domain.Poster;

public interface PosterMapper {
    int deleteByPrimaryKey(Integer posterId);

    int insert(Poster record);

    int insertSelective(Poster record);

    Poster selectByPrimaryKey(Integer posterId);

    int updateByPrimaryKeySelective(Poster record);

    int updateByPrimaryKey(Poster record);
}