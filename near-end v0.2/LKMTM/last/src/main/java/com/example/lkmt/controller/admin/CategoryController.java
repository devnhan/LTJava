package com.example.lkmt.controller.admin;

import org.springframework.ui.Model;
import com.example.lkmt.entity.Category;
import com.example.lkmt.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServices categoryService;
    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);

        if (category != null) {
            model.addAttribute("category", category);
            return "Category/editCategory";
        }else {
            return "redirect:/manager-category";
        }
    }

    @PostMapping("/edit")
    public String editCategory (@ModelAttribute("category") Category updatedCategory) {
        categoryService.updateCategory(updatedCategory);
        return "redirect:/manager-category";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory (@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/manager-category";
    }
}
