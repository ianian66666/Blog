package com.ian.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ian.blog.entity.Type;
import com.ian.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.rmi.runtime.Log;

import javax.validation.Valid;

/**
 * @author Ian
 * @date 2020/4/18 -  下午 02:27
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/types")
    public String types(@RequestParam(value = "pageNum",required = false,defaultValue = "2") int pageNum,
                        @RequestParam(value = "pageSize" , required = false ,defaultValue = "3") int pageSize,
                        Model model){
        PageInfo<Type> pageInfo = typeService.PageType(pageNum, pageSize);
        model.addAttribute("page",pageInfo);
    return "/admin/types";
    }


    @GetMapping("/types/input")
    public String input(Model model){
                model.addAttribute("type", new Type());
        return "/admin/types-input";
    }


    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes){
        if(typeService.getByName(type) >= 1){
                result.rejectValue("name","nameError","該標籤已重複");
        }
            if(result.hasErrors()){
                return "admin/types-input";
            }
        int i = typeService.saveType(type);
        if(i>0){
            attributes.addFlashAttribute("message","新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失敗");
        }
        return "redirect:/admin/types";

    }

    @GetMapping("/types/{id}/update")
    public String editInput(@PathVariable("id") Long id , Model model){
        model.addAttribute("type",typeService.getType(id));
        return "/admin/types-input";
    }


   @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result, @PathVariable("id")Long id, RedirectAttributes attributes){
                    type.setId(id);
        if(typeService.getByName(type) >= 1){
                result.rejectValue("name","nameError","該標籤已重複");
        }
            if(result.hasErrors()){
                return "admin/types-input";
            }
       int count = typeService.upDateType(type);
       if(count >= 1){
            attributes.addFlashAttribute("message","更新成功");
        }else{
            attributes.addFlashAttribute("message","更新失敗");
        }
        return "redirect:/admin/types";

    }
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable("id") Long id , RedirectAttributes attributes){
            typeService.deleteType(id);
            attributes.addFlashAttribute("message","刪除成功");
            return "redirect:/admin/types";

    }



}
