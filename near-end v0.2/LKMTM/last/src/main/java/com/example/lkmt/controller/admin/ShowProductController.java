package com.example.lkmt.controller.admin;

import com.example.lkmt.entity.Product;
import com.example.lkmt.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ShowProductController {

    @Autowired
    private ProductServices productServices;

    @GetMapping("/")
    public String showAllProductsAdmin(Model model) {
        List<Product> products = productServices.getAllProducts();
        model.addAttribute("products", products);
        return "showproduct/index";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Product product = productServices.getProductById(id);

        if(product == null) {
//         thông báo sản phẩm

            return "error";
        }

        model.addAttribute("product", product);
        return "showproduct/details";
    }


}
