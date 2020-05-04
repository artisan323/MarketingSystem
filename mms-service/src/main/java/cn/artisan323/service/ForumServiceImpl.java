package cn.artisan323.service;

import cn.artisan323.dao.ForumMapper;
import cn.artisan323.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForumServiceImpl implements ForumService{

    @Autowired
    private ForumMapper forumMapper;

    @Override
    public List<Forum> getList() {
        return forumMapper.selectAll();
    }

    @Override
    public void upForum(Forum forum) {
        forumMapper.insertSelective(forum);
    }
}
