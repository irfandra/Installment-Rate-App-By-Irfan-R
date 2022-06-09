package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.category.CategoryHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.category.CategoryInsertDTO;
import com.IrfanEcomProject.Ecom.models.Category;
import com.IrfanEcomProject.Ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryHeaderDTO> findAllCategory() {
        return CategoryHeaderDTO.toList(categoryRepository.findAll());

    }

    public List<CategoryHeaderDTO> findAllCategoryStream() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryHeaderDTO> categoryStream = categoryList.stream()
                .map(category -> new CategoryHeaderDTO(category.getId(),
                        category.getDescription()))
                .collect(Collectors.toList());

        return categoryStream;
    }

    public boolean insertCategory(CategoryInsertDTO categoryInsertDTO) {
        Category category = categoryInsertDTO.toCategory();
        categoryRepository.save(category);
        return true;
    }

    public String deleteCategoryByStringId(String categoryId) {
        Category checkId = categoryRepository.findById(categoryId).orElse(null);
        categoryRepository.deleteById(checkId.getId());
        return "Deleted";
    }

    public boolean updateCategory(String categoryId, CategoryInsertDTO categoryUpdate) {
        Category checkId = categoryRepository.findById(categoryId).orElse(null);
        checkId.setId(categoryUpdate.getCategoryName() == null ? checkId.getId() : categoryUpdate.getCategoryName());
        checkId.setDescription(categoryUpdate.getDescription() == null ? checkId.getDescription() : categoryUpdate.getDescription());
        categoryRepository.save(checkId);
        return true;
    }
}
