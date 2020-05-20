package com.ian.blog.controller;

import com.ian.blog.entity.Type;
import com.ian.blog.service.BlogService;
import com.ian.blog.service.TypeService;
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
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PathVariable("id") long id,@RequestParam(value = "pageNum",required = false,defaultValue = "3") int pageNum,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "14") int pageSize, Model model) {



        List<Type>  types = typeService.listTypeTop(10000);
        if(id == -1){
            id= types.get(0).getId();
        }
        model.addAttribute("types",types);
        model.addAttribute("pages",blogService.blogByTypeId(id,pageNum,pageSize));
        model.addAttribute("activeTypeId",id);
        return  "types";
    }
}
