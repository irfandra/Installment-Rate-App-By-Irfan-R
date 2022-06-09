package com.IrfanEcomProject.Ecom.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @Column(name = "CategoryName", nullable = false, length = 20)
    private String id;

    @Column(name = "Description", length = 100)
    private String description;

    @OneToMany(mappedBy = "categoryName")
    private Set<Product> products = new LinkedHashSet<>();

    public Category(String categoryName, String description) {
        this.id = categoryName;
        this.description = description;
    }

    public Category(String categoryName) {
        this.id = categoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

}