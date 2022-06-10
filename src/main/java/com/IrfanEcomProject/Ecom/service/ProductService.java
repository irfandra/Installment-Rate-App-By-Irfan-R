package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.product.ProductHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.product.ProductInsertDTO;

import java.util.List;

public interface ProductService {
    List<ProductHeaderDTO> findAllProduct();
    boolean insertProduct(ProductInsertDTO productInsertDTO);
    boolean deleteProductByStringId(String productId);
    boolean updateProduct(String productId, ProductInsertDTO productUpdate);

}
