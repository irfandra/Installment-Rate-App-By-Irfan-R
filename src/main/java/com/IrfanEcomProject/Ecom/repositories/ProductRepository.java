package com.IrfanEcomProject.Ecom.repositories;

import com.IrfanEcomProject.Ecom.models.Category;
import com.IrfanEcomProject.Ecom.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
        @Query(value = """
                select * from Product
                """, nativeQuery = true)
        List<Product> getAllProduct();
    }

