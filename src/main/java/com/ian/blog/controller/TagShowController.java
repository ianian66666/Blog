package com.ian.blog.controller;

import com.ian.blog.entity.Tag;
import com.ian.blog.service.BlogService;
import com.ian.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Ian
 * @date 2020/4/26 -  上午 11:40
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String types(@PathVariable("id") Long id,@RequestParam(value = "pageNum",required = false,defaultValue = "3") int pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "14") int pageSize, Model model, HttpServletRequest request) {



        List<Tag>  tags = tagService.allTags();

        if(id == -1){
            id= tags.get(0).getId();
        }
        model.addAttribute("tags",tags);
        model.addAttribute("pages",blogService.blogByTagIds(id,pageNum,pageSize));
        model.addAttribute("activeTagId",id);
        return  "/tags";
    }
}
