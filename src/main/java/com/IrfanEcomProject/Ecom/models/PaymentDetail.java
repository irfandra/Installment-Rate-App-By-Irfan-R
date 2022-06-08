package com.IrfanEcomProject.Ecom.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId", nullable = false)
    private Integer id;

    @Column(name = "InstallmentYear", nullable = false)
    private Integer installmentYear;

    @Column(name = "InterestRate", nullable = false, length = 10)
    private String interestRate;

    @OneToMany(mappedBy = "payment")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public PaymentDetail(Integer installmentYear, String interestRate) {
        this.installmentYear = installmentYear;
        this.interestRate = interestRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstallmentYear() {
        return installmentYear;
    }

    public void setInstallmentYear(Integer installmentYear) {
        this.installmentYear = installmentYear;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

}