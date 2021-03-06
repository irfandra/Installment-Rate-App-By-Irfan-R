package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.RestResponse;
import com.IrfanEcomProject.Ecom.dtos.category.CategoryHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.category.CategoryInsertDTO;
import com.IrfanEcomProject.Ecom.service.CategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private CategoryServiceImplementation categoryServiceImplementation;

    @Autowired
    public CategoryController(CategoryServiceImplementation categoryServiceImplementation) {
        this.categoryServiceImplementation = categoryServiceImplementation;
    }

    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<CategoryHeaderDTO>>> getAllCategory() {
        return new ResponseEntity<>(
                new RestResponse<>(categoryServiceImplementation.findAllCategoryStream(),
                        "Category Find Success",
                        200),
                HttpStatus.OK);
    }


    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertCategory(@RequestBody CategoryInsertDTO categoryInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(categoryServiceImplementation.insertCategory(categoryInsertDTO),
                        "Category Insert Success",
                        201),
                HttpStatus.CREATED);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<RestResponse<Boolean>> updateCategory(@PathVariable("categoryId") String categoryId, @RequestBody CategoryInsertDTO categoryInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(categoryServiceImplementation.updateCategory(categoryId, categoryInsertDTO),
                        "Category Update Success",
                        200),
                HttpStatus.OK);
    }

    @DeleteMapping("by-string/{categoryId}")
    public ResponseEntity<RestResponse<Boolean>> deleteCategoryByString(@PathVariable("categoryId") String categoryId) {
        return new ResponseEntity<>(
                new RestResponse<>(categoryServiceImplementation.deleteCategoryByStringId(categoryId),
                        "Category Delete Success",
                        200),
                HttpStatus.OK);
    }
}
