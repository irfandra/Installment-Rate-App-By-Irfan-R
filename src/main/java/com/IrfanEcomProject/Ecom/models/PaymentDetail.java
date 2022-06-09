package com.IrfanEcomProject.Ecom.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId", nullable = false)
    private Integer id;

    @Column(name = "InstallmentYear", nullable = false)
    private Integer installmentYear;

    @Column(name = "InterestRate", nullable = false, length = 10)
    private Double interestRate;

    @OneToMany(mappedBy = "payment")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public PaymentDetail(Integer installmentYear, Double interestRate) {
        this.installmentYear = installmentYear;
        this.interestRate = interestRate;
    }

    public PaymentDetail(Integer paymentId) {
        this.id = paymentId;
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

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

}