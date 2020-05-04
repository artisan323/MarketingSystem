package cn.artisan323.dao;

import cn.artisan323.domain.Forum;

import java.util.List;

public interface ForumMapper {
    int deleteByPrimaryKey(Integer fCde);

    int insert(Forum record);

    int insertSelective(Forum record);

    Forum selectByPrimaryKey(Integer fCde);

    int updateByPrimaryKeySelective(Forum record);

    int updateByPrimaryKey(Forum record);

    List<Forum> selectAll();
}