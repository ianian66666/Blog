package com.ian.blog.controller;

import com.ian.blog.entity.User;
import com.ian.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author Ian
 * @date 2020/4/17 -  下午 09:56
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userservice;

    @GetMapping
    public String loginpage(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username , @RequestParam("password") String password ,
                        HttpSession session, RedirectAttributes attributes){
        User user = userservice.checkUser(username, password);
        if(user!=null){
            user.setPassword(null);
        session.setAttribute("user", user);
        return "admin/index";
        }else{
            //重定向可以傳遞信息的方法RedirectAttributes
        attributes.addFlashAttribute("message","用戶名和密碼錯誤");
                return  "redirect:/admin";
        }

    }
    @GetMapping("/logout")
    public String  logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
