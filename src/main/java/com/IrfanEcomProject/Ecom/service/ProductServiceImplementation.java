package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.product.ProductHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.product.ProductInsertDTO;
import com.IrfanEcomProject.Ecom.models.Product;
import com.IrfanEcomProject.Ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<ProductHeaderDTO> findAllProduct(){
        return ProductHeaderDTO.toList(productRepository.findAll());
    }

    @Override
    public boolean insertProduct(ProductInsertDTO productInsertDTO) {
        Product product = productInsertDTO.toProduct();
        productRepository.save(product);
        return true;

    }
    @Override
    public boolean deleteProductByStringId(String productId) {
        Product checkId = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product "+ productId +" Not Found"));
        productRepository.deleteById(checkId.getId());
        return true;
    }
    @Override
    public boolean updateProduct(String productId, ProductInsertDTO productUpdate) {
        Product checkId = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product "+ productId +" Not Found"));
        checkId.setId(productUpdate.getProductName()==null?checkId.getId():productUpdate.getProductName());
        checkId.setDescription(productUpdate.getDescription()==null?checkId.getDescription():productUpdate.getDescription());
        checkId.setPrice(productUpdate.getPrice()==null?checkId.getPrice():productUpdate.toProduct().getPrice());
        checkId.setCategoryName(productUpdate.getCategoryName()==null?checkId.getCategoryName():productUpdate.toProduct().getCategoryName());
        checkId.setUnitInStock(productUpdate.getUnitInStock()==null?checkId.getUnitInStock():productUpdate.getUnitInStock());
        productRepository.save(checkId);
        return true;
    }
}
