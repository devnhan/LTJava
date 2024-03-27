package com.example.lkmt.controller.admin;

import com.example.lkmt.repository.IUserRepository;
import com.example.lkmt.entity.Role;
import com.example.lkmt.entity.User;
import com.example.lkmt.services.UserServices;
import com.example.lkmt.services.RoleServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;
@Controller
public class UserController {
    @Autowired
    private UserServices userService;

    @Autowired
    private RoleServices roleService;

    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        User user = userRepository.findByUsername(username);

        if(user != null) {
            Long roleId = user.getRole().getId();

            if(roleId == 1L) {
                return "redirect:/admin";
            } else {
                return "redirect:/";
            }
        }
        return "redirect:/register";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }


    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult, Model model) {
        // Role user
        Role userRole;
        if(userService.countAdminUsers() == 0) {
            userRole = roleService.getRoleById(1L);
        } else {
            userRole = roleService.getRoleById(2L);
        }
        user.setRole(userRole);



        // Check confirm password
        if (!user.getPassword().equals(user.getConfirmpassword())) {
            model.addAttribute("confirmPassword_error", "Mật khẩu xác nhận không khớp");

            // Display alert
            model.addAttribute("alertMessage", "Mật khẩu xác nhận không khớp");
            model.addAttribute("alertType", "danger");
            return "user/register";
        }

        /*if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                model.addAttribute(error.getField() + "_error",
                        error.getDefaultMessage());
            }

            return "user/register";
        }*/


        //Mã hóa mật khẩu xác nhận
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedConfirmPassword = passwordEncoder.encode(user.getConfirmpassword());
        user.setConfirmpassword(encodedConfirmPassword);

        //Mã hóa mật khẩu
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userService.save(user);
        return "redirect:/login";
    }
}


