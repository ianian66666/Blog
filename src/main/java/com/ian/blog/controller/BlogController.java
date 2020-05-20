package com.ian.blog.controller;

import com.ian.blog.entity.Blog;
import com.ian.blog.entity.BlogSearch;
import com.ian.blog.entity.User;
import com.ian.blog.service.BlogService;
import com.ian.blog.service.TagService;
import com.ian.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Ian
 * @date 2020/4/18 -  下午 12:15
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String INPUT = "/admin/blogs-input";
    private static final String lIST = "/admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blogs")
    public String list(BlogSearch blogSearch, Model model){
        model.addAttribute("types",typeService.allType());
        List<Blog> blogList = blogService.simpleQueryBySearch(blogSearch);
        model.addAttribute("page",blogList);
    return  lIST;
    }
    @PostMapping("/blogs/search")
    public String search(BlogSearch blogSearch,Model model){

        model.addAttribute("page",blogService.simpleQueryBySearch(blogSearch));
    return  "/admin/blogs :: blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        setTypeAndTag(model);
        model.addAttribute("blog",new Blog());
        return INPUT;
    }
    private void setTypeAndTag(Model model){
        model.addAttribute("types",typeService.allType());
        model.addAttribute("tags",tagService.allTags());
    }
    @GetMapping("/blogs/{id}/update")
    public String enditInput(Model model , @PathVariable("id") Long id ){
                setTypeAndTag(model);
        model.addAttribute("blog",blogService.getBlogById(id));
        return INPUT;
    }
    @PostMapping("/blogs")
    public String put(Blog blog, HttpSession session, RedirectAttributes attributes,Model model){
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.getAllTagByid(blog.getTagIds()));
        int i;
        if(blog.getId() == null){
            i = blogService.saveBlog(blog);
        }else{
            i =blogService.updateBlog(blog);
        }
        if(i>0){
            attributes.addFlashAttribute("message","操作成功");
        }else{
            attributes.addFlashAttribute("message","操作失敗");
        }
        return REDIRECT_LIST;
    }
    @GetMapping("blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        int count = blogService.deleteBlog(id);
        if(count>0){
            attributes.addFlashAttribute("message","刪除成功");
        }else{
            attributes.addFlashAttribute("message","刪除失敗");
        }
        return REDIRECT_LIST;
    }

}
