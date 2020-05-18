package cn.artisan323.controller;

import cn.artisan323.domain.FanUsr;
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

    @RequestMapping("/getFanUsr")
    public String getFan(Model model, HttpServletRequest request){
        List<FanUsr> fanUsrs = forumServiceImpl.getFan();
        model.addAttribute("fanUsrs", fanUsrs);
        return "management";
    }

    @RequestMapping("/upForum")
    public String upForum(String title, Model model){
        Forum forum = new Forum();
        forum.setFunId(1);
        forum.setContent(title);
        forum.setApprovalStatus(2);
        forum.setCreateTime(DateUtils.getCurrentFormatDateShort10());
        System.out.printf(forum.toString());
        forumServiceImpl.upForum(forum);
        List<Forum> forums = forumServiceImpl.getList();
        model.addAttribute("forums", forums);
        return "forum";
    }


    @RequestMapping("/getDynamic")
    public String getDynamic(Model model, HttpServletRequest request){
        List<Forum> fanUsrs = forumServiceImpl.getList();
        System.out.printf(fanUsrs.toString());
        model.addAttribute("forums", fanUsrs);
        return "dynamic";
    }

}
