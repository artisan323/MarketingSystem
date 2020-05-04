package cn.artisan323.controller;

import cn.artisan323.domain.Forum;
import cn.artisan323.service.ForumService;
import cn.artisan323.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ForumController {

    @Autowired
    ForumService forumServiceImpl;

    @RequestMapping("/getList")
    public String getList(Model model, HttpServletRequest request){
        List<Forum> forums = forumServiceImpl.getList();
        model.addAttribute("forums", forums);
        return "forum";
    }

    @RequestMapping("/upForum")
    public String upForum(String title){
        Forum forum = new Forum();
        forum.setFunId(1);
        forum.setContent(title);
        forum.setApprovalStatus(2);
        forum.setCreateTime(DateUtils.getCurrentFormatDateShort10());
        forumServiceImpl.upForum(forum);
        return "forum";
    }

}
