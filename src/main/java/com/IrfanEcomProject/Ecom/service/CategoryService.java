package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.category.CategoryHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.category.CategoryInsertDTO;
import com.IrfanEcomProject.Ecom.models.Category;
import com.IrfanEcomProject.Ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryHeaderDTO> findAllCategory(){
        return CategoryHeaderDTO.toList(categoryRepository.findAll());

    }

    public boolean insertCategory(CategoryInsertDTO categoryInsertDTO) {
        Category category = categoryInsertDTO.toCategory();
        categoryRepository.save(category);
        return true;
    }

    public String deleteCategoryByStringId(String categoryId) {
        Category checkId = categoryRepository.findById(categoryId).orElse(null);
        categoryRepository.deleteById(checkId.getCategoryName());
        return "Deleted";
    }

    public boolean updateCategory(String categoryId, CategoryInsertDTO categoryUpdate) {
        Category checkId = categoryRepository.findById(categoryId).orElse(null);
        checkId.setCategoryName(categoryUpdate.getCategoryName()==null?checkId.getCategoryName():categoryUpdate.getCategoryName());
        checkId.setDescription(categoryUpdate.getDescription()==null?checkId.getDescription():categoryUpdate.getDescription());
        categoryRepository.save(checkId);
        return true;
    }
}
