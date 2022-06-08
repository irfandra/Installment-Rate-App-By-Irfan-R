package com.IrfanEcomProject.Ecom.dtos.product;

import com.IrfanEcomProject.Ecom.models.Product;
import lombok.Data;

import java.text.NumberFormat;
import java.util.Locale;

@Data
public class ProductInsertDTO {
    private String productName;
    private String description;
    private String price;
    private String categoryName;


    public Product toProduct() {
        return new Product(productName,
                description,
                price,
                categoryName);
    }
}
