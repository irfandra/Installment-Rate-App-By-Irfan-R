package com.IrfanEcomProject.Ecom.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @Column(name = "ProductName", nullable = false, length = 20)
    private String id;

    @Column(name = "Description", length = 1000)
    private String description;

    @Column(name = "Price", precision = 19, scale = 4)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryName")
    private Category categoryName;

    @Column(name = "UnitInStock")
    private Integer unitInStock;

    @OneToMany(mappedBy = "productName")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public Product(String productName, String description, String price, String categoryName, Integer unitInStock) {
        this.id = productName;
        this.description = description;
        this.price = new BigDecimal(price);
        this.categoryName = new Category(categoryName);
        this.unitInStock = unitInStock;
    }

    public Product(String productName) {
        this.id = productName;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

}