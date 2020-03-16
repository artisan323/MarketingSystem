package cn.artisan323.dao;

import cn.artisan323.domain.Poster;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PosterMapper {
    int deleteByPrimaryKey(Integer posterId);

    int insert(Poster record);

    int insertSelective(Poster record);

    Poster selectByPrimaryKey(Integer posterId);

    int updateByPrimaryKeySelective(Poster record);

    int updateByPrimaryKey(Poster record);

    List<Poster> selectPosterByUsrId(@Param("usrCde") Integer usrCde);

    List<Poster> selectByTime();
}