package com.example.lkmt.services;

import com.example.lkmt.entity.Category;
import com.example.lkmt.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories() { return categoryRepository.findAll(); }

    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new RuntimeException("category not found");
        }
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) { categoryRepository.deleteById(id); }
}

