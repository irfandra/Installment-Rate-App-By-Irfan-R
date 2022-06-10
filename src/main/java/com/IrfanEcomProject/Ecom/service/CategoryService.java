package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.category.CategoryHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.category.CategoryInsertDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryHeaderDTO> findAllCategoryStream();
    boolean insertCategory(CategoryInsertDTO categoryInsertDTO);
    boolean deleteCategoryByStringId(String categoryId);
    boolean updateCategory(String categoryId, CategoryInsertDTO categoryUpdate);
}
