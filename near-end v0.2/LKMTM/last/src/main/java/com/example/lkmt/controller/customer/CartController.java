//package com.example.lkmt.controller.customer;
//
//import com.example.lkmt.entity.Product;
//import com.example.lkmt.services.ProductServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/")
//public class CartController {
//    @Autowired
//    private ProductServices productServices;
//    @GetMapping("/")
//    public String getProductById(@PathVariable("productId") Long id, Model model) {
//        Product product = productServices.getProductById(id);
//        model.addAttribute("product", product);
//        return "showproduct/details";
//    }
//
//}
