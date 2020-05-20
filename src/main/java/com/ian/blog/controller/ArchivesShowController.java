package com.ian.blog.controller;

import com.ian.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ian
 * @date 2020/4/26 -  下午 04:25
 */
@Controller
public class ArchivesShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archivesMap", blogService.archivesBlog());
        model.addAttribute("countBlog",blogService.countBlog());
        return "archives";
    }
}
