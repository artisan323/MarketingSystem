package cn.artisan323.service;

import cn.artisan323.domain.Forum;

import java.util.List;

public interface ForumService {

    List<Forum> getList();

    void upForum(Forum forum);
}
