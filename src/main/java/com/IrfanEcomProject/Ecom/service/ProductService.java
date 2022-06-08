package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.product.ProductHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.product.ProductInsertDTO;
import com.IrfanEcomProject.Ecom.models.Product;
import com.IrfanEcomProject.Ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductHeaderDTO> findAllProduct(){
        return ProductHeaderDTO.toList(productRepository.findAll());
    }

    public boolean insertProduct(ProductInsertDTO productInsertDTO) {
        Product product = productInsertDTO.toProduct();
        productRepository.save(product);
        return true;

    }

    public String deleteProductByStringId(String productId) {
        Product checkId = productRepository.findById(productId).orElse(null);
        productRepository.deleteById(checkId.getId());
        return "Deleted";
    }

    public boolean updateProduct(String productId, ProductInsertDTO productUpdate) {
        Product checkId = productRepository.findById(productId).orElse(null);
        checkId.setId(productUpdate.getProductName()==null?checkId.getId():productUpdate.getProductName());
        checkId.setDescription(productUpdate.getDescription()==null?checkId.getDescription():productUpdate.getDescription());
        checkId.setPrice(productUpdate.getPrice()==null?checkId.getPrice():productUpdate.toProduct().getPrice());
        checkId.setCategoryName(productUpdate.getCategoryName()==null?checkId.getCategoryName():productUpdate.toProduct().getCategoryName());
        productRepository.save(checkId);
        return true;
    }
}
