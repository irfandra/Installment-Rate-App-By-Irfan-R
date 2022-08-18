package com.IrfanEcomProject.Ecom.dtos.product;

import com.IrfanEcomProject.Ecom.models.Product;
import lombok.Data;


@Data
public class ProductInsertDTO {
    private String productName;
    private String description;
    private String price;
    private String categoryName;
    private Integer unitInStock;
    private String image;


    public Product toProduct() {
        return new Product(
                productName,
                description,
                price,
                categoryName,
                unitInStock,
                image);
    }
}
