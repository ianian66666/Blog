package com.ian.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ian.blog.entity.Tag;
import com.ian.blog.entity.Type;
import com.ian.blog.service.TagService;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * @author Ian
 * @date 2020/4/19 -  上午 11:39
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String tags(@RequestParam(value = "pageNum",required = false ,defaultValue = "2") int pageNum,
                       @RequestParam(value = "pageSize",required = false,defaultValue = "3") int pageSize,
                           Model model ){

        PageInfo<Tag> pageInfo = tagService.pageTag(pageNum, pageSize);
        model.addAttribute("page",pageInfo);

        return "/admin/tags";
    }
    @GetMapping("/tags/input")
    public String input(Model model){
        model.addAttribute("tag",new Tag());

        return "/admin/tags-input";
    }
    @PostMapping("/tags")
    public String post(@Valid Tag tag , BindingResult result, RedirectAttributes attributes){
        if(tagService.getByName(tag) >0){
            result.rejectValue("name","nameError","標籤不能重複");
        }
        if(result.hasErrors()){
            return "admin/tags-input";
        }

        int count = tagService.saveTag(tag);
        if(count > 0){
            attributes.addFlashAttribute("message" ,"新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失敗");
        }
        return  "redirect:/admin/tags";
    }
//跳轉到更新葉面
    @GetMapping("/tags/{id}/update")
    public String enditInput(@PathVariable("id") Long id, Model model){
        model.addAttribute("tag",tagService.getTagByid(id));
        return "/admin/tags-input";
    }
    //更新提交 重定向到tags
    @PostMapping("/tags/{id}")
    public String enditPost(@Valid Tag tag,BindingResult result,@PathVariable("id")long id,RedirectAttributes attributes){
           if( tagService.getByName(tag) >0){
               result.rejectValue("name","nameError","此標籤以重複");
           }

            if(result.hasErrors()){
                return "admin/tags-input";
            }

        int count = tagService.updateTag(tag);
        if(count>0){
            attributes.addFlashAttribute("message","修改成功");
        }else{
            attributes.addFlashAttribute("message","修改失敗");
        }

        return "redirect:/admin/tags";
    }
    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable("id") long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","刪除成功");

        return "redirect:/admin/tags";

    }

}
