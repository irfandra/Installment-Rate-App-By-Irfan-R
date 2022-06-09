package com.IrfanEcomProject.Ecom.dtos.category;

import com.IrfanEcomProject.Ecom.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class CategoryHeaderDTO {
    private final String CategoryName;
    private final String Description;

    public static CategoryHeaderDTO set(Category category) {
        return new CategoryHeaderDTO(category.getId(), category.getDescription());
    }

    public static List<CategoryHeaderDTO> toList(List<Category> categories) {
        List<CategoryHeaderDTO> result = new ArrayList<>();
        for (Category e: categories
        ) {
            result.add(set(e));
        }
        return result;
    }
}
