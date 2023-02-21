package com.myblog.controller;

import com.myblog.pojo.User;
import com.myblog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: Mr.Xia
 * @Date: 2023/2/10 14:08
 * @Description:
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录操作
     * @param user 输入的用户
     * @param model
     * @return
     */
    @RequestMapping(value = "/enter",method = RequestMethod.POST)
    public String login(User user, Model model){
        User u = loginService.userLogin(user);
        if(u != null){
            return "home";
        }
        return "redirect:/";
    }

    /**
     * 首页页面
     * @return
     */
    @RequestMapping("/home")
    public String home(){
        return "home";
    }

}
