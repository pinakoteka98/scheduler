package com.robertsonwebdev.sunshadersrestservice.controllers;

import com.robertsonwebdev.sunshadersrestservice.User;
import com.robertsonwebdev.sunshadersrestservice.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/users")
public class UserController {


    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String userLogin(){
        return "userLogin";
    }

    @PostMapping(path = "/verify")
    public String userVerify(@ModelAttribute User formUser, Model model){
        User dbUser = queryForUser(formUser);
        if (dbUser == null){
            return "loginError";
        }
        else{
            model.addAttribute("user", dbUser);
            return "scheduler";
        }
    }


    private User queryForUser(User user){
        String email = user.getEmail();
        return userRepository.findByEmail(email);
    }
}
