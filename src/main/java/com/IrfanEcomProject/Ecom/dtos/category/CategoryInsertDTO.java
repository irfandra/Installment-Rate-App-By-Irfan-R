package com.IrfanEcomProject.Ecom.dtos.category;


import com.IrfanEcomProject.Ecom.models.Category;
import lombok.Data;

@Data
public class CategoryInsertDTO {
    private String categoryName;
    private String description;

    public Category toCategory() {
        return new Category(categoryName, description);
    }
}
