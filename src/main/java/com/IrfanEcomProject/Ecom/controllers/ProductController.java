package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.RestResponse;
import com.IrfanEcomProject.Ecom.dtos.product.ProductHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.product.ProductInsertDTO;
import com.IrfanEcomProject.Ecom.service.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private ProductServiceImplementation productServiceImplementation;
    @Autowired
    public ProductController(ProductServiceImplementation productServiceImplementation) {
        this.productServiceImplementation = productServiceImplementation;
    }
    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<ProductHeaderDTO>>> getAllProduct() {
        return new ResponseEntity<>(
                new RestResponse<>(productServiceImplementation.findAllProduct(),
                        "Product Find Success",
                        200),
                HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertProduct(@RequestBody ProductInsertDTO productInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(productServiceImplementation.insertProduct(productInsertDTO),
                        "Product Insert Success",
                        201),
                HttpStatus.CREATED);
    }
    @DeleteMapping("by-string/{productId}")
    public ResponseEntity<RestResponse<Boolean>> deleteProductByString(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(
                new RestResponse<>(productServiceImplementation.deleteProductByStringId(productId),
                        "Product Delete Success",
                        200),
                HttpStatus.OK);
    }
    @PutMapping("{productId}")
    public ResponseEntity<RestResponse<Boolean>> updateProduct(@PathVariable("productId") String productId, @RequestBody ProductInsertDTO productInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(productServiceImplementation.updateProduct(productId, productInsertDTO),
                        "Product Update Success",
                        200),
                HttpStatus.OK);
    }
}
