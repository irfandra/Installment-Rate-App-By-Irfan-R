package com.IrfanEcomProject.Ecom.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Transaction\"")
public class Transaction {
    @Id
    @Column(name = "TransactionId", nullable = false, length = 20)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PaymentId")
    private PaymentDetail payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductName")
    private Product productName;

    @Column(name = "DownPayment", precision = 19, scale = 4)
    private BigDecimal downPayment;

    @Column(name = "MonthlyPayment", precision = 19, scale = 4)
    private BigDecimal monthlyPayment;

    @Column(name = "TotalFirstPayment", precision = 19, scale = 4)
    private BigDecimal totalFirstPayment;

    @Column(name = "TotalPrice", precision = 19, scale = 4)
    private BigDecimal totalPrice;

    public Transaction(String customTicket, Integer customerId, Integer paymentId,
                       String productName, String downPayment, String monthlyPayment,
                       String totalFirstPayment, String totalPrice) {
        this.id = customTicket;
        this.customer = new Customer(customerId);
        this.payment = new PaymentDetail(paymentId);
        this.productName = new Product(productName);
        this.downPayment = new BigDecimal(downPayment);
        this.monthlyPayment = new BigDecimal(monthlyPayment);
        this.totalFirstPayment = new BigDecimal(totalFirstPayment);
        this.totalPrice = new BigDecimal(totalPrice);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentDetail getPayment() {
        return payment;
    }

    public void setPayment(PaymentDetail payment) {
        this.payment = payment;
    }

    public Product getProductName() {
        return productName;
    }

    public void setProductName(Product productName) {
        this.productName = productName;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BigDecimal getTotalFirstPayment() {
        return totalFirstPayment;
    }

    public void setTotalFirstPayment(BigDecimal totalFirstPayment) {
        this.totalFirstPayment = totalFirstPayment;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}