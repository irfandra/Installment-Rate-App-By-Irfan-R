package com.IrfanEcomProject.Ecom.dtos.product;

import com.IrfanEcomProject.Ecom.models.Product;
import lombok.Data;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class ProductHeaderDTO {
    private final String productName;
    private final String decription;
    private final String price;
    private final String categoryName;

    public static ProductHeaderDTO set(Product product) {
        Locale locale = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        return new ProductHeaderDTO(
                product.getId(),
                product.getDescription(),
                currencyFormatter.format(product.getPrice()),
                product.getCategoryName().getCategoryName());
    }
    public static List<ProductHeaderDTO> toList(List<Product> products) {
        List<ProductHeaderDTO> result = new ArrayList<>();
        for (Product e: products
        ) {
            result.add(set(e));
        }
        return result;
    }

}
