package com.msr.controller;

import com.msr.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @create 2025-01-15 12:33
 * @desc
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/method01")
    public String method01(Model model){
        model.addAttribute("name", "tom");
        return "index";
    }
    @RequestMapping("/method02")
    public String method02(Model model, HttpSession session){
        User user = new User(111,"lisi","123");
        //model.addAttribute("user",user); request
        session.setAttribute("user",user); //session

        User user1 = new User(111,"lisi1","123");
        User user2 = new User(112,"lisi2","456");
        User user3 = new User(113,"lisi3","789");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        model.addAttribute("userList",userList);
        return "index";
    }
}
