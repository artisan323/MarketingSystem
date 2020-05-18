package cn.artisan323.service;

import cn.artisan323.domain.Dynamic;
import cn.artisan323.domain.FanUsr;
import cn.artisan323.domain.Forum;

import java.util.List;

public interface ForumService {

    List<Forum> getList();

    List<Dynamic> getDynamic();

    List<FanUsr> getFan();

    void upForum(Forum forum);
}
