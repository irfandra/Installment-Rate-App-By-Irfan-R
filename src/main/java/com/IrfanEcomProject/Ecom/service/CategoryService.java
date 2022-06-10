package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.category.CategoryHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.category.CategoryInsertDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryHeaderDTO> findAllCategoryStream();
    public boolean insertCategory(CategoryInsertDTO categoryInsertDTO);
    public boolean deleteCategoryByStringId(String categoryId);
    public boolean updateCategory(String categoryId, CategoryInsertDTO categoryUpdate);
}
