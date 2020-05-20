package com.ian.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ian.blog.entity.Blog;
import com.ian.blog.entity.User;
import com.ian.blog.service.BlogService;
import com.ian.blog.service.TagService;
import com.ian.blog.service.TypeService;
import com.ian.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Ian
 * @date 2020/4/16 -  下午 09:38
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(@RequestParam(value = "pageNum",required = false,defaultValue = "3") int pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "14") int pageSize, Model model, HttpServletRequest request) {
        model.addAttribute("page",blogService.pageAll(pageNum,pageSize));
                model.addAttribute("types", typeService.listTypeTop(5));
                model.addAttribute("tags",tagService.allTags());
                model.addAttribute("recommendBlog", blogService.listRecommendBlog(6));

    return "index";
    }
    @PostMapping("/search")
    public String search(@RequestParam(value = "pageNum",required = false,defaultValue = "3") int pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue = "14") int pageSize, Model model,@RequestParam("query") String query,  HttpServletRequest request) {
                            model.addAttribute("page", blogService.queryBlog(query,pageNum,pageSize));
                            model.addAttribute("query",query);
        return  "search";
    }

    @GetMapping("blog/{id}")
    public String blog(@PathVariable("id") Long id,Model model){
        model.addAttribute("blog", blogService.getAndConvert(id));

        return "blog";
    }
    @GetMapping("/about")
    public String about(){

        return "about";
    }

    @GetMapping("/footer/newblog")
    public String footerNewBlog(Model model){
        List<Blog> blogs = blogService.listRecommendBlog(3);
        model.addAttribute("newblogs",blogs);
        return "_fragments :: newbloglist";
    }
}
