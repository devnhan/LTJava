package com.example.lkmt.controller.admin;

import com.example.lkmt.entity.Category;
import com.example.lkmt.entity.Product;
import com.example.lkmt.entity.User;
import com.example.lkmt.services.EmployeeService;
import com.example.lkmt.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/edit/{id}")
    public String editemployeeForm(@PathVariable("id") Long id, Model model) {
        User user = employeeService.getUserById(id);

        if (user != null) {
            model.addAttribute("user", user);
            return "employee/Edit/editemployee";
        }else {
            return "redirect:/manager-employee";
        }
    }

    @PostMapping("/edit")
    public String editCategory (@ModelAttribute("User") User updateUser) {
        employeeService.updateUser(updateUser);
        return "redirect:/manager-employee";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory (@PathVariable("id") Long id){
        employeeService.deleteUser(id);
        return "redirect:/manager-employee";
    }
}
