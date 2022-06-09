package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.category.CategoryHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.category.CategoryInsertDTO;
import com.IrfanEcomProject.Ecom.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("get-all")
    public List<CategoryHeaderDTO> findAllCategory(){
        return categoryService.findAllCategory();
    }

    @GetMapping("get-all-stream")
    public List<CategoryHeaderDTO> findAllCategoryStream(){
        return categoryService.findAllCategoryStream();
    }

    @PostMapping("insert")
    public boolean insertCategory(@RequestBody CategoryInsertDTO categoryInsertDTO) {
        return categoryService.insertCategory(categoryInsertDTO);
    }

    @PutMapping("{categoryId}")
    public boolean updateCategory(@PathVariable String categoryId, @RequestBody CategoryInsertDTO categoryUpdate) {
        return categoryService.updateCategory(categoryId, categoryUpdate);
    }

    @DeleteMapping("by-string/{categoryId}")
    public String deleteAllCategoryByStringId(@PathVariable String categoryId) {
        return categoryService.deleteCategoryByStringId(categoryId);
    }
}
