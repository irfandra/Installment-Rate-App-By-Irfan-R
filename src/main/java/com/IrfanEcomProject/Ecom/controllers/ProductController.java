package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.product.ProductHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.product.ProductInsertDTO;
import com.IrfanEcomProject.Ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("get-all")
    public List<ProductHeaderDTO> findAllProduct(){
        return productService.findAllProduct();
    }
    @PostMapping("insert")
    public boolean insertProduct(@RequestBody ProductInsertDTO productInsertDTO) {
        return productService.insertProduct(productInsertDTO);
    }
    @DeleteMapping("by-string/{productId}")
    public String deleteAllProductByStringId(@PathVariable String productId) {
        return productService.deleteProductByStringId(productId);
    }
    @PutMapping("{productId}")
    public boolean updateProduct(@PathVariable String productId, @RequestBody ProductInsertDTO productUpdate) {
        return productService.updateProduct(productId, productUpdate);
    }
}
