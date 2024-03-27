package com.example.lkmt.controller.admin;

import com.example.lkmt.entity.Product;
import com.example.lkmt.services.CategoryServices;
import com.example.lkmt.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServices productServices;
    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productServices.getProductById(id);

        if (product != null) {
            model.addAttribute("product", product);
            model.addAttribute("currentCategory", product.getCategory().getId());
            model.addAttribute("categories", categoryServices.getAllCategories());
            return "product/Editproduct/editProduct";
        }else {
            return "redirect:/manager-product";
        }
    }

    @PostMapping("/edit")
    public String editCategory (@ModelAttribute("product") Product updatedProduct) {
        productServices.updateProduct(updatedProduct);
        return "redirect:/manager-product";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory (@PathVariable("id") Long id){
        productServices.deleteProduct(id);
        return "redirect:/manager-product";
    }

}
