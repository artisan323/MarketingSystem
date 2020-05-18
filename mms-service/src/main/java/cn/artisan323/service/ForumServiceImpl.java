package cn.artisan323.service;

import cn.artisan323.dao.DynamicMapper;
import cn.artisan323.dao.FanUsrMapper;
import cn.artisan323.dao.ForumMapper;
import cn.artisan323.domain.Dynamic;
import cn.artisan323.domain.FanUsr;
import cn.artisan323.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ForumServiceImpl implements ForumService{

    @Autowired
    private ForumMapper forumMapper;

    @Autowired
    private FanUsrMapper fanUsrMapper;

    @Autowired
    private DynamicMapper dynamicMapper;

    @Override
    public List<Forum> getList() {
        return forumMapper.selectAll();
    }

    @Override
    public List<Dynamic> getDynamic() {
        return dynamicMapper.selectAll();
    }

    @Override
    public List<FanUsr> getFan() {
        return fanUsrMapper.selectAll();
    }
    @Override
    public void upForum(Forum forum) {
        forumMapper.insert(forum);
    }
}
