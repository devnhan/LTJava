package com.example.lkmt.controller.admin;

import com.example.lkmt.entity.Category;
import com.example.lkmt.entity.Product;
import com.example.lkmt.entity.User;
import com.example.lkmt.services.CategoryServices;
import com.example.lkmt.services.EmployeeService;
import com.example.lkmt.services.ProductServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ProductServices productServices;
    @Autowired
    private CategoryServices categoryServices;
    @Autowired
    private CategoryServices categoryService;
    @GetMapping("/manager-category")
    public String showCategory(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categoriesTitle", "Danh sách danh mục");
        model.addAttribute( "categoryAdd", "+ Thêm danh mục");
        model.addAttribute("categories", categories);
        return "manage/category/index";
    }
    @GetMapping("/add-Category")
    public String addCategoryForm (Model model) {
        model.addAttribute( "category", new Category());

        return "Category/index";
    }

    @PostMapping("/add-Category")
    public String addCategory (@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/manager-category";
    }
    @GetMapping("/admin")
    public String trangchiuSB(Model m){
        return "indexSB";
    }
    @GetMapping("/manager-product")
    public String showAllProducts(Model model) {
        List<Product> products = productServices.getAllProducts();
        model.addAttribute("products", products);
        return "manage/product/index";
    }

    @GetMapping("/add-product")
    public String addProductForm(Model m){
        m.addAttribute("products", new Product());
        m.addAttribute("categories", categoryServices.getAllCategories());
        return "/product/index";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("products") @Valid Product product, BindingResult result, @RequestParam("imgProduct") MultipartFile imgProduct) {
        Category category = product.getCategory();
        if (category != null && category.getId() == null) {
            categoryServices.addCategory(category);
            product.setCategory(category);
        }

        if (!imgProduct.isEmpty()) {
            try {
                byte[] bytes = imgProduct.getBytes();
                product.setImage(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productServices.addProduct(product);
        return "redirect:/manager-product";
    }
    @GetMapping("/manager-employee")
    public String showEmployee(Model model) {
        List<User> Users = employeeService.getAllUsers();
        model.addAttribute("employeesTitle", "Danh sách nhân viên");
        model.addAttribute( "employeeAdd", "+ Thêm nhân viên");
        model.addAttribute("employees", Users);
        return "manage/employee/index";
    }
    @GetMapping("/add-employee")
    public String addUserForm(Model model) {
        model.addAttribute("users", new User());
        return "employee/index";
    }

    @PostMapping("/add-employee")
    public String addUser(@ModelAttribute("users") User user) {
        employeeService.addUser(user);
        return "redirect:/manager-employee";
    }

}
