package generate;

import generate.Poster;

public interface PosterDao {
    int deleteByPrimaryKey(Integer posterId);

    int insert(Poster record);

    int insertSelective(Poster record);

    Poster selectByPrimaryKey(Integer posterId);

    int updateByPrimaryKeySelective(Poster record);

    int updateByPrimaryKey(Poster record);
}