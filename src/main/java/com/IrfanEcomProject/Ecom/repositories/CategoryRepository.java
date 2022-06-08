package com.IrfanEcomProject.Ecom.repositories;

import com.IrfanEcomProject.Ecom.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query(value = """
            select * from Category
            """, nativeQuery = true)
    List<Category> getAllCategory();
}

